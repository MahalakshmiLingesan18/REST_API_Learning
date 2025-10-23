package com.stepdefinition;

import org.hamcrest.Matchers;
import static io.restassured.RestAssured.*;

import java.io.File;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class JiraSteps {

	RequestSpecBuilder preConditions = new RequestSpecBuilder();
	Response response;
	String id;

	@Given("User should set the base uri as {string}")
	public void user_should_set_the_base_uri_as(String baseURI) {
		preConditions.setBaseUri(baseURI);
	}

	@And("User should set the base path as {string}")
	public void user_should_set_the_base_path_as(String basePATH) {
		preConditions.setBasePath(basePATH);
	}

	@And("User should set the basic authentication with Username as {string} and API token as {string}")
	public void user_should_set_the_basic_authentication_with_username_as_and_api_token_as(String userName, String apiToken) {
		preConditions.setAuth(preemptive().basic(userName, apiToken));
	}
	
	@When("User hits the POST request with request body")
	public void user_hits_the_post_request_with_request_body() {
		File requestBody = new File("src/test/resources/RequestPayload/issue.json");
		response = given().spec(preConditions.build()).log().all().contentType(ContentType.JSON).body(requestBody).post();
	}

	@Then("User should able to retrieve the {string} for the issue and see the relevant {string} and {string}")
	public void user_should_able_to_retrieve_the_for_the_issue_and_see_the_relevant_and(String id, String statusCODE, String statusMessage) {
		System.out.println("Create response => " + response.asPrettyString());
		id = response.jsonPath().getString("id");
		System.out.println("ID: " +id);
		this.id = id;
		response.then().assertThat().statusCode(Integer.parseInt(statusCODE))
				.statusLine(Matchers.containsString(statusMessage));
	}
	
	@And("User should attach files to the issue")
	public void user_should_attach_files_to_the_issue() {
		preConditions.addPathParam("issueId", id);
	}
	
	@When("User hits the POST request to add files to {string} field")
	public void user_hits_the_post_request_to_add_files_to_field(String endpoint) {
		response = given().spec(preConditions.build()).log().all().header("X-Atlassian-Token", "no-check")
				.multiPart("file", new File("src/test/resources/Attachments/CSV_Data.csv"))
	            .multiPart("file", new File("src/test/resources/Attachments/CSV_Data - Copy.csv"))
	            .post(endpoint);
	}

	@Then("User should able to see the relevant {string} and {string}")
	public void user_should_able_to_see_the_relevant_and(String statusCODE, String statusMessage) {
		response.then().assertThat().statusCode(Integer.parseInt(statusCODE))
		.statusLine(Matchers.containsString(statusMessage));
	}

}
