package com.example.demo.bdd;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.HttpResponse;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@ContextConfiguration
@SpringBootTest
public class SpringIntegrationTest {

    // executeGet implementation
    public void executeGet(String url) throws IOException {

        WireMockServer wireMockServer = new WireMockServer(1313);

        CloseableHttpClient httpClient = HttpClients.createDefault();

        wireMockServer.start();

        configureFor("localhost", wireMockServer.port());
        stubFor(get(urlEqualTo("/api/books"))
                .withHeader("content-type", equalTo("application/json"))
                .willReturn(aResponse().withStatus(200).withBody("Crime and Punishment")));

        ClassicHttpRequest request = new HttpGet("http://localhost:" + url);
        request.addHeader("content-type", "application/json");
        HttpResponse response = httpClient.execute(request);

        wireMockServer.stop();

    }
}