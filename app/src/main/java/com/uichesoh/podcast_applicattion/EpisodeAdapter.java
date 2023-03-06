package com.uichesoh.podcast_applicattion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uichesoh.podcast_applicattion.apimodel.EpisodeResponse;
import com.uichesoh.podcast_applicattion.apimodel.PodcastEpisode;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EpisodeAdapter extends RecyclerView.Adapter<EpisodeAdapter.ViewHolder> {

    private EpisodeResponse episodeResponse;
    private Context context;

    public EpisodeAdapter(Context context, EpisodeResponse episodeResponse) {
        this.context = context;
        this.episodeResponse = episodeResponse;
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
            new EpisodeAdapterListener(){
                @Override
                public void onEpisodeSelected(PodcastEpisode episode) {

                }
            };
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

    public void setData(EpisodeResponse episodes) {
        episodeResponse = episodes;
        notifyDataSetChanged();
    }
}
