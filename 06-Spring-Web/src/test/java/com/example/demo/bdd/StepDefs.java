package com.example.demo.bdd;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class StepDefs extends SpringIntegrationTest {

    @When("the client calls {word}")
    public void the_client_issues_GET_version(String word) throws Throwable {
        executeGet("/api/books");
    }

    @Then("the client receives status code of {int}")
    public void theClientReceivesStatusCodeOf(int arg0) {
        Assert.assertEquals(arg0, 200);
    }

    @Then("the client receives response down below")
    public void theClientReceivesResponseDownBelow(DataTable table) {

    }

    @When("the client calls {string} with body")
    public void theClientCallsPostWithBody(String api, DataTable table) throws IOException {

        List<Map<String, String>> dataList = table.asMaps(String.class, String.class);

        // Convert the first row into a HashMap
        HashMap<String, String> bookDetailsMap = new HashMap<>(dataList.get(0));

        // Just to verify
        bookDetailsMap.forEach((key, value) ->
                System.out.println(key + " : " + value)
        );

        executePost(api, bookDetailsMap);
    }
}
