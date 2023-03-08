package com.uichesoh.podcast_applicattion;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.uichesoh.podcast_applicattion.apimodel.Entry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PodcastAdapter extends ArrayAdapter<String> implements Filterable {

    private List<Entry> podcasts;
    private List<String> mOriginalValues;
    private List<String> mDisplayedValues;

    public PodcastAdapter(Context context, ArrayList<Entry> apiResponse) {
        super(context, android.R.layout.simple_dropdown_item_1line);
        this.podcasts = apiResponse;
        this.setPocasts(apiResponse);
        this.mDisplayedValues = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mDisplayedValues.size();
    }

    @Override
    public String getItem(int position) {
        return mDisplayedValues.get(position);
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                List<String> filteredList = new ArrayList<>();
                if (constraint == null || constraint.length() == 0) {
                    filteredList.addAll(mOriginalValues);
                } else {
                    String filterPattern = constraint.toString().toLowerCase().trim();
                    for (String item : mOriginalValues) {
                        if (item.toLowerCase().contains(filterPattern)) {
                            filteredList.add(item);
                        }
                    }
                }
                results.values = filteredList;
                results.count = filteredList.size();
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                mDisplayedValues.clear();
                mDisplayedValues.addAll((Collection<? extends String>) results.values);
                notifyDataSetChanged();
            }
        };
    }


    public void setPocasts(List<Entry> entry) {
        this.podcasts = entry;
        this.mOriginalValues = new ArrayList<>();
        for(Entry singlePodcast : podcasts){
            this.mOriginalValues.add(singlePodcast.getTitle().getLabel());
        }
        notifyDataSetChanged();
    }


    public List<Entry> getPodcasts() {
        return podcasts;
    }
}
