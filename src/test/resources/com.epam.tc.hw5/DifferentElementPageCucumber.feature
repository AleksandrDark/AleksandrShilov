Feature: Check the functionality on the different page

  Scenario: Select and test functionality elements on Different page
    Given I open JDI GitHub site
    And I login as user "Roman Iovlev"
    When I click on "Service" button in Header
    And I click on "Different Elements Page" button in Service dropdown
    And Select checkboxes 'Water, Wind'
    And Select radio Selen
    And Select in dropdown "Yellow"
    Then Log rows are displayed and radio button,checkbox, dropdown names and their status are corresponding to selected on different Page:
      | Yellow |
      | Selen  |
      | Wind   |
      | Water  |