package com.uichesoh.podcast_applicattion.apimodel;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LinkAttributes implements Parcelable {
    private String rel;
    private String type;
    private String href;

    public LinkAttributes() {
    }

    @JsonProperty("rel")
    public String getRel() {
        return rel;
    }

    @JsonProperty("rel")
    public void setRel(String value) {
        this.rel = value;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String value) {
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

    protected LinkAttributes(Parcel in) {
        rel = in.readString();
        type = in.readString();
        href = in.readString();
    }

    public static final Creator<LinkAttributes> CREATOR = new Creator<LinkAttributes>() {
        @Override
        public LinkAttributes createFromParcel(Parcel in) {
            return new LinkAttributes(in);
        }

        @Override
        public LinkAttributes[] newArray(int size) {
            return new LinkAttributes[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(rel);
        dest.writeString(type);
        dest.writeString(href);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}

