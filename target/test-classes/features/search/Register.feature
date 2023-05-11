Feature: Register an account

  Background:
    Given I open the home page

  Scenario: TC_01 Register with empty data
    When I click on Register link
    Then I click on Register button
    And I should see error message at mandatory fields
    Then I close the application

  Scenario: TC_02 Register with invalid email
    When I click on Register link
    When I input information to register an account as below
      | Gender | First name | Last name | Day | Month | Year | Email               | Company Name | Password | Confirm password |
      | Male   | Nam        | Hoang     | 6   | July  | 1990 | namhoang1990@gmail. | Facegram     | Fake!23  | Fake!23          |
    And I should see error message with "invalid email" fields as "Wrong email" at Register page
    Then I close the application

  Scenario: TC_03 Register with valid data
    When I click on Register link
    When I input information to register an account as below
      | Gender | First name | Last name | Day | Month | Year | Email                  | Company Name | Password | Confirm password |
      | Male   | Nam        | Hoang     | 6   | July  | 1990 | namhoang1990@gmail.com | Facegram     | Fake!23  | Fake!23          |
    Then I click on Register button
    And I should see success message is displayed after registering successfullly
    Then I close the application

  Scenario: TC_04 Register with an email is exist
    When I click on Register link
    When I input information to register an account as below
      | Gender | First name | Last name | Day | Month | Year | Email                  | Company Name | Password | Confirm password |
      | Male   | Nam        | Hoang     | 6   | July  | 1990 | namhoang1990@gmail.com | Facegram     | Fake!23  | Fake!23          |
    Then I click on Register button
    And I should see error message with "email is exist" fields as "The specified email already exists" at Register page
    Then I close the application

  Scenario: TC_05 Register with invalid password
    When I click on Register link
    When I input information to register an account as below
      | Gender | First name | Last name | Day | Month | Year | Email                  | Company Name | Password | Confirm password |
      | Male   | Nam        | Hoang     | 6   | July  | 1990 | namhoang1990@gmail.com | Facegram     | abc      | ABC              |
    Then I click on Register button
    And I should see error message with "invalid password" fields as "Password must meet the following rules: must have at least 6 characters" at Register page
    Then I close the application

  Scenario: TC_06 Register with confirm password and password is not the same
    When I click on Register link
    When I input information to register an account as below
      | Gender | First name | Last name | Day | Month | Year | Email                  | Company Name | Password | Confirm password |
      | Male   | Nam        | Hoang     | 6   | July  | 1990 | namhoang1990@gmail.com | Facegram     | Fake!23  | Fa               |
    Then I click on Register button
    And I should see error message with "unmatch confirm password" fields as "The password and confirmation password do not match." at Register page
    Then I close the application