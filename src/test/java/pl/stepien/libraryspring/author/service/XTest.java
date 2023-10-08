package pl.stepien.libraryspring.author.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
class XTest {
    public static final String API_URL = "https://openlibrary.org/api/books?bibkeys=ISBN%3A0201558025&format=json&jscmd=viewapi";
    public static final String API_URL_NO_PARAMS = "https://openlibrary.org/api/books";
    public static final String API_URL_NO_PARAMS2 = "https://openlibrary.org/api";

    @Test
    void usingHttpRequest() throws Exception {
        URL url = new URL(API_URL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

//        Map<String, String> parameters = new HashMap<>();
//        parameters.put("bibkeys", "ISBN%3A0201558025");
//        parameters.put("format", "json");
//        parameters.put("booksjscmd", "viewapi");
//
//        con.setDoOutput(true);
//        DataOutputStream out = new DataOutputStream(con.getOutputStream());
//        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
//        out.flush();
//        out.close();

        con.setRequestProperty("Content-Type", "application/json");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        System.err.println(content);
    }


    @Test
    public void getBookInfo() {
        /*
        1. create an instance
        2. make a request
        3. handle the response
         */

        WebClient client = WebClient.builder()
//                .uriBuilderFactory(factory)
                .baseUrl(API_URL_NO_PARAMS2)
//                .defaultCookie("cookieKey", "cookieValue")
//                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .defaultUriVariables(Collections.singletonMap("url", a))
                .build();

        URI uri = URI.create("https://openlibrary.org/api/books?bibkeys=ISBN%3A0201558025&format=json&jscmd=viewapi");

        Mono<String> retrieve = client.get().uri(uri)
                .retrieve().bodyToMono(String.class);

        String block = retrieve.block();
        System.out.println(block);
    }

    @Test
    public void getBookInfo2() {
        /*
        1. create an instance
        2. make a request
        3. handle the response
         */

        WebClient client = WebClient.builder()
//                .uriBuilderFactory(factory)
//            .baseUrl(API_URL)
//                .defaultCookie("cookieKey", "cookieValue")
//                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .defaultUriVariables(Collections.singletonMap("url", a))
                .build();

        URI uri = URI.create("https://openlibrary.org/api/books?bibkeys=ISBN%3A0201558025&format=json&jscmd=viewapi");

        Mono<String> retrieve = client.get().uri(uri)
                .retrieve().bodyToMono(String.class);

        String block = retrieve.block();
        System.out.println(block);
    }
}


class ParameterStringBuilder {
    public static String getParamsString(Map<String, String> params)
            throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()) {
            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            result.append("&");
        }

        String resultString = result.toString();
        return resultString.length() > 0
                ? resultString.substring(0, resultString.length() - 1)
                : resultString;
    }
}