#Author: Harsh Prasad
@Regression
Feature: As a user, I want to view the list of veterinarians.
  As a user, I should see a pet clinic logo image on home page below the welcome text.

  Background:
    Given User is on pet-clinic home page "http://localhost:8080/"

  Scenario: Verify user is able to see veterinarians list
    When User navigates to "Veterinarians" page
    Then User should see list of veterinarians
    |James Carter|Helen Leary|Linda Douglas|Rafael Ortega|Henry Stevens|Sharon Jenkins|

  Scenario: Verify user is able to see clinic logo
    When User navigates to "Home" page
    Then User should see pet clinic logo