
Feature: Login by account

  Background:
    Given I open the home page

  Scenario: TC_01 Login with empty email
    When I click on "Login" link
    Then I click on "Login" button
    And I should see error message with "empty email" fields as "Please enter your email" at Login page


  Scenario: TC_02 Login with invalid email
    Given I click on "Login" link
    And I input information to login as below
      | Email        | Password |
      | namhoang@gm. | abc123   |
    And I should see error message with "invalid email" fields as "Wrong email" at Login page
    

  Scenario: TC_03 Login with email has not registered
    Given I click on "Login" link
    And I input information to login as below
      | Email              | Password |
      | namhoang@gmail.com | Abc!23   |
    Then I click on "Login" button
    And I should see error message with "email has not registered" fields as "Login was unsuccessful. Please correct the errors and try again. No customer account found" at Login page
    

  Scenario: Prepare data for TC_04, 05
    Given I click on Register link
    When I input information to register an account as below
      | Gender | First name | Last name | Day | Month | Year | Email              | Company Name | Password | Confirm password |
      | Male   | Nam        | Hoang     | 6   | July  | 1990 | namhoang@gmail.com | Facegram     | Abc!23   | Abc!23           |
    Then I click on "Register" button
    

  Scenario: TC_04 Login with email has registered but the password is not inputted
    Given I click on "Login" link
    And I input information to login as below
      | Email              | Password |
      | namhoang@gmail.com |          |
    Then I click on "Login" button
    And I should see error message with "blank password" fields as "Login was unsuccessful. Please correct the errors and try again. The credentials provided are incorrect" at Login page
    

  Scenario: TC_05 Login with email has registered but the password does not match
    Given I click on "Login" link
    And I input information to login as below
      | Email              | Password |
      | namhoang@gmail.com | Ayh!23   |
    Then I click on "Login" button
    And I should see error message with "password does not match" fields as "Login was unsuccessful. Please correct the errors and try again. The credentials provided are incorrect" at Login page
    

  Scenario: TC_06 Login with valid email and password
    Given I click on "Login" link
    And I input information to login as below
      | Email              | Password |
      | namhoang@gmail.com | Abc!23   |
    Then I click on "Login" button
    And I should see Login successfully and navigate to home page
    