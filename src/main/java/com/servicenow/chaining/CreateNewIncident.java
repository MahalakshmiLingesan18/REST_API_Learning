package com.servicenow.chaining;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import com.servicenow.pojo.CreateIncident;

public class CreateNewIncident extends BaseClass {

	CreateIncident createIncidentRequest;

	@BeforeClass
	public void requestCreatePayload() {

		createIncidentRequest = new CreateIncident();

	}

	@Test
	public void create() {

		createIncidentRequest.setShort_description("Learning RESTAPI");
		createIncidentRequest.setDescription("Creating a new incident");

		Response response = given().pathParam("tableName", "incident").accept(ContentType.JSON)
				.contentType(ContentType.JSON).body(createIncidentRequest).post("{tableName}");

		sys_id = response.jsonPath().getString("result.sys_id");

		System.out.println("Sys_ID: " + sys_id);

		response.then().assertThat().statusCode(201).statusLine(Matchers.containsString("Created"))
				.time(Matchers.lessThan(5000L)).body("result", Matchers.hasKey("short_description"))
				.body("result", Matchers.hasKey("description"));
		
		System.out.println("Response: ");
		response.prettyPrint();

	}

}
