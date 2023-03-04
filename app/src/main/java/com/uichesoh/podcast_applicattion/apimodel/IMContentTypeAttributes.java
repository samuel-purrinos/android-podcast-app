package com.uichesoh.podcast_applicattion.apimodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IMContentTypeAttributes {
    private FluffyLabel term;
    private FluffyLabel label;

    @JsonProperty("term")
    public FluffyLabel getTerm() {
        return term;
    }

    @JsonProperty("term")
    public void setTerm(FluffyLabel value) {
        this.term = value;
    }

    @JsonProperty("label")
    public FluffyLabel getLabel() {
        return label;
    }

    @JsonProperty("label")
    public void setLabel(FluffyLabel value) {
        this.label = value;
    }
}
