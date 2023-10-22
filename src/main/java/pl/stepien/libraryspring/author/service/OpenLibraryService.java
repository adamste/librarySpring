package pl.stepien.libraryspring.author.service;

import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import pl.stepien.libraryspring.author.model.openLibApi.Subject;
import pl.stepien.libraryspring.author.model.openLibApi.Work;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

public class OpenLibraryService {

    private final WebClient client = WebClient.builder()
            .clientConnector(new ReactorClientHttpConnector(
                    HttpClient.create().followRedirect(true)
            ))
            .baseUrl("https://openlibrary.org")
            .build();


    public String worksBySubject(String subject) {

        Mono<Subject> retrieve = client.get().uri(uriBuilder -> uriBuilder.path("/subjects/{subjects}.json")
                .build(subject))
                .retrieve().bodyToMono(Subject.class);

        Subject block = retrieve.block();
        return null;
    }

    public String worksByOlid(String olid) {

        Mono<Work> retrieve = client.get().uri(uriBuilder -> uriBuilder.path("/works/{olid}")
                .build(olid))
                .retrieve().bodyToMono(Work.class);

        Work block = retrieve.block();
        return null;
    }
}
