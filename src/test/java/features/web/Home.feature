@web
Feature: Home Page Product Navigation

  As a user
  I want to navigate to the product details page
  So that I can view more information about a product

  @positive
  Scenario Outline: Successfully navigating to a product details page
    Given I am on the DemoBlaze homepage
    When I click on a product titled "<productTitle>"
    Then I should be redirected to the product details page for "<productTitle>"
    And I should see the product's price
    And I should see the product's description

    Examples:
      | productTitle      |
      | Nexus 6           |
      | Samsung galaxy s6 |
      | Samsung galaxy s7 |
      | Nokia lumia 1520  |


  @positive
  Scenario Outline: Browsing products in the "Laptops" category
    Given I am on the DemoBlaze homepage
    When I click on the "<CATEGORIES>" category
    Then I should see a list of category
    And each laptop should have a name, price, and description

    Examples:
      | CATEGORIES |
      | Laptops    |
      | Monitors   |
      | Phones     |

  @negative
  Scenario: Adding a product to the cart from the homepage
  Expected : I should see a message saying "Please log in to add products to your cart"
  Actual : I should see a confirmation message saying "Product added"
    Given I am on the DemoBlaze homepage
    When I click on the "Samsung galaxy s7" product
    And I click the "Add to cart" button
    And I should see a confirmation message saying "Product added"
    Then the product should be added to my cart
