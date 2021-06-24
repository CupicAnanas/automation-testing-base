@Login
Feature: Testing login flow
  Steps below show the flow of login

  Background:
    Given user is on login page

  @HappyPathLogin
  Scenario Outline: Happy path (successful login)
    When user inputs "<email>" and "<password>" parameters
    And user clicks on login button
    Then user should be logged into his account
    Examples:
      | email                           | password   |
      | nemanja.vlaisavljevic@ananas.rs | dotamen5   |
      | bogdan.jovanovic@ananas.rs      | ananastest |
      | cupicmarko.ananas@gmail.com     | Cup@vi98!  |

  @HappyPathLogin
  @AlternativePathLogin
  Scenario: Alternative path (login with facebook)
    When user clicks on login with Facebook account
    And user inserts "nem.vlaisavljevic.ananas@gmail.com" into facebook email
    And user insert "dotamen5" into facebook password
    And user clicks on facebook login button
    Then user should be logged in and see the pop up for successful login

  @ForgotPassword
  Scenario Outline: User clicks "Zaboravili ste lozinku?"
    When user clicks on forgot password button
    And user provides his "<email>"
    And user clicks send email button
    Then user should receive email to change password
    Examples:
      | email                           |
      | cupic.marko.ananas@gmail.com    |
      | nemanja.vlaisavljevic@ananas.rs |
      | randommejl@gmail.com             |