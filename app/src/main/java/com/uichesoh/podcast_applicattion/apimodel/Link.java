package com.uichesoh.podcast_applicattion.apimodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Link {
    private LinkAttributes attributes;

    @JsonProperty("attributes")
    public LinkAttributes getAttributes() {
        return attributes;
    }

    @JsonProperty("attributes")
    public void setAttributes(LinkAttributes value) {
        this.attributes = value;
    }
}
