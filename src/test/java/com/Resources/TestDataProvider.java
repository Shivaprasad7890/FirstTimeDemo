package com.Resources;

import java.util.ArrayList;
import java.util.List;

import com.POJO_classes_automation.Location_POJO;
import com.POJO_classes_automation.SerializePOJOBody;

public class TestDataProvider {
	
	public SerializePOJOBody addPlacePayload(String name, String language, String address) {
		Location_POJO lp = new Location_POJO();
		lp.setLat("-38.383494");
		lp.setLng("33.427362");
		
		SerializePOJOBody sp = new SerializePOJOBody();
		sp.setLocation(lp);
		sp.setAccuracy("50");
		sp.setName(name);
		sp.setPhone_number("(+91)983 893 3937");
		sp.setAddress(address);
		
		List<String> ls = new ArrayList<>();
		ls.add("shoe park");
		ls.add("shop");
		
		sp.setTypes(ls);	
		sp.setWebsite("http://google.com");
		sp.setLanguage(language);
		
		return sp;
		
	}
	
	public String deletePlacePayload(String placeId)
	{
		return "{\r\n    \"place_id\":\""+placeId+"\"\r\n}";
	}
	
	
}
