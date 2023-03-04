package com.uichesoh.podcast_applicattion.apimodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryAttributes {
    private String imID;
    private PurpleLabel term;
    private String scheme;
    private PurpleLabel label;

    @JsonProperty("im:id")
    public String getIMID() { return imID; }
    @JsonProperty("im:id")
    public void setIMID(String value) { this.imID = value; }

    @JsonIgnore()
    public PurpleLabel getTerm() { return term; }
    @JsonProperty("term")
    public void setTerm(PurpleLabel value) { this.term = value; }

    @JsonProperty("scheme")
    public String getScheme() { return scheme; }
    @JsonProperty("scheme")
    public void setScheme(String value) { this.scheme = value; }

    @JsonIgnore()
    public PurpleLabel getLabel() { return label; }
    @JsonProperty("label")
    public void setLabel(PurpleLabel value) { this.label = value; }

}
