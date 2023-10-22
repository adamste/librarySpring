package pl.stepien.libraryspring.author.model.openLibApi;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * API response Object.
 * Reference: https://openlibrary.org/dev/docs/api/books
 */
public final class Edition implements Comparable<Edition> {

    @SerializedName("publishers")
    private final String[] publishers;

    @SerializedName("number_of_pages")
    private final int numberOfPages;

    @SerializedName("isbn_10")
    private final String[] isbn10;

    @SerializedName("covers")
    private final int[] covers;

    @SerializedName("last_modified")
    private final LastModified lastModified;

    @SerializedName("latest_revision")
    private final int latestRevision;

    @SerializedName("key")
    private final String key;

    @SerializedName("authors")
    private final Author[] authors;

    @SerializedName("ocaid")
    private final String ocaId;

    @SerializedName("contributions")
    private final String[] contributions;

    @SerializedName("languages")
    private final Language[] languages;

    @SerializedName("classifications")
    private final Classification classifications;

    @SerializedName("source_records")
    private final String[] sourceRecords;

    @SerializedName("title")
    private final String title;

    @SerializedName("identifiers")
    private final Identifier identifiers;

    @SerializedName("created")
    private final Created created;

    @SerializedName("isbn_13")
    private final String[] isbn13;

    @SerializedName("local_id")
    private final String[] localId;

    @SerializedName("publish_date")
    private final String publishDate;

    @SerializedName("works")
    private final Work[] works;

    @SerializedName("type")
    private final Type type;

    @SerializedName("first_sentence")
    private final FirstSentence firstSentence;

    @SerializedName("revision")
    private final int revision;

    public Edition(String[] publishers, int numberOfPages, String[] isbn10, int[] covers,
                   LastModified lastModified, int latestRevision, String key, Author[] authors,
                   String ocaId, String[] contributions, Language[] languages,
                   Classification classifications, String[] sourceRecords, String title,
                   Identifier identifiers, Created created, String[] isbn13, String[] localId,
                   String publishDate, Work[] works, Type type,
                   FirstSentence firstSentence, int revision) {
        this.publishers = publishers;
        this.numberOfPages = numberOfPages;
        this.isbn10 = isbn10;
        this.covers = covers;
        this.lastModified = lastModified;
        this.latestRevision = latestRevision;
        this.key = key;
        this.authors = authors;
        this.ocaId = ocaId;
        this.contributions = contributions;
        this.languages = languages;
        this.classifications = classifications;
        this.sourceRecords = sourceRecords;
        this.title = title;
        this.identifiers = identifiers;
        this.created = created;
        this.isbn13 = isbn13;
        this.localId = localId;
        this.publishDate = publishDate;
        this.works = works;
        this.type = type;
        this.firstSentence = firstSentence;
        this.revision = revision;
    }

    /**
     * Factory for testing, should only set field used in Comparable.
     */
    public static Edition newEditionForTesting(String title, int revision) {
        return new Edition(null, 0, null, null, null,
                0, null, null, null, null, null,
                null, null, title, null, null, null,
                null, null, null, null, null, revision);
    }

    public String[] getPublishers() {
        return publishers;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String[] getIsbn10() {
        return isbn10;
    }

    public int[] getCovers() {
        return covers;
    }

    public LastModified getLastModified() {
        return lastModified;
    }

    public int getLatestRevision() {
        return latestRevision;
    }

    public String getKey() {
        return key;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public String getOcaId() {
        return ocaId;
    }

    public String[] getContributions() {
        return contributions;
    }

    public Language[] getLanguages() {
        return languages;
    }

    public Classification getClassifications() {
        return classifications;
    }

    public String[] getSourceRecords() {
        return sourceRecords;
    }

    public String getTitle() {
        return title;
    }

    public Identifier getIdentifiers() {
        return identifiers;
    }

    public Created getCreated() {
        return created;
    }

    public String[] getIsbn13() {
        return isbn13;
    }

    public String[] getLocalId() {
        return localId;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public Work[] getWorks() {
        return works;
    }

    public Type getType() {
        return type;
    }

    public FirstSentence getFirstSentence() {
        return firstSentence;
    }

    public int getRevision() {
        return revision;
    }

    @Override
    public String toString() {
        return "Edition{" +
                "title='" + title + '\'' +
                ", revision=" + revision +
                '}';
    }

    /**
     * Natural sorting by title, reversed revision as secondary.
     */
    @Override
    public int compareTo(Edition edition) {
        int result = title.compareTo(edition.title);
        if (result == 0) {
            result = Integer.compare(revision, edition.revision);

            // Flip order
            if (result == -1) {
                result = 1;
            } else if (result == 1) {
                result = -1;
            }
        }
        return result;
    }

    public final static class LastModified {

        @SerializedName("type")
        private final String type;

        @SerializedName("value")
        private final String value;

        public LastModified(String type, String value) {
            this.type = type;
            this.value = value;
        }

        public String getType() {
            return type;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "LastModified{" +
                    "type='" + type + '\'' +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    public final static class Author {

        @SerializedName("key")
        private final String key;

        public Author(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }

        @Override
        public String toString() {
            return "Authors{" +
                    "key='" + key + '\'' +
                    '}';
        }
    }

    public final static class Language {

        @SerializedName("key")
        private final String key;

        public Language(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }

        @Override
        public String toString() {
            return "Language{" +
                    "key='" + key + '\'' +
                    '}';
        }
    }

    public final static class Classification {

        public Classification() {
        }
    }

    public static final class Identifier {

        @SerializedName("goodreads")
        private final String[] goodReads;

        @SerializedName("librarything")
        private final String[] libraryThing;

        public Identifier(String[] goodReads, String[] libraryThing) {
            this.goodReads = goodReads;
            this.libraryThing = libraryThing;
        }

        public String[] getGoodReads() {
            return goodReads;
        }

        public String[] getLibraryThing() {
            return libraryThing;
        }

        @Override
        public String toString() {
            return "Identifier{" +
                    "goodReads=" + Arrays.toString(goodReads) +
                    ", libraryThing=" + Arrays.toString(libraryThing) +
                    '}';
        }
    }

    public final static class Created {

        @SerializedName("type")
        private final String type;

        @SerializedName("value")
        private final String value;

        public Created(String type, String value) {
            this.type = type;
            this.value = value;
        }

        public String getType() {
            return type;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Created{" +
                    "type='" + type + '\'' +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    public final static class Work {

        @SerializedName("key")
        private final String key;

        public Work(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }

        @Override
        public String toString() {
            return "Work{" +
                    "key='" + key + '\'' +
                    '}';
        }
    }

    public final static class Type {

        @SerializedName("key")
        private final String key;

        public Type(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }

        @Override
        public String toString() {
            return "Type{" +
                    "key='" + key + '\'' +
                    '}';
        }
    }

    public final static class FirstSentence {

        @SerializedName("type")
        private final String type;

        @SerializedName("value")
        private final String value;

        public FirstSentence(String type, String value) {
            this.type = type;
            this.value = value;
        }

        public String getType() {
            return type;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "FirstSentence{" +
                    "type='" + type + '\'' +
                    ", value='" + value + '\'' +
                    '}';
        }
    }
}
