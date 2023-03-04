package com.uichesoh.podcast_applicattion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ProgressBar;
import android.widget.Toast;
import com.uichesoh.podcast_applicattion.apimodel.Welcome;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.GET;

public class MainActivity extends AppCompatActivity {
    interface MyAPIService {

        @GET("/us/rss/toppodcasts/limit=100/genre=1310/json")
        Call<Welcome> getPodcasts();
    }

    static class RetrofitClientInstance {

        private static Retrofit retrofit;
        private static final String BASE_URL = "https://itunes.apple.com/";

        public static Retrofit getRetrofitInstance() {
            if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(JacksonConverterFactory.create())
                        .build();
            }
            return retrofit;
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
            String title = podcasts.getFeed().getEntry().get(position).getTitle().getLabel();
            holder.getView().setText(title);
            holder.getView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, podcasts.getFeed().getEntry().get(position).getTitle().getLabel(), Toast.LENGTH_SHORT).show();
                }
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
        Log.d("POPULATE","POPULATING VIEW WITH: "+podcasts.toString());
        adapter = new RecyclerViewAdapter(this,podcasts);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        PodcastList myFragment = new PodcastList();
        fragmentTransaction.add(R.id.fragment_podcast_list, myFragment);
        fragmentTransaction.commit();

        final ProgressBar myProgressBar= findViewById(R.id.myProgressBar);
        myProgressBar.setIndeterminate(true);
        myProgressBar.setVisibility(View.VISIBLE);

        /*Create handle for the RetrofitInstance interface*/
        MyAPIService myAPIService = RetrofitClientInstance.getRetrofitInstance().create(MyAPIService.class);

        Call<Welcome> call = myAPIService.getPodcasts();
        call.enqueue(new Callback<Welcome>() {

            @Override
            public void onResponse(Call<Welcome> call, Response<Welcome> response) {
                System.out.println("Response: " + response.body());
                myProgressBar.setVisibility(View.GONE);
                populateListView(response.body());
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

