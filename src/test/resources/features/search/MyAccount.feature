Feature: Verify information of an account

  Background:
    Given I open the home page

  Scenario: Pre-data Register an account successfully
    When I click on Register link
    When I input information to register an account as below
      | Gender | First name | Last name | Day | Month | Year | Email                 | Company Name | Password | Confirm password |
      | Male   | Nam        | Hoang     | 6   | July  | 1990 | namhoang123@gmail.com | Microsoft    | Abc!23   | Abc!23           |
    Then I click on Register button
    Then I close the application

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
