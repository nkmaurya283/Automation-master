@test
Feature: Heathrow home page ui automation

  Background:
    Given I accept cookie


  Scenario: Validate Only T3 Terminal Displayed by Selecting on Flight arrival
    Given I mouse Hover on "Flights"
    And I clicked on "Arrivals" flights
    And I filter with "Terminal T3"
    And I select the date "Sat Mar 07 2020"
    Then I verify the "T3" terminal only displayed on the page
  @bar
  Scenario Outline: Search different type of keywords
    Given I click on Search field
    When I search the value in <searchField>
    Examples:
    |    searchField    |
    |   Heathrow parking|
   # |   Fast track      |
  @bar
  Scenario: Mouse Hover on Header parts on Different link
    Given I mouse Hover on "Flights"
    Given I mouse Hover on "At the Airport"
    Given I mouse Hover on "Transport & Directions"
    #Given I mouse Hover on "Transport & Direction"


