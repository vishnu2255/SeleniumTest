Feature: Login Test

  Scenario: login with valid credentials
    Given I am on login page
    When I give valid username and password
    Then I should navigate to home page


  Scenario: Giving data
    Given I give multiple sets of data
      | name  | num | id  |
      | virat | 1   | ind |
      | smith | 2   | aus |
    Then print names


  Scenario Outline: Data Outline example
    Given I give <name> and <id> records
    Then print names

    Examples:
      | name  | id |
      | virat | 1  |
      | smith | 2  |