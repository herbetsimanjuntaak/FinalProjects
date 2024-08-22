@api
Feature: Test Get User Automation Dummy API
  This feature allows users to retrieve information about an existing user via a dummy API for automation purposes.

  @positive
  Scenario: Test get list data user
    Given prepare url for "GET_LIST_USERS"
    When HIT API get list users
    Then should return status code 200
    Then validation response body get list users
    Then validation response json with JSONSchema "get_list_users.json"

  @positive
  Scenario: Test get list data user only created by user
    Given prepare url for "GET_USER_BY_CREATED"
    When HIT API get list users
    Then should return status code 200
    Then validation response body get list users
    Then validation response json with JSONSchema "get_user_created.json"

  @negative
  Scenario: Test get list data user invalid endpoint
    Given prepare url for "GET_ENDPOINT_WRONG"
    When HIT API get list users
    Then should return status code 404
    Then validation response body invalid endpoint

  @negative
  Scenario: Test get list data user without app-id header
    Given prepare url for "GET_LIST_USERS"
    And hit API get blank header
    Then should return status code 403
    Then validation response body invalid endpoint

  @positive
  Scenario: Test get data user by id
    Given prepare url for "GET_LIST_USER_BY_ID"
    And prepare valid id "60d0fe4f5311236168a109d1"
    And hit API get user by id
    Then should return status code 200
    Then validation response body get user by id
    Then validation response json with JSONSchema "get_user_by_id.json"

  @negative
  Scenario: Test get data invalid id
    Given prepare url for "GET_LIST_USER_BY_ID"
    And prepare valid id "69581364"
    And hit API get user by id
    Then should return status code 400
    Then validation response body wrong id

  @positive
  Scenario Outline: Get user details by query parameters
    Given prepare url for "GET_LIST_USERS"
    And hit API get list user with parameters "<firstName>" and "<lastName>"
    Then validation status code is equals 200
    Then validation response json with JSONSchema "get_user_with_params.json"
    And validate data should be contain "<firstName>" and "<lastName>"

    Examples:
      | firstName | lastName |
      | Valentin  | Ortega   |
      | Sibylle   | Leibold  |
      | Elisa     | Lorenzo  |

  @positive
  Scenario Outline: Get user details by query parameters page and limit
    Given prepare url for "GET_LIST_USERS"
    And hit API get list user with parameters "<page>" and "<limit>"
    Then validation status code is equals 200
    Then validation response json with JSONSchema "get_list_users.json"
    And validate data user should be contain "<page>" and "<limit>"

    Examples:
      | page | limit |
      | 0    | 20    |
      | 5    | 10    |
      | 999  | 50    |

  @negative
  Scenario Outline: Get user details by query parameters invalid page and limit
  Expected : User get get response status code 400 , and response body "error": "PARAMS_NOT_VALID"
  Actual : User get status code 200 and success get user when params invalid
    Given prepare url for "GET_LIST_USERS"
    And hit API get list user with parameters "<page>" and "<limit>"
    Then validation status code is equals 200
    Then validation response json with JSONSchema "get_list_users.json"

    Examples:
      | page | limit |
      | -1   | 50    |
      | -1   | 20    |
      | 10   | 51    |
      | 5    | 10    |
      | 9999 | 0     |
