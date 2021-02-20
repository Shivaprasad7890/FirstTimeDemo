package com.POJO_classes_automation;

public class Location_POJO {

	private String lat; // make sure these variable names are same as the Key names in the request. Otherwise it wont work
	private String lng;
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}

	
}
