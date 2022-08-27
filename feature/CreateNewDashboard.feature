Feature: Create a new dashboard using salesforce application

Background: Positive Login
Given Type the username as "ramkumar.ramaiah@testleaf.com"
And Type the password as "Password#123"
When Click on the login button
Then Verify the Home Page is displayed

Scenario Outline: Create a new dashboard and verify the dashboard name
Given Click on toggle menu button from the left corner
And Click view All
And Click Dashboards from App Launcher
And Click on the New Dashboard option
And In New Dashboard enter Name as <opportunityName>
And In dashboard page Click on Create
When Click on Save button in dashboard
Then Verify dashboard name


Examples:
|opportunityName|
|Salesforce Automation by Revathi|