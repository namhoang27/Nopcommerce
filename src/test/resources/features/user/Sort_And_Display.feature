Feature: Sort product and display paging

  Background:
    Given I open the home page

  Scenario: Pre-data Register an account successfully
    When I click on "Register" link
    When I input information to register an account as below
      | Gender | First name | Last name | Day | Month | Year | Email                 | Company Name | Password | Confirm password |
      | Male   | Nam        | Hoang     | 6   | July  | 1990 | namhoang345@gmail.com | Microsoft    | Abc!23   | Abc!23           |
    Then I click on "Register" button


  Scenario: TC_01 Sort with Name: A to Z
    When I click on "Login" link
    And I input information to login as below
      | Email                 | Password |
      | namhoang345@gmail.com | Abc!23   |
    Then I click on "Login" button
    And I select "Notebooks" of "Computers" option tab
    And I select option "Name: A to Z" of "Sort by" dropdown list
    Then I should see list product displays as below
      | Product Name                                | Price     |
      | Apple MacBook Pro 13-inch                   | $1,800.00 |
      | Asus N551JK-XO076H Laptop                   | $1,500.00 |
      | HP Envy 6-1180ca 15.6-Inch Sleekbook        | $1,460.00 |
      | HP Spectre XT Pro UltraBook                 | $1,350.00 |
      | Lenovo Thinkpad X1 Carbon Laptop            | $1,360.00 |
      | Samsung Series 9 NP900X4C Premium Ultrabook | $1,590.00 |

  Scenario: TC_02 Sort with Name: Z to A
    When I click on "Login" link
    And I input information to login as below
      | Email                 | Password |
      | namhoang345@gmail.com | Abc!23   |
    Then I click on "Login" button
    And I select "Notebooks" of "Computers" option tab
    And I select option "Name: Z to A" of "Sort by" dropdown list
    Then I should see list product displays as below
      | Product Name                                | Price     |
      | Samsung Series 9 NP900X4C Premium Ultrabook | $1,590.00 |
      | Lenovo Thinkpad X1 Carbon Laptop            | $1,360.00 |
      | HP Spectre XT Pro UltraBook                 | $1,350.00 |
      | HP Envy 6-1180ca 15.6-Inch Sleekbook        | $1,460.00 |
      | Asus N551JK-XO076H Laptop                   | $1,500.00 |
      | Apple MacBook Pro 13-inch                   | $1,800.00 |

  Scenario: TC_03 Sort with Price: Low to High
    When I click on "Login" link
    And I input information to login as below
      | Email                 | Password |
      | namhoang345@gmail.com | Abc!23   |
    Then I click on "Login" button
    And I select "Notebooks" of "Computers" option tab
    And I select option "Price: Low to High" of "Sort by" dropdown list
    Then I should see list product displays as below
      | Product Name                                | Price     |
      | HP Spectre XT Pro UltraBook                 | $1,350.00 |
      | Lenovo Thinkpad X1 Carbon Laptop            | $1,360.00 |
      | HP Envy 6-1180ca 15.6-Inch Sleekbook        | $1,460.00 |
      | Asus N551JK-XO076H Laptop                   | $1,500.00 |
      | Samsung Series 9 NP900X4C Premium Ultrabook | $1,590.00 |
      | Apple MacBook Pro 13-inch                   | $1,800.00 |

  Scenario: TC_04 Sort with Price: High to Low
    When I click on "Login" link
    And I input information to login as below
      | Email                 | Password |
      | namhoang345@gmail.com | Abc!23   |
    Then I click on "Login" button
    And I select "Notebooks" of "Computers" option tab
    And I select option "Price: High to Low" of "Sort by" dropdown list
    Then I should see list product displays as below
      | Product Name                                | Price     |
      | Apple MacBook Pro 13-inch                   | $1,800.00 |
      | Samsung Series 9 NP900X4C Premium Ultrabook | $1,590.00 |
      | Asus N551JK-XO076H Laptop                   | $1,500.00 |
      | HP Envy 6-1180ca 15.6-Inch Sleekbook        | $1,460.00 |
      | Lenovo Thinkpad X1 Carbon Laptop            | $1,360.00 |
      | HP Spectre XT Pro UltraBook                 | $1,350.00 |

  Scenario: TC_05 Display with 3 products per page
    When I click on "Login" link
    And I input information to login as below
      | Email                 | Password |
      | namhoang345@gmail.com | Abc!23   |
    Then I click on "Login" button
    And I select "Notebooks" of "Computers" option tab
    And I select option "3" of "Display" dropdown list
    Then I verify the products display per page is not bigger than 3
    And I verify the current page is "1" and display icon "next"
    When I select page "2"
    And I verify the current page is "2" and display icon "previous"
    When I select page "1"
    And I verify the current page is "1" and display icon "next"

