Feature: User should login
Background:
  Given the user is at the login page

  Scenario:Only authorized	users	should	be	able	to	login	to	the	application
    When the user enters login credentials
    Then Account Summary Page Displayed

  Scenario Outline: Users	with	wrong	username	or	wrong	password	should	not	be	able	to	login with "<user>" and "<pass>"
    When the user enters invalid "<user>" and "<pass>"
    Then the user should not be able to login

    Examples:
  |user    |pass      |
  |user    |pass      |
  |username|pass      |
  |user    |password  |
  |        |          |
