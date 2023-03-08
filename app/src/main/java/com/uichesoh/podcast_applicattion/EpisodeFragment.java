package com.uichesoh.podcast_applicattion;

import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.uichesoh.podcast_applicattion.apimodel.Entry;
import com.uichesoh.podcast_applicattion.apimodel.PodcastEpisode;

import java.io.IOException;

public class EpisodeFragment extends Fragment {

    private static final String ARG_ENTRY = "entry";
    private static final String ARG_EPISODE = "episode";

    private Entry entry;
    private PodcastEpisode episode;

    private TextView titleTextView;
    private TextView podcastTitleTextView;
    private TextView podcastAuthorTextView;
    private ImageView imageView;
    private TextView descriptionTextView;
    private Button playButton;

    public EpisodeFragment() {
        // Required empty public constructor
    }

    public static EpisodeFragment newInstance(Entry entry, PodcastEpisode episode) {
        EpisodeFragment fragment = new EpisodeFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_ENTRY, entry);
        args.putParcelable(ARG_EPISODE, episode);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            entry = getArguments().getParcelable(ARG_ENTRY);
            episode = getArguments().getParcelable(ARG_EPISODE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MainActivity homeActivity = (MainActivity) getActivity();
        View view = inflater.inflate(R.layout.fragment_podcast_episode, container, false);

        titleTextView = view.findViewById(R.id.episodeTitleTextView);
        podcastTitleTextView = view.findViewById(R.id.podcastTitleTextView);
        podcastTitleTextView.setOnClickListener(v -> {
            homeActivity.loadPodcastDetailScreen(entry);
        });
        podcastAuthorTextView = view.findViewById(R.id.podcastAuthorTextView);
        podcastAuthorTextView.setOnClickListener(v -> {
            homeActivity.loadPodcastDetailScreen(entry);
        });
        imageView = view.findViewById(R.id.podcastImageView);
        descriptionTextView = view.findViewById(R.id.episodeDescriptionTextView);
        playButton = view.findViewById(R.id.playButton);
        String episodeAudioUrl = episode.getPreviewUrl();
        if (episode != null) {
            titleTextView.setText(episode.getTrackName());
            descriptionTextView.setText(episode.getDescription());
            /**
            playButton.setOnClickListener(v -> {
                MediaPlayer mediaPlayer = new MediaPlayer();
                try {
                    mediaPlayer.setDataSource(episode.getPreviewUrl()); // set the audio file URL
                    mediaPlayer.prepare(); // prepare the MediaPlayer asynchronously
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            mp.start(); // start playing the audio
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });*/
        }

        if (entry != null) {
            podcastTitleTextView.setText(entry.getTitle().getLabel());
            podcastAuthorTextView.setText(entry.getIMArtist().getLabel());
            Glide.with(this)
                    .load(entry.getIMImage().get(1).getLabel())
                    .into(imageView);
        }

        return view;
    }

}
