Feature: Customers
  Background: Below are the common steps for following scenarios
    Given User Launch Chrome Browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then User can view Dashboard
  @sanity
  Scenario: Add a New Customer
    When User click on Customer menu
    And  click on customer's menu item
    And click on Add new
    Then user can view add new customer page
    When user enter customer infor
    And click on Save button
    Then user can view confirmation message "The new customer has been added successfully."
    And close browser
@regression
    Scenario: Search Customer By EmailID

      When User click on Customer menu
      And  click on customer's menu item
      And Enter Customer Email
      When Click on search button
     Then User should found email in User table
      And close browser
  @regression
  Scenario: Search Customer By Name

    When User click on Customer menu
    And  click on customer's menu item
    And Enter Customer First Name
    And Enter Customer Last Name
    When Click on search button
    Then User should found name  in User table
    And close browser



