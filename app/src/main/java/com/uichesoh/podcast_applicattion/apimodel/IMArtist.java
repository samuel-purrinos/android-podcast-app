package com.uichesoh.podcast_applicattion.apimodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IMArtist {
    private String label;
    private IMArtistAttributes attributes;

    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    @JsonProperty("label")
    public void setLabel(String value) {
        this.label = value;
    }

    @JsonProperty("attributes")
    public IMArtistAttributes getAttributes() {
        return attributes;
    }

    @JsonProperty("attributes")
    public void setAttributes(IMArtistAttributes value) {
        this.attributes = value;
    }
}
