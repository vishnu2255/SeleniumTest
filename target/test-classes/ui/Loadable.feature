Feature: Loadable component test

  Background: I am on Main page
    Given I am on home page

  Scenario: Login with valid creds
    Given I am on login page
    When I give valid username and password
