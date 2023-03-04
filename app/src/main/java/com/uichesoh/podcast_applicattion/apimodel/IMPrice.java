package com.uichesoh.podcast_applicattion.apimodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IMPrice {
    private IMPriceLabel label;
    private IMPriceAttributes attributes;

    @JsonProperty("label")
    public IMPriceLabel getLabel() {
        return label;
    }

    @JsonProperty("label")
    public void setLabel(IMPriceLabel value) {
        this.label = value;
    }

    @JsonProperty("attributes")
    public IMPriceAttributes getAttributes() {
        return attributes;
    }

    @JsonProperty("attributes")
    public void setAttributes(IMPriceAttributes value) {
        this.attributes = value;
    }
}
