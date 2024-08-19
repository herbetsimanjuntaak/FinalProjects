Feature: User Login

  @positive
  Scenario Outline: Successful user login
    Given the user is on the Login page
    When the user enters a valid <username> and a valid <password>
    And the user clicks the Login button
    Then the user should be logged in successfully
    And the user should see their <username> displayed on the page
    Examples:
      | username  | password   |
#      | "benzema" | "Password" |
      | "ronaldo" | "Password" |

  @negative
  Scenario Outline: Login with an incorrect username and password,non-existent username,empty username and password
    Given the user is on the Login page
    When the user enters a valid <username> and a valid <password>
    And the user clicks the Login button
    Then the user should see a confirmation message saying <message>
    Examples:
      | username  | password   | message                                  |
      | "ronaldo" | "Pass"     | "Wrong password"                         |
      | "ronaldo" | ""         | "Please fill out Username and Password." |
      | ""        | "password" | "Please fill out Username and Password." |
      | ""        | ""         | "Please fill out Username and Password." |
      | "onana"   | "12345"    | "User does not exist."                   |

