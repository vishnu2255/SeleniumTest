package com.steps.api;

import com.google.gson.Gson;
import com.utilities.ApiPayloads;
import cucumber.api.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserSteps {

    private ApiPayloads apiPayloads = new ApiPayloads();

    @Given("^I send details$")
    public void test(String data)
    {
        Gson gson = new Gson();
        String s = gson.toJson(apiPayloads.getBody());

        Response resp = given().baseUri("http://restapi.demoqa.com/customer")
                .accept(ContentType.JSON)
                .body(s)
                .post("/register");

        System.out.println(resp.statusCode()+" , "+ resp.body().asString());


    }
}
