@api
Feature: Test Create User Automation Dummy API
  This feature allows users to test the creation of a new user via a dummy API for automation purposes.
  It is intended for testing and demonstration only.

  @positive
  Scenario: Test create valid data user
    Given prepare url for "CREATE_NEW_USERS"
    And hit API create new users
    Then should return status code 200
    Then validation response body create user
    Then validation response json with JSONSchema "create_valid_user.json"

  @negative
  Scenario: Test create data user with empty body required
    Given prepare url for "CREATE_NEW_USERS"
    When user hit API invalid create new users
    Then should return status code 400
    Then validation response body create invalid user

  @negative
  Scenario: Test create data user with over maximum length characters (30)
    Given prepare url for "CREATE_NEW_USERS"
    When user hit API over characters
    Then should return status code 400
    Then validation response body over characters

  @negative
  Scenario: Test create data user with blank email
    Given prepare url for "CREATE_NEW_USERS"
    When user hit API blank email
    Then should return status code 400
    Then validation response body invalid endpoint

  @negative
  Scenario: Test create data user with invalid email
    Given prepare url for "CREATE_NEW_USERS"
    When user hit API invalid email
    Then should return status code 400
    Then validation response body invalid endpoint

  @negative
  Scenario: Test create data user invalid endpoint
    Given prepare url for "GET_ENDPOINT_WRONG"
    And hit API create new users
    Then should return status code 404
    Then validation response body invalid endpoint