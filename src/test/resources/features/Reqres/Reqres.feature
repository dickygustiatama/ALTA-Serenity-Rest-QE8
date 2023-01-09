Feature: Testing Reqres API ALTA QE
  @Latihan
  Scenario Outline: Get list users with valid parameter page reqres API
    Given get list user with page <page>
    When send request get list user
    Then should return status code 200
    And response body should page should be <page>

  Examples:
    | page |
    | 1    |
    | 2    |

  @Latihan
  Scenario: Post create new user with valid json
    Given post create user with valid json
    When send request post create user
    Then should return status code 200
    And response body name should be "Dicky Gustiatama" and job "QA Engineer"

  @Latihan
  Scenario: put update user with valid json
    Given put update user with valid json with id 2
    When send request put update user
    Then should return status code 200
    And response body name should be "Dicky Gustiatama" and job "QA Engineer"

  @Latihan
  Scenario Outline: Delete users with valid id
    Given delete user with valid id <id>
    When send request delete user
    Then should return status code 200
  Examples:
    | id |
    | 1  |
    | 2  |


