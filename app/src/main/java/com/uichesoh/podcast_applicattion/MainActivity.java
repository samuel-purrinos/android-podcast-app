package com.uichesoh.podcast_applicattion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.uichesoh.podcast_applicattion.apimodel.Entry;
import com.uichesoh.podcast_applicattion.apimodel.Welcome;

import java.util.List;

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

    class ListViewAdapter extends BaseAdapter {

        private Welcome podcasts;
        private Context context;

        public ListViewAdapter(Context context,Welcome podcasts){
            this.context = context;
            this.podcasts = podcasts;
        }

        @Override
        public int getCount() {
            return podcasts.getFeed().getEntry().size();
        }

        @Override
        public Object getItem(int pos) {
            return podcasts.getFeed().getEntry().get(pos);
        }

        @Override
        public long getItemId(int pos) {
            return pos;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            if(view==null)
            {
                view= LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1,viewGroup,false);
            }

            TextView nameTxt = view.findViewById(android.R.id.text1);

            final String title= podcasts.getFeed().getEntry().get(position).getTitle().getLabel();
            Log.d("POPULATE","POPULATING VIEW WITH: "+title+" at position: "+position);
            nameTxt.setText(title);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, title, Toast.LENGTH_SHORT).show();
                }
            });

            return view;
        }
    }

    private ListViewAdapter adapter;
    private ListView mListView;
    ProgressBar myProgressBar;

    private void populateListView(Welcome podcasts) {
        mListView = findViewById(android.R.id.list);
        Log.d("POPULATE","POPULATING VIEW WITH: "+podcasts);
        adapter = new ListViewAdapter(this,podcasts);
        mListView.setAdapter(adapter);
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

