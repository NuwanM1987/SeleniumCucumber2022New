Feature: Login
  @sanity
  Scenario: Successful login with Valid Username and Password
    Given User Launch Chrome Browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then Page title should be "Dashboard / nopCommerce administration"
    When User click on Logout Link
    Then Page title should be "Your store. Login"
    And Close the browser

@regression
  Scenario Outline: Login Data driven
    Given User Launch Chrome Browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "<email>" and Password as "<password>"
    And Click on Login
    Then Page title should be "Dashboard / nopCommerce administration"
    When User click on Logout Link
    Then Page title should be "Your store. Login"
    And Close the browser
    Examples:
      |email  |password|
      |admin@yourstore.com |admin |
      |admin1@yourstore.com |admin123 |


