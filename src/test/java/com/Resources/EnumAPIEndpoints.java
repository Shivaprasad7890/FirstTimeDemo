package com.Resources;

public enum EnumAPIEndpoints {
	// Enum is a special class in Java which has collections of Constants & Methods
	
	// This is how define Enum methods
	addPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
	protected String endPoint;
	
	//Defining Enum constructor
	EnumAPIEndpoints(String endPoint){
		this.endPoint = endPoint;
	}
	
	public String getEndpoint() {
		return this.endPoint;
	}

}
