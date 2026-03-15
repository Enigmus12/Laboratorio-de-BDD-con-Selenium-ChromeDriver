@addremove
Feature: Add and Remove Elements

  Scenario: Add and remove elements
    Given the user is on the add remove elements page
    When the user adds 3 elements
    Then the user should see 3 delete buttons
    When the user removes 1 element
    Then the user should see 2 delete buttons
