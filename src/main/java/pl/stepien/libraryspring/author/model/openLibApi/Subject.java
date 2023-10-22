package pl.stepien.libraryspring.author.model.openLibApi;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

/**
 * API response Object.
 * Reference: https://openlibrary.org/dev/docs/api/subjects
 */
public class Subject implements Comparable<Subject> {

    @SerializedName("key")
    private final String key;

    @SerializedName("name")
    private final String name;

    @SerializedName("subject_type")
    private final String subjectType;

    @SerializedName("work_count")
    private final int workCount;

    @SerializedName("works")
    private final Work[] works;

    public Subject(String key, String name, String subjectType, int workCount, Work[] works) {
        this.key = key;
        this.name = name;
        this.subjectType = subjectType;
        this.workCount = workCount;
        this.works = works;
    }

    /**
     * Factory for testing, should only set field used in Comparable.
     */
    public static Subject newSubjectForTesting(String name) {
        return new Subject(null, name, null, 0, null);
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public int getWorkCount() {
        return workCount;
    }

    public Work[] getWorks() {
        return works;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", workCount=" + workCount +
                '}';
    }

    /**
     * Natural sorting by title.
     */
    @Override
    public int compareTo(Subject subject) {
        return name.compareTo(subject.getName());
    }

    /**
     * Convert Subject API response to Subject.
     */
    public static <T extends Subject> T jsonConverter(Class<T> subjectClass, JsonObject obj) {
        return new Gson().fromJson(obj, subjectClass);
    }
}
