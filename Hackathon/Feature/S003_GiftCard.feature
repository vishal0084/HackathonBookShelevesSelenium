Feature: Working On Gift Card
 
  Scenario Outline: Sending a Gift Card
    Given the user is on the Urban Ladder home page
    When user clicks on Gift Cards
    Then gets redirected to Gift Cards Page
    When chooses an occasion "Birthday/Anniversary"
    And customizes the gift card by entering the amount as "1000"
    And enters the personal details with invalid email id using "<Sheetname>" and <Rownumber>
    Then capture the error message and print in console
    When update with valid email id and submit
    Then validate all the given details in the Confirm Details section
    And display all the details in the console
 
    Examples: 
      | Sheetname | Rownumber |
      | Details   |         0 |