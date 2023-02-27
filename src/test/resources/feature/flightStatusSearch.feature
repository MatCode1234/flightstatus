Feature: Flight status search
  Our website users should be able get the flights status of a given flight route by a given date

  Background:
    Given I'm on the flight website search page
  Scenario: I want to search a fly positive path
    When I select valid "CGN" departure airport
    And I select valid "BER" destination airport
    And I select valid travel date
    And I click Show flight status button
    Then A table with flight status should be displayed

  Scenario: I want to search flight with not selected departure airport
    When I select valid "BER" destination airport
    And I select valid travel date
    And I click Show flight status button
    Then Search button is not available

  Scenario: I want to search flight with not selected destination airport
    When I select valid "CGN" departure airport
    And I select valid travel date
    And I click Show flight status button
    Then Search button is not available

  Scenario: I want to search flight with not selected travel date airport
    When I select valid "BER" destination airport
    And I select valid "CGN" departure airport
    And I click Show flight status button
    Then Search button is not available

  Scenario: I want to search flight with not selected destination and departure airport
    When I select valid travel date
    And I click Show flight status button
    Then Search button is not available

  Scenario: I want to search flight with not selected destination, departure airport and travel date
    When I click Show flight status button
    Then Search button is not available

  Scenario: I want to search flight with date which produce empty result table
    When I select valid "BHX" departure airport
    And I select valid "BOJ" destination airport
    And I select valid travel date
    And I click Show flight status button
    Then A table with no result should be displayed and equals to "Unfortunately, we could not find any results for your search."