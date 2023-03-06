package com.uichesoh.podcast_applicattion.apimodel;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Entry implements Parcelable {
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

    public Entry() {
    }

    public Entry(Icon imName, List<IMImage> imImage, Icon summary, IMPrice imPrice, IMContentType imContentType, Icon rights, Icon title, Link link, ID id, IMArtist imArtist, Category category, IMReleaseDate imReleaseDate) {
        this.imName = imName;
        this.imImage = imImage;
        this.summary = summary;
        this.imPrice = imPrice;
        this.imContentType = imContentType;
        this.rights = rights;
        this.title = title;
        this.link = link;
        this.id = id;
        this.imArtist = imArtist;
        this.category = category;
        this.imReleaseDate = imReleaseDate;
    }

    protected Entry(Parcel in) {
        imName = in.readParcelable(Icon.class.getClassLoader());
        imImage = new ArrayList<>();
        in.readList(imImage, IMImage.class.getClassLoader());
        summary = in.readParcelable(Icon.class.getClassLoader());
        imPrice = in.readParcelable(IMPrice.class.getClassLoader());
        imContentType = in.readParcelable(IMContentType.class.getClassLoader());
        rights = in.readParcelable(Icon.class.getClassLoader());
        title = in.readParcelable(Icon.class.getClassLoader());
        link = in.readParcelable(Link.class.getClassLoader());
        id = in.readParcelable(ID.class.getClassLoader());
        imArtist = in.readParcelable(IMArtist.class.getClassLoader());
        category = in.readParcelable(Category.class.getClassLoader());
        imReleaseDate = in.readParcelable(IMReleaseDate.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable((Parcelable) imName, flags);
        dest.writeList(imImage);
        dest.writeParcelable((Parcelable) summary, flags);
        dest.writeParcelable((Parcelable) imPrice, flags);
        dest.writeParcelable((Parcelable) imContentType, flags);
        dest.writeParcelable((Parcelable) rights, flags);
        dest.writeParcelable((Parcelable) title, flags);
        dest.writeParcelable((Parcelable) link, flags);
        dest.writeParcelable((Parcelable) id, flags);
        dest.writeParcelable((Parcelable) imArtist, flags);
        dest.writeParcelable((Parcelable) category, flags);
        dest.writeParcelable((Parcelable) imReleaseDate, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Entry> CREATOR = new Creator<Entry>() {
        @Override
        public Entry createFromParcel(Parcel in) {
            return new Entry(in);
        }

        @Override
        public Entry[] newArray(int size) {
            return new Entry[size];
        }
    };


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
