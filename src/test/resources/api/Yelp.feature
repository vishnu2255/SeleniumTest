Feature: Working on Yelp API's

  Scenario: Search a phone number
    Given I am authenticated as user
    When  I search for a phone number
    Then  Response status is 200

  Scenario: Post a user
    Given I send details
    Then Response status is 201

   Scenario: Transform Example
     Given I give details

