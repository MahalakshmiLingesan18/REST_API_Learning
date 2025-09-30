package com.servicenow.changerequest;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class IncidentManagement {

	public static String Sys_ID;

	@Test(priority = 1)
	public static void createChangeRequest() {

		baseURI = "https://dev274767.service-now.com/";
		basePath = "api/now/table/";
		authentication = basic("admin", "yC8=NAigk0@K");

		String requestPayload = """
				{
				"short_description": "Created via RestAssured"
				}""";

		Response response = given().pathParam("tableName", "change_request").contentType(ContentType.JSON)
				.body(requestPayload).post("{tableName}");

		System.out.println("POST status code is " + response.getStatusCode());
		Sys_ID = response.jsonPath().getString("result.sys_id");
		System.out.println("Sys_ID: "+Sys_ID);
		
		response.prettyPrint();

		response.then().assertThat().statusCode(201).statusLine(Matchers.containsString("Created"));

	}

	@Test(priority = 2)
	public static void updateChangeRequest() {

		baseURI = "https://dev274767.service-now.com/";
		basePath = "api/now/table/";
		authentication = basic("admin", "yC8=NAigk0@K");

		String requestPayload = """
				{
				"short_description": "Updated via RestAssured"
				}""";

		Response response = given().pathParam("tableName", "change_request").pathParam("sys_id", Sys_ID)
				.contentType(ContentType.JSON).body(requestPayload).put("{tableName}/{sys_id}");

		System.out.println("PUT Status code is " + response.getStatusCode());
		response.prettyPrint();

		response.then().assertThat().statusCode(200).statusLine(Matchers.containsString("OK"));
	}

	@Test(priority = 3)
	public static void deleteChangeRequest() {

		baseURI = "https://dev274767.service-now.com/";
		basePath = "api/now/table/";
		authentication = basic("admin", "yC8=NAigk0@K");

		Response response = given().pathParam("tableName", "change_request").pathParam("sys_id", Sys_ID)
				.delete("{tableName}/{sys_id}");

		System.out.println("DELETE Status code is " + response.getStatusCode());
		response.prettyPrint();

		response.then().assertThat().statusCode(204).statusLine(Matchers.containsString("No Content"));
	}

}
