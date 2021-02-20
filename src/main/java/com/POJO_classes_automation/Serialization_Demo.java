package com.POJO_classes_automation;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;

public class Serialization_Demo {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		Location_POJO lp = new Location_POJO();
		lp.setLat("-38.383494");
		lp.setLng("33.427362");
		
		SerializePOJOBody sp = new SerializePOJOBody();
		sp.setLocation(lp);
		sp.setAccuracy("50");
		sp.setName("Frontline house");
		sp.setPhone_number("(+91)983 893 3937");
		sp.setAddress("29, side layout, cohen 09");
		
		List<String> ls = new ArrayList<>();
		ls.add("shoe park");
		ls.add("shop");
		
		sp.setTypes(ls);	
		sp.setWebsite("http://google.com");
		sp.setLanguage("French");
		
		given().queryParam("key", "qaclick123").body(sp).log().all().when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).log().all();
		
	}

}
