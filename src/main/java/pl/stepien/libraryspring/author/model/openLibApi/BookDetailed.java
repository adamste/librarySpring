package pl.stepien.libraryspring.author.model.openLibApi;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * API response Object.
 * Detailed version of Book, contains the most information.
 * Reference: https://openlibrary.org/dev/docs/api/books
 */
public final class BookDetailed extends Book {

    @SerializedName("info_url")
    private final String infoUrl;

    @SerializedName("bib_key")
    private final String bibKey;

    @SerializedName("preview_url")
    private final String previewUrl;

    @SerializedName("thumbnail_url")
    private final String thumbnailUrl;

    @SerializedName("preview")
    private final String preview;

    @SerializedName("details")
    private final Details details;

    public BookDetailed(String infoUrl, String bibKey, String previewUrl,
                        String thumbnailUrl, String preview, Details details) {
        this.infoUrl = infoUrl;
        this.bibKey = bibKey;
        this.previewUrl = previewUrl;
        this.thumbnailUrl = thumbnailUrl;
        this.preview = preview;
        this.details = details;
    }

    public String getInfoUrl() {
        return infoUrl;
    }

    public String getBibKey() {
        return bibKey;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public String getPreview() {
        return preview;
    }

    public Details getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return "BookDetailed{" +
                "bibKey='" + bibKey + '\'' +
                ", infoUrl='" + infoUrl + '\'' +
                ", details=" + details +
                '}';
    }

    public final static class Details {

        @SerializedName("number_of_pages")
        private final int numberOfPages;

        @SerializedName("table_of_contents")
        private final TableOfContents[] tableOfContents;

        @SerializedName("weight")
        private final String weight;

        @SerializedName("covers")
        private final int[] covers;

        @SerializedName("lc_classifications")
        private final String[] lcClassifications;

        @SerializedName("latest_revision")
        private final int latestRevision;

        @SerializedName("source_records")
        private final String[] sourceRecords;

        @SerializedName("title")
        private final String title;

        @SerializedName("languages")
        private final Language[] languages;

        @SerializedName("subjects")
        private final String[] subjects;

        @SerializedName("publish_country")
        private final String publishCountry;

        @SerializedName("by_statement")
        private final String byStatement;

        @SerializedName("oclc_numbers")
        private final String[] oclcNumbers;

        @SerializedName("type")
        private final Type type;

        @SerializedName("physical_dimensions")
        private final String physicalDimensions;

        @SerializedName("revision")
        private final int revision;

        @SerializedName("publishers")
        private final String[] publishers;

        @SerializedName("description")
        private final String description;

        @SerializedName("physical_format")
        private final String physicalFormat;

        @SerializedName("last_modified")
        private final LastModified lastModified;

        @SerializedName("key")
        private final String key;

        @SerializedName("authors")
        private final Author[] authors;

        @SerializedName("publish_places")
        private final String[] publishPlaces;

        @SerializedName("pagination")
        private final String pagination;

        @SerializedName("classifications")
        private final Classification classifications;

        @SerializedName("created")
        private final Created created;

        @SerializedName("lccn")
        private final String[] lccn;

        @SerializedName("notes")
        private final String notes;

        @SerializedName("identifiers")
        private final Identifiers identifiers;

        @SerializedName("isbn_13")
        private final String[] isbn13;

        @SerializedName("dewey_decimal_class")
        private final String[] deweyDecimalClass;

        @SerializedName("isbn_10")
        private final String[] isbn10;

        @SerializedName("publish_date")
        private final String publishDate;

        @SerializedName("works")
        private final Work[] works;

        public Details(int numberOfPages, TableOfContents[] tableOfContents, String weight,
                       int[] covers, String[] lcClassifications, int latestRevision,
                       String[] sourceRecords, String title, Language[] languages,
                       String[] subjects, String publishCountry, String byStatement,
                       String[] oclcNumbers, Type type, String physicalDimensions,
                       int revision, String[] publishers, String description,
                       String physicalFormat, LastModified lastModified, String key,
                       Author[] authors, String[] publishPlaces, String pagination,
                       Classification classifications, Created created, String[] lccn,
                       String notes, Identifiers identifiers, String[] isbn13,
                       String[] deweyDecimalClass, String[] isbn10, String publishDate,
                       Work[] works) {
            this.numberOfPages = numberOfPages;
            this.tableOfContents = tableOfContents;
            this.weight = weight;
            this.covers = covers;
            this.lcClassifications = lcClassifications;
            this.latestRevision = latestRevision;
            this.sourceRecords = sourceRecords;
            this.title = title;
            this.languages = languages;
            this.subjects = subjects;
            this.publishCountry = publishCountry;
            this.byStatement = byStatement;
            this.oclcNumbers = oclcNumbers;
            this.type = type;
            this.physicalDimensions = physicalDimensions;
            this.revision = revision;
            this.publishers = publishers;
            this.description = description;
            this.physicalFormat = physicalFormat;
            this.lastModified = lastModified;
            this.key = key;
            this.authors = authors;
            this.publishPlaces = publishPlaces;
            this.pagination = pagination;
            this.classifications = classifications;
            this.created = created;
            this.lccn = lccn;
            this.notes = notes;
            this.identifiers = identifiers;
            this.isbn13 = isbn13;
            this.deweyDecimalClass = deweyDecimalClass;
            this.isbn10 = isbn10;
            this.publishDate = publishDate;
            this.works = works;
        }

        public int getNumberOfPages() {
            return numberOfPages;
        }

        public TableOfContents[] getTableOfContents() {
            return tableOfContents;
        }

        public String getWeight() {
            return weight;
        }

        public int[] getCovers() {
            return covers;
        }

        public String[] getLcClassifications() {
            return lcClassifications;
        }

        public int getLatestRevision() {
            return latestRevision;
        }

        public String[] getSourceRecords() {
            return sourceRecords;
        }

        public String getTitle() {
            return title;
        }

        public Language[] getLanguages() {
            return languages;
        }

        public String[] getSubjects() {
            return subjects;
        }

        public String getPublishCountry() {
            return publishCountry;
        }

        public String getByStatement() {
            return byStatement;
        }

        public String[] getOclcNumbers() {
            return oclcNumbers;
        }

        public Type getType() {
            return type;
        }

        public String getPhysicalDimensions() {
            return physicalDimensions;
        }

        public int getRevision() {
            return revision;
        }

        public String[] getPublishers() {
            return publishers;
        }

        public String getDescription() {
            return description;
        }

        public String getPhysicalFormat() {
            return physicalFormat;
        }

        public LastModified getLastModified() {
            return lastModified;
        }

        public String getKey() {
            return key;
        }

        public Author[] getAuthors() {
            return authors;
        }

        public String[] getPublishPlaces() {
            return publishPlaces;
        }

        public String getPagination() {
            return pagination;
        }

        public Classification getClassifications() {
            return classifications;
        }

        public Created getCreated() {
            return created;
        }

        public String[] getLccn() {
            return lccn;
        }

        public String getNotes() {
            return notes;
        }

        public Identifiers getIdentifiers() {
            return identifiers;
        }

        public String[] getIsbn13() {
            return isbn13;
        }

        public String[] getDeweyDecimalClass() {
            return deweyDecimalClass;
        }

        public String[] getIsbn10() {
            return isbn10;
        }

        public String getPublishDate() {
            return publishDate;
        }

        public Work[] getWorks() {
            return works;
        }

        @Override
        public String toString() {
            return "Details{" +
                    "type=" + type +
                    ", key='" + key + '\'' +
                    ", title='" + title + '\'' +
                    '}';
        }

        public final static class TableOfContents {

            @SerializedName("title")
            private final String title;

            @SerializedName("type")
            private final Type type;

            @SerializedName("level")
            private final int level;

            public TableOfContents(String title, Type type, int level) {
                this.title = title;
                this.type = type;
                this.level = level;
            }

            public String getTitle() {
                return title;
            }

            public Type getType() {
                return type;
            }

            public int getLevel() {
                return level;
            }

            @Override
            public String toString() {
                return "TableOfContents{" +
                        "title='" + title + '\'' +
                        ", type=" + type +
                        ", level=" + level +
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

            @SerializedName("name")
            private final String name;

            @SerializedName("key")
            private final String key;

            public Author(String name, String key) {
                this.name = name;
                this.key = key;
            }

            public String getName() {
                return name;
            }

            public String getKey() {
                return key;
            }

            @Override
            public String toString() {
                return "Author{" +
                        "name='" + name + '\'' +
                        ", key='" + key + '\'' +
                        '}';
            }
        }

        public final static class Classification {
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

        public final static class Identifiers {

            @SerializedName("amazon")
            private final String[] amazon;

            @SerializedName("google")
            private final String[] google;

            @SerializedName("project_gutenberg")
            private final String[] projectGutenberg;

            @SerializedName("goodreads")
            private final String[] goodReads;

            @SerializedName("librarything")
            private final String[] libraryThing;

            public Identifiers(String[] amazon, String[] google, String[] projectGutenberg,
                               String[] goodReads, String[] libraryThing) {
                this.amazon = amazon;
                this.google = google;
                this.projectGutenberg = projectGutenberg;
                this.goodReads = goodReads;
                this.libraryThing = libraryThing;
            }

            public String[] getAmazon() {
                return amazon;
            }

            public String[] getGoogle() {
                return google;
            }

            public String[] getProjectGutenberg() {
                return projectGutenberg;
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
                        "amazon=" + Arrays.toString(amazon) +
                        ", google=" + Arrays.toString(google) +
                        ", projectGutenberg=" + Arrays.toString(projectGutenberg) +
                        ", goodReads=" + Arrays.toString(goodReads) +
                        ", libraryThing=" + Arrays.toString(libraryThing) +
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
    }
}
