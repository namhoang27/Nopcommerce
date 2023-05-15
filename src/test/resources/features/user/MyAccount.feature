Feature: Verify information of an account

  Background:
    Given I open the home page

  Scenario: Pre-data Register an account successfully
    When I click on Register link
    When I input information to register an account as below
      | Gender | First name | Last name | Day | Month | Year | Email                 | Company Name | Password | Confirm password |
      | Male   | Nam        | Hoang     | 6   | July  | 1990 | namhoang123@gmail.com | Microsoft    | Abc!23   | Abc!23           |
    Then I click on Register button


  Scenario: TC_01: Customer info
    When I click on Login link
    And I input information to login as below
      | Email                 | Password |
      | namhoang123@gmail.com | Abc!23   |
    Then I click on Login button
    Then I click on My Account link
    When I click on "Customer info" tab of My account option
    And I should see the information of customer info as below
      | Gender | First name | Last name | Day | Month | Year | Email                 | Company Name |
      | Male   | Nam        | Hoang     | 6   | July  | 1990 | namhoang123@gmail.com | Microsoft    |
    When I update information of an account as below
      | Gender | First name | Last name | Day | Month | Year | Email                  | Company Name |
      | Male   | Nam01      | Hoang02   | 7   | June  | 1998 | namhoang1994@gmail.com | Netflix      |
    Then I click Save button after update customer info
    Then I should see success message is displayed "The customer info has been updated successfully."
    And I should see the information of customer info as below
      | Gender | First name | Last name | Day | Month | Year | Email                  | Company Name |
      | Male   | Nam01      | Hoang02   | 7   | June  | 1998 | namhoang1994@gmail.com | Netflix      |

  Scenario: TC_02: Addresses
    When I click on Login link
    And I input information to login as below
      | Email                  | Password |
      | namhoang1994@gmail.com | Abc!23   |
    Then I click on Login button
    Then I click on My Account link
    When I click on "Addresses" tab of My account option
    Then I click on Add new Address button
    And I input information of addresses as below
      | First name | Last name | Email             | Company  | Country  | State / province | City   | Address 1       | Address 2         | Zip / Postal code | Phone number | Fax number |
      | Gavi       | Son       | gavison@gmail.com | Vinamilk | Cambodia | Other            | London | 12/23 Greenwich | Buckingham Palace | 550000            | 0123456789   | 6892134    |
    And I click Save button after inputting address
    Then I should see success message is displayed "The new address has been added successfully."
    And I verify the information of addresses have just inputted display as below
      | Name     | Email             | Phone      | Fax     | Company  | Address1        | Address2          | City-Zip       | Country  |
      | Gavi Son | gavison@gmail.com | 0123456789 | 6892134 | Vinamilk | 12/23 Greenwich | Buckingham Palace | London, 550000 | Cambodia |

  Scenario: TC_03: Change password
    When I click on Login link
    And I input information to login as below
      | Email                  | Password |
      | namhoang1994@gmail.com | Abc!23   |
    Then I click on Login button
    Then I click on My Account link
    When I click on "Change password" tab of My account option
    And I input information of change password as below
      | Old password | New password | Confirm password |
      | Abc!23       | Abc@34       | Abc@34           |
    Then I click on Change Password button
    Then I should see success message is displayed "Password was changed"
    And I dismiss the popup message
    And I click on Logout link
    When I click on Login link
    And I input information to login as below
      | Email                  | Password |
      | namhoang1994@gmail.com | Abc!23   |
    Then I click on Login button
    And I should see error message with "password does not match" fields as "Login was unsuccessful. Please correct the errors and try again. The credentials provided are incorrect" at Login page
    And I input information to login as below
      | Email                  | Password |
      | namhoang1994@gmail.com | Abc@34   |
    Then I click on Login button
    And I should see Login successfully and navigate to home page

  Scenario: TC_04: My product reviews
    When I click on Login link
    And I input information to login as below
      | Email                  | Password |
      | namhoang1994@gmail.com | Abc@34   |
    Then I click on Login button
    And I select "Notebooks" of "Computers" option tab
    And I select product name "Lenovo Thinkpad X1 Carbon Laptop"
    And I click "Add your review" option
    And I input information for write review as below
      | Review title        | Review text           | Rating |
      | The monitor is good | Best screen I've used | 4      |
    Then I click on Submit review button
    And I should see success message after reviewing "Product review is successfully added."
    Then I click on My Account link
    When I click on "My product reviews" tab of My account option
    And I verify information for review product at My product reviews as below
      | Product is reviewed              | Review title        | Review text           | Rating |
      | Lenovo Thinkpad X1 Carbon Laptop | The monitor is good | Best screen I've used | 4      |
