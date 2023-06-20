Feature: Order product  Background:    Given I open the home page  Scenario: Pre-data Register an account successfully    When I click on "Register" link    When I input information to register an account as below      | Gender | First name | Last name | Day | Month | Year | Email                 | Company Name | Password | Confirm password |      | Male   | Nam        | Hoang     | 6   | July  | 1990 | namhoang567@gmail.com | Microsoft    | Abc!23   | Abc!23           |    Then I click on "Register" button  Scenario: TC_01 Add product to Cart    When I click on "Login" link    And I input information to login as below      | Email                 | Password |      | namhoang567@gmail.com | Abc!23   |    Then I click on "Login" button    And I select "Desktops" of "Computers" option tab    And I select product name "Digital Storm VANQUISH 3 Custom Performance PC"    Then I add product to cart    Then I should see success message is displayed "The product has been added to your shopping cart"    When I click on "Shopping cart" link    Then I should see products is added to shopping cart as list below      | SKU       | Product(s)                                     | Price     | Qty. | Total     |      | DS_VA3_PC | Digital Storm VANQUISH 3 Custom Performance PC | $1,259.00 | 1    | $1,259.00 |    Then I verify the total price as below      | Sub-Total | Total     |      | $1,259.00 | $1,259.00 |  Scenario: TC_02 Edit product in Shopping Cart    When I click on "Login" link    And I input information to login as below      | Email                 | Password |      | namhoang567@gmail.com | Abc!23   |    Then I click on "Login" button    When I click on "Shopping cart" link    And I Edit Product "Digital Storm VANQUISH 3 Custom Performance PC" quantity is "2"    And I click "Update shopping cart" at Shopping cart    Then I should see products is added to shopping cart as list below      | SKU       | Product(s)                                     | Price     | Qty. | Total     |      | DS_VA3_PC | Digital Storm VANQUISH 3 Custom Performance PC | $1,259.00 | 2    | $2,518.00 |    Then I verify the total price as below      | Sub-Total | Total     |      | $2,518.00 | $2,518.00 |  Scenario: TC_03 Remove from Cart    When I click on "Login" link    And I input information to login as below      | Email                 | Password |      | namhoang567@gmail.com | Abc!23   |    Then I click on "Login" button    When I click on "Shopping cart" link    And I select product below to "REMOVE"      | Digital Storm VANQUISH 3 Custom Performance PC |    Then I should see the message "Your Shopping Cart is empty!" is displayed    And I should see the products is removed from "Shopping Cart page"      | Digital Storm VANQUISH 3 Custom Performance PC |  Scenario: TC_04 Checkout/Order ( Payment method by Cheque )    When I click on "Login" link    And I input information to login as below      | Email                 | Password |      | namhoang567@gmail.com | Abc!23   |    Then I click on "Login" button    And I select "Notebooks" of "Computers" option tab    And I select product name "Apple MacBook Pro 13-inch"    Then I add product to cart    Then I should see success message is displayed "The product has been added to your shopping cart"    When I click on "Shopping cart" link    And I click on checkout agree with the terms of service    And I click "Checkout" at Shopping cart    Then I input information at Checkout page as below      | Country  | State / province | City   | Address 1      | Zip / postal code | Phone number | Fax number |      | Viet Nam | Other            | Ha noi | Hoan kiem lake | 550000            | 0123456789   | 987654321  |    Then I click Continue button at step "1-Billing address"    And I select "Shipping method" is "Next Day Air"    Then I click Continue button at step "3-Shipping method"    And I select "Payment method" is "Check / Money Order"    Then I click Continue button at step "4-Payment method"    Then I verify payment information    Then I click Continue button at step "5-Payment information"    And I verify information of "Billing Address" displayed as below      | Name      | Email                 | Phone      | Fax       | Company   | Address1       | City          | Country  | Payment             |      | Nam Hoang | namhoang567@gmail.com | 0123456789 | 987654321 | Microsoft | Hoan kiem lake | Ha noi,550000 | Viet Nam | Check / Money Order |    And I verify information of "Shipping Address" displayed as below      | Name      | Email                 | Phone      | Fax       | Company   | Address1       | City          | Country  | Shipping     |      | Nam Hoang | namhoang567@gmail.com | 0123456789 | 987654321 | Microsoft | Hoan kiem lake | Ha noi,550000 | Viet Nam | Next Day Air |    Then I should see the list product display to check out as below      | SKU       | Product(s)                | Price     | Qty. | Total     |      | AP_MBP_13 | Apple MacBook Pro 13-inch | $1,800.00 | 2    | $3,600.00 |    Then I verify the total price as below      | Sub-Total | Total     |      | $3,600.00 | $3,600.00 |    Then I click Continue button at step "6-Confirm order"    Then I should see success message order complete is displayed "Your order has been successfully processed!"