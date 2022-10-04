Feature: Cart

  Scenario: Add items to the cart
    Given User navigates to the shopping page
    When User add items to the cart
    Then Cart should be filled with the added items
    And User quits the browser