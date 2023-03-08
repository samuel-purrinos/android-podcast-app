package com.uichesoh.podcast_applicattion.apimodel;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IMContentTypeAttributes implements Parcelable {
    private String term;
    private String label;

    public IMContentTypeAttributes() {
    }
    @JsonProperty("term")
    public String getTerm() {
        return term;
    }

    @JsonProperty("term")
    public void setTerm(String value) {
        this.term = value;
    }

    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    @JsonProperty("label")
    public void setLabel(String value) {
        this.label = value;
    }

    // Parcelable implementation
    protected IMContentTypeAttributes(Parcel in) {
        term = in.readString();
        label = in.readString();
    }

    public static final Creator<IMContentTypeAttributes> CREATOR = new Creator<IMContentTypeAttributes>() {
        @Override
        public IMContentTypeAttributes createFromParcel(Parcel in) {
            return new IMContentTypeAttributes(in);
        }

        @Override
        public IMContentTypeAttributes[] newArray(int size) {
            return new IMContentTypeAttributes[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(term);
        dest.writeString(label);
    }
}

