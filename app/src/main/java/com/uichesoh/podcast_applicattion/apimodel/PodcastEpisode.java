package com.uichesoh.podcast_applicattion.apimodel;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class PodcastEpisode implements Parcelable {

    private String shortDescription;
    private String episodeGuid;
    private String country;
    private String artworkUrl60;
    private String contentAdvisoryRating;
    private String trackViewUrl;
    private String description;
    private long trackId;
    private String trackName;

    private Date releaseDate;
    private String feedUrl;
    private String closedCaptioning;
    private long collectionId;
    private String collectionName;
    private int artistId;
    private String previewUrl;
    private String artworkUrl160;
    private String episodeContentType;
    private String collectionViewUrl;
    private long trackTimeMillis;
    private String episodeFileExtension;
    private String episodeUrl;
    private String artworkUrl600;
    private String kind;
    private String wrapperType;

    public PodcastEpisode() {
    }

    protected PodcastEpisode(Parcel in) {
        country = in.readString();
        artworkUrl60 = in.readString();
        contentAdvisoryRating = in.readString();
        trackViewUrl = in.readString();
        episodeGuid = in.readString();
        description = in.readString();
        trackId = in.readLong();
        trackName = in.readString();
        shortDescription = in.readString();
        releaseDate = new Date(in.readLong());
        feedUrl = in.readString();
        closedCaptioning = in.readString();
        collectionId = in.readLong();
        collectionName = in.readString();
        artistId = in.readInt();
        previewUrl = in.readString();
        artworkUrl160 = in.readString();
        episodeContentType = in.readString();
        collectionViewUrl = in.readString();
        trackTimeMillis = in.readLong();
        episodeFileExtension = in.readString();
        episodeUrl = in.readString();
        artworkUrl600 = in.readString();
        kind = in.readString();
        wrapperType = in.readString();
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(country);
        dest.writeString(artworkUrl60);
        dest.writeString(contentAdvisoryRating);
        dest.writeString(trackViewUrl);
        dest.writeString(episodeGuid);
        dest.writeString(description);
        dest.writeLong(trackId);
        dest.writeString(trackName);
        dest.writeString(shortDescription);
        dest.writeLong(releaseDate.getTime());
        dest.writeString(feedUrl);
        dest.writeString(closedCaptioning);
        dest.writeLong(collectionId);
        dest.writeString(collectionName);
        dest.writeInt(artistId);
        dest.writeString(previewUrl);
        dest.writeString(artworkUrl160);
        dest.writeString(episodeContentType);
        dest.writeString(collectionViewUrl);
        dest.writeLong(trackTimeMillis);
        dest.writeString(episodeFileExtension);
        dest.writeString(episodeUrl);
        dest.writeString(artworkUrl600);
        dest.writeString(kind);
        dest.writeString(wrapperType);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PodcastEpisode> CREATOR = new Creator<PodcastEpisode>() {
        @Override
        public PodcastEpisode createFromParcel(Parcel in) {
            return new PodcastEpisode(in);
        }

        @Override
        public PodcastEpisode[] newArray(int size) {
            return new PodcastEpisode[size];
        }
    };

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getArtworkUrl60() {
        return artworkUrl60;
    }

    public void setArtworkUrl60(String artworkUrl60) {
        this.artworkUrl60 = artworkUrl60;
    }

    public String getContentAdvisoryRating() {
        return contentAdvisoryRating;
    }

    public void setContentAdvisoryRating(String contentAdvisoryRating) {
        this.contentAdvisoryRating = contentAdvisoryRating;
    }

    public String getTrackViewUrl() {
        return trackViewUrl;
    }

    public void setTrackViewUrl(String trackViewUrl) {
        this.trackViewUrl = trackViewUrl;
    }

    public String getEpisodeGuid() {
        return episodeGuid;
    }

    public void setEpisodeGuid(String episodeGuid) {
        this.episodeGuid = episodeGuid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getTrackId() {
        return trackId;
    }

    public void setTrackId(long trackId) {
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getFeedUrl() {
        return feedUrl;
    }

    public void setFeedUrl(String feedUrl) {
        this.feedUrl = feedUrl;
    }

    public String getClosedCaptioning() {
        return closedCaptioning;
    }

    public void setClosedCaptioning(String closedCaptioning) {
        this.closedCaptioning = closedCaptioning;
    }

    public long getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(long collectionId) {
        this.collectionId = collectionId;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public String getArtworkUrl160() {
        return artworkUrl160;
    }

    public void setArtworkUrl160(String artworkUrl160) {
        this.artworkUrl160 = artworkUrl160;
    }

    public String getEpisodeContentType() {
        return episodeContentType;
    }

    public void setEpisodeContentType(String episodeContentType) {
        this.episodeContentType = episodeContentType;
    }

    public String getCollectionViewUrl() {
        return collectionViewUrl;
    }

    public void setCollectionViewUrl(String collectionViewUrl) {
        this.collectionViewUrl = collectionViewUrl;
    }

    public long getTrackTimeMillis() {
        return trackTimeMillis;
    }

    public void setTrackTimeMillis(long trackTimeMillis) {
        this.trackTimeMillis = trackTimeMillis;
    }

    public String getEpisodeFileExtension() {
        return episodeFileExtension;
    }

    public void setEpisodeFileExtension(String episodeFileExtension) {
        this.episodeFileExtension = episodeFileExtension;
    }

    public String getEpisodeUrl() {
        return episodeUrl;
    }

    public void setEpisodeUrl(String episodeUrl) {
        this.episodeUrl = episodeUrl;
    }

    public String getArtworkUrl600() {
        return artworkUrl600;
    }

    public void setArtworkUrl600(String artworkUrl600) {
        this.artworkUrl600 = artworkUrl600;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getWrapperType() {
        return wrapperType;
    }

    public void setWrapperType(String wrapperType) {
        this.wrapperType = wrapperType;
    }
}