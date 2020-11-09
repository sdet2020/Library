Feature: Add book

  @add_book @smoke
  Scenario: As a librarian when I click on Add Book button on Books page then I should be able to create a book.
    Given I have navigated to Library Login Page
    When I enter "librarian" credentials
    And I navigate to "Books" page
    When I click on Add Book button
    Then I should be able to create a Book