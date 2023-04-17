@Regression
Feature: Desktop Checkout for Guest User
  As a customer
  I want to be able proceed to checkout
  So that I can specify my delivery and payment details and place the order


  Scenario: Proceed to checkout, final review and place order as guest user
    Given I am an anonymous customer with clear cookies
    And I open the "https://www.bookdepository.com/"
    And I search for "Stranger things"
    And I am redirected to a "Search results"
    And Search results contain the following products
      | Stranger Things: Suspicious Minds               |
      | Stranger Things: Rebel Robin                    |
      | Stranger Things: The Other Side (graphic Novel) |
    And I apply the following search filters
      | Price range  | 30 € +           |
      | Availability | Pre-order (20)   |
      | Language     | English (1,025)  |
      | Format       | Hardback (203)   |
    And Search results contain only the following products
      | Stranger Things: The Ultimate Pop-Up Book                                    |
      | Stranger Things: The Ultimate Pop-Up Book                                    |
      | Stranger Things: Shadows Over Hawkins--A Comics Cover Gallery                |
      | Stranger Things Psychology                                                   |
      | Fluxus as a Network of Friends, Strangers, and Things                        |
    When I click 'Pre-order' button for product with name "Stranger Things Psychology"
    And I select Basket Checkout in basket pop-up
    Then I am redirected to the "Basket page"
    And Basket order summary is as following:
      | Delivery cost | Total   |
      | FREE          | 28,63 €|
    When I click 'Checkout' button on 'Basket' page
    Then I am redirected to the "Checkout" page
    When I click 'Buy now' button
    Then the following validation error messages are displayed on 'Delivery Address' form:
      | Form field name | validation error message                              |
      | Email address   | Please enter your Email address                       |
      | Full name       | Please enter your Full name                           |
      | Address line 1  | Please enter your Address line 1                      |
      | Town/City       | Please enter your Town/City                           |
      | Postcode/ZIP    | Please enter your postcode/ZIP or write 'No Postcode' |
    And the following validation error messages are displayed on 'Payment' form:
      | Please enter your card number, Please enter your card's expiration date, Please enter your CVV |
    And Checkout order summary is as following:
      | Sub-total | Delivery | VAT    | Total   |
      | 28,63 €  | FREE      | 0,00 € | 28,63 € |
    And I checkout as a new customer with email "test@user.com"
    When I fill delivery address information manually:
      | Full name | Delivery country | Address line 1   | Address line 2   | Town/City | County/State | Postcode |
      | John      | Canada           | Random address 1 | Random address 2 | Kyiv      | Random State | 12345    |
    Then there is no validation error messages displayed on 'Delivery Address' form
    When I enter my card details
      | Card Type    | Visa             |
      | Name On Card | RandomName       |
      | cardNumber   | 4111111111111111 |
      | Expiry Year  | 2022             |
      | Expiry Month | 03               |
      | Cvv          | 123              |