package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
        ApiCall apiCall=new ApiCall();

        ObjectMapper objectMapper=new ObjectMapper();
        Todo todo=new Todo(1234,1,"Devendu",true);

        String json=objectMapper.writeValueAsString(todo);
        System.out.println(json);
        apiCall.create(todo);
        List<Todo>list=apiCall.findAll();
        for(Todo todoIter:list)
        {
           // System.out.println("The id is "+todoIter.id);
            System.out.println("The title is "+todoIter.title);
           // System.out.println("The boolean val is "+todoIter.completed);

        }

    }
}
        /*
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://openjdk.org/"))
                .timeout(Duration.ofMinutes(1))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofFile(Paths.get("file.json")))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
        System.out.println(response.body());
        */
