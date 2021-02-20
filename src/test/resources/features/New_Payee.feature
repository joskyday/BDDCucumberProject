Feature: Add new payee under pay bills
  
  Background: 
    Given the user is at the login page
    And the user enters login credentials
    And the user navigates to "Pay Bills" tab

  Scenario: Add a new payee
    Given Add New Payee tab
    And creates new payee using following information
      |Payee Name | The Law Offices of Hyde, Price & Scharks|
      |Payee Address | 100 Same St, Anytown, USA, 10001 |
      |Account | Checking |
      |Payee details | XYZ account |
    Then message "The new payee The Law Offices of Hyde, Price & Scharks was successfully created." should be displayed