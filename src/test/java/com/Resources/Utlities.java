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
	

	public static void gitBasicStatements() {
		System.out.println("First we split the master branch into Develop branch");
		System.out.println("Adding this statement from develop branch");
		System.out.println("Will push this code to Develop branch");
	}
	public static void gitBasicStatementsTwo() {
		System.out.println("Remember if you are creating new branch and switching to that branch then you need to use 'git checkout -b develop' command");
		System.out.println("And if you want another person to pull the code from this newly created branch, first he need to go to his project path"
				+ "use git pull origin develop to pull the code and type 'git checkout branch' so that he can switch to develop branch");
		System.out.println("Then do your code and push it using 'git push origin develop'");
	}
	
	

}
