Feature: Working on Twitter API's
  Scenario: Post a tweet
#    Given I am authenticated as user
    When  I post a tweet
    Then  Response status is 200
