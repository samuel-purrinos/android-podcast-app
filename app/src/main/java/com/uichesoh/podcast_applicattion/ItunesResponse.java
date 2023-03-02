package com.uichesoh.podcast_applicattion;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.List;

public class ItunesResponse {
    public class Welcome {
        private Feed feed;

        public Feed getFeed() { return feed; }
        public void setFeed(Feed value) { this.feed = value; }
    }

    public class Feed {
        private Author author;
        private List<Entry> entry;
        private Icon updated;
        private Icon rights;
        private Icon title;
        private Icon icon;
        private List<Link> link;
        private Icon id;

        public Author getAuthor() { return author; }
        public void setAuthor(Author value) { this.author = value; }

        public List<Entry> getEntry() { return entry; }
        public void setEntry(List<Entry> value) { this.entry = value; }

        public Icon getUpdated() { return updated; }
        public void setUpdated(Icon value) { this.updated = value; }

        public Icon getRights() { return rights; }
        public void setRights(Icon value) { this.rights = value; }

        public Icon getTitle() { return title; }
        public void setTitle(Icon value) { this.title = value; }

        public Icon getIcon() { return icon; }
        public void setIcon(Icon value) { this.icon = value; }

        public List<Link> getLink() { return link; }
        public void setLink(List<Link> value) { this.link = value; }

        public Icon getID() { return id; }
        public void setID(Icon value) { this.id = value; }
    }

    public class Author {
        private Icon name;
        private Icon uri;

        public Icon getName() { return name; }
        public void setName(Icon value) { this.name = value; }

        public Icon getURI() { return uri; }
        public void setURI(Icon value) { this.uri = value; }
    }
    public class Icon {
        private String label;

        public String getLabel() { return label; }
        public void setLabel(String value) { this.label = value; }
    }

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

        public Icon getIMName() { return imName; }
        public void setIMName(Icon value) { this.imName = value; }

        public List<IMImage> getIMImage() { return imImage; }
        public void setIMImage(List<IMImage> value) { this.imImage = value; }

        public Icon getSummary() { return summary; }
        public void setSummary(Icon value) { this.summary = value; }

        public IMPrice getIMPrice() { return imPrice; }
        public void setIMPrice(IMPrice value) { this.imPrice = value; }

        public IMContentType getIMContentType() { return imContentType; }
        public void setIMContentType(IMContentType value) { this.imContentType = value; }

        public Icon getRights() { return rights; }
        public void setRights(Icon value) { this.rights = value; }

        public Icon getTitle() { return title; }
        public void setTitle(Icon value) { this.title = value; }

        public Link getLink() { return link; }
        public void setLink(Link value) { this.link = value; }

        public ID getID() { return id; }
        public void setID(ID value) { this.id = value; }

        public IMArtist getIMArtist() { return imArtist; }
        public void setIMArtist(IMArtist value) { this.imArtist = value; }

        public Category getCategory() { return category; }
        public void setCategory(Category value) { this.category = value; }

        public IMReleaseDate getIMReleaseDate() { return imReleaseDate; }
        public void setIMReleaseDate(IMReleaseDate value) { this.imReleaseDate = value; }
    }

    public class Category {
        private CategoryAttributes attributes;

        public CategoryAttributes getAttributes() { return attributes; }
        public void setAttributes(CategoryAttributes value) { this.attributes = value; }
    }

    public class CategoryAttributes {
        private String imID;
        private PurpleLabel term;
        private String scheme;
        private PurpleLabel label;

        public String getIMID() { return imID; }
        public void setIMID(String value) { this.imID = value; }

        public PurpleLabel getTerm() { return term; }
        public void setTerm(PurpleLabel value) { this.term = value; }

        public String getScheme() { return scheme; }
        public void setScheme(String value) { this.scheme = value; }

        public PurpleLabel getLabel() { return label; }
        public void setLabel(PurpleLabel value) { this.label = value; }
    }

    public enum PurpleLabel {
        MUSIC, MUSIC_COMMENTARY, MUSIC_HISTORY, MUSIC_INTERVIEWS, NATURAL_SCIENCES;

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

        public static PurpleLabel forValue(String value) throws IOException {
            if (value.equals("Music")) return MUSIC;
            if (value.equals("Music Commentary")) return MUSIC_COMMENTARY;
            if (value.equals("Music History")) return MUSIC_HISTORY;
            if (value.equals("Music Interviews")) return MUSIC_INTERVIEWS;
            if (value.equals("Natural Sciences")) return NATURAL_SCIENCES;
            throw new IOException("Cannot deserialize PurpleLabel");
        }
    }
    public class ID {
        private String label;
        private IDAttributes attributes;

        public String getLabel() { return label; }
        public void setLabel(String value) { this.label = value; }

        public IDAttributes getAttributes() { return attributes; }
        public void setAttributes(IDAttributes value) { this.attributes = value; }
    }

    public class IDAttributes {
        private String imID;

        public String getIMID() { return imID; }
        public void setIMID(String value) { this.imID = value; }
    }

    public class IMArtist {
        private String label;
        private IMArtistAttributes attributes;

        public String getLabel() { return label; }
        public void setLabel(String value) { this.label = value; }

        public IMArtistAttributes getAttributes() { return attributes; }
        public void setAttributes(IMArtistAttributes value) { this.attributes = value; }
    }

    public class IMArtistAttributes {
        private String href;

        public String getHref() { return href; }
        public void setHref(String value) { this.href = value; }
    }

    public class IMContentType {
        private IMContentTypeAttributes attributes;

        public IMContentTypeAttributes getAttributes() { return attributes; }
        public void setAttributes(IMContentTypeAttributes value) { this.attributes = value; }
    }

    public class IMContentTypeAttributes {
        private FluffyLabel term;
        private FluffyLabel label;

        public FluffyLabel getTerm() { return term; }
        public void setTerm(FluffyLabel value) { this.term = value; }

        public FluffyLabel getLabel() { return label; }
        public void setLabel(FluffyLabel value) { this.label = value; }
    }

    public enum FluffyLabel {
        PODCAST;

        public String toValue() {
            switch (this) {
                case PODCAST: return "Podcast";
            }
            return null;
        }

        public static FluffyLabel forValue(String value) throws IOException {
            if (value.equals("Podcast")) return PODCAST;
            throw new IOException("Cannot deserialize FluffyLabel");
        }
    }


    public class IMImage {
        private String label;
        private IMImageAttributes attributes;

        public String getLabel() { return label; }
        public void setLabel(String value) { this.label = value; }

        public IMImageAttributes getAttributes() { return attributes; }
        public void setAttributes(IMImageAttributes value) { this.attributes = value; }
    }


    public class IMImageAttributes {
        private String height;

        public String getHeight() { return height; }
        public void setHeight(String value) { this.height = value; }
    }

    public class IMPrice {
        private IMPriceLabel label;
        private IMPriceAttributes attributes;

        public IMPriceLabel getLabel() { return label; }
        public void setLabel(IMPriceLabel value) { this.label = value; }

        public IMPriceAttributes getAttributes() { return attributes; }
        public void setAttributes(IMPriceAttributes value) { this.attributes = value; }
    }

    public class IMPriceAttributes {
        private String amount;
        private Currency currency;

        public String getAmount() { return amount; }
        public void setAmount(String value) { this.amount = value; }

        public Currency getCurrency() { return currency; }
        public void setCurrency(Currency value) { this.currency = value; }
    }

    public enum Currency {
        USD;

        public String toValue() {
            switch (this) {
                case USD: return "USD";
            }
            return null;
        }

        public static Currency forValue(String value) throws IOException {
            if (value.equals("USD")) return USD;
            throw new IOException("Cannot deserialize Currency");
        }
    }


    public enum IMPriceLabel {
        GET;

        public String toValue() {
            switch (this) {
                case GET: return "Get";
            }
            return null;
        }

        public static IMPriceLabel forValue(String value) throws IOException {
            if (value.equals("Get")) return GET;
            throw new IOException("Cannot deserialize IMPriceLabel");
        }
    }

    public class IMReleaseDate {
        private OffsetDateTime label;
        private Icon attributes;

        public OffsetDateTime getLabel() { return label; }
        public void setLabel(OffsetDateTime value) { this.label = value; }

        public Icon getAttributes() { return attributes; }
        public void setAttributes(Icon value) { this.attributes = value; }
    }

    public class Link {
        private LinkAttributes attributes;

        public LinkAttributes getAttributes() { return attributes; }
        public void setAttributes(LinkAttributes value) { this.attributes = value; }
    }


    public class LinkAttributes {
        private Rel rel;
        private Type type;
        private String href;

        public Rel getRel() { return rel; }
        public void setRel(Rel value) { this.rel = value; }

        public Type getType() { return type; }
        public void setType(Type value) { this.type = value; }

        public String getHref() { return href; }
        public void setHref(String value) { this.href = value; }
    }

    public enum Rel {
        ALTERNATE, SELF;

        public String toValue() {
            switch (this) {
                case ALTERNATE: return "alternate";
                case SELF: return "self";
            }
            return null;
        }

        public static Rel forValue(String value) throws IOException {
            if (value.equals("alternate")) return ALTERNATE;
            if (value.equals("self")) return SELF;
            throw new IOException("Cannot deserialize Rel");
        }
    }


    public enum Type {
        TEXT_HTML;

        public String toValue() {
            switch (this) {
                case TEXT_HTML: return "text/html";
            }
            return null;
        }

        public static Type forValue(String value) throws IOException {
            if (value.equals("text/html")) return TEXT_HTML;
            throw new IOException("Cannot deserialize Type");
        }
    }

}
