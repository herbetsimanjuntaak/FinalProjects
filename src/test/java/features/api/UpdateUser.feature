@UPDATE
Feature: Test Update User Automation Dummy API
  This feature allows users to test updating an existing user's information via a dummy API for automation purposes.

  @positive
  Scenario: Test update data user by id
    Given prepare url for "GET_LIST_USER_BY_ID"
    And prepare valid id "66a9f196dfd770b1d69c89fe"
    And hit API get user by id
    Then should return status code 200
    When user hit updated data
    Then should return status code 200
    Then validation response body update user
    Then validation response json with JSONSchema "update_valid_user.json"

  @negative
  Scenario: Test update data user invalid id
    Given prepare url for "GET_LIST_USER_BY_ID"
    And prepare valid id "69581364"
    When user hit updated data
    Then should return status code 400
    Then validation response body wrong id


