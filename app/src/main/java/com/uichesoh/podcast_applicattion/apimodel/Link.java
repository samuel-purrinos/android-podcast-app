package com.uichesoh.podcast_applicattion.apimodel;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Link implements Parcelable {
    private LinkAttributes attributes;

    public Link() {
    }
    @JsonProperty("attributes")
    public LinkAttributes getAttributes() {
        return attributes;
    }

    @JsonProperty("attributes")
    public void setAttributes(LinkAttributes value) {
        this.attributes = value;
    }

    protected Link(Parcel in) {
        attributes = in.readParcelable(LinkAttributes.class.getClassLoader());
    }

    public static final Creator<Link> CREATOR = new Creator<Link>() {
        @Override
        public Link createFromParcel(Parcel in) {
            return new Link(in);
        }

        @Override
        public Link[] newArray(int size) {
            return new Link[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(attributes, flags);
    }
}

