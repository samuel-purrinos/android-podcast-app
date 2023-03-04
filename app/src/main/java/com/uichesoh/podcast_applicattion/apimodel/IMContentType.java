package com.uichesoh.podcast_applicattion.apimodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IMContentType {
    private IMContentTypeAttributes attributes;

    @JsonProperty("attributes")
    public IMContentTypeAttributes getAttributes() {
        return attributes;
    }

    @JsonProperty("attributes")
    public void setAttributes(IMContentTypeAttributes value) {
        this.attributes = value;
    }
}
