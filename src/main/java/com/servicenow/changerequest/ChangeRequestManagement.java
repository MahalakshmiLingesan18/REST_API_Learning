package com.servicenow.changerequest;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ChangeRequestManagement {

	public static void createChangeRequest() {

		String changeRequestPayload = """
				            {
				"short_description": "Test Change Request",
				"description": "Created via RestAssured"
				}""";

		// Sending POST request to create change request
		Response response = given().contentType(ContentType.JSON).body(changeRequestPayload)
				.post("api/now/table/change_request");

		// Print response to console
		System.out.println("Create Change Request Response: ");
		response.prettyPrint();

	}

	public static void main(String[] args) {

		// Base URI and authentication setup
		baseURI = "https://dev274767.service-now.com/";
		authentication = basic("admin", "yC8=NAigk0@K");

		// Call POST request method
		createChangeRequest();

	}

}
