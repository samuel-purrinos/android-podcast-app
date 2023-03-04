package com.uichesoh.podcast_applicattion.apimodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Author {
    private Icon name;
    private Icon uri;

    @JsonProperty("name")
    public Icon getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(Icon value) {
        this.name = value;
    }

    @JsonProperty("uri")
    public Icon getURI() {
        return uri;
    }

    @JsonProperty("uri")
    public void setURI(Icon value) {
        this.uri = value;
    }
}
