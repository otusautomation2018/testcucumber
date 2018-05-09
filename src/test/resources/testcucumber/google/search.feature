@google
Feature: google

    Scenario: Finding some cars
        Given I am on the Google search page
        When I search for "Cars"
        Then The page title contains "Cars"
