Feature: EBFS Registration

  Scenario Outline: Registration scenario with different set of data
    Given User is on the Login Page
    When User enters email address for Registration
    And User is on Registration Page
    When user fills the registration form from given sheetName "<SheetName>" and rowNumber <RowNumber>
    Then Successful registration page title should be "My account - eBFS - the power of choice"

    Examples:
      | SheetName | RowNumber |
      | registration     | 0         |


  Scenario Outline: Registration scenario with different set of data from Sheet
    Given User is on the Login Page
    When User enters email and fills the registration form from given sheetName "<SheetName>" and rowNumber <RowNumber>

    Examples:
      | SheetName | RowNumber |
      | regis     | 0         |