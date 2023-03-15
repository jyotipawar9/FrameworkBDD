Feature: It contains Tcs related to Actitime task Creation functinality
  @Smoke @Regression
  Scenario Outline: Creat new task "<Flow>" on "<Server>"
    Given user is on actitime login page for task creation
    And user has enters username as "<userName>" and password as "<pwd>"
    And user click on login button
    When click on the task tab
    And click on add new task button
    And select new task option
    And select project from project dropdown
    And enter the task name as "<taskName>"
    And click on the create task button
    Then User should be able to see the created task

 

    Examples: 
      | Flow     | Server | userName  | pwd       | taskName  |
      | positive |  QA    | admin     |   manager | Testing   |
      | nagative |  QA    | admin     | test@123  | Delopment |
      |positive  |staging | trainee   | trainee   | Desingning|
