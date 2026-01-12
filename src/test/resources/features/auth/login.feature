@auth
Feature: Login

  @smoke
  Scenario: Successful login shows welcome message
    Given the user is on the home page
    When the user opens the login modal
    And logs in with username "qa_auto_user_01" and password "qa_auto_pass_01"
    Then the welcome message should contain "qa_auto_user_01"

  @negative
  Scenario: Login fails with wrong password
    Given the user is on the home page
    When the user opens the login modal
    And logs in with username "qa_auto_user_01" and password "wrong_pass"
    Then an alert should be shown with message "Wrong password."