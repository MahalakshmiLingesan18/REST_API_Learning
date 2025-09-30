package com.servicenow;

import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.basic;
import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GetwithQueryParams {

	@Test
	public static void getChangeRequest() {

		baseURI = "https://dev274767.service-now.com/";
		basePath = "api/now/table/";
		authentication = basic("admin", "yC8=NAigk0@K");

		Response response = given().pathParam("tableName", "change_request")
				.queryParam("sysparm_fields", "sys_id,short_description").queryParam("sysparm_limit", "3")
				.get("{tableName}");

		System.out.println("GET status code is " + response.getStatusCode());

		response.then().assertThat().statusCode(200).statusLine(Matchers.containsString("OK"));
		response.prettyPrint();

	}

}
