package com.stepdefinition;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ServiceNowSteps {
	
	RequestSpecBuilder preConditions = new RequestSpecBuilder();
	Response response;
	
	@Given("User should set the base uri as {string} in the api client")
	public void user_should_set_the_base_uri_as_in_the_api_client(String baseUri) {
		preConditions.setBaseUri(baseUri);
	}

	@And("User should set the base path as {string} of the service now table api")
	public void user_should_set_the_base_path_as_of_the_service_now_table_api(String basePath) {
		preConditions.setBasePath(basePath);
	}

	@And("User should set the basic authentication with {string} and {string}")
	public void user_should_set_the_basic_authentication_with_and(String username, String password) {
		preConditions.setAuth(basic(username, password));
	}

	@And("User should filter the active change requests using query Params as {string} and limit that to {int}")
	public void user_should_filter_the_active_change_requests_using_query_params_as(String queryParam, Integer limit) {
		preConditions.addQueryParam("sysparm_query", queryParam).addQueryParam("sysparm_limit", 3);
	}

	@When("User hits the Get request of the {string} table")
	public void user_hits_the_get_request_of_the_table(String endPoint) {
		response = given().spec(preConditions.build()).accept(ContentType.JSON).get(endPoint);
		response.prettyPrint();
	}

	@Then("User should able to see the success response and with relevant {string} and {string}")
	public void user_should_able_to_see_the_success_response_and_with_relevant_and(String statusCode, String statusLine) {
	    response.then().assertThat().statusCode(Integer.parseInt(statusCode)).statusLine(Matchers.containsString(statusLine));
	}

}
