@address
Feature: To test Address with different combination
          of street name and number

  Scenario: test simple street name and number
    Given The system is up and running
    When I pass address as "Winterallee 3"
    Then I verify the address as "Winterallee" and "3"

  Scenario: test complex street name and number
    Given The system is up and running
    When I pass address as "Am Bachle 3"
    Then I verify the address as "Am Bachle" and "3"

  Scenario Outline: test street name for different countries
    Given The system is up and running
    When I pass address as "<complete_address>"
    Then I verify the address as "<street>" and "<number>"
    Examples:
      | complete_address | street       | number  |
      | 200 Broadway Av  | Broadway Av  | 200     |
      | Calle Aduana, 29 | Calle Aduana | 29      |
      | Calle 39 No 1540 | Calle 39     | No 1540 |
