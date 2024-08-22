@api
Feature: Test Delete User Automation Dummy API
  This feature allows users to test the deletion of an existing user via a dummy API for automation purposes.
  It is intended for testing and demonstration only

  @positive
  Scenario: Test delete data user by id
    Given prepare url for "GET_LIST_USER_BY_ID"
    And prepare valid id "669e2293de732a72b6f83f10"
    And hit API get user by id
    Then should return status code 200
    When user hit delete user data
    Then should return status code 200
    Then validation response delete user


  @negative
  Scenario: Test delete data user invalid id
    Given prepare url for "GET_LIST_USER_BY_ID"
    And prepare valid id "69581364"
    When user hit delete user data
    Then should return status code 400
    Then validation response body wrong id


