package pl.stepien.libraryspring.author.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@ExtendWith(MockitoExtension.class)
class XTest {

    @Test
    public void getBookInfo2() {
        /*
        1. create an instance
        2. make a request
        3. handle the response
         */

        WebClient client = WebClient.builder()
                .baseUrl("https://openlibrary.org/api")
                .build();

        Mono<String> retrieve = client.get().uri(uriBuilder -> uriBuilder.path("/books")
                .queryParam("bibkeys", "0201558025")
                .queryParam("format", "json")
                .queryParam("jscmd", "viewapi")
                .build())
                .retrieve().bodyToMono(String.class);

        String block = retrieve.block();
        System.out.println(block);
    }
}
}