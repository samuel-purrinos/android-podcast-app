package com.uichesoh.podcast_applicattion.apimodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IDAttributes {
    private String imID;

    @JsonProperty("im:id")
    public String getIMID() {
        return imID;
    }

    @JsonProperty("im:id")
    public void setIMID(String value) {
        this.imID = value;
    }
}
