package com.uichesoh.podcast_applicattion;

import android.os.Bundle;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.uichesoh.podcast_applicattion.apimodel.Entry;
import com.uichesoh.podcast_applicattion.apimodel.Welcome;

import java.util.ArrayList;


/**
 * A fragment representing a list of Items.
 */
public class PodcastList extends Fragment {
    private Welcome podcasts;
    private PodcastAdapter podcastAdapter;
    private RecyclerView recyclerView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_podcast_list, container, false);
        AutoCompleteTextView autoCompleteTextView = view.findViewById(R.id.autoCompleteTextView);
        this.podcastAdapter = new PodcastAdapter(getContext(), new ArrayList<Entry>());
        autoCompleteTextView.setAdapter(podcastAdapter);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        return view;
    }


    public void setPodcasts(Welcome podcasts) {
        this.podcasts = podcasts;
        this.podcastAdapter.clear();
        this.podcastAdapter.setPocasts(podcasts.getFeed().getEntry());
        this.podcastAdapter.notifyDataSetChanged();
    }

}