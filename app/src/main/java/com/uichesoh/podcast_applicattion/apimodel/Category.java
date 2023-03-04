package com.uichesoh.podcast_applicattion.apimodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Category {
    private CategoryAttributes attributes;

    @JsonProperty("attributes")
    public CategoryAttributes getAttributes() {
        return attributes;
    }

    @JsonProperty("attributes")
    public void setAttributes(CategoryAttributes value) {
        this.attributes = value;
    }
}
