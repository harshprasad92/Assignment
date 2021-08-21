#Author: Harsh Prasad
@Regression
Feature: As a user, I want to add a new pet for an existing owner.

  Background:
    Given User is on pet-clinic home page "http://localhost:8080/"
    And User navigates to "FIND OWNERS" page
    And Search owner details with last name "McTavish"

  Scenario: Verify that user is able to add pet to the owner
    When User click on 'Add New Pet'
    And Add details for the pet and save
    Then User should the pet listed for the owner