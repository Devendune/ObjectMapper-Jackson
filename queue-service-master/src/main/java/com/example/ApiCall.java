package com.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class ApiCall
{
    private final String API="https://jsonplaceholder.typicode.com/todos";

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public ApiCall()
    {
        httpClient=HttpClient.newHttpClient();
        objectMapper=new ObjectMapper();
    }

    public List<Todo> findAll() throws IOException, InterruptedException
    {
       HttpRequest request= HttpRequest.newBuilder()
                .uri(URI.create(API)).GET()
                .build();

        HttpResponse<String> response=httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response);
        return objectMapper.readValue(response.body(), new TypeReference<>(){});
    }

    public HttpResponse<String> create(Todo todo) throws IOException, InterruptedException {
        HttpRequest httpRequest=HttpRequest.newBuilder().uri(
                URI.create(API)).
                POST(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(todo)))
                .build();

        return httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());
    }
}
