@web
Feature: Cart Functionality

  @positive
  Scenario: Successfully adding a product to the Cart after login
    Given the user is on the Login page
    When the user enters a valid "ronaldo" and a valid "Password"
    And the user clicks the Login button
    Then the user should be logged in successfully
    And the user should see their "ronaldo" displayed on the page
    And I click on the "Phones" category
    When I click on the "Samsung galaxy s7" product
    And I click the "Add to cart" button
    And I should see a confirmation message saying "Product added"
    Then the product should be added to my cart

  @positive
  Scenario: Successfully adding a product to the Cart after login and validate price
    Given the user is on the Login page
    When the user enters a valid "ronaldo" and a valid "Password"
    And the user clicks the Login button
    Then the user should be logged in successfully
    And the user should see their "ronaldo" displayed on the page
    And I click on the "Phones" category
    When I click on the "Samsung galaxy s7" product
    And I click the "Add to cart" button
    And I should see a confirmation message saying "Product added"
    Then the product should be added to my cart
    And The total price should be calculated correctly

  @positive
  Scenario: User successfully places an order from the cart
    Given User is on the Cart page
    When User clicks on the Place Order button
    And I fill in the order form with my details
      | Name        | John Doe         |
      | Country     | Indonesia        |
      | City        | Jakarta          |
      | Credit card | 1234567890123456 |
      | Month       | August           |
      | Year        | 2024             |
    And User clicks on the "Purchase" button
    Then a confirmation message should be displayed with the order ID
    And the cart should be empty
