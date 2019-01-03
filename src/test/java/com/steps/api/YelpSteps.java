package com.steps.api;


import com.utilities.ApiUtilities;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class YelpSteps {

    private static final String token = "BUn-n9wNrGo8_Hncnneg3B0xQQLxg_7n8PRPNq6kyhhIm0wQ5jzvMZfZpfHUFLYQyaoJVPLHTLNksKGcFzyo4mVry5j7LHge9iudSsWcufU4AIvYN-FbzKah4gwbXHYx";
    private ApiUtilities apiUtilities = new ApiUtilities();
    ValidatableResponse val;

    @Given("^I am authenticated as user$")
    public void iAmAuthenticatedAsUser() {

        String baseuri = "https://api.yelp.com/v3/businesses/search/phone";
        RequestSpecification spec = given()
                                    .accept(ContentType.JSON)
                                    .header("Authorization","Bearer "+token)
                                    .baseUri(baseuri);

        apiUtilities.setSpec(spec);

    }

    @Then("^Response status is (\\d+)$")
    public void responseStatusIs(int code) {

        int cod = apiUtilities.getResponse().getStatusCode();
        System.out.println(cod);
        val = apiUtilities.getValidatableResponse().assertThat().statusCode(code);

//    apiUtilities.getValidatableResponse().assertThat().statusCode(code);

    }


    @When("^I search for a phone number$")
    public void iSearchForAPhoneNumber() {

       Response response = given()
                           .spec(apiUtilities.getSpec())
                           .param("phone","+14159083801")
                           .when()
                           .get();

        ValidatableResponse validatableResponse = given()
                                                  .spec(apiUtilities.getSpec())
                                                  .param("phone","+14159083801")
                                                  .when()
                                                  .get()
                                                  .then().log().ifError();

        JsonPath path = new JsonPath(response.asString());

        System.out.println(path.get("businesses.name"));

        System.out.println(response.statusCode()+" , "+response.body().asString());
        apiUtilities.setResponse(response);
        apiUtilities.setValidatableResponse(validatableResponse);

    }

//    @Given("^I give (.*)$")
//    public void iGiveDetails(@Transform(NullableStringConverter.class) String text)
//    {
//
//
//    }
}
