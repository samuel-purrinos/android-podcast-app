package com.uichesoh.podcast_applicattion.apimodel;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IMPrice implements Parcelable {
    private String label;
    private IMPriceAttributes attributes;

    public IMPrice(){

    }
    public static final Creator<IMPrice> CREATOR = new Creator<IMPrice>() {
        @Override
        public IMPrice createFromParcel(Parcel in) {
            return new IMPrice(in);
        }

        @Override
        public IMPrice[] newArray(int size) {
            return new IMPrice[size];
        }
    };
    protected IMPrice(Parcel in) {
        label = in.readString();
        attributes = in.readParcelable(IMPriceAttributes.class.getClassLoader());
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(label);
        dest.writeParcelable(attributes, flags);
    }

    @Override
    public int describeContents() {
        return 0;
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
    public IMPriceAttributes getAttributes() {
        return attributes;
    }

    @JsonProperty("attributes")
    public void setAttributes(IMPriceAttributes value) {
        this.attributes = value;
    }
}
