#Author: Harsh Prasad
@Regression
Feature: As a user, I want to add a visit to the veterinarian for my pet.
  As a user, I want to view my pets & visits details.

  Background:
    Given User is on pet-clinic home page "http://localhost:8080/"
    And User navigates to "FIND OWNERS" page
    And Search owner details with last name "McTavish"

  Scenario: Verify that is user able to add visit for the pet
    And User navigate to Add Visit for pet "George"
    When User add details for visit and save
    Then Visit details should be saved with description