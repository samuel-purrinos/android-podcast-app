package com.uichesoh.podcast_applicattion.apimodel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.IOException;

public enum Type {
    TEXT_HTML;

    @JsonValue
    public String toValue() {
        switch (this) {
            case TEXT_HTML:
                return "text/html";
        }
        return null;
    }

    @JsonCreator
    public static Type forValue(String value) throws IOException {
        if (value.equals("text/html")) return TEXT_HTML;
        throw new IOException("Cannot deserialize Type");
    }
}
