@web
Feature: About Us Page

  @positive
  Scenario: Accessing About Us page
    Given the user is on the homepage
    When the user clicks the About Us button
    Then the About Us modal should be displayed

