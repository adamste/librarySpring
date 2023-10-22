package pl.stepien.libraryspring.author.service;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

//zapytać o Data
@Data
@NoArgsConstructor
class Detail {
    private String bib_key;
    private String info_url;
    private String preview;
    private String preview_url;
    private String thumbnail_url;
}

//@Data
@NoArgsConstructor
@Setter
@Getter
class Book {
    @SerializedName(value = "preview")
    private Detail bookList;
}
