package com.uichesoh.podcast_applicattion.apimodel;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IMContentType implements Parcelable {
    private IMContentTypeAttributes attributes;

    public IMContentType() {
    }

    @JsonProperty("attributes")
    public IMContentTypeAttributes getAttributes() {
        return attributes;
    }

    @JsonProperty("attributes")
    public void setAttributes(IMContentTypeAttributes value) {
        this.attributes = value;
    }

    // Parcelable implementation
    protected IMContentType(Parcel in) {
        attributes = in.readParcelable(IMContentTypeAttributes.class.getClassLoader());
    }

    public static final Creator<IMContentType> CREATOR = new Creator<IMContentType>() {
        @Override
        public IMContentType createFromParcel(Parcel in) {
            return new IMContentType(in);
        }

        @Override
        public IMContentType[] newArray(int size) {
            return new IMContentType[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable((Parcelable) attributes, flags);
    }
}

