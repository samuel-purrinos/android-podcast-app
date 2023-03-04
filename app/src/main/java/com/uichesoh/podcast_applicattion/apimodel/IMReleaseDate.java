package com.uichesoh.podcast_applicattion.apimodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.*;
import java.util.Date;

public class IMReleaseDate {
    private Date label;
    private Icon attributes;

    @JsonProperty("label")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssX", timezone = "UTC")
    public Date getLabel() { return label; }
    @JsonProperty("label")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssX", timezone = "UTC")
    public void setLabel(Date value) { this.label = value; }

    @JsonProperty("attributes")
    public Icon getAttributes() { return attributes; }
    @JsonProperty("attributes")
    public void setAttributes(Icon value) { this.attributes = value; }
}

