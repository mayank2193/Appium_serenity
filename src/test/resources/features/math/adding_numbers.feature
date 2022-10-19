Feature: Adding Numbers

#  Scenario: Adding two numbers
#    Given a is 1
#    And b is 2
#    When I add a and b
#    Then the total should be 3

  Scenario Outline: Add task
    Given I click add button
    When I input task "<title>" and task "<content>"
    And I click save button
    Then my task added "<result>"
    Examples:
      | title | content | result |
      | belajar | belajar yok | success |
      |         |             | error_message |

#  Scenario: Add task with null value
#    Given I click add button
#    When I input null title and null content
#    And I click save button
#    Then I verify the error message