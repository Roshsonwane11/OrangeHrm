Feature: Personal Information Management functionality

  Scenario: Verify successful navigation to PIM Module
    When The user is on the OrangeHRM login page
    And The user clicks on the "PIM" module in the menu
    Then The Employee Information page should be displayed

  Scenario: Verify system should Add new employee with valid data
    When The user is on the OrangeHRM login page
    And The user clicks on the "PIM" module in the menu
    And the user clicks on "Add Employee"
    And the user enters first name "Roshani" middle name "Rajendra" & last name "Sonawane"
    And the user sets employee ID
    And the user uploads a valid profile picture "profile.jpg"
    And the user clicks the "Save" button
    Then the system should display the new employee in the Employee List

  Scenario: Verify system should not allow to add employee without first name and last name
    When The user is on the OrangeHRM login page
    And The user clicks on the "PIM" module in the menu
    And the user clicks on "Add Employee"
    And the user leaves first name and last name fields blank
    And the user clicks the "Save" button
    Then the system should display validation error messages for required fields

  Scenario: Verify system should not allow to add employee with more than 30 characters in First Name
    When The user is on the OrangeHRM login page
    And The user clicks on the "PIM" module in the menu
    And the user clicks on "Add Employee"
    When user enters more than 30 "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345" characters in First Name field
    Then the system should display error message Should not exceed 30 characters

  #Bug
  Scenario: Verify system should not allow special characters in employee name
    When The user is on the OrangeHRM login page
    And The user clicks on the "PIM" module in the menu
    And the user clicks on "Add Employee"
    And the user enters first name "@#Roshani!" middle name "Rajendra" & last name "@#sonawane"
    And the user clicks the "Save" button
    Then the system should display validation error for invalid characters


  Scenario: Verify system should not allow when user set invalid profile picture (too big)
    When The user is on the OrangeHRM login page
    And The user clicks on the "PIM" module in the menu
    And the user clicks on "Add Employee"
    Then The user uploads a profile picture larger than 1MB
    Then The system should display a validation error message
    
 @todays
  Scenario: Verify system should not allow when user set invalid profile picture (too big)
    When The user is on the OrangeHRM login page
    And The user clicks on the "PIM" module in the menu
    And the user clicks on "Add Employee"
    Then The user uploads a profile picture with unsupported file type .pdf
    Then The system should display a validation error message 
