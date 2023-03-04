package com.uichesoh.podcast_applicattion.apimodel;
import java.io.IOException;
import com.fasterxml.jackson.annotation.*;
public enum PurpleLabel {
    MUSIC, MUSIC_COMMENTARY, MUSIC_HISTORY, MUSIC_INTERVIEWS, NATURAL_SCIENCES;

    @JsonValue
    public String toValue() {
        switch (this) {
            case MUSIC: return "Music";
            case MUSIC_COMMENTARY: return "Music Commentary";
            case MUSIC_HISTORY: return "Music History";
            case MUSIC_INTERVIEWS: return "Music Interviews";
            case NATURAL_SCIENCES: return "Natural Sciences";
        }
        return null;
    }

    @JsonCreator
    public static PurpleLabel forValue(String value) throws IOException {
        if (value.equals("Music")) return MUSIC;
        if (value.equals("Music Commentary")) return MUSIC_COMMENTARY;
        if (value.equals("Music History")) return MUSIC_HISTORY;
        if (value.equals("Music Interviews")) return MUSIC_INTERVIEWS;
        if (value.equals("Natural Sciences")) return NATURAL_SCIENCES;
        throw new IOException("Cannot deserialize PurpleLabel");
    }
}
