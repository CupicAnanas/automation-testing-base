@Registration
Feature: Registration flow
  Steps below show the flow of registration

  Background:
    Given user is on registration page

  @HappyPathRegistration
  Scenario Outline: Happy path (successful registration)
    When user inputs "<email>", "<name>", "<surname>", "<password>" parameters
    And user checks terms of use button
    And user clicks on register button
    Then user should be registered

    Examples:
      | email                      | name    | surname     | password         |
      | nekitestmail12122@gmail.com | NekoIme | NekoPrezime | NovaTest$ifr@123 |

  @HappyPathRegistration
    @AlternativePathRegistration
  Scenario Outline: Alternative path (clicks on newsletter)
    When user inputs "<email>", "<name>", "<surname>", "<password>" parameters
    And user checks terms of use button
    And user checks newsletter button
    And user clicks on register button
    Then user should be registered
#   user should also check his email for newsletter confirmation, but this functionality doesn't yet exist
#   23.06.2021

    Examples:
      | email                      | name    | surname     | password         |
      | nekitestmail1212@gmail.com | NekoIme | NekoPrezime | NovaTest$ifr@123 |

  @ExceptionalPathRegistration
  Scenario Outline: Exceptional path (user inputs invalid parameters or no parameters at all)
    When user inputs invalid "<email>", "<name>", "<surname>", "<password>" or inputs empty parameters
    And user checks terms of use button
    Then user should be unable to register

    Examples:
      | email                         | name     | surname      | password       |
      |                               |          |              |                |
      |                               | ImeTestA | PrezimeTestA | LozinkaTestA1! |
      | nekiemailtest12345@gmail.com  |          | PrezimeTestA | LozinkaTestA1! |
      | nekiemailtest12345@gmail.com  | ImeTestA |              | LozinkaTestA1! |
      | nekiemailtest12345@gmail.com  | ImeTestC | PrezimeTestC |                |
      | email1                        | ImeTestA | PrezimeTestA | LozinkaTestA1! |
      | nekiemailtest123456@gmail.com | ImeTestB | PrezimeTestB | 1234           |
      | email2                        | ImeTestC | PrezimeTestC | 555            |

  @ExceptionalPathRegistration
  Scenario Outline: Exceptional path (user doesn't check terms of use)
    When user inputs "<email>", "<name>", "<surname>", "<password>" parameters
    And user checks then unchecks terms of use
    Then user should be unable to register

    Examples:
      | email                      | name    | surname     | password         |
      | nekitestmail1212@gmail.com | NekoIme | NekoPrezime | NovaTest$ifr@123 |