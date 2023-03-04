package com.uichesoh.podcast_applicattion.apimodel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.IOException;

public enum IMPriceLabel {
    GET;

    @JsonValue
    public String toValue() {
        switch (this) {
            case GET:
                return "Get";
        }
        return null;
    }

    @JsonCreator
    public static IMPriceLabel forValue(String value) throws IOException {
        if (value.equals("Get")) return GET;
        throw new IOException("Cannot deserialize IMPriceLabel");
    }
}
