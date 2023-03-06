package com.uichesoh.podcast_applicattion;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.uichesoh.podcast_applicattion.apimodel.Entry;
import com.uichesoh.podcast_applicattion.apimodel.EpisodeResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PodcastDetail extends Fragment {

    private ImageView podcastImageView;
    private TextView podcastTitleTextView;
    private TextView podcastAuthorTextView;
    private TextView podcastDescriptionTextView;
    private Entry mPodcast;
    private EpisodeAdapter mEpisodeAdapter;
    private static final String ARG_ENTRY = "entry";

    private EpisodeResponse episodeResponse;

    public static PodcastDetail newInstance(Entry podcastEntry) {
        PodcastDetail fragment = new PodcastDetail();
        Bundle args = new Bundle();
        args.putParcelable(ARG_ENTRY, podcastEntry);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPodcast = getArguments().getParcelable(ARG_ENTRY);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_podcast_detail, container, false);

        podcastImageView = view.findViewById(R.id.podcast_detail_imageview);
        podcastTitleTextView = view.findViewById(R.id.podcast_detail_title_textview);
        podcastAuthorTextView = view.findViewById(R.id.podcast_detail_author_textview);
        podcastDescriptionTextView = view.findViewById(R.id.podcast_detail_description_textview);

        // Load podcast image from URL using Glide or Picasso
        Glide.with(this)
                .load(mPodcast.getIMImage().get(1).getLabel())
                .placeholder(android.R.drawable.ic_menu_gallery)
                .error(android.R.drawable.ic_menu_report_image)
                .into(podcastImageView);

        podcastTitleTextView.setText(mPodcast.getTitle().getLabel());
        podcastAuthorTextView.setText(mPodcast.getIMArtist().getLabel());
        podcastDescriptionTextView.setText(mPodcast.getSummary().getLabel());

        // Set up RecyclerView for displaying podcast episodes
        RecyclerView episodesRecyclerView = view.findViewById(R.id.podcast_detail_episodes_recyclerview);
        mEpisodeAdapter = new EpisodeAdapter(getActivity(), episodeResponse);
        episodesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        episodesRecyclerView.setAdapter(mEpisodeAdapter);
        if (mPodcast != null) {
            getEpisodeList(mPodcast.getID().getLabel());
        }
        return view;
    }

    private void getEpisodeList(String collectionId){
        MainActivity.MyAPIService myAPIService = MainActivity.RetrofitClientInstance.getRetrofitInstance().create(MainActivity.MyAPIService.class);
        Call<EpisodeResponse> call = myAPIService.getEpisodes(collectionId);
        call.enqueue(new Callback<EpisodeResponse>() {

            @Override
            public void onResponse(Call<EpisodeResponse> call, Response<EpisodeResponse> response) {
                episodeResponse = response.body();
                mEpisodeAdapter.setData(episodeResponse);
            }
            @Override
            public void onFailure(Call<EpisodeResponse> call, Throwable throwable) {
                Log.e("PodcastDetail", throwable.toString());
            }
        });
    }
}
