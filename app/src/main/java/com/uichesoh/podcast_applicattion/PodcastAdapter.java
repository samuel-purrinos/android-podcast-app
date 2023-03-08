package com.uichesoh.podcast_applicattion;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import com.uichesoh.podcast_applicattion.apimodel.Entry;

import java.util.ArrayList;
import java.util.List;

public class PodcastAdapter extends ArrayAdapter<String> implements Filterable {

    private List<Entry> podcasts;
    private List<String> suggestions;

    public PodcastAdapter(Context context, ArrayList<Entry> apiResponse) {
        super(context, android.R.layout.simple_dropdown_item_1line);
        this.podcasts = apiResponse;
    }

    @Override
    public int getCount() {
        return podcasts.size();
    }

    @Override
    public String getItem(int position) {
        return suggestions.get(position);
    }

    @Override
    public Filter getFilter() {
        return new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();

                if (constraint == null || constraint.length() == 0) {
                    results.values = podcasts;
                    results.count = podcasts.size();
                } else {
                    List<String> sugerencias = new ArrayList<>();

                    for (Entry singlePodcast : podcasts) {
                        if (singlePodcast.getTitle().getLabel().toLowerCase().contains(constraint.toString().toLowerCase())) {
                            sugerencias.add(singlePodcast.getTitle().getLabel());
                        }
                    }

                    results.values = sugerencias;
                    suggestions = sugerencias;
                    results.count = sugerencias.size();
                }

                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                clear();
                addAll((List<String>) results.values);
                notifyDataSetChanged();
            }
        };
    }

    public void setPocasts(List<Entry> entry) {
        this.podcasts = entry;
        notifyDataSetChanged();
    }
}
