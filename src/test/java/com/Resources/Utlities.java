package com.Resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Utlities {
	// Declaring common global variables
	public static RequestSpecification requestSetUp;// declaring it as static so that it considers as one common variable for all test

	public RequestSpecification commonRequestSpecification() throws IOException {

		if(requestSetUp==null) {// it will append the logs for every test run instead of creating new one for every run
			PrintStream logs = new PrintStream(new FileOutputStream("LogFiles.txt"));
			requestSetUp = new RequestSpecBuilder().setBaseUri(getValuefromConfig("baseURL"))
					.addQueryParam("key", "qaclick123").setContentType(ContentType.JSON)
					.addFilter(RequestLoggingFilter.logRequestTo(logs)).addFilter(ResponseLoggingFilter.logResponseTo(logs))
					.build();
			return requestSetUp;
		}
		return requestSetUp;
	}

	public static String getValuefromConfig(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Abc\\eclipse-workspace-Shiva\\RestAssured_Cucumber_Framework_RSA\\src\\test\\java\\com\\Resources\\config.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}
	
	public String getValueFromResponse(Response response, String key ) {
			String resp = response.asString();	
			JsonPath js = new JsonPath(resp);
			return js.get(key).toString();
	}
	

	
	
	

}
