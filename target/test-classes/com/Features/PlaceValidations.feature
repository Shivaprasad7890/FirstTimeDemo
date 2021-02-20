Feature: Validating Place API's' 

@AddPlaceTestCase
Scenario Outline: Verify if place is added successfully using Add place API 

	Given the user has Add place payload ready with "<name>" "<language>" "<address>" 
	When user sends "POST" request to "addPlaceAPI" 
	Then the API call should be successfull and return with status code 200 
	And the "status" in the response should be "OK" 
	And the "scope" in the response should be "APP" 
	And verify place_id created is mapped to "<name>" using "getPlaceAPI" 
	
	Examples: 
		|name|language|address|
		|Peter tom|French|Downhill road, New york|
		#|Harry potter|London|Hogwarts, Ministry of magic|
		
@DeletePlaceTestCase		
Scenario: Verify whether Delete place API is working fine 
	Given user has Delete place payload 
	When user sends "POST" request to "deletePlaceAPI" 
	And the "status" in the response should be "OK" 
	
  	