package com.uichesoh.podcast_applicattion.apimodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IMImageAttributes {
    private String height;

    @JsonProperty("height")
    public String getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(String value) {
        this.height = value;
    }
}
