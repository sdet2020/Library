Feature: Check all tabs for functionality

  @smoke
  Scenario Outline: Check <tabs> for critical functionality
    Given I have logged in to Library Home Page as a "librarian"
    When I click on "<tabs>"
    Then I should land on this "<url>"
    Examples:
    | tabs        | url                                             |
    | dashboard   | http://library2.cybertekschool.com/#dashboard   |
    | users       | http://library2.cybertekschool.com/#users       |
    | books       | http://library2.cybertekschool.com/#books       |