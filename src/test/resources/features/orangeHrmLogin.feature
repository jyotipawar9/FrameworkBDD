
Feature: OrangeHrm Login functionality
  
    @Regression
  Scenario: Test the login functionality of orangeHrm
    Given user opens thr "Edge" browser and OrangeHrm application using "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When user enters username as "Admin" and password as "admin123" 
    And user click on Login button
    Then user should navigate to home page having url as "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"
   
  