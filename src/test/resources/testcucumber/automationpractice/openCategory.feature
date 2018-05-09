@at
Feature: Open category on site automationpractice
    
Scenario: Open category
    Given I am on the Automationpractice Main page
    When I focus on Women category
    And I click T-shirts link
    Then I see T-shirts page