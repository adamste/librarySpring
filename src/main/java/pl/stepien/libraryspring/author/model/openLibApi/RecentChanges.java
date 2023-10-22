package pl.stepien.libraryspring.author.model.openLibApi;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * API response Object.
 * Reference: https://openlibrary.org/dev/docs/api/recentchanges
 */
public final class RecentChanges {

    @SerializedName("id")
    private final String id;

    @SerializedName("kind")
    private final String kind;

    @SerializedName("timestamp")
    private final String timestamp;

    @SerializedName("comment")
    private final String comment;

    @SerializedName("changes")
    private final Change[] changes;

    @SerializedName("author")
    private final Author author;

    @SerializedName("ip")
    private final String ip;

    @SerializedName("data")
    private final Data data;

    public RecentChanges(String id, String kind, String timestamp, String comment,
                         Change[] changes, Author author, String ip, Data data) {
        this.id = id;
        this.kind = kind;
        this.timestamp = timestamp;
        this.comment = comment;
        this.changes = changes;
        this.author = author;
        this.ip = ip;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public String getKind() {
        return kind;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getComment() {
        return comment;
    }

    public Change[] getChanges() {
        return changes;
    }

    public Author getAuthor() {
        return author;
    }

    public String getIp() {
        return ip;
    }

    public Data getData() {
        return data;
    }

    @Override
    public String toString() {
        return "ChangeSet{" +
                "id='" + id + '\'' +
                ", kind='" + kind + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", comment='" + comment + '\'' +
                ", changes=" + Arrays.toString(changes) +
                ", author=" + author +
                ", ip='" + ip + '\'' +
                ", data=" + data +
                '}';
    }

    public static final class Change {

        @SerializedName("key")
        private final String key;

        @SerializedName("revision")
        private final int revision;

        public Change(String key, int revision) {
            this.key = key;
            this.revision = revision;
        }

        public String getKey() {
            return key;
        }

        public int getRevision() {
            return revision;
        }

        @Override
        public String toString() {
            return "Change{" +
                    "key='" + key + '\'' +
                    ", revision=" + revision +
                    '}';
        }
    }

    public static final class Author {

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
            return "Author{" +
                    "key='" + key + '\'' +
                    '}';
        }
    }

    public static final class Data {

        @SerializedName("master")
        private final String master;

        @SerializedName("duplicates")
        private final String[] duplicates;

        public Data(String master, String[] duplicates) {
            this.master = master;
            this.duplicates = duplicates;
        }

        public String getMaster() {
            return master;
        }

        public String[] getDuplicates() {
            return duplicates;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "master='" + master + '\'' +
                    ", duplicates=" + Arrays.toString(duplicates) +
                    '}';
        }
    }
}
