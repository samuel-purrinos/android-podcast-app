package com.uichesoh.podcast_applicattion.apimodel;

import android.os.Parcelable;

import java.util.List;

public class EpisodeResponse  {
        int resultCount;
        List<PodcastEpisode> results;

        public int getResultCount() {
            return resultCount;
        }

        public List<PodcastEpisode> getResults() {
            return results;
        }
}
