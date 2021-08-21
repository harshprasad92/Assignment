#Author: Harsh Prasad
@Regression
Feature: As a user, I want to update an existing owner

  Background:
    Given User is on pet-clinic home page "http://localhost:8080/"
    And User navigates to "FIND OWNERS" page

  Scenario: Verify user is able to search owner
    And Search owner details with last name "Franklin"
    Then User should see owner details for "Franklin"
    When User navigates to Edit Owner
    Then User should be able to edit detail and save the owner
