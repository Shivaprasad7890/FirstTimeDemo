package com.Stepdefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	
	@Before
	public void beforeScenario() throws IOException {
		// Write a code that will give you "place_id" so that it can be used whenver you are running only the DeletePlaceAPI test case
		// And also make sure that it should run iff "place_id" is null. Because if you are running all the test cases then "place_id" will be
		// passed from previous test case itself.
		
		PlaceValidationsStep stepDefintion = new PlaceValidationsStep();
		if(PlaceValidationsStep.place_id==null) {
			stepDefintion.the_user_has_add_place_payload_ready_with("Lord", "English", "Middle Earth, Mordor");
			stepDefintion.user_sends_request_to("POST", "addPlaceAPI");
			stepDefintion.verify_place_id_created_is_mapped_to_using("Lord", "getPlaceAPI");
		}
		
		
	}
}
