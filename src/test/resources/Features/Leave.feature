Feature: Verify Leave functionality

  Scenario: Verify when user click on "Leave" menu, should navigate to Leave page with default tab selected as "Leave List".
    When User Logged in successfully
    And User click on "Leave" menu
    Then User should navigate to "Leave" page with default tab selected as "Leave List"

  Scenario: Verify that From Date and To Date should have format "yyyy-dd-mm".
    When User Logged in successfully
    And User click on "Leave" menu
    And User select "2025-02-01" as From Date from the calendar
    And User select "2025-09-05" as To Date from the calendar
    Then "yyyy-dd-mm" format should be shown on both places.

  @todays1
  Scenario: Verify when user click on "Leave" menu, if not having any records then should show toast message as "No Records found" else should not show any message.
    When User Logged in successfully
    And User click on "Leave" menu
    Then if not having any leave records then should show toast message as "No Records Found" else should not show any message.
