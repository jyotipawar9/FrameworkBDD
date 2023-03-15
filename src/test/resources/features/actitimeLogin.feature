
Feature: Actitime Login functionality
  

  @Smoke 
  Scenario: Test the login functionality with Admin credentials
    Given Browser is opened and user is on actitime login page
    When User enters the username and password
    And User click on login button
    Then User will be navigated to home page
    

  