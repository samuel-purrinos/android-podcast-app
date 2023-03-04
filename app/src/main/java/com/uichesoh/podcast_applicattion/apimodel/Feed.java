package com.uichesoh.podcast_applicattion.apimodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Feed {
    private Author author;
    private List<Entry> entry;
    private Icon updated;
    private Icon rights;
    private Icon title;
    private Icon icon;
    private List<Link> link;
    private Icon id;

    @JsonProperty("author")
    public Author getAuthor() {
        return author;
    }

    @JsonProperty("author")
    public void setAuthor(Author value) {
        this.author = value;
    }

    @JsonProperty("entry")
    public List<Entry> getEntry() {
        return entry;
    }

    @JsonProperty("entry")
    public void setEntry(List<Entry> value) {
        this.entry = value;
    }

    @JsonProperty("updated")
    public Icon getUpdated() {
        return updated;
    }

    @JsonProperty("updated")
    public void setUpdated(Icon value) {
        this.updated = value;
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

    @JsonProperty("icon")
    public Icon getIcon() {
        return icon;
    }

    @JsonProperty("icon")
    public void setIcon(Icon value) {
        this.icon = value;
    }

    @JsonProperty("link")
    public List<Link> getLink() {
        return link;
    }

    @JsonProperty("link")
    public void setLink(List<Link> value) {
        this.link = value;
    }

    @JsonProperty("id")
    public Icon getID() {
        return id;
    }

    @JsonProperty("id")
    public void setID(Icon value) {
        this.id = value;
    }
}
