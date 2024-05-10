Feature: Living area furnitures
  Scenario: Retrieving Living sub menu items
    Given the user is on the Urban Ladder home page
    When the user hovers on the Living Menu Item
    And Chooses any sub-menu like "Chair"
    Then fetch the items under that sub-menu and print in console