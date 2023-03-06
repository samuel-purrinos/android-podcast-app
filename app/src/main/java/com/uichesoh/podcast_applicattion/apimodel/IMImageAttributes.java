package com.uichesoh.podcast_applicattion.apimodel;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IMImageAttributes implements Parcelable {
    @JsonProperty("height")
    private String height;

    public IMImageAttributes() {}

    public String getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(String height) {
        this.height = height;
    }

    protected IMImageAttributes(Parcel in) {
        height = in.readString();
    }

    public static final Creator<IMImageAttributes> CREATOR = new Creator<IMImageAttributes>() {
        @Override
        public IMImageAttributes createFromParcel(Parcel in) {
            return new IMImageAttributes(in);
        }

        @Override
        public IMImageAttributes[] newArray(int size) {
            return new IMImageAttributes[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(height);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
