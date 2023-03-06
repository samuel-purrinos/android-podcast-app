package com.uichesoh.podcast_applicattion;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.uichesoh.podcast_applicattion.apimodel.Entry;
import com.uichesoh.podcast_applicattion.apimodel.EpisodeResponse;
import com.uichesoh.podcast_applicattion.apimodel.PodcastEpisode;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EpisodeAdapter extends RecyclerView.Adapter<EpisodeAdapter.ViewHolder> {

    private EpisodeResponse episodeResponse;
    private Context context;
    private Entry podcast;

    public EpisodeAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.episode_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PodcastEpisode episode = episodeResponse.getResults().get(position);
        holder.titleTextView.setText(episode.getTrackName());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date releaseDate = episode.getReleaseDate();
        holder.dateTextView.setText((dateFormat.format(releaseDate)));
        holder.durationTextView.setText(String.valueOf((episode.getTrackTimeMillis() / 1000) / 60));
        holder.itemView.setOnClickListener(v -> {
            if (context instanceof FragmentActivity) {
                EpisodeFragment fragment = EpisodeFragment.newInstance(podcast,episode);
                FragmentActivity activity = (FragmentActivity) context;
                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_podcast_list, fragment)
                        .addToBackStack(null)
                        .commit();
            }

        });
    }

    @Override
    public int getItemCount() {
        if (episodeResponse == null || episodeResponse.getResults() == null) {
            return 0;
        }
        return episodeResponse.getResults().size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView titleTextView;
        private TextView dateTextView;
        private TextView durationTextView;

        ViewHolder(View view) {
            super(view);
            titleTextView = view.findViewById(R.id.titleTextView);
            dateTextView = view.findViewById(R.id.dateTextView);
            durationTextView = view.findViewById(R.id.durationTextView);
        }
    }

    public interface EpisodeAdapterListener {
        void onEpisodeSelected(PodcastEpisode episode);
    }

    public void setEpisodes(EpisodeResponse episodes) {
        episodeResponse = episodes;
        Log.d("EpisodeAdapter", "DATA SIZE " + episodes.getResultCount());
        notifyDataSetChanged();
    }
    public void setPodcast(Entry podcast) {
        this.podcast = podcast;
    }
}
