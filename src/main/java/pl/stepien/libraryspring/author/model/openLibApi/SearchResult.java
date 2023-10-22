package pl.stepien.libraryspring.author.model.openLibApi;

import com.google.gson.annotations.SerializedName;

/**
 * API response Object.
 * Reference: https://openlibrary.org/dev/docs/api/search
 */
public final class SearchResult {

    @SerializedName("start")
    private final int start;

    @SerializedName("num_found")
    private final int numFound;

    @SerializedName("docs")
    private final Result[] results;

    public SearchResult(int start, int numFound, Result[] results) {
        this.start = start;
        this.numFound = numFound;
        this.results = results;
    }

    public int getStart() {
        return start;
    }

    public int getNumFound() {
        return numFound;
    }

    public Result[] getResults() {
        return results;
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "start='" + start + '\'' +
                ", numFound=" + numFound +
                '}';
    }

    public static final class Result {

        @SerializedName("key")
        private final String key;

        @SerializedName("type")
        private final String type;

        @SerializedName("title")
        private final String title;

        @SerializedName("title_suggest")
        private final String titleSuggest;

        @SerializedName("has_fulltext")
        private final boolean hasFullText;

        @SerializedName("edition_count")
        private final int editionCount;

        @SerializedName("first_publish_year")
        private final int firstPublishYear;

        @SerializedName("last_modified_i")
        private final long lastModifiedI;

        @SerializedName("ebook_count_i")
        private final int ebookCountI;

        @SerializedName("public_scan_b")
        private final boolean publicScanB;

        @SerializedName("ia_collection_s")
        private final String iaCollectionS;

        @SerializedName("lending_edition_s")
        private final String lendingEditionS;

        @SerializedName("lending_identifier_s")
        private final String lendingIdentifierS;

        @SerializedName("printdisabled_s")
        private final String printDisabledS;

        @SerializedName("cover_edition_key")
        private final String coverEditionKey;

        @SerializedName("cover_i")
        private final int coverI;

        @SerializedName("publish_year")
        private final int[] publishYears;

        @SerializedName("author_name")
        private final String[] authorNames;

        @SerializedName("id_amazon")
        private final String[] amazonIDs;

        @SerializedName("seed")
        private final String[] seeds;

        @SerializedName("author_alternative_name")
        private final String[] authorAlternativeNames;

        @SerializedName("subject")
        private final String[] subjects;

        @SerializedName("isbn")
        private final String[] isbns;

        @SerializedName("ia_loaded_id")
        private final String[] iaLoadedIDs;

        @SerializedName("edition_key")
        private final String[] editionKeys;

        @SerializedName("language")
        private final String[] languages;

        @SerializedName("id_librarything")
        private final String[] libraryThingIDs;

        @SerializedName("lcc")
        private final String[] lccs;

        @SerializedName("lccn")
        private final String[] lccns;

        @SerializedName("id_goodreads")
        private final String[] goodReadsIDs;

        @SerializedName("publish_place")
        private final String[] publishPlaces;

        @SerializedName("contributor")
        private final String[] contributors;

        @SerializedName("id_google")
        private final String[] googleIDs;

        @SerializedName("ia")
        private final String[] ias;

        @SerializedName("text")
        private final String[] texts;

        @SerializedName("place")
        private final String[] places;

        @SerializedName("dcc")
        private final String[] dccs;

        @SerializedName("author_key")
        private final String[] authorKeys;

        @SerializedName("id_libris")
        private final String[] librisIDs;

        @SerializedName("id_overdrive")
        private final String[] overdriveIDs;

        @SerializedName("id_dnb")
        private final String[] dndIDs;

        @SerializedName("id_alibris_id")
        private final String[] alibrisID;

        @SerializedName("ia_box_id")
        private final String[] iaBoxIDs;

        @SerializedName("first_sentence")
        private final String[] firstSentences;

        @SerializedName("person")
        private final String[] persons;

        @SerializedName("id_wikidata")
        private final String[] wikidataIDs;

        @SerializedName("oclc")
        private final String[] oclcs;

        @SerializedName("publisher")
        private final String[] publishers;

        @SerializedName("id_bcid")
        private final String[] bcidIDs;

        @SerializedName("publish_date")
        private final String[] publishDates;

        public Result(String key, String type, String title, String titleSuggest,
                      boolean hasFullText, int editionCount, int firstPublishYear,
                      long lastModifiedI, int ebookCountI, boolean publicScanB,
                      String iaCollectionS, String lendingEditionS, String lendingIdentifierS,
                      String printDisabledS, String coverEditionKey, int coverI,
                      int[] publishYears, String[] authorNames, String[] amazonIDs,
                      String[] seeds, String[] authorAlternativeNames, String[] subjects,
                      String[] isbns, String[] iaLoadedIDs, String[] editionKeys,
                      String[] languages, String[] libraryThingIDs, String[] lccs,
                      String[] lccns, String[] goodReadsIDs, String[] publishPlaces,
                      String[] contributors, String[] googleIDs, String[] ias,
                      String[] texts, String[] places, String[] dccs, String[] authorKeys,
                      String[] librisIDs, String[] overdriveIDs, String[] dndIDs,
                      String[] alibrisID, String[] iaBoxIDs, String[] firstSentences,
                      String[] persons, String[] wikidataIDs, String[] oclcs,
                      String[] publishers, String[] bcidIDs, String[] publishDates) {
            this.key = key;
            this.type = type;
            this.title = title;
            this.titleSuggest = titleSuggest;
            this.hasFullText = hasFullText;
            this.editionCount = editionCount;
            this.firstPublishYear = firstPublishYear;
            this.lastModifiedI = lastModifiedI;
            this.ebookCountI = ebookCountI;
            this.publicScanB = publicScanB;
            this.iaCollectionS = iaCollectionS;
            this.lendingEditionS = lendingEditionS;
            this.lendingIdentifierS = lendingIdentifierS;
            this.printDisabledS = printDisabledS;
            this.coverEditionKey = coverEditionKey;
            this.coverI = coverI;
            this.publishYears = publishYears;
            this.authorNames = authorNames;
            this.amazonIDs = amazonIDs;
            this.seeds = seeds;
            this.authorAlternativeNames = authorAlternativeNames;
            this.subjects = subjects;
            this.isbns = isbns;
            this.iaLoadedIDs = iaLoadedIDs;
            this.editionKeys = editionKeys;
            this.languages = languages;
            this.libraryThingIDs = libraryThingIDs;
            this.lccs = lccs;
            this.lccns = lccns;
            this.goodReadsIDs = goodReadsIDs;
            this.publishPlaces = publishPlaces;
            this.contributors = contributors;
            this.googleIDs = googleIDs;
            this.ias = ias;
            this.texts = texts;
            this.places = places;
            this.dccs = dccs;
            this.authorKeys = authorKeys;
            this.librisIDs = librisIDs;
            this.overdriveIDs = overdriveIDs;
            this.dndIDs = dndIDs;
            this.alibrisID = alibrisID;
            this.iaBoxIDs = iaBoxIDs;
            this.firstSentences = firstSentences;
            this.persons = persons;
            this.wikidataIDs = wikidataIDs;
            this.oclcs = oclcs;
            this.publishers = publishers;
            this.bcidIDs = bcidIDs;
            this.publishDates = publishDates;
        }

        public String getKey() {
            return key;
        }

        public String getType() {
            return type;
        }

        public String getTitle() {
            return title;
        }

        public String getTitleSuggest() {
            return titleSuggest;
        }

        public boolean isHasFullText() {
            return hasFullText;
        }

        public int getEditionCount() {
            return editionCount;
        }

        public int getFirstPublishYear() {
            return firstPublishYear;
        }

        public long getLastModifiedI() {
            return lastModifiedI;
        }

        public int getEbookCountI() {
            return ebookCountI;
        }

        public boolean isPublicScanB() {
            return publicScanB;
        }

        public String getIaCollectionS() {
            return iaCollectionS;
        }

        public String getLendingEditionS() {
            return lendingEditionS;
        }

        public String getLendingIdentifierS() {
            return lendingIdentifierS;
        }

        public String getPrintDisabledS() {
            return printDisabledS;
        }

        public String getCoverEditionKey() {
            return coverEditionKey;
        }

        public int getCoverI() {
            return coverI;
        }

        public int[] getPublishYears() {
            return publishYears;
        }

        public String[] getAuthorNames() {
            return authorNames;
        }

        public String[] getAmazonIDs() {
            return amazonIDs;
        }

        public String[] getSeeds() {
            return seeds;
        }

        public String[] getAuthorAlternativeNames() {
            return authorAlternativeNames;
        }

        public String[] getSubjects() {
            return subjects;
        }

        public String[] getIsbns() {
            return isbns;
        }

        public String[] getIaLoadedIDs() {
            return iaLoadedIDs;
        }

        public String[] getEditionKeys() {
            return editionKeys;
        }

        public String[] getLanguages() {
            return languages;
        }

        public String[] getLibraryThingIDs() {
            return libraryThingIDs;
        }

        public String[] getLccs() {
            return lccs;
        }

        public String[] getLccns() {
            return lccns;
        }

        public String[] getGoodReadsIDs() {
            return goodReadsIDs;
        }

        public String[] getPublishPlaces() {
            return publishPlaces;
        }

        public String[] getContributors() {
            return contributors;
        }

        public String[] getGoogleIDs() {
            return googleIDs;
        }

        public String[] getIas() {
            return ias;
        }

        public String[] getTexts() {
            return texts;
        }

        public String[] getPlaces() {
            return places;
        }

        public String[] getDccs() {
            return dccs;
        }

        public String[] getAuthorKeys() {
            return authorKeys;
        }

        public String[] getLibrisIDs() {
            return librisIDs;
        }

        public String[] getOverdriveIDs() {
            return overdriveIDs;
        }

        public String[] getDndIDs() {
            return dndIDs;
        }

        public String[] getAlibrisID() {
            return alibrisID;
        }

        public String[] getIaBoxIDs() {
            return iaBoxIDs;
        }

        public String[] getFirstSentences() {
            return firstSentences;
        }

        public String[] getPersons() {
            return persons;
        }

        public String[] getWikidataIDs() {
            return wikidataIDs;
        }

        public String[] getOclcs() {
            return oclcs;
        }

        public String[] getPublishers() {
            return publishers;
        }

        public String[] getBcidIDs() {
            return bcidIDs;
        }

        public String[] getPublishDates() {
            return publishDates;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "type='" + type + '\'' +
                    ", key='" + key + '\'' +
                    ", title='" + title + '\'' +
                    '}';
        }
    }
}
