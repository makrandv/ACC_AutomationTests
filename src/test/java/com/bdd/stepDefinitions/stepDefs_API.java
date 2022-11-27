package com.bdd.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


public class stepDefs_API {

    //ToDo remove hardcoding of URL
    private String apiUrl = "https://api.trademe.co.nz/v1/Categories/UsedCars.json";
    private Response response;
    private RequestSpecification requestSpecification;

    @Given("^User has access to TradeMe API$")
    public void user_has_access_to_TradeMe_API() throws URISyntaxException {
        requestSpecification = RestAssured.given();
    }

    @When("^User requests for number of named car makers$")
    public void user_requests_for_number_of_name_car_maker() throws URISyntaxException {

        response = requestSpecification.when().get(new URI(apiUrl));
        Assert.assertEquals(response.then().extract().statusCode(),200);
    }

    @Then("^User is returned with count of \"(.*)\" car makers$")
    public void user_is_returned_total_number_of_car_makers(int expectedCount)
    {
        List<String > namedCarsList = response.jsonPath().get("Subcategories.Name");
        Assert.assertEquals(namedCarsList.size(),expectedCount);

    }
}
