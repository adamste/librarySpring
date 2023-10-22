package pl.stepien.libraryspring.author.model.openLibApi;

import com.google.gson.annotations.SerializedName;

/**
 * API response Object.
 * Reference: https://openlibrary.org/dev/docs/api/subjects
 */
public final class SubjectDetailed extends Subject {

    @SerializedName("authors")
    private final Author[] authors;

    @SerializedName("publishers")
    private final Publisher[] publishers;

    @SerializedName("subjects")
    private final Subject[] subjects;

    @SerializedName("people")
    private final People[] people;

    @SerializedName("places")
    private final Place[] places;

    @SerializedName("times")
    private final Time[] times;

    @SerializedName("publishing_history")
    private final String[][] publishingHistory;

    public SubjectDetailed(String key, String name, String subjectType, int workCount,
                           Work[] works, Author[] authors, Publisher[] publishers,
                           Subject[] subjects, People[] people, Place[] places,
                           Time[] times, String[][] publishingHistory) {
        super(key, name, subjectType, workCount, works);
        this.authors = authors;
        this.publishers = publishers;
        this.subjects = subjects;
        this.people = people;
        this.places = places;
        this.times = times;
        this.publishingHistory = publishingHistory;
    }

    /**
     * Factory for testing, should only set field used in Comparable.
     */
    public static SubjectDetailed newSubjectDetailedForTesting(String name) {
        return new SubjectDetailed(null, name, null, 0, null,
                null, null, null, null, null,
                null, null);
    }

    public Author[] getAuthors() {
        return authors;
    }

    public Publisher[] getPublishers() {
        return publishers;
    }

    public Subject[] getSubjects() {
        return subjects;
    }

    public People[] getPeople() {
        return people;
    }

    public Place[] getPlaces() {
        return places;
    }

    public Time[] getTimes() {
        return times;
    }

    public String[][] getPublishingHistory() {
        return publishingHistory;
    }

    public static final class Author {

        @SerializedName("count")
        private final int count;

        @SerializedName("name")
        private final String name;

        @SerializedName("key")
        private final String key;

        public Author(int count, String name, String key) {
            this.count = count;
            this.name = name;
            this.key = key;
        }

        public int getCount() {
            return count;
        }

        public String getName() {
            return name;
        }

        public String getKey() {
            return key;
        }

        @Override
        public String toString() {
            return "Authors{" +
                    "count=" + count +
                    ", name='" + name + '\'' +
                    ", key='" + key + '\'' +
                    '}';
        }
    }

    public static final class Publisher {

        @SerializedName("count")
        private final int count;

        @SerializedName("name")
        private final String name;

        public Publisher(int count, String name) {
            this.count = count;
            this.name = name;
        }

        public int getCount() {
            return count;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Publisher{" +
                    "count=" + count +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static final class Subject {

        @SerializedName("count")
        private final int count;

        @SerializedName("name")
        private final String name;

        @SerializedName("key")
        private final String key;

        public Subject(int count, String name, String key) {
            this.count = count;
            this.name = name;
            this.key = key;
        }

        public int getCount() {
            return count;
        }

        public String getName() {
            return name;
        }

        public String getKey() {
            return key;
        }

        @Override
        public String toString() {
            return "Subject{" +
                    "count=" + count +
                    ", name='" + name + '\'' +
                    ", key='" + key + '\'' +
                    '}';
        }
    }

    public static final class People {

        @SerializedName("count")
        private final int count;

        @SerializedName("name")
        private final String name;

        @SerializedName("key")
        private final String key;

        public People(int count, String name, String key) {
            this.count = count;
            this.name = name;
            this.key = key;
        }

        public int getCount() {
            return count;
        }

        public String getName() {
            return name;
        }

        public String getKey() {
            return key;
        }

        @Override
        public String toString() {
            return "People{" +
                    "count=" + count +
                    ", name='" + name + '\'' +
                    ", key='" + key + '\'' +
                    '}';
        }
    }

    public static final class Place {

        @SerializedName("count")
        private final int count;

        @SerializedName("name")
        private final String name;

        @SerializedName("key")
        private final String key;

        public Place(int count, String name, String key) {
            this.count = count;
            this.name = name;
            this.key = key;
        }

        public int getCount() {
            return count;
        }

        public String getName() {
            return name;
        }

        public String getKey() {
            return key;
        }

        @Override
        public String toString() {
            return "Place{" +
                    "count=" + count +
                    ", name='" + name + '\'' +
                    ", key='" + key + '\'' +
                    '}';
        }
    }

    public static final class Time {

        @SerializedName("count")
        private final int count;

        @SerializedName("name")
        private final String name;

        @SerializedName("key")
        private final String key;

        public Time(int count, String name, String key) {
            this.count = count;
            this.name = name;
            this.key = key;
        }

        public int getCount() {
            return count;
        }

        public String getName() {
            return name;
        }

        public String getKey() {
            return key;
        }

        @Override
        public String toString() {
            return "Time{" +
                    "count=" + count +
                    ", name='" + name + '\'' +
                    ", key='" + key + '\'' +
                    '}';
        }
    }
}