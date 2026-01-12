@cart
Feature: Shopping cart

  @smoke
  Scenario: Add a product to cart and verify total
    Given the cart is empty
    When the user opens the product "Samsung galaxy s6"
    And adds the product to the cart
    Then an alert should be shown with message "Product added"
    When the user opens the cart page
    Then the cart should contain product "Samsung galaxy s6"
    And the cart total should be 360