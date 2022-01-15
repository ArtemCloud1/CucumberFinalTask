Feature: Smoke
  main tests for online shop 'Asos'


  Scenario Outline: check section matches the selected one
    Given User open '<StartPage>' page
    And User chooses gender
    Then the user got a page with the selected gender
    Examples:
      | StartPage            |
      | https://www.asos.com/|
Scenario Outline: chek search url contain search word
  Given User open '<StartPage>' page
  And User click to search field
  And User input search '<keyword>'
  And User click search button
  Then User checks contains url search '<keyword>'
  Examples:
    | StartPage            | keyword |
    | https://www.asos.com/| adidas  |
Scenario Outline: Check all items contain search word
  Given User open '<StartPage>' page
  And User click to search field
  And User input search '<keyword>'
  And User click search button
  Then User check search result item contains '<keyword>'
  Examples:
    | StartPage            | keyword |
    | https://www.asos.com/| Nike    |
  Scenario Outline: Sign In
    Given User open '<StartPage>' page
    And User click my account button
    And User click sign in link
    And User enters '<email>'
    When User click login button
    Then User check '<errorMessage>'
    Examples:
      | StartPage            | email                     |errorMessage               |
      | https://www.asos.com/| yiyec10158@huekieu.com    |Hey, we need a password here|
Scenario Outline: Check saved item
  Given User open '<StartPage>' page
  And User click to search field
  And User input search '<keyword>'
  And User click search button
  And User add item in 'saved item'
  And User click to 'Heart' icon
  Then User check saved '<expected count item>'

  Examples: select items for add to cart
    | StartPage            | keyword|expected count item|
    | https://www.asos.com/| Nike   |1 item             |
  Scenario Outline: Sign Up without date of birth
    Given User open '<StartPage>' page
    And User click my account button
    And User click sign in link
    And User click 'sign up' link
    And User enter '<name>'
    And User '<lastName>' enter in field
    And User enter '<email>' in field
    When enter '<password>'
    And click 'sign up' button
    Then check date of birth eeror '<message>'
    Examples:
      | StartPage            | email                     |password  |name  |lastName|message                      |
      | https://www.asos.com/| yiyec10158@huekieu.com    |1234567845|Sauron|Ainur   |Enter your full date of birth|
Scenario Outline:
  Given User open '<StartPage>' page
  And User click to search field
  And User input search '<keyword>'
  And User click search button
  And Open first item
  And User select size
  And User click 'add to beg'
  Examples:
    | StartPage            | keyword |
    | https://www.asos.com/| Nike    |
