Feature: Verify car search results per car makers

  Scenario Outline:
    Given User access the "cars" search page
    When User clicks on "<filterType>" from available filters
    And selects "<filterOptions>" from available list
    Then Count shown in dropdown pane is same as count shown in page header

    Examples:
    |filterType|filterOptions|
    |Make: All  |BMW          |
    |Make: All  |Mazda        |
    |Make: All  |Honda        |
    |Make: All  |Ferrari      |




