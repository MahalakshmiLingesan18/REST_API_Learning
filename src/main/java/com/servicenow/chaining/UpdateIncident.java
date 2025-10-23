package com.servicenow.chaining;

import static io.restassured.RestAssured.*;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.servicenow.pojo.ChangeRequestBody;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateIncident extends BaseClass {
	
	ChangeRequestBody changeRequest;

	@BeforeClass
	public void requestUploadPayload() {

		changeRequest = new ChangeRequestBody();

	}

	@Test
	public void update() {

		changeRequest.setDescription("Updating an incident");

		Response response = given().pathParam("tableName", "incident").pathParam("sysID", sys_id).accept(ContentType.JSON)
				.contentType(ContentType.JSON).body(changeRequest).put("{tableName}/{sysID}");

		response.then().assertThat().statusCode(200).statusLine(Matchers.containsString("OK"))
				.time(Matchers.lessThan(5000L)).body("result", Matchers.hasKey("description"))
				.body("result.description", Matchers.equalTo(changeRequest.getDescription()));
		
		System.out.println("Response: ");
		response.prettyPrint();

	}

}
