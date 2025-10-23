Feature: Get all change requests

Scenario Outline: Retrieve active change requests
Given User should set the base uri as "https://dev274767.service-now.com/" in the api client
And User should set the base path as "api/now/table/" of the service now table api
And User should set the basic authentication with "<Username>" and "<Password>"
And User should filter the active change requests using query Params as "active=true" and limit that to 3
When User hits the Get request of the "change_request" table
Then User should able to see the success response and with relevant "<StatusCode>" and "<StatusLine>" 

Examples:
|Username | Password| StatusCode| StatusLine|
|admin | yC8=NAigk0@K| 200| OK|