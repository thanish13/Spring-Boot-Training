package com.example.demo.bdd;

import io.cucumber.spring.CucumberContextConfiguration;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.io.IOException;

@CucumberContextConfiguration
@SpringBootTest(classes = TestConfig.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringIntegrationTest {

    @LocalServerPort
    public int port;

    public SpringIntegrationTest(){
        System.out.println("Starting App in PORT : " + port);
    }

    public static CloseableHttpClient httpClient = HttpClients.createDefault();

    // executeGet implementation
    public HttpResponse executeGet(String url) throws IOException {

        ClassicHttpRequest request = new HttpPost("http://localhost:" + port + url);
        request.addHeader("content-type", "application/json");
        HttpResponse response = httpClient.execute(request);
        return response;
    }

    // executePost implementation
    public HttpResponse executePost(String url, Object body) throws IOException {

        ClassicHttpRequest request = new HttpPost("http://localhost:" + port + url);
        request.addHeader("content-type", "application/json");
        StringEntity entity = new StringEntity(body.toString());
        request.setEntity(entity);
        HttpResponse response = httpClient.execute(request);

        return  response;

    }
}