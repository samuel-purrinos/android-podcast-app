package com.uichesoh.podcast_applicattion.apimodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Welcome {
    private Feed feed;

    @JsonProperty("feed")
    public Feed getFeed() {
        return feed;
    }

    @JsonProperty("feed")
    public void setFeed(Feed value) {
        this.feed = value;
    }
}
