package pl.stepien.libraryspring.author.model.openLibApi;

import com.google.gson.annotations.SerializedName;

/**
 * API response Object.
 * Reference: https://openlibrary.org/dev/docs/api/books
 */
public final class Work implements Comparable<Work> {

    @SerializedName("title")
    private final String title;

    @SerializedName("description")
    private final String description;

    @SerializedName("covers")
    private final int[] covers;

    @SerializedName("subject_places")
    private final String[] subjectPlaces;

    @SerializedName("subjects")
    private final String[] subjects;

    @SerializedName("subject_people")
    private final String[] subjectPeople;

    @SerializedName("key")
    private final String key;

    @SerializedName("authors")
    private final Author[] authors;

    @SerializedName("subject_times")
    private final String[] subjectTimes;

    @SerializedName("type")
    private final Type type;

    @SerializedName("latest_revision")
    private final int latestRevision;

    @SerializedName("revision")
    private final int revision;

    @SerializedName("created")
    private final Created created;

    @SerializedName("last_modified")
    private final LastModified lastModified;

    public Work(String title, String description, int[] covers, String[] subjectPlaces,
                String[] subjects, String[] subjectPeople, String key, Author[] authors,
                String[] subjectTimes, Type type, int latestRevision, int revision,
                Created created, LastModified lastModified) {
        this.title = title;
        this.description = description;
        this.covers = covers;
        this.subjectPlaces = subjectPlaces;
        this.subjects = subjects;
        this.subjectPeople = subjectPeople;
        this.key = key;
        this.authors = authors;
        this.subjectTimes = subjectTimes;
        this.type = type;
        this.latestRevision = latestRevision;
        this.revision = revision;
        this.created = created;
        this.lastModified = lastModified;
    }

    /**
     * Factory for testing, should only set field used in Comparable.
     */
    public static Work newWorkForTesting(String title, int revision) {
        return new Work(title, null, null, null, null,
                null, null, null, null, null, 0,
                revision, null, null);
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int[] getCovers() {
        return covers;
    }

    public String[] getSubjectPlaces() {
        return subjectPlaces;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public String[] getSubjectPeople() {
        return subjectPeople;
    }

    public String getKey() {
        return key;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public String[] getSubjectTimes() {
        return subjectTimes;
    }

    public Type getType() {
        return type;
    }

    public int getLatestRevision() {
        return latestRevision;
    }

    public int getRevision() {
        return revision;
    }

    public Created getCreated() {
        return created;
    }

    public LastModified getLastModified() {
        return lastModified;
    }

    @Override
    public String toString() {
        return "Work{" +
                "key='" + key + '\'' +
                ", title='" + title + '\'' +
                ", revision=" + revision +
                '}';
    }

    /**
     * Natural sorting by title, reversed revision as secondary.
     */
    @Override
    public int compareTo(Work work) {
        int result = title.compareTo(work.title);
        if (result == 0) {
            result = Integer.compare(revision, work.revision);

            // Flip order
            if (result == -1) {
                result = 1;
            } else if (result == 1) {
                result = -1;
            }
        }
        return result;
    }

    public final static class Author {

        /* The serialized name is author here but the class/field is called authorIdentifier,
         * this is to make it cleared what is what because there are currently an author
         * inside an author in the returned Api JSON. And since the inner author only
         * contains an identifying key, authorIdentifier seems like the best choice. */
        @SerializedName("author")
        private final AuthorIdentifier authorIdentifier;

        @SerializedName("type")
        private final Type type;

        public Author(AuthorIdentifier authorIdentifier, Type type) {
            this.authorIdentifier = authorIdentifier;
            this.type = type;
        }

        public AuthorIdentifier getAuthor() {
            return authorIdentifier;
        }

        public Type getType() {
            return type;
        }

        @Override
        public String toString() {
            return "Author{" +
                    "authorIdentifier=" + authorIdentifier +
                    ", type=" + type +
                    '}';
        }

        public final static class AuthorIdentifier {

            @SerializedName("type")
            private final Type type;

            public AuthorIdentifier(Type type) {
                this.type = type;
            }

            public Type getType() {
                return type;
            }

            @Override
            public String toString() {
                return "AuthorIdentifier{" +
                        "type=" + type +
                        '}';
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
}