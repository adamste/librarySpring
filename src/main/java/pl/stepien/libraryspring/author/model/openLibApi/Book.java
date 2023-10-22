package pl.stepien.libraryspring.author.model.openLibApi;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public abstract class Book {

    /**
     * Convert Book API response to List<T extends Book>.
     */
    public static <T extends Book> List<T> jsonConverter(Class<T> bookClass, JsonObject obj) {
        List<T> books = new ArrayList<>();
        obj.keySet().forEach(key -> books.add(new Gson().fromJson(obj.get(key), bookClass)));
        return books;
    }
}
