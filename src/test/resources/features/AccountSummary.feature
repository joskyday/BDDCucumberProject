Feature: Account Summary

    Scenario: Account Summary Page Title
      Given the user is at the login page
      When the user enters login credentials
      Then Account Summary Page Displayed
      And Account summary page should have the title Zero – Account summary

    Scenario: Account Types
      Given the user is at the login page
      When the user enters login credentials
      Then Account summary page should have to following account types:
    |Cash Accounts      |
    |Investment Accounts|
    |Credit Accounts    |
    |Loan Accounts      |


    Scenario: Credit Accounts table columns
    Given the user is at the login page
    When the user enters login credentials
    Then Credit Accounts table must have columns
    |Account|
    |Credit Card|
    |Balance|