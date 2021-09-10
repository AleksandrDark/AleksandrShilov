Feature: Check the functionality on the different page

  Scenario: Select and test functionality elements on Different page
    Given Open test site by URL
    And Perform login
    And Open through the header menu 'Service' -> 'Different Elements Page'
    When Select checkboxes 'Water, Wind'
    And Select radio 'Selen'
    And Select in dropdown 'Yellow'
    Then Log rows are displayed and radio button,checkbox, dropdown names and their status are corresponding to selected on Different Page
