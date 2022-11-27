Feature:
  Tests number named Car makes from API

  Scenario Outline: Verify car makers from TradeMe API
  Given User has access to TradeMe API
  When User requests for number of named car makers
  Then User is returned with count of "<expectedCount>" car makers
    Examples:
    |expectedCount|
    |78           |