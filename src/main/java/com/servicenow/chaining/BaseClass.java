package com.servicenow.chaining;

import static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeMethod;

public class BaseClass {
	
	public static String sys_id;
	
	@BeforeMethod
	public void setUp() {
		
		baseURI = "https://dev274767.service-now.com/";
		basePath = "api/now/table/";
		authentication = basic("admin", "yC8=NAigk0@K");
		
	}

}
