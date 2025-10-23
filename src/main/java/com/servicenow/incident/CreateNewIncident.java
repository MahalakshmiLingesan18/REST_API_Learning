package com.servicenow.incident;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.servicenow.pojo.ChangeRequestBody;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateNewIncident {

	@Test
	public static void incident() {

		ChangeRequestBody requestBody = new ChangeRequestBody();

		requestBody.setShortDescription("RESTAPI");
		requestBody.setDescription("Learning POJO");

		baseURI = "https://dev274767.service-now.com/";
		basePath = "api/now/table/";
		authentication = basic("admin", "yC8=NAigk0@K");

		Response response = given().pathParam("tableName", "incident").contentType(ContentType.JSON).body(requestBody)
				.post("{tableName}");

		System.out.println("Status code: " +response.statusCode());
		System.out.println("Status: " +response.statusLine());
		response.then().assertThat().statusCode(201).statusLine(Matchers.containsString("Created"));
		System.out.println("Response: ");
		response.prettyPrint();

	}

}
