@web
Feature: Contact Form on DemoBlaze

  @positive
  Scenario Outline: Successful Submission of Contact Form
    Given I am on the "Contact" page of DemoBlaze
    When I fill in the Email field with <email>
    And I fill in the Name field with <name>
    And I fill in the Message field with <message>
    And I click the Send message button
    Then the user should see a confirmation message saying <confirmationMessage>

    Examples:
      | email                    | name          | message                                                                   | confirmationMessage        |
      | "johndoe@example.com"    | "John Doe"    | "Can you provide more details about the features and pricing? Thank you!" | "Thanks for the message!!" |
      | "johnnydepp@example.com" | "johnny depp" | "Hi, I'm Johnny Depp, I want free products"                               | "Thanks for the message!!" |

  @negative
  Scenario: Invalid Email Address
  Expected : User get pop up notification "Please fill Contact Email !!"
  Actual : User get pop up notification "Thanks for the message!!"
    Given I am on the "Contact" page of DemoBlaze
    When I fill in the Email field with ""
    And I fill in the Name field with ""
    And I fill in the Message field with ""
    And I click the Send message button
    Then the user should see a confirmation message saying "Thanks for the message!!"

  @negative
  Scenario: Message Field Empty
  Expected : User get pop up notification "Please fill Message !!"
  Actual : User get pop up notification "Thanks for the message!!"
    Given I am on the "Contact" page of DemoBlaze
    When I fill in the Email field with "johndoe@example.com"
    And I fill in the Name field with "John Doe"
    And I fill in the Message field with ""
    And I click the Send message button
    Then the user should see a confirmation message saying "Thanks for the message!!"

  @negative
  Scenario: Name Field Empty
  Expected : User get pop up notification "Please fill Name !!"
  Actual : User get pop up notification "Thanks for the message!!"
    Given I am on the "Contact" page of DemoBlaze
    When I fill in the Email field with "johndoe@example.com"
    And I fill in the Name field with ""
    And I fill in the Message field with "Can you provide more details about the features and pricing? Thank you!"
    And I click the Send message button
    Then the user should see a confirmation message saying "Thanks for the message!!"

  @negative
  Scenario: Close Contact Form
    Given I am on the "Contact" page of DemoBlaze
    When The user clicks on the Close button on the contact form
    And The contact form should be closed