Feature: Number named Car makes from UI

Scenario Outline: Verify count of items on filter drop down
    Given User visits TradeMe Motors Search webpage for "<motorType>"
    When User clicks on "<filter>" dropdown
    Then User is able to get "<count>" of options in the "<filter>" dropdown
    Examples:
      |motorType        |filter   |count|
      |car              |Make     |79   |
      |car              |Location |23   |
      |motorbike        |Make     |83   |
      |motorbike        |Style    |11   |



  Scenario Outline: Verify count of cars listed per car maker
    Given User visits TradeMe Motors Search webpage for "<motorType>"
    When User searches "<motorType>" with "<filter>" as "<filterOptions>"
    Then User is shown the "<count>" "<motorType>" with "<filter>" as "<filterOptions>"
    Examples:
      |motorType|filter     |filterOptions   |count|
      |car      |Make        |Ferrari        | 32  |
      |car      |Make        |BMW            | 3635|
      |car      |Make        |Mazda          | 6372|
      |car      |Make        |Honda          | 2774|
      |car      |Location    |Whanganui      | 546 |
      |motorbike|Style       |Scooters       | 512 |



