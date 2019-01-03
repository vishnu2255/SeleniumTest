package com.steps.api;

import com.utilities.ApiUtilities;
import com.utilities.reader.TestDataReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.apache.http.client.utils.URIBuilder;

import java.net.URI;

import static io.restassured.RestAssured.given;

public class TwitterSteps {

    private TestDataReader testDataReader = new TestDataReader();
    private ApiUtilities apiUtilities = new ApiUtilities();
    private ValidatableResponse response;

    private String con_key = testDataReader.getLoginData("CONSUMER_KEY");
    private String con_sec = testDataReader.getLoginData("CONSUMER_SECRET");
    private String acc_key = testDataReader.getLoginData("ACCESS_KEY");
    private String acc_tok = testDataReader.getLoginData("ACCESS_SECRET");

//    TwitterSteps(TestDataReader testDataReader, ApiUtilities apiUtilities)
//    {
//        this.testDataReader = testDataReader;
//        this.apiUtilities   = apiUtilities;
//
//    }



    @Given("^I am not authenticated as user$")
    public void iAmnotAuthenticatedAsUser() {
//
//    given()
//    .auth()
//    .oauth(con_key,con_sec,acc_key,acc_tok);

    RequestSpecBuilder builder = new RequestSpecBuilder();
        String base = "https://api.twitter.com/1.1/statuses/update.json";
        RequestSpecification specification = given()
                                             .auth()
                                             .oauth(con_key,con_sec,acc_key,acc_tok)
                                             .accept(ContentType.JSON)
                                             .baseUri(base);
        apiUtilities.setSpec(specification);
    }


    @When("^I post a tweet$")
    public void iPostATweet() throws java.net.URISyntaxException{

        URI uri = new URIBuilder()
                .setScheme("https")
                .setHost("api.twitter.com/")
                .setPath("1.1/statuses/update.json")
                .addParameter("status" , "Hey")
                .build();


        given()
                .auth()
                .oauth(con_key,con_sec,acc_key,acc_tok)
                .when()
                .post(uri)
                .then().assertThat().statusCode(HttpStatus.SC_OK);

        String s =  given()
                .auth()
                .oauth(con_key,con_sec,acc_key,acc_tok)
                .when()
                .post(uri)
                .asString();

        System.out.println(s);

//
//        ValidatableResponse validatableResponse = given().spec(apiUtilities.getSpec())
//                .when()
//                .post(uri).then().assertThat().statusCode(200);

//        Status status = new Status();
//        status.setStatus("Hey");
//
//        Gson obj = new Gson();
//        String s = obj.toJson(status);
//
//     Response res  =   given()
//        .when()
//        .post(s)
//        ;
//
//        System.out.println(res.statusCode());

    }


}
