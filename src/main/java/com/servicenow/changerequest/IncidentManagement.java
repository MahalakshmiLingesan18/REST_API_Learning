package com.servicenow.changerequest;

import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.basic;
import static io.restassured.RestAssured.given;

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
				"short_description": "Test Change Request",
				"description": "Created via RestAssured"
				 }""";

		Response response = given().pathParam("tableName", "change_request").contentType(ContentType.JSON)
				.body(requestPayload).post("{tableName}");

		System.out.println("POST status code is " + response.getStatusCode());

		Sys_ID = response.jsonPath().getString("result.sys_id");

		response.then().assertThat().statusCode(201).statusLine(Matchers.containsString("Created"));
		response.prettyPrint();

	}

	@Test(priority = 2)
	public static void updateChangeRequest() {

		baseURI = "https://dev274767.service-now.com/";
		basePath = "api/now/table/";
		authentication = basic("admin", "yC8=NAigk0@K");

		String requestPayload = """
				{
				"short_description": "Updated via RestAssured",
				"description": "Success"
				 }""";

		Response response = given().pathParam("tableName", "change_request").pathParam("sys_id", Sys_ID)
				.contentType(ContentType.JSON).body(requestPayload).put("{tableName}/{sys_id}");

		System.out.println("PUT status code is " + response.getStatusCode());

		response.then().assertThat().statusCode(200).statusLine(Matchers.containsString("OK"));
		response.prettyPrint();

	}

	@Test(priority = 3)
	public static void deleteChangeRequest() {

		baseURI = "https://dev274767.service-now.com/";
		basePath = "api/now/table/";
		authentication = basic("admin", "yC8=NAigk0@K");

		Response response = given().pathParam("tableName", "change_request").pathParam("sys_id", Sys_ID)
				.delete("{tableName}/{sys_id}");

		System.out.println("DELETE status code is " + response.getStatusCode());

		response.then().assertThat().statusCode(204).statusLine(Matchers.containsString("No Content"));
		response.prettyPrint();

	}

}
