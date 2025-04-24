Feature: Login functionality

  @today 
 Scenario: Verify that the login URL loads properly
    When User navigates to url the login page should be loaded properly
    
  @today 
 Scenario: Verify user can successfully log in with valid credentials
    When User navigates to url the login page should be loaded properly
    Then The user enters Valid username and password then user should be redirected to the dashboard page
   
    