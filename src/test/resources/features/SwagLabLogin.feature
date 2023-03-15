
Feature: It contains TCs related to SwagLab login functionality
# Background will be executed before each scenario in this feature file but after the '@before' hook. 
  Background: This background will be used to execute common pre-requisite step for all the scenarios and scenario outline defined in this feature file
    Given user is on SwagLab login page
    
      @Regression 
  Scenario: Test the SwagLab login functionality with different users using datatable as list
    
    When user enter username and password
      | standard_user   | secret_sauce |
      | locked_out_user | secret_sauce |
      
      
    And click on the login button
    Then user should logged in successfully for valid user
    
    
	@Regression
 Scenario: Test the SwagLab login functionality with different users using datatable as map
    When user enter username and password using datatable data
      | username        | password     |
      | standard_user   | secret_sauce |
      | locked_out_user | secret_sauce |
    And click on the login button
    Then user should logged in successfully for valid user