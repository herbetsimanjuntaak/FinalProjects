@POSTING
Feature: CREATE,GET,UPDATE,DELETE Post Dummy API
  1. Get List
  Get list of posts sorted by creation date.

  2. Get List By User
  Get list of posts for specific user sorted by creation date.

  3. Get List By Tag
  Get list of posts for specific tag sorted by creation date.

  4. Get Post by id
  Get post full data by post id

  5.Get Post by id
  Get post full data by post id

  6.Update Post
  Update post by id, return updated Post data

  7.Delete Post
  Delete post by id, return id of deleted post

  @positive
  Scenario: Get list of posts sorted by creation date.
    Given prepare url for "GET_LIST_POST"
    When HIT API get list users
    Then should return status code 200
    Then validation response body
    Then validation response json with JSONSchema "get_list_post.json"

  @positive
  Scenario Outline: Test Get list of comments by query parameters page and limit
    Given prepare url for "GET_LIST_POST"
    And hit API get list user with parameters "<page>" and "<limit>"
    Then validation status code is equals 200
    Then validation response json with JSONSchema "get_list_post_params.json"
    And validate data user should be contain "<page>" and "<limit>"

    Examples:
      | page | limit |
      | 5    | 10    |
      | 999  | 50    |

  @positive
  Scenario: Get post full data by post id
    Given prepare url for "GET_LIST_POST"
    And prepare valid id "66b201cb5cbce57cf74b8302"
    When hit Api get post by id
    Then should return status code 200
    Then validation response body
    Then validation response json with JSONSchema "get_post_by_id.json"

  @positive
  Scenario: Get list of posts for specific user sorted by creation date.
    Given prepare url for "GET_LIST_POST_BY_USER_ID"
    And prepare valid id "60d0fe4f5311236168a109cf"
    When hit Api get list post by user id
    Then should return status code 200
    Then validation response body
    Then validation response json with JSONSchema "get_list_post_by_user_id.json"


  @positive
  Scenario: Test Create new post, return created post data.
    Given prepare url for "CREATE_POST"
    And hit API create post
    Then should return status code 200
    Then validation response body
    Then validation response json with JSONSchema "create_post.json"

  @negative
  Scenario: Test Create new post with empty owner
    Given prepare url for "CREATE_POST"
    When hit API create post empty owner
    Then should return status code 400
    Then validation response body empty owner

  @negative
  Scenario: Test Create new post with over maximum length characters (50)
  Expected : User get get response status code 400 , and response body "error": "BODY_NOT_VALID"
  Actual : User get status code 200 and success create new post
    Given prepare url for "CREATE_POST"
    When hit API create post max char
    Then should return status code 200

  @negative
  Scenario: Test Create new post invalid endpoint
    Given prepare url for "GET_ENDPOINT_WRONG"
    And hit API create post
    Then should return status code 404
    Then validation response body invalid endpoint

  @positive
  Scenario: Update post by id, return updated Post data
    Given prepare url for "UPDATE_POST"
    And prepare valid id "66b1d4c65cbce5d9fb4b76de"
    When hit API update post
    Then should return status code 200
    Then validation response json with JSONSchema "update_post.json"

  @positive
  Scenario: Test Create new post and then update post
    Given prepare url for "CREATE_POST"
    And hit API create post
    Then should return status code 200
    Then validation response body
    When hit API update post after create
    Then should return status code 200
    Then validation response json with JSONSchema "update_post.json"

  @positive
  Scenario: Delete post by id, return id of deleted post
    Given prepare url for "CREATE_POST"
    And hit API create post
    Then should return status code 200
    Then validation response body
    When hit API delete post
    Then should return status code 200
