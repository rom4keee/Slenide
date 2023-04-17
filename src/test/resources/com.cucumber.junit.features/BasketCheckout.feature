Feature: Basket Checkout for Guest User
  As a customer
  I want to be able proceed to checkout
  So that I can check Order Subtotal and Order Total

  @checkout
  Scenario: Proceed to checkout, final review as guest user
    Given the user opens Book Depository website
    When the user enters flowers for algernon into the search input
    And the user clicks on Search button
    Then Search results page with URL https://www.bookdepository.com/search?searchTerm=flowers+for+algernon&search=Find+book is displayed
    When the user clicks Add to basket button for product with name Flowers for Algernon
    And the user clicks on Basket-Checkout button in basket pop-up
    Then Basket page opens with correct values
      |field   |value |
      |Total   |9,29 €|
      |Subtotal|9,29 €|
    When the user clicks Checkout button on Basket page
    And Checkout page opens with correct values
      |field   |value |
      |Total   |9,29 €|
      |Subtotal|9,29 €|
    And the user set test@user.com as e-mail address
