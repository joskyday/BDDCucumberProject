Feature: Account Activity

  Scenario: Account Activity page should have the title
    Given the user is at the login page
    When the user enters login credentials
    And the user navigates to "Account Activity" tab
    Then the page	should	have	the	title	"Zero - Account Activity"

    Scenario: Account	drop	down	default	option
      Given the user is at the login page
      When the user enters login credentials
      And the user navigates to "Account Activity" tab
      Then Account	drop	down	default	option	should	be	"Savings"
      And Account	drop	down should	have	the	following	options:
  |Savings      |
  |Checking     |
  |Loan         |
  |Credit Card  |
  |Brokerage    |
    And Transactions	table	should	have	column	names:
  |Date       |
  |Description|
  |Deposit    |
  |Withdrawal |




