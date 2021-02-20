package com.POJO_classes_automation;
// Main JSON
public class GetResponse_POJO {

	private String url;
	private String services;
	private String expertise;
	private Courses_POJO courses;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getLinkedIn() {
		return linkedIn;
	}
	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}
	
	public Courses_POJO getCourses() {
		return courses;
	}
	public void setCourses(Courses_POJO courses) {
		this.courses = courses;
	}
	private String instructor;
	private String linkedIn;
	
	
}
