package com.servicenow.chaining;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteIncident extends BaseClass {

	@Test(dependsOnMethods = { "com.servicenow.chaining.CreateNewIncident.create"})
	public void delete() {

		Response response = given().pathParam("tableName", "incident").pathParam("sysID", sys_id)
				.accept(ContentType.JSON).delete("{tableName}/{sysID}");

		response.then().assertThat().statusCode(204);
		
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 204 No Content", "Status line should be 'HTTP/1.1 204 No Content’");
		
		long responseTime = response.getTime();
		
		Assert.assertTrue(responseTime < 5000, "Response time should be less than 5000ms");
		
	}

}
