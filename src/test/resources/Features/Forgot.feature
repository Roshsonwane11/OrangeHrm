Feature: Forgot functionality

Scenario: To Verify Forgot Passwoard
Given user in login page and verify "Forgot your password?" is Displayed

Scenario: To verify Forgot Button Clickable
When User Click on Forgot Button
Then User Should redirect to Reset password page
