Feature: Orange HRM Login Test

  Background: launch Application
    Given I want launch Orange HRM Application

  @AITest1
  Scenario Outline: Validate Login Functionality
   # Given load test data from "<SheetName>" and "<TestCaseID>"
    When I enter "<username>" and "<password>"
  #  When I enter username and password
    When I Click on Login buttom
    When I Click on Logout button

    Examples: 
      | username | password|
      | Admin     | admin123      |

  @AITest1
  Scenario: Resuse Login
    When I enter username and password
    When I Click on Login buttom
    When I Click on Logout button
    