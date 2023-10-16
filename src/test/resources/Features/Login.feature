Feature: Login on WebShop Application

  Background:
    Given User Navigates to Demo Website URL

  @DemoWebLogin
  Scenario: User Login to Website

    And User Validates Demo Website Title
    And User enters the username
    And User enters the password
    Then User clicks on the login button
    And  User should be logged in successfully