package com.uichesoh.podcast_applicattion.apimodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;
import java.util.UUID;
@JsonIgnoreProperties(ignoreUnknown = true)
public class PodcastEpisode {
    private String wrapperType;
    private String kind;

    private long collectionID;
    private long trackID;
    private String artistName;
    private String collectionName;
    private String trackName;
    private String collectionCensoredName;
    private String trackCensoredName;
    private String collectionViewURL;
    private String feedURL;
    private String trackViewURL;
    private String artworkUrl30;
    private String artworkUrl60;
    private String artworkUrl100;
    private Long collectionPrice;
    private Long trackPrice;
    private Long collectionHDPrice;
    private Date releaseDate;
    private String collectionExplicitness;
    private String trackExplicitness;
    private Long trackCount;
    private long trackTimeMillis;
    private String country;
    private String currency;
    private String primaryGenreName;
    private String contentAdvisoryRating;
    private String artworkUrl600;
    @JsonIgnore
    private List<String> genreIDS;
    @JsonIgnore
    private List<String> genres;
    private String closedCaptioning;
    private String previewURL;
    private UUID episodeGUID;
    private String description;
    private String shortDescription;
    @JsonIgnore
    private List<Object> artistIDS;
    private String artworkUrl160;
    private String episodeFileExtension;
    private String episodeContentType;
    private String episodeURL;

    public String getWrapperType() {
        return wrapperType;
    }

    public String getKind() {
        return kind;
    }

    public long getCollectionID() {
        return collectionID;
    }

    public long getTrackID() {
        return trackID;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public String getTrackName() {
        return trackName;
    }

    public String getCollectionCensoredName() {
        return collectionCensoredName;
    }

    public String getTrackCensoredName() {
        return trackCensoredName;
    }

    public String getCollectionViewURL() {
        return collectionViewURL;
    }

    public String getFeedURL() {
        return feedURL;
    }

    public String getTrackViewURL() {
        return trackViewURL;
    }

    public String getArtworkUrl30() {
        return artworkUrl30;
    }

    public String getArtworkUrl60() {
        return artworkUrl60;
    }

    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    public Long getCollectionPrice() {
        return collectionPrice;
    }

    public Long getTrackPrice() {
        return trackPrice;
    }

    public Long getCollectionHDPrice() {
        return collectionHDPrice;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public String getCollectionExplicitness() {
        return collectionExplicitness;
    }

    public String getTrackExplicitness() {
        return trackExplicitness;
    }

    public Long getTrackCount() {
        return trackCount;
    }

    public long getTrackTimeMillis() {
        return trackTimeMillis;
    }

    public String getCountry() {
        return country;
    }

    public String getCurrency() {
        return currency;
    }

    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    public String getContentAdvisoryRating() {
        return contentAdvisoryRating;
    }

    public String getArtworkUrl600() {
        return artworkUrl600;
    }

    public String getClosedCaptioning() {
        return closedCaptioning;
    }

    public String getPreviewURL() {
        return previewURL;
    }

    public UUID getEpisodeGUID() {
        return episodeGUID;
    }

    public String getDescription() {
        return description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getArtworkUrl160() {
        return artworkUrl160;
    }

    public String getEpisodeFileExtension() {
        return episodeFileExtension;
    }

    public String getEpisodeContentType() {
        return episodeContentType;
    }

    public String getEpisodeURL() {
        return episodeURL;
    }
}
