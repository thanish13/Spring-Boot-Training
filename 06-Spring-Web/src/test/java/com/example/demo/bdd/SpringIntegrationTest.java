package com.example.demo.bdd;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.cucumber.spring.CucumberContextConfiguration;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@CucumberContextConfiguration
@SpringBootTest
public class SpringIntegrationTest {

    WireMockServer wireMockServer = new WireMockServer();

    CloseableHttpClient httpClient = HttpClients.createDefault();

    public SpringIntegrationTest(){

        wireMockServer.start();

    }

    // executeGet implementation
    public void executeGet(String url) throws IOException {

        ClassicHttpRequest request = new HttpGet("http://localhost:" + wireMockServer.port() + url);
        request.addHeader("content-type", "application/json");
        HttpResponse response = httpClient.execute(request);

        wireMockServer.stop();
    }

    // executePost implementation
    public void executePost(String url, Object body) throws IOException {

        ClassicHttpRequest request = new HttpPost("http://localhost:" + wireMockServer.port() + url);
        request.addHeader("content-type", "application/json");
        StringEntity entity = new StringEntity(body.toString());
        request.setEntity(entity);
        HttpResponse response = httpClient.execute(request);

        wireMockServer.stop();

    }
}