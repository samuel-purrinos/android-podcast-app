package com.uichesoh.podcast_applicattion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.*;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.*;

import android.widget.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uichesoh.podcast_applicattion.apimodel.*;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.*;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.*;

public class MainActivity extends AppCompatActivity {
    private PodcastList podcastList;
    interface MyAPIService {
        @Headers("Cache-Control: public, max-age=86400")
        @GET("/us/rss/toppodcasts/limit=100/genre=1310/json")
        Call<Welcome> getPodcasts();
        @Headers("Cache-Control: public, max-age=86400")
        @GET("/lookup?entity=podcastEpisode")
        Call<EpisodeResponse> getEpisodes(@Query("id") String id);
    }

    static class RetrofitClientInstance {

        private static Retrofit retrofit;
        private static final String BASE_URL = "https://itunes.apple.com/";
        private static final int cacheSize = 10 * 1024 * 1024; // 10 MB
        private static Context context;

        public static void setContext(Context context) {
            if(RetrofitClientInstance.context == null) {
                RetrofitClientInstance.context = context;
            }
        }
        public static Retrofit getRetrofitInstance() {
            if (retrofit == null) {
                File httpCacheDirectory = new File(context.getCacheDir(), "responses");
                int cacheSize = 10 * 1024 * 1024; // 10 MiB
                Cache cache = new Cache(httpCacheDirectory, cacheSize);

                OkHttpClient okHttpClient = new OkHttpClient.Builder()
                        .cache(cache)
                        .addInterceptor(new Interceptor() {
                            @Override
                            public okhttp3.Response intercept(Chain chain) throws IOException {
                                Request request = chain.request();
                                if (isNetworkAvailable()) {
                                    request = request.newBuilder().header("Cache-Control", "public, max-age=" + 60).build();
                                } else {
                                    request = request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24).build();
                                }
                                return chain.proceed(request);
                            }
                        })
                        .build();

                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .client(okHttpClient)
                        .addConverterFactory(JacksonConverterFactory.create())
                        .build();
            }
            return retrofit;
        }
        public static boolean isNetworkAvailable() {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
    }

    class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

        private Welcome podcasts;
        private Context context;

        public RecyclerViewAdapter(Context context,Welcome podcasts){
            this.context = context;
            this.podcasts = podcasts;
        }

        @Override
        public int getItemViewType(final int position) {
            return R.layout.list_item;
        }
        @NonNull
        @Override
        public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
            RecyclerViewHolder vh = new RecyclerViewHolder(view);
            return vh;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerViewHolder holder, @SuppressLint("RecyclerView") int position) {
            Entry podcast =podcasts.getFeed().getEntry().get(position);
            String title = podcast.getTitle().getLabel();
            holder.getView().setText(title);
            holder.getView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadPodcastDetailScreen(podcast);}
            });
        }

        @Override
        public int getItemCount() {
            return podcasts.getFeed().getEntry().size();
        }

    }

    private RecyclerViewAdapter adapter;
    private RecyclerView mRecyclerView;
    ProgressBar myProgressBar;

    private void populateListView(Welcome podcasts) {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        Log.d("POPULATE", "POPULATING VIEW WITH: " + podcasts.toString());
        adapter = new RecyclerViewAdapter(this, podcasts);
        mRecyclerView.setAdapter(adapter);
        podcastList.setRecyclerViewAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        podcastList = new PodcastList();
        fragmentTransaction.add(R.id.fragment_podcast_list, podcastList);
        fragmentTransaction.commit();
        View headerView = findViewById(R.id.header);
        headerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reloadHomeScreen();
                loadPodcastData();
            }
        });

        loadPodcastData();


    }

    public void reloadHomeScreen(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
        PodcastList podcastListFragment = new PodcastList();
        transaction.replace(R.id.fragment_podcast_list, podcastListFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        loadPodcastData();
    }

    public void loadPodcastDetailScreen(Entry podcast){
        PodcastDetail fragment = PodcastDetail.newInstance(podcast);
        FragmentManager fragmentManager =  getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
        transaction.replace(R.id.fragment_podcast_list, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void loadPodcastData(){
        final ProgressBar myProgressBar= findViewById(R.id.progressBar);
        myProgressBar.setIndeterminate(true);
        myProgressBar.setVisibility(View.VISIBLE);
        RetrofitClientInstance.setContext(this);
        MyAPIService myAPIService = RetrofitClientInstance.getRetrofitInstance().create(MyAPIService.class);

        Call<Welcome> call = myAPIService.getPodcasts();
        call.enqueue(new Callback<Welcome>() {

            @Override
            public void onResponse(Call<Welcome> call, Response<Welcome> response) {
                if(response.isSuccessful()){
                    okhttp3.Response cachedResponse = response.raw().cacheResponse();
                    if(cachedResponse != null && cachedResponse.body() != null) {
                        try {
                            String cachedJson = cachedResponse.body().string();
                            ObjectMapper objectMapper = new ObjectMapper();
                            Welcome cachedPodcasts = objectMapper.readValue(cachedJson, Welcome.class);
                            System.out.println("Response came from cache");
                            myProgressBar.setVisibility(View.GONE);
                            populateListView(cachedPodcasts);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("Response came from network");
                        myProgressBar.setVisibility(View.GONE);
                        populateListView(response.body());
                        podcastList.setPodcasts(response.body());
                    }

                }
            }
            @Override
            public void onFailure(Call<Welcome> call, Throwable throwable) {
                System.out.println("Error: " + throwable.getMessage());
                myProgressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, throwable.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

}

