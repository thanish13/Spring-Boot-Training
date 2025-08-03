package com.example.demo.bdd;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.message.BasicHttpResponse;
import org.junit.Assert;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class StepDefs extends SpringIntegrationTest {

    public HttpResponse response;

    @When("the client calls {word}")
    public void the_client_calls_get(String url) throws Throwable {
        response = executeGet(url);
    }

    @Then("the client receives status code of {int}")
    public void theClientReceivesStatusCodeOf(int statusCode) {
        Assert.assertEquals(statusCode, response.getCode());
    }

    @Then("the client receives response down below")
    public void theClientReceivesResponseDownBelow(DataTable table) {

    }

    @When("the client calls {string} with body")
    public void theClientCallsPostWithBody(String url, DataTable table) throws IOException {

        List<Map<String, String>> dataList = table.asMaps(String.class, String.class);

        // Convert the first row into a HashMap
        HashMap<String, String> bookDetailsMap = new HashMap<>(dataList.get(0));

        // Just to verify
        bookDetailsMap.forEach((key, value) ->
                System.out.println(key + " : " + value)
        );

        response = executePost(url, bookDetailsMap);
    }
}
