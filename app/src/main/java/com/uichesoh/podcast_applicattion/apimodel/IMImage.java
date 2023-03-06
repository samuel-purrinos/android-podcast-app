package com.uichesoh.podcast_applicattion.apimodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IMImage implements java.io.Serializable{
    private String label;
    private IMImageAttributes attributes;

    public IMImage() {
    }
    public IMImage(String label, IMImageAttributes attributes) {
        this.label = label;
        this.attributes = attributes;
    }
    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    @JsonProperty("label")
    public void setLabel(String value) {
        this.label = value;
    }

    @JsonProperty("attributes")
    public IMImageAttributes getAttributes() {
        return attributes;
    }

    @JsonProperty("attributes")
    public void setAttributes(IMImageAttributes value) {
        this.attributes = value;
    }
}
