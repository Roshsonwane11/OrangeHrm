
Feature: Verify Leave functionality


Scenario: Verify when user click on "Leave" menu, should navigate to Leave page with default tab selected as "Leave List".
When User Logged in successfully
And User click on "Leave" menu
Then User should navigate to "Leave" page with default tab selected as "Leave List"

Scenario: 