Feature: Orange HRM Login
  Scenario: Logo presence in Orange Hrm home page
    Given I launch chrome browser
    When I Open Orange Hrm home page
    Then I verify that the logo is present on page
    And I close the browser
