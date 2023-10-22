package pl.stepien.libraryspring.author.model.openLibApi;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * API response Object.
 * Reference: https://openlibrary.org/dev/docs/api/read
 */
public final class Read {

    @SerializedName("records")
    private final Record[] records;

    @SerializedName("items")
    private final Item[] items;

    public Read(Record[] record, Item[] items) {
        this.records = record;
        this.items = items;
    }

    public Record[] getRecords() {
        return records;
    }

    public Item[] getItems() {
        return items;
    }

    public static final class Record {

        @SerializedName("isbns")
        private final String[] isbns;

        @SerializedName("issns")
        private final String[] issns;

        @SerializedName("lccns")
        private final String[] lccns;

        @SerializedName("oclcs")
        private final String[] oclcs;

        @SerializedName("olids")
        private final String[] olids;

        @SerializedName("publishDates")
        private final String[] publishDates;

        @SerializedName("recordURL")
        private final String recordUrl;

        @SerializedName("data")
        private final BookData data;

        @SerializedName("details")
        private final BookDetailed detailed;

        public Record(String[] isbns, String[] issns, String[] lccns, String[] oclcs,
                      String[] olids, String[] publishDates, String recordUrl,
                      BookData data, BookDetailed detailed) {
            this.isbns = isbns;
            this.issns = issns;
            this.lccns = lccns;
            this.oclcs = oclcs;
            this.olids = olids;
            this.publishDates = publishDates;
            this.recordUrl = recordUrl;
            this.data = data;
            this.detailed = detailed;
        }

        public String[] getIsbns() {
            return isbns;
        }

        public String[] getIssns() {
            return issns;
        }

        public String[] getLccns() {
            return lccns;
        }

        public String[] getOclcs() {
            return oclcs;
        }

        public String[] getOlids() {
            return olids;
        }

        public String[] getPublishDates() {
            return publishDates;
        }

        public String getRecordUrl() {
            return recordUrl;
        }

        public BookData getData() {
            return data;
        }

        public BookDetailed getDetailed() {
            return detailed;
        }

        @Override
        public String toString() {
            return "Record{" +
                    "isbns=" + Arrays.toString(isbns) +
                    ", issns=" + Arrays.toString(issns) +
                    ", lccns=" + Arrays.toString(lccns) +
                    ", oclcs=" + Arrays.toString(oclcs) +
                    ", olids=" + Arrays.toString(olids) +
                    ", publishDates=" + Arrays.toString(publishDates) +
                    ", recordUrl='" + recordUrl + '\'' +
                    ", data=" + data +
                    ", detailed=" + detailed +
                    '}';
        }
    }

    public static final class Item {

        @SerializedName("match")
        private final String match;

        @SerializedName("status")
        private final String status;

        @SerializedName("itemURL")
        private final String itemUrl;

        @SerializedName("cover")
        private final Cover cover;

        @SerializedName("fromRecord")
        private final String fromRecord;

        @SerializedName("publishDate")
        private final String publishDate;

        @SerializedName("ol-edition-id")
        private final String olEditionId;

        @SerializedName("ol-work-id")
        private final String olWorkId;

        public Item(String match, String status, String itemUrl, Cover cover,
                    String fromRecord, String publishDate, String olEditionId,
                    String olWorkId) {
            this.match = match;
            this.status = status;
            this.itemUrl = itemUrl;
            this.cover = cover;
            this.fromRecord = fromRecord;
            this.publishDate = publishDate;
            this.olEditionId = olEditionId;
            this.olWorkId = olWorkId;
        }

        public String getMatch() {
            return match;
        }

        public String getStatus() {
            return status;
        }

        public String getItemUrl() {
            return itemUrl;
        }

        public Cover getCover() {
            return cover;
        }

        public String getFromRecord() {
            return fromRecord;
        }

        public String getPublishDate() {
            return publishDate;
        }

        public String getOlEditionId() {
            return olEditionId;
        }

        public String getOlWorkId() {
            return olWorkId;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "match='" + match + '\'' +
                    ", status='" + status + '\'' +
                    ", itemUrl='" + itemUrl + '\'' +
                    ", cover=" + cover +
                    ", fromRecord='" + fromRecord + '\'' +
                    ", publishDate='" + publishDate + '\'' +
                    ", olEditionId='" + olEditionId + '\'' +
                    ", olWorkId='" + olWorkId + '\'' +
                    '}';
        }

        private static final class Cover {

            @SerializedName("small")
            private final String small;

            @SerializedName("medium")
            private final String medium;

            @SerializedName("large")
            private final String large;

            public Cover(String small, String medium, String large) {
                this.small = small;
                this.medium = medium;
                this.large = large;
            }

            public String getSmall() {
                return small;
            }

            public String getMedium() {
                return medium;
            }

            public String getLarge() {
                return large;
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
    }

    @Override
    public String toString() {
        return "Read{" +
                "records=" + Arrays.toString(records) +
                ", items=" + Arrays.toString(items) +
                '}';
    }

    /**
     * Convert Read API response to Read.
     */
    public static Read jsonConverter(JsonObject obj) {
        List<Record> records = new ArrayList<>();
        if (obj.get("records").isJsonArray()) {
            for (JsonElement e : obj.get("records").getAsJsonArray()) {
                records.add(new Gson().fromJson(e, Record.class));
            }
        } else {
            obj.get("records").getAsJsonObject().keySet().forEach(
                    key -> records.add(new Gson().fromJson(obj.get("records").getAsJsonObject().get(key), Record.class)));
        }
        List<Item> items = new ArrayList<>();
        for (JsonElement e : obj.get("items").getAsJsonArray()) {
            items.add(new Gson().fromJson(e, Item.class));
        }
        return new Read(records.toArray(new Record[0]), items.toArray(new Item[0]));
    }
}
