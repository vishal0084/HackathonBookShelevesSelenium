Feature: Display Bookshelves
 
  Scenario: Display Bookshelves below Rs 15000
    Given the user is on the Urban Ladder home page
    When the user searches "bookshelves below 15000" on the search bar
    And the user clicks on search button
    Then gets redirected to the search page
    When selects Exclude Out Of Stock
    And Sort by as "Price: High to Low"
    And Chooses any category like "Bookshelves"
    Then Check if the correct options are chosen
    And Display top 3 items and print in the console