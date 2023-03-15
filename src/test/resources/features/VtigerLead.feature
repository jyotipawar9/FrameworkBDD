
Feature: Test the create lead and delete created lead functinality
  I want to use this template for my feature file

  Background:
  	Given user is on Vtiger login page
  	And user login using valid credentials
  	And user navigates to lead page
  	
     @Regression
  Scenario Outline: Create new lead with name as "<firstname>"
    When user click on the add leads button
    And user enters firstname as "<firstname>" and lastname as "<lastname>" and click on the save button
    Then verify lead is created with "<firstname>"
   
   
   Examples: 
      | firstname | lastname |
      | Smith     | Lee      |
      | Jeff      | Mike     |
      @Regression
   Scenario: Delete all the created leads  
    When user click on the select all leads checkbox
    And user click on the delete button
    Then a delete confirmation pop up will appear
    When user click on Yes to confirm the deletion
    Then verify that all the leads are deleted

    
