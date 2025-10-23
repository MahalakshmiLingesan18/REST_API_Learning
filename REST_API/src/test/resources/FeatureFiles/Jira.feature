Feature: Create Jira issue with multiple files

Scenario Outline: Create a Jira issue
Given User should set the base uri as "https://mahalakshmilingesan4.atlassian.net/"
And User should set the base path as "rest/api/3/issue"
And User should set the basic authentication with Username as "mahalakshmi.lingesan4@gmail.com" and API token as "ATATT3xFfGF0ord_xLsbNPU2SZA4XwtmqQtn1X5ZX1NPw67St4vrYeTqpe7sbzCRn2k_TPdnJH_djcz1N23-_6zQz1yyZDuBYp-OjUT8trb1ua2q7-Po65o1sgAUynPBLMhyyu35Ud9PvxUe2AevdaFLAuoTNQfd5GGXSAaHTy7fLzzeLRlw8Jw=0DE2D7A4" 
When User hits the POST request with request body
Then User should able to retrieve the "id" for the issue and see the relevant "<StatusCode>" and "<StatusLine>" 
And User should attach files to the issue
When User hits the POST request to add files to "/{issueId}/attachments" field
Then User should able to see the relevant "<AttachmentStatusCode>" and "<AttachmentStatusLine>"

Examples:
|StatusCode | StatusLine| AttachmentStatusCode| AttachmentStatusLine|
|201 | Created| 200| OK|