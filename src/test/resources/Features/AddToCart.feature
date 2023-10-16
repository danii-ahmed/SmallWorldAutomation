Feature: Add product to cart of Demo website

  Background:
    Given User logged in Demo website

  @DemoAddProduct
  Scenario: Successfully Add a product to the cart

    When User clicks on add to cart button
    And Selected product is added to the cart successfully
    And User clicks on Cart
    Then Added Item should be shown in the cart