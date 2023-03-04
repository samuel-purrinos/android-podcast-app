package com.uichesoh.podcast_applicattion.apimodel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.IOException;

public enum Rel {
    ALTERNATE, SELF;

    @JsonValue
    public String toValue() {
        switch (this) {
            case ALTERNATE:
                return "alternate";
            case SELF:
                return "self";
        }
        return null;
    }

    @JsonCreator
    public static Rel forValue(String value) throws IOException {
        if (value.equals("alternate")) return ALTERNATE;
        if (value.equals("self")) return SELF;
        throw new IOException("Cannot deserialize Rel");
    }
}
