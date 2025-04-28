Feature: Login functionality

  Scenario: Verify that the login URL loads properly
    When User navigates to url the login page should be loaded properly

  Scenario: Verify user can successfully log in with valid credentials
    When The user enters Valid username and password then user should be redirected to the dashboard page

  Scenario Outline: Verify user should not able to login with valid credentials
    When The user enters InValid "<username>" and "<password>" then user should NOT able to login.

    Examples: 
      | username     | password        |
      | Admin1222    | admin123        |
      | Admin        | Testing         |
      | AdminTesting | passwordTesting |

  Scenario: Verify user should not able to login with NULL username and password
    When The user enters "null" username and "null" password then user should NOT able to login.

  @today
  Scenario: Verify user should not able to login with valid credentials
    When The user enters Invalid credentials then user should NOT able to login
      | username | password |
      | user1    | pass123  |
      | user2    | pass456  |
      | user3    | pass789  |
