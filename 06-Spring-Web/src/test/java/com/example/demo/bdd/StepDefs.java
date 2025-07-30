package com.example.demo.bdd;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StepDefs extends SpringIntegrationTest {

    @When("^the client calls /version$")
    public void the_client_issues_GET_version() throws Throwable {
        executeGet("1313/api/books");
    }

    @Then("the client receives status code of {int}")
    public void theClientReceivesStatusCodeOf(int arg0) {
        Assert.assertEquals(arg0, 200);
    }
}
