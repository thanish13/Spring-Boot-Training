package com.example.demo.bdd;

import com.example.demo.DemoApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.spring.CucumberContextConfiguration;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;

import java.io.IOException;
import java.util.HashMap;

@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringIntegrationTest {

    private static final Logger log = LoggerFactory.getLogger(SpringIntegrationTest.class);

    @LocalServerPort
    public int port;

    public static CloseableHttpClient httpClient = HttpClients.createDefault();

    private static final ObjectMapper mapper = new ObjectMapper();

    // executeGet implementation
    public HttpResponse executeGet(String url) throws IOException {

        String requestUrl = "http://localhost:" + port + "/api/books";

        ClassicHttpRequest request = new HttpGet(requestUrl);
        request.addHeader("content-type", "application/json");

        log.info("Get Call to : {}" ,requestUrl);

        return httpClient.executeOpen(null, request, null);
    }

    // executePost implementation
    public HttpResponse executePost(String url, HashMap<String,String> body) throws IOException {

        String requestUrl = "http://localhost:" + port + "/api/books";

        ClassicHttpRequest request = new HttpPost(requestUrl);

        String json = mapper.writeValueAsString(body);
        StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
        request.setEntity(entity);
        request.addHeader("content-type", "application/json");

        log.info("Post Call to : {}" ,requestUrl);

        return httpClient.executeOpen(null, request, null);

    }



}