package com.Stepdefinitions;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import org.testng.Assert;
import com.Resources.EnumAPIEndpoints;
import com.Resources.TestDataProvider;
import com.Resources.Utlities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class PlaceValidationsStep extends Utlities{
	// Declaring common global variables
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	Response response;
	TestDataProvider testdata = new TestDataProvider();
	static String place_id;// declaring static so that same place_id can be used across all test cases in Feature file, otherwise we will get NullPointerException
	//String res;
	
	@Given("the user has Add place payload ready with {string} {string} {string}")
	public void the_user_has_add_place_payload_ready_with(String name, String language, String address) throws IOException {
		// Initializing the required basic request setup
		requestSpec = given().spec(commonRequestSpecification()).body(testdata.addPlacePayload(name,language,address)).log().all(); // adding payload			
	}

	@When("user sends {string} request to {string}")
	public void user_sends_request_to(String httpMethod, String endPoint) {
		// Initializing the required basic response setup
		EnumAPIEndpoints  ep=EnumAPIEndpoints.valueOf(endPoint);// This method will create an Enum Object 
		System.out.println("Calling endpoint is : "+ep.getEndpoint());
		
		if(httpMethod.equalsIgnoreCase("POST")) {
			response = requestSpec.when().post(ep.getEndpoint());
		}else if(httpMethod.equalsIgnoreCase("GET")){
			response = requestSpec.when().get(ep.getEndpoint());
		}

	//	responseSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	
	}

	@Then("the API call should be successfull and return with status code {int}")
	public void the_api_call_should_be_successfull_and_return_with_status_code(Integer statusCode) {
		responseSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		response = response.then().spec(responseSpec).log().all().extract().response();
	    Assert.assertEquals(response.getStatusCode(), 200);
	    System.out.println("Status code passed");
	}

	@Then("the {string} in the response should be {string}")
	public void the_in_the_response_should_be(String key, String expectedValue) {
		//String res = 	response.asString();
	//JsonPath js = new JsonPath(res);// converting response into String
	
//	System.out.println("Response is : "+res);
	//System.out.println("========="+js.getString("place_id"));
	//System.out.println("Scope is : "+js.get(key).toString());

	//Assert.assertEquals(js.getString(key), expectedValue);
	Assert.assertEquals(getValueFromResponse(response, key ), expectedValue);
//	System.out.println("========="+js.getString("scope"));	
	
	
	}
	@Then("verify place_id created is mapped to {string} using {string}")
	public void verify_place_id_created_is_mapped_to_using(String expectedName, String endPoint) throws IOException {
		 place_id= getValueFromResponse(response, "place_id" );
		// Now requestSpec will be loaded with getPlaceAPI request spec
		requestSpec =given().spec(commonRequestSpecification()).queryParam("place_id", place_id);
		// Calling the same method
		user_sends_request_to("GET", endPoint); 
		// now the "response" variable will be loaded with getPlaceAPI response.
		
		String nameValue= getValueFromResponse(response, "name" );
		Assert.assertEquals(nameValue, expectedName);
		System.out.println("name is : "+nameValue);
		System.out.println("Added place is deleted.");
		System.out.println("OMG");
		
	}
	
	@Given("user has Delete place payload")
	public void user_has_delete_place_payload() throws IOException {
	    requestSpec  =given().spec(commonRequestSpecification()).body(testdata.deletePlacePayload(place_id));
	   
	}



}
