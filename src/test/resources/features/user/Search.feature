Feature: Search product

  Background:
    Given I open the home page

  Scenario: Pre-data Register an account successfully
    When I click on "Register" link
    When I input information to register an account as below
      | Gender | First name | Last name | Day | Month | Year | Email                 | Company Name | Password | Confirm password |
      | Male   | Nam        | Hoang     | 6   | July  | 1990 | namhoang234@gmail.com | Microsoft    | Abc!23   | Abc!23           |
    Then I click on "Register" button


  Scenario: TC_01 Search with empty data
    When I click on "Login" link
    And I input information to login as below
      | Email                 | Password |
      | namhoang234@gmail.com | Abc!23   |
    Then I click on "Login" button
    And I click "Search" tab of "Customer service" footer option
    Then I search with information as below
      | Search keyword | Advanced search | Category | Search sub categories | Manufacturer | Product descriptions |
      |                | Unchecked       |          |                       |              |                      |
    And I click on "Search" button
    Then I verify the message will be displayed "Search term minimum length is 3 characters" with case "empty data"


  Scenario: TC_02 Search with data does not exist
    When I click on "Login" link
    And I input information to login as below
      | Email                 | Password |
      | namhoang234@gmail.com | Abc!23   |
    Then I click on "Login" button
    And I click "Search" tab of "Customer service" footer option
    Then I search with information as below
      | Search keyword   | Advanced search | Category | Search sub categories | Manufacturer | Product descriptions |
      | Macbook pro 2100 | Unchecked       |          |                       |              |                      |
    And I click on "Search" button
    Then I verify the message will be displayed "No products were found that matched your criteria." with case "data does not exist"

  Scenario: TC_03 Search with product name (relative)
    When I click on "Login" link
    And I input information to login as below
      | Email                 | Password |
      | namhoang234@gmail.com | Abc!23   |
    Then I click on "Login" button
    And I click "Search" tab of "Customer service" footer option
    Then I search with information as below
      | Search keyword | Advanced search | Category | Search sub categories | Manufacturer | Product descriptions |
      | Lenovo         | Unchecked       |          |                       |              |                      |
    And I click on "Search" button
    Then I verify the result return as below
      | Lenovo IdeaCentre 600 All-in-One PC |
      | Lenovo Thinkpad X1 Carbon Laptop    |


  Scenario: TC_04 Search with product name (absolute)
    When I click on "Login" link
    And I input information to login as below
      | Email                 | Password |
      | namhoang234@gmail.com | Abc!23   |
    Then I click on "Login" button
    And I click "Search" tab of "Customer service" footer option
    Then I search with information as below
      | Search keyword     | Advanced search | Category | Search sub categories | Manufacturer | Product descriptions |
      | Thinkpad X1 Carbon | Unchecked       |          |                       |              |                      |
    And I click on "Search" button
    Then I verify the result return as below
      | Lenovo Thinkpad X1 Carbon Laptop |


  Scenario: TC_05 Search with Advanced search is checked and Parent categories
    When I click on "Login" link
    And I input information to login as below
      | Email                 | Password |
      | namhoang234@gmail.com | Abc!23   |
    Then I click on "Login" button
    And I click "Search" tab of "Customer service" footer option
    Then I search with information as below
      | Search keyword    | Advanced search | Category  | Search sub categories | Manufacturer | Product descriptions |
      | Apple Macbook Pro | Checked         | Computers | Unchecked             | All          | Unchecked            |
    And I click on "Search" button
    Then I verify the message will be displayed "No products were found that matched your criteria." with case "data does not exist"


  Scenario: TC_06 Search with Advanced search is checked and Sub Categories
    When I click on "Login" link
    And I input information to login as below
      | Email                 | Password |
      | namhoang234@gmail.com | Abc!23   |
    Then I click on "Login" button
    And I click "Search" tab of "Customer service" footer option
    Then I search with information as below
      | Search keyword    | Advanced search | Category  | Search sub categories | Manufacturer | Product descriptions |
      | Apple Macbook Pro | Checked         | Computers | Checked               | All          | Unchecked            |
    And I click on "Search" button
    Then I verify the result return as below
      | Apple MacBook Pro 13-inch |

  Scenario: TC_07 Search with Advanced search is checked and Incorrect Manufacturer
    When I click on "Login" link
    And I input information to login as below
      | Email                 | Password |
      | namhoang234@gmail.com | Abc!23   |
    Then I click on "Login" button
    And I click "Search" tab of "Customer service" footer option
    Then I search with information as below
      | Search keyword | Advanced search | Category  | Search sub categories | Manufacturer | Product descriptions |
      | Laptop         | Checked         | Computers | Checked               | HP           | Unchecked            |
    And I click on "Search" button
    Then I verify the message will be displayed "No products were found that matched your criteria." with case "data does not exist"

  @test
  Scenario: TC_08 Search with Advanced search is checked and Correct Manufacturer
    When I click on "Login" link
    And I input information to login as below
      | Email                 | Password |
      | namhoang234@gmail.com | Abc!23   |
    Then I click on "Login" button
    And I click "Search" tab of "Customer service" footer option
    Then I search with information as below
      | Search keyword | Advanced search | Category         | Search sub categories | Manufacturer | Product descriptions |
      | Nike           | Checked         | Apparel >> Shoes | Checked               | Nike         | Unchecked            |
    And I click on "Search" button
    Then I verify the result return as below
      | Nike Floral Roshe Customized Running Shoes |
      | Nike SB Zoom Stefan Janoski "Medium Mint"  |

