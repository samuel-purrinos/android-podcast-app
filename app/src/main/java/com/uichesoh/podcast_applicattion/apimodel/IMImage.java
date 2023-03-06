package com.uichesoh.podcast_applicattion.apimodel;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IMImage implements Parcelable {

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

    // Parcelable implementation

    protected IMImage(Parcel in) {
        label = in.readString();
        attributes = in.readParcelable(IMImageAttributes.class.getClassLoader());
    }

    public static final Creator<IMImage> CREATOR = new Creator<IMImage>() {
        @Override
        public IMImage createFromParcel(Parcel in) {
            return new IMImage(in);
        }

        @Override
        public IMImage[] newArray(int size) {
            return new IMImage[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(label);
        dest.writeParcelable(attributes, flags);
    }
}
