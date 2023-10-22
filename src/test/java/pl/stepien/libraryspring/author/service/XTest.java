package pl.stepien.libraryspring.author.service;

import com.google.gson.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.lang.reflect.Type;

@ExtendWith(MockitoExtension.class)
class XTest {

    private final WebClient client = WebClient.builder()
            .baseUrl("https://openlibrary.org")
            .build();

    @Test
    public void serializeBook() {
        Book book = new Book();
        Detail detail = new Detail();
        detail.setBib_key("1");
        detail.setPreview("2");
        detail.setInfo_url("3");
        detail.setThumbnail_url("4");
        book.setBookList(detail);

        GsonBuilder gsonBuilder = new GsonBuilder()
                .registerTypeAdapter(Book.class, new StudentAdapter());

        Gson gson = gsonBuilder.create();
        String s = gson.toJson(book);
        System.out.println(s);
    }

    class StudentAdapter implements JsonSerializer<Book> {

        @Override
        public JsonElement serialize(Book src, Type typeOfSrc,
                                     JsonSerializationContext context) {

            JsonObject obj = new JsonObject();
//            obj.addProperty("name", );
            obj.addProperty(src.getBookList().getBib_key(), new Gson().toJson(src.getBookList()));

            return obj;
        }
    }

    @Test // /api/books
    public void getBookInfo2() {
//sensowne źródło:  https://www.amitph.com/spring-webclient-request-parameters/
        Mono<String> retrieve = client.get().uri(uriBuilder -> uriBuilder.path("/api/books")
                .queryParam("bibkeys", "0201558025")
                .queryParam("format", "json")
                .queryParam("jscmd", "viewapi")
                .build())
                .retrieve().bodyToMono(String.class);

        String block = retrieve.block();
        System.out.println(block);
//        Assert.assertTrue();
    }

    @Test // /subjects/automotive.json?details=false
    public void getBookInfo3() {
        Mono<String> retrieve = client.get().uri(uriBuilder -> uriBuilder.path("/subjects/{subjects}.json")
                .build("automotive"))
                .retrieve().bodyToMono(String.class);

        String block = retrieve.block();
        System.out.println(block);
    }

    @Test // search/authors.json?q=richardson
    public void getBookInfo4() {
        Mono<String> retrieve = client.get().uri(uriBuilder -> uriBuilder.path("/search/authors.json")
                .queryParam("q", "richardson")
                .build("automotive"))
                .retrieve().bodyToMono(String.class);

        String block = retrieve.block();
        System.out.println(block);
    }
//    https://openlibrary.org/OL53924W
//    https://openlibrary.org/books/OL53924W
//    https://openlibrary.org/isbn/9780807286005
//https://openlibrary.org/isbn/9780807286005
//https://openlibrary.org/isbn/9780807286005xdddd


    //githubowe
    //https://github.com/internetarchive/openlibrary

    @Test //    /books/OL53924W
    public void getBookInfo5() throws InterruptedException {
        Mono<String> retrieve = client.get()
                .uri(uriBuilder -> uriBuilder.path("isbn/{isbn}").build("9780807286005"))
                .retrieve().bodyToMono(String.class);

        Thread.sleep(10000);

        String block = retrieve.block();
        System.out.println(block);
    }


    //co ja probowalem tutaj zrobic?
    //chyba zrobic kazdy typ requestu w ramach testu;
    //sa requesty GET, ale nie ma żadnych postów
    //nie ma serializacji do obiektów szczegółowych typów

    //w tym api są same gety
}