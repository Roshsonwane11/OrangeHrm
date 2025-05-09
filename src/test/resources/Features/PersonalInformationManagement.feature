Feature: Personal Information Management functionality

  Scenario: Verify successful navigation to PIM Module
    When The user is on the OrangeHRM login page
    And The user clicks on the "PIM" module in the menu
    Then The Employee Information page should be displayed

  @todays
  Scenario: Verify system should Add new employee with valid data
    When The user is on the OrangeHRM login page
    And The user clicks on the "PIM" module in the menu
    And the user clicks on "Add Employee"
    And the user enters first name "Roshani" middle name "Rajendra" & last name "Sonawane"
    And the user sets employee ID to "0397"
    #And the user uploads a valid profile picture "profile.jpg"
    And the user clicks the "Save" button
    Then the system should display the new employee in the Employee List
