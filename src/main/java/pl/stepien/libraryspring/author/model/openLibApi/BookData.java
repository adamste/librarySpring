package pl.stepien.libraryspring.author.model.openLibApi;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * API response Object.
 * Data version of Book, contains default information.
 * Reference: https://openlibrary.org/dev/docs/api/books
 */
public final class BookData extends Book implements Comparable<BookData> {

    @SerializedName("publishers")
    private final Publisher[] publishers;

    @SerializedName("identifiers")
    private final Identifier identifiers;

    @SerializedName("classifications")
    private final Classification classifications;

    @SerializedName("links")
    private final Link[] links;

    @SerializedName("weight")
    private final String weight;

    @SerializedName("title")
    private final String title;

    @SerializedName("url")
    private final String url;

    @SerializedName("number_of_pages")
    private final int numberOfPages;

    @SerializedName("cover")
    private final Cover cover;

    @SerializedName("subjects")
    private final Subject[] subjects;

    @SerializedName("publish_date")
    private final String publishDate;

    @SerializedName("authors")
    private final Author[] authors;

    @SerializedName("excerpts")
    private final Excerpt[] excerpts;

    @SerializedName("publish_place")
    private final PublishPlace[] publishPlaces;

    public BookData(Publisher[] publishers, Identifier identifiers, Classification classifications,
                    Link[] links, String weight, String title, String url, int numberOfPages,
                    Cover cover, Subject[] subjects, String publishDate, Author[] authors,
                    Excerpt[] excerpts, PublishPlace[] publishPlaces) {
        this.publishers = publishers;
        this.identifiers = identifiers;
        this.classifications = classifications;
        this.links = links;
        this.weight = weight;
        this.title = title;
        this.url = url;
        this.numberOfPages = numberOfPages;
        this.cover = cover;
        this.subjects = subjects;
        this.publishDate = publishDate;
        this.authors = authors;
        this.excerpts = excerpts;
        this.publishPlaces = publishPlaces;
    }

    /**
     * Factory for testing, should only set field used in Comparable.
     */
    public static BookData newBookDataForTesting(String title) {
        return new BookData(null, null, null, null, null, title,
                null, 0, null, null, null, null,
                null, null);
    }

    public Publisher[] getPublishers() {
        return publishers;
    }

    public Identifier getIdentifiers() {
        return identifiers;
    }

    public Classification getClassifications() {
        return classifications;
    }

    public Link[] getLinks() {
        return links;
    }

    public String getWeight() {
        return weight;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public Cover getCover() {
        return cover;
    }

    public Subject[] getSubjects() {
        return subjects;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public Excerpt[] getExcerpts() {
        return excerpts;
    }

    public PublishPlace[] getPublishPlaces() {
        return publishPlaces;
    }

    @Override
    public String toString() {
        return "BookData{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    /**
     * Natural sorting by title.
     */
    @Override
    public int compareTo(BookData bookData) {
        return title.compareTo(bookData.title);
    }

    public final static class Publisher {

        @SerializedName("name")
        private final String name;

        public Publisher(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Publisher{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public final static class Identifier {

        @SerializedName("google")
        private final String[] google;

        @SerializedName("lccn")
        private final String[] lccn;

        @SerializedName("isbn_13")
        private final String[] isbn13;

        @SerializedName("amazon")
        private final String[] amazon;

        @SerializedName("isbn_10")
        private final String[] isbn10;

        @SerializedName("oclc")
        private final String[] oclc;

        @SerializedName("librarything")
        private final String[] libraryThing;

        @SerializedName("project_gutenberg")
        private final String[] projectGutenberg;

        @SerializedName("goodreads")
        private final String[] goodReads;

        public Identifier(String[] google, String[] lccn, String[] isbn13, String[] amazon,
                          String[] isbn10, String[] oclc, String[] libraryThing,
                          String[] projectGutenberg, String[] goodReads) {
            this.google = google;
            this.lccn = lccn;
            this.isbn13 = isbn13;
            this.amazon = amazon;
            this.isbn10 = isbn10;
            this.oclc = oclc;
            this.libraryThing = libraryThing;
            this.projectGutenberg = projectGutenberg;
            this.goodReads = goodReads;
        }

        public String[] getGoogle() {
            return google;
        }

        public String[] getLccn() {
            return lccn;
        }

        public String[] getIsbn13() {
            return isbn13;
        }

        public String[] getAmazon() {
            return amazon;
        }

        public String[] getIsbn10() {
            return isbn10;
        }

        public String[] getOclc() {
            return oclc;
        }

        public String[] getLibraryThing() {
            return libraryThing;
        }

        public String[] getProjectGutenberg() {
            return projectGutenberg;
        }

        public String[] getGoodReads() {
            return goodReads;
        }

        @Override
        public String toString() {
            return "Identifier{" +
                    "google=" + Arrays.toString(google) +
                    ", lccn=" + Arrays.toString(lccn) +
                    ", isbn13=" + Arrays.toString(isbn13) +
                    ", amazon=" + Arrays.toString(amazon) +
                    ", isbn10=" + Arrays.toString(isbn10) +
                    ", oclc=" + Arrays.toString(oclc) +
                    ", libraryThing=" + Arrays.toString(libraryThing) +
                    ", projectGutenberg=" + Arrays.toString(projectGutenberg) +
                    ", goodReads=" + Arrays.toString(goodReads) +
                    '}';
        }
    }

    public final static class Classification {

        @SerializedName("dewey_decimal_class")
        private final String[] deweyDecimalClass;

        @SerializedName("lc_classifications")
        private final String[] lcClassifications;

        public Classification(String[] deweyDecimalClass, String[] lcClassifications) {
            this.deweyDecimalClass = deweyDecimalClass;
            this.lcClassifications = lcClassifications;
        }

        public String[] getDeweyDecimalClass() {
            return deweyDecimalClass;
        }

        public String[] getLcClassifications() {
            return lcClassifications;
        }

        @Override
        public String toString() {
            return "Classification{" +
                    "deweyDecimalClass=" + Arrays.toString(deweyDecimalClass) +
                    ", lcClassifications=" + Arrays.toString(lcClassifications) +
                    '}';
        }
    }

    public final static class Link {

        @SerializedName("url")
        private final String url;

        @SerializedName("title")
        private final String title;

        public Link(String url, String title) {
            this.url = url;
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public String getTitle() {
            return title;
        }

        @Override
        public String toString() {
            return "Link{" +
                    "url='" + url + '\'' +
                    ", title='" + title + '\'' +
                    '}';
        }
    }

    public final static class Cover {

        @SerializedName("small")
        private final String small;

        @SerializedName("large")
        private final String large;

        @SerializedName("medium")
        private final String medium;

        public Cover(String small, String large, String medium) {
            this.small = small;
            this.large = large;
            this.medium = medium;
        }

        public String getSmall() {
            return small;
        }

        public String getLarge() {
            return large;
        }

        public String getMedium() {
            return medium;
        }

        @Override
        public String toString() {
            return "Cover{" +
                    "small='" + small + '\'' +
                    ", medium='" + medium + '\'' +
                    ", large='" + large + '\'' +
                    '}';
        }
    }

    public final static class Subject {

        @SerializedName("url")
        private final String url;

        @SerializedName("name")
        private final String name;

        public Subject(String url, String name) {
            this.url = url;
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Subject{" +
                    "url='" + url + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public final static class Author {

        @SerializedName("url")
        private final String url;

        @SerializedName("name")
        private final String name;

        public Author(String url, String name) {
            this.url = url;
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Author{" +
                    "url='" + url + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public final static class Excerpt {

        @SerializedName("comment")
        private final String comment;

        @SerializedName("text")
        private final String text;

        public Excerpt(String comment, String text) {
            this.comment = comment;
            this.text = text;
        }

        public String getComment() {
            return comment;
        }

        public String getText() {
            return text;
        }

        @Override
        public String toString() {
            return "Excerpt{" +
                    "comment='" + comment + '\'' +
                    ", text='" + text + '\'' +
                    '}';
        }
    }

    public final static class PublishPlace {

        @SerializedName("name")
        private final String name;

        public PublishPlace(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "PublishPlace{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
