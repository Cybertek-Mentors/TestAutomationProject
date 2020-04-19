@create_car
Feature: Create a car
  As user, I want to be able to add new cars

  Scenario: Add new car
    Given user is on the login page
    When user logs in as a sales manager
    Then user navigates to "Fleet" and "Vehicles"
    And user click on create a car button
    Then user creates a car with following info:
      | License Plate | Driver    | Location    | Model Year | Color |
      | SDET          | Pro Racer | Rome, Italy | 2020       | Red   |
    And user verifies that car info is displayed:
      | License Plate | Driver    | Location    | Model Year | Color |
      | SDET          | Pro Racer | Rome, Italy | 2020       | Red   |