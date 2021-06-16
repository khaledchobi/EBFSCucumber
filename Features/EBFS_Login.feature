Feature: EBFS Login

  Scenario Outline: Login with correct credentials
    Given user is on Home page
    When User Navigate to Login Page
    And user enters Email "<email>" and Password "<password>"
    Then my account page title should be "My account - eBFS - the power of choice"
    When User Log out from the application
    Then User redirect to Home page
    Examples:
      | email                  | password         |
      | khaledhasanb@gmail.com | khaled1234567890 |
      | xaim@abc.com           | Compilia         |
      | komolkhanm4@gmail.com  | 28februarY       |
      | kislam780@gmail.com    | Test123          |


  Scenario: Login with correct credentials using Data Table
    Given user is on Home page
    When User Navigate to Login Page
    And user enters Credentials to Login
      | khaledhasanb@gmail.com | khaled1234567890 |
    Then my account page title should be "My account - eBFS - the power of choice"

  Scenario: Login with correct credentials using Data Table List
    Given user is on Home page
    When User Navigate to Login Page
    And user enters Credentials to Login by List
      | email                  | password         |
      | khaledhasanb@gmail.com | khaled1234567890 |
      | xaim@abc.com           | Compilia         |
      | komolkhanm4@gmail.com  | 28februarY       |
      | kislam780@gmail.com    | Test123          |
    Then my account page title should be "My account - eBFS - the power of choice"

  Scenario: Login with correct credentials using Data Table Map
    Given user is on Home page
    When User Navigate to Login Page
    And user enters Credentials to Login by Map
      | email                  | password         |
      | khaledhasanb@gmail.com | khaled1234567890 |
      | xaim@abc.com           | Compilia         |
      | komolkhanm4@gmail.com  | 28februarY       |
      | kislam780@gmail.com    | Test123          |


  Scenario Outline: Login scenario with different set of data
    Given user is on Home page
    When User Navigate to Login Page
    When user fills the form from given sheetName "<SheetName>" and rowNumber <RowNumber>
    Then my account page title should be "Login - eBFS - the power of choice"

    Examples:
      | SheetName | RowNumber |
      | login     | 0         |


  Scenario: Successful Log Out
    When User Log out from the application
    Then User redirect to Home page