#Author: Harsh Prasad
@Regression
Feature: As a user, I want to add a new owner

  Background: 
    Given User is on pet-clinic home page "http://localhost:8080/"
    When User navigates to "FIND OWNERS" page

  Scenario: Verify that user is able to add owner with valid data
    And User click on 'Add Owner'
    And Add owner details
    Then Owner details should be displayed

  Scenario: Verify that user is unable to add owner with incomplete data
    And User click on 'Add Owner'
    And Add owner first name and submit
    Then User should get error message for each field
