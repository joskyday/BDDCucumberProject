Feature: Pay Bills

  Background:
    Given the user is at the login page
    When the user enters login credentials
    And the user navigates to "Pay Bills" tab

  Scenario: Page Title
    Then the page	should	have	the	title	"Zero - Pay Bills"

  Scenario: Successful Pay Operation
    And the user	completes	a successful	Pay	operation with following information:
      | Payee       | sprint         |
      | Account     | Savings        |
      | Amount      | 100            |
      | Date        | 2021-02-16     |
      | Description | Coding Deposit |
    Then "The payment was successfully submitted." should be displayed


  Scenario Outline: Pay Operation with missing data "<amount>" or "<date>"
    And user tries to make a payment without entering the "<amount>" or "<date>":
    Then "Please fill out this field." message should be displayed
    Examples:
      | amount | date       |
      | 100    |            |
      |        | 2021-02-17 |
      |        |            |


  Scenario Outline: Pay Operation Amount Field "<amount>"
    And user tries to make a payment entering the "<amount>":
    Then Amount field should not accept alphabetical or special characters
    Examples:
      | amount |
      | !      |
      | \\\    |
      | \"     |
      | \\#    |
      | $      |
      | %      |
      | &      |
      | '      |
      | (      |
      | )      |
      | *      |
      | +      |
      | ,      |
      | -      |
      | .      |
      | /      |
      | :      |
      | ;      |
      | <      |
      | =      |
      | >      |
      | ?      |
      | @      |
      | \\[    |
      | \\]    |
      | ^      |
      | _      |
      | `      |
      | {      |
      | \|     |
      | }      |
      | ~      |
      | A      |
      | B      |
      | C      |
      | D      |
      | E      |
      | F      |
      | G      |
      | H      |
      | I      |
      | J      |
      | K      |
      | L      |
      | M      |
      | N      |
      | O      |
      | P      |
      | Q      |
      | R      |
      | S      |
      | T      |
      | U      |
      | V      |
      | W      |
      | X      |
      | Y      |
      | Z      |
      | a      |
      | b      |
      | c      |
      | d      |
      | e      |
      | f      |
      | g      |
      | h      |
      | i      |
      | j      |
      | k      |
      | l      |
      | m      |
      | n      |
      | o      |
      | p      |
      | q      |
      | r      |
      | s      |
      | t      |
      | u      |
      | v      |
      | w      |
      | x      |
      | y      |
      | z      |


  Scenario Outline: Pay Operation Date Field "<date>"
    And user tries to make a payment entering "<date>"
    Then Date field should not accept alphabetical characters
    Examples:
      | date |
      | A    |
      | B    |
      | C    |
      | D    |
      | E    |
      | F    |
      | G    |
      | H    |
      | I    |
      | J    |
      | K    |
      | L    |
      | M    |
      | N    |
      | O    |
      | P    |
      | Q    |
      | R    |
      | S    |
      | T    |
      | U    |
      | V    |
      | W    |
      | X    |
      | Y    |
      | Z    |
      | a    |
      | b    |
      | c    |
      | d    |
      | e    |
      | f    |
      | g    |
      | h    |
      | i    |
      | j    |
      | k    |
      | l    |
      | m    |
      | n    |
      | o    |
      | p    |
      | q    |
      | r    |
      | s    |
      | t    |
      | u    |
      | v    |
      | w    |
      | x    |
      | y    |
      | z    |
