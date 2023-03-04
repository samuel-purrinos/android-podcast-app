package com.uichesoh.podcast_applicattion.apimodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Entry {
    private Icon imName;
    private List<IMImage> imImage;
    private Icon summary;
    private IMPrice imPrice;
    private IMContentType imContentType;
    private Icon rights;
    private Icon title;
    private Link link;
    private ID id;
    private IMArtist imArtist;
    private Category category;
    private IMReleaseDate imReleaseDate;

    @JsonProperty("im:name")
    public Icon getIMName() {
        return imName;
    }

    @JsonProperty("im:name")
    public void setIMName(Icon value) {
        this.imName = value;
    }

    @JsonProperty("im:image")
    public List<IMImage> getIMImage() {
        return imImage;
    }

    @JsonProperty("im:image")
    public void setIMImage(List<IMImage> value) {
        this.imImage = value;
    }

    @JsonProperty("summary")
    public Icon getSummary() {
        return summary;
    }

    @JsonProperty("summary")
    public void setSummary(Icon value) {
        this.summary = value;
    }

    @JsonProperty("im:price")
    public IMPrice getIMPrice() {
        return imPrice;
    }

    @JsonProperty("im:price")
    public void setIMPrice(IMPrice value) {
        this.imPrice = value;
    }

    @JsonProperty("im:contentType")
    public IMContentType getIMContentType() {
        return imContentType;
    }

    @JsonProperty("im:contentType")
    public void setIMContentType(IMContentType value) {
        this.imContentType = value;
    }

    @JsonProperty("rights")
    public Icon getRights() {
        return rights;
    }

    @JsonProperty("rights")
    public void setRights(Icon value) {
        this.rights = value;
    }

    @JsonProperty("title")
    public Icon getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(Icon value) {
        this.title = value;
    }

    @JsonProperty("link")
    public Link getLink() {
        return link;
    }

    @JsonProperty("link")
    public void setLink(Link value) {
        this.link = value;
    }

    @JsonProperty("id")
    public ID getID() {
        return id;
    }

    @JsonProperty("id")
    public void setID(ID value) {
        this.id = value;
    }

    @JsonProperty("im:artist")
    public IMArtist getIMArtist() {
        return imArtist;
    }

    @JsonProperty("im:artist")
    public void setIMArtist(IMArtist value) {
        this.imArtist = value;
    }

    @JsonProperty("category")
    public Category getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(Category value) {
        this.category = value;
    }

    @JsonProperty("im:releaseDate")
    public IMReleaseDate getIMReleaseDate() {
        return imReleaseDate;
    }

    @JsonProperty("im:releaseDate")
    public void setIMReleaseDate(IMReleaseDate value) {
        this.imReleaseDate = value;
    }
}
