Feature: Create a new opportunity using salesforce application

Background: Positive Login
Given Type the username as "ramkumar.ramaiah@testleaf.com"
And Type the password as "Password#123"
When Click on the login button
Then Verify the Home Page is displayed

Scenario Outline: Create a new opportunity and verify the opportunity name
Given Click on toggle menu button from the left corner
And Click view All
And Click Sales from App Launcher
And Click on Opportunity tab
And Click on New button
And Enter Opportunity name as <opportunityName>
And Choose close date as Today
And Select Stage as Need Analysis
When Click on Save button
Then VerifyOpportunity Name displayed is <opportunityName>

Examples:
|opportunityName|
|Salesforce Automation by Revathi|