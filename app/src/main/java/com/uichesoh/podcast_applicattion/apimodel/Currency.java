package com.uichesoh.podcast_applicattion.apimodel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.IOException;

public enum Currency {
    USD;

    @JsonValue
    public String toValue() {
        switch (this) {
            case USD:
                return "USD";
        }
        return null;
    }

    @JsonCreator
    public static Currency forValue(String value) throws IOException {
        if (value.equals("USD")) return USD;
        throw new IOException("Cannot deserialize Currency");
    }
}
