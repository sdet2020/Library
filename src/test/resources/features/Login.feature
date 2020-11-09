Feature: library.com login

  Background:
    Given I have navigated to Library Login Page

  @librarian_login @smoke
  Scenario: Login to Library.com as a librarian
    When I enter "librarian" credentials
    Then I should land on Library Home Page

  @s_o @smoke
  Scenario Outline: Negative login scenarios for vyTrack as <username>
    When I enter invalid "<username>" and "<password>" and click login
    Then I should see a message Invalid username or password

    Examples:
      | username  | password  |
      | admin     | admin     |
      | admin2    | admin2    |
      | admin3    | admin3    |

  @negative_and_positive_login @smoke
  Scenario Outline: Login scenarios to vyTrack as a <username>
    When I enter "<username>" and "<password>" and click login
    Then I should see "<currentPageTitle>"

    Examples: data set
      | username              | password  | currentPageTitle  |
      | admin                 | admin     | Login - Library   |
      | admin2                | admin2    | Login - Library   |
      | student27@library     | kkMksO2i  | Library           |
