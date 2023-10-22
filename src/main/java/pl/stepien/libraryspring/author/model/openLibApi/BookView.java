package pl.stepien.libraryspring.author.model.openLibApi;

import com.google.gson.annotations.SerializedName;

/**
 * API response Object.
 * View version of Book, contains very limited information.
 * Reference: https://openlibrary.org/dev/docs/api/books
 */
public final class BookView extends Book {

    @SerializedName("bib_key")
    private final String bibKey;

    @SerializedName("info_url")
    private final String infoUrl;

    @SerializedName("preview")
    private final String preview;

    @SerializedName("preview_url")
    private final String previewUrl;

    @SerializedName("thumbnail_url")
    private final String thumbnailUrl;

    public BookView(String bibKey, String infoUrl, String preview,
                    String previewUrl, String thumbnailUrl) {
        this.bibKey = bibKey;
        this.infoUrl = infoUrl;
        this.preview = preview;
        this.previewUrl = previewUrl;
        this.thumbnailUrl = thumbnailUrl;
    }

    /**
     * "Identifier used to query this book."
     */
    public String getBibKey() {
        return bibKey;
    }

    /**
     * "A URL to the book page in the Open Library."
     */
    public String getInfoUrl() {
        return infoUrl;
    }

    /**
     * "Preview state - either "noview" or "full"."
     */
    public String getPreview() {
        return preview;
    }

    /**
     * "A URL to the preview of the book. This links to the archive.org page
     * when a readable version of the book is available, otherwise it links
     * to the book page on openlibrary.org. Please note that the preview_url
     * is always provided even if there is no readable version available.
     * The preview property should be used to test if a book is readable."
     */
    public String getPreviewUrl() {
        return previewUrl;
    }

    /**
     * "A URL to a thumbnail of the cover of the book.
     * This is provided only when thumbnail is available."
     */
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    @Override
    public String toString() {
        return "BookView{" +
                "bibKey='" + bibKey + '\'' +
                ", infoUrl='" + infoUrl + '\'' +
                '}';
    }
}