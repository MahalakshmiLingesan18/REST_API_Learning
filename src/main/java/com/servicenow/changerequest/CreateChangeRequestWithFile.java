package com.servicenow.changerequest;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateChangeRequestWithFile {

	@Test
	public static void createChangeRequest() {

		File requestBody = new File("src/main/resources/TestData/changeRequestBody.json");

		baseURI = "https://dev274767.service-now.com/";
		basePath = "api/now/table/";
		authentication = basic("admin", "yC8=NAigk0@K");

		Response response = given().pathParam("tableName", "change_request").contentType(ContentType.JSON)
				.body(requestBody).post("{tableName}");

		System.out.println("POST status code is " + response.getStatusCode());
		response.prettyPrint();

		response.then().assertThat().statusCode(201).statusLine(Matchers.containsString("Created"));
	}

}
