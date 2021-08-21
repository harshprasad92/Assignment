#Author: Harsh Prasad
@Regression
Feature: As a user, I want to search for an existing owner by his/her lastname.

  Background:
    Given User is on pet-clinic home page "http://localhost:8080/"
    And User navigates to "FIND OWNERS" page

  Scenario: Verify user is able to search owner
    And Search owner details with last name "McTavish"
    Then Owner details should be displayed

  Scenario: Verify user gets error message on invalid search of owner
    And Search owner details with last name "invalid name"
    Then User should see error message "has not been found"

  Scenario: Verify user gets all results when click on search without any name
    And Click on search without any name entered
    Then User should see all the records of owners
