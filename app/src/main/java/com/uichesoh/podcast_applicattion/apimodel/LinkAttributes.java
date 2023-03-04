package com.uichesoh.podcast_applicattion.apimodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LinkAttributes {
    private Rel rel;
    private Type type;
    private String href;

    @JsonProperty("rel")
    public Rel getRel() {
        return rel;
    }

    @JsonProperty("rel")
    public void setRel(Rel value) {
        this.rel = value;
    }

    @JsonProperty("type")
    public Type getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(Type value) {
        this.type = value;
    }

    @JsonProperty("href")
    public String getHref() {
        return href;
    }

    @JsonProperty("href")
    public void setHref(String value) {
        this.href = value;
    }
}
