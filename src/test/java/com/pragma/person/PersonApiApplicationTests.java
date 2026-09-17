package com.pragma.person;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonApiApplicationTests {

    @LocalServerPort
    private int port;

    @Test
    void contextLoads() {
    }

        @Test
        void shouldSaveAndQueryPerson() throws Exception {
            String baseUrl = "http://localhost:" + port + "/api/v1/person";
            HttpResponse<String> queryResponse;
            try (HttpClient httpClient = HttpClient.newHttpClient()) {
                HttpRequest createRequest = HttpRequest.newBuilder(URI.create(baseUrl))
                        .header("Content-Type", "application/json")
                        .POST(HttpRequest.BodyPublishers.ofString("""
                                {
                                  "identificationNumber": "123456789",
                                  "name": "Ada Lovelace",
                                  "email": "ada@example.com"
                                }
                                """))
                        .build();

                HttpResponse<String> createResponse = httpClient.send(createRequest,
                        HttpResponse.BodyHandlers.ofString());
                assertEquals(201, createResponse.statusCode());

                HttpRequest queryRequest = HttpRequest.newBuilder(URI.create(baseUrl)).GET().build();
                queryResponse = httpClient.send(queryRequest,
                        HttpResponse.BodyHandlers.ofString());
            }
            assertEquals(200, queryResponse.statusCode());
            assertTrue(queryResponse.body().contains("123456789"));
            assertTrue(queryResponse.body().contains("Ada Lovelace"));
            assertTrue(queryResponse.body().contains("ada@example.com"));
        }

}
