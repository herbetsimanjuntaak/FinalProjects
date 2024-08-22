@api
Feature: List of routes to get Post data.

  1. Get List
  Get list of comments sorted by creation date.

  2. Get List By Post
  Get list of comments for specific post sorted by creation date.

  3. Get List By User
  Get list of comments for specific user sorted by creation date.

  4. Create Comment
  Create new comment, return created comment data.

  5.Delete Comment
  Delete comment by id, return id of deleted post

  @positive
  Scenario: Test Get list of comments sorted by creation date.
    Given prepare url for "GET_LIST_COMMENT"
    When HIT API get list users
    Then should return status code 200
    Then validation response body get list users
    Then validation response json with JSONSchema "get_list_comment.json"

  @positive
  Scenario Outline: Test Get list of comments by query parameters page and limit
    Given prepare url for "GET_LIST_COMMENT"
    And hit API get list user with parameters "<page>" and "<limit>"
    Then validation status code is equals 200
    Then validation response json with JSONSchema "get_list_comment.json"
    And validate data user should be contain "<page>" and "<limit>"

    Examples:
      | page | limit |
      | 5    | 10    |
      | 999  | 50    |

  @positive
  Scenario: Get list of comments for specific post sorted by creation date.
    Given prepare url for "GET_LIST_POST"
    And prepare valid id "60d21be767d0d8992e610e61"
    When Hit Api list of comments By Post
    Then should return status code 200
    Then validation response body get list users
    Then validation response json with JSONSchema "get_list_comment.json"

  @negative
  Scenario: Get list of comments for specific post sorted by creation date, invalid ID post
    Given prepare url for "GET_LIST_POST"
    And prepare valid id "60d21be767d0d8992e610e6109674"
    When Hit Api list of comments By Post
    Then should return status code 400
    Then validation response body invalid endpoint

  @positive
  Scenario: Get list of comments for specific user sorted by creation date.
    Given prepare url for "GET_LIST_USERS"
    And prepare valid id "60d0fe4f5311236168a109df"
    When Hit Api list of comments By User
    Then should return status code 200
    Then validation response body get list users
    Then validation response json with JSONSchema "get_list_comment.json"

  @negative
  Scenario: Get list of comments for specific user sorted by creation date, invalid ID User
    Given prepare url for "GET_LIST_POST"
    And prepare valid id "60d21be767d0d8992e610e6109674"
    When Hit Api list of comments By User
    Then should return status code 400
    Then validation response body invalid endpoint

  @positive
  Scenario: Create new comment, return created comment data.
    Given prepare url for "CREATE_COMMENT"
    When hit Api create comment
    Then should return status code 200
    Then validation response body
    Then validation response json with JSONSchema "create_comment.json"

  @negative
  Scenario: Create new comment, invalid user ID
    Given prepare url for "CREATE_COMMENT"
    When hit Api create comment invalid user ID
    Then should return status code 400
    And validation error response body


  @negative
  Scenario: Create new comment, invalid post ID
    Given prepare url for "CREATE_COMMENT"
    When hit Api create comment invalid post ID
    Then should return status code 400
    And validation error response body


  @negative
  Scenario: Create new comment, max char message (500)
  Expected : User get get response status code 400 , and response body "error": "BODY_NOT_VALID"
  Actual : User get status code 200 and success create new comment
    Given prepare url for "CREATE_COMMENT"
    When hit Api create comment max message
    Then should return status code 200
    Then validation response body
    Then validation response json with JSONSchema "create_comment.json"

  @positive
  Scenario: Delete comment by id, return id of deleted post
    Given prepare url for "CREATE_COMMENT"
    When hit Api create comment
    Then should return status code 200
    Then validation response body
    When hit API delete comment
    Then should return status code 200
    Then validation response body

