Feature: Forgot functionality

Scenario: To Verify Forgot Passwoard
Given user in login page and verify "Forgot your password?" is Displayed

Scenario: To verify Forgot Button Clickable
When User Click on Forgot Button
Then User Should redirect to Reset password page

Scenario: To verify Clicking on the cancel button
When User Click on Forgot Button
And User Click on cancle button 
Then User Should redirect to the Login Page

