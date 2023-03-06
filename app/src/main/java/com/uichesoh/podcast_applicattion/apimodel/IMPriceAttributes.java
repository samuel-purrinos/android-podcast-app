package com.uichesoh.podcast_applicattion.apimodel;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IMPriceAttributes implements Parcelable {
    private String amount;
    private String currency;
    public IMPriceAttributes() {}

    protected IMPriceAttributes(Parcel in) {
        amount = in.readString();
        currency = in.readString();
    }
    @Override
    public int describeContents() {
        return 0;
    }
    public static final Creator<IMPriceAttributes> CREATOR = new Creator<IMPriceAttributes>() {
        @Override
        public IMPriceAttributes createFromParcel(Parcel in) {
            return new IMPriceAttributes(in);
        }

        @Override
        public IMPriceAttributes[] newArray(int size) {
            return new IMPriceAttributes[size];
        }
    };
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(amount);
        dest.writeString(currency);
    }
    @JsonProperty("amount")
    public String getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(String value) {
        this.amount = value;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String value) {
        this.currency = value;
    }
}
