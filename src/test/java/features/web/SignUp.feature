Feature: User Sign Up

  @positive
  Scenario Outline: Successful user registration
    Given the user is on the Sign Up page
    When the user enters a unique <username> and a valid <password>
    And the user clicks the Sign Up button
    Then the user should see a confirmation message saying "Sign up successful"
    And the user should be redirected to the login page

    Examples:
      | username | password   |
      | "bale"   | "Password" |
      | "pique"  | "Password" |

  @negative
  Scenario Outline: Registration with an existing username
    Given the user is on the Sign Up page
    When the user enters an existing <username> and a valid <password>
    And the user clicks the Sign Up button
    Then the user should see a confirmation message saying <message>
    Examples:
      | username  | password   | message                    |
      | "benzema" | "Password" | "This user already exist." |
      | "ronaldo" | "Password" | "This user already exist." |
      | "bale"    | "Password" | "This user already exist." |

  @negative
  Scenario Outline: Registration with a username and password less than 6 characters
  Expected : the user should see an error message indicating the username and password must be at least 6 characters long
  Actual : the user should see a confirmation message saying "Sign up successful"
    Given the user is on the Sign Up page
    When the user enters a unique <username> and a valid <password>
    And the user clicks the Sign Up button
    Then the user should see a confirmation message saying "Sign up successful"
    And the user should be redirected to the login page

    Examples:
      | username | password |
      | "balo"   | "a"      |
      | "cia"    | "abc"    |

  @negative
  Scenario Outline: Registration with an empty username and password
    Given the user is on the Sign Up page
    When the user enters a unique <username> and a valid <password>
    And the user clicks the Sign Up button
    Then the user should see a confirmation message saying <message>

    Examples:
      | username  | password   | message                                  |
      | ""        | "Password" | "Please fill out Username and Password." |
      | "benzema" | ""         | "Please fill out Username and Password." |
      | ""        | ""         | "Please fill out Username and Password." |

