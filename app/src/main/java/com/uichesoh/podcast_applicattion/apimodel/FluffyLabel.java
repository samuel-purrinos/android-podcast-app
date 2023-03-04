package com.uichesoh.podcast_applicattion.apimodel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.IOException;

public enum FluffyLabel {
    PODCAST;

    @JsonValue
    public String toValue() {
        switch (this) {
            case PODCAST:
                return "Podcast";
        }
        return null;
    }

    @JsonCreator
    public static FluffyLabel forValue(String value) throws IOException {
        if (value.equals("Podcast")) return PODCAST;
        throw new IOException("Cannot deserialize FluffyLabel");
    }
}
