Feature: Testing Login User
  @Tugas
# PositifCase
  Scenario: Login users with valid id
    Given post login user with valid json email and password
    When send request login user
    Then should return status code 200
    And response body name should be token "QpwL5tke4Pnpja7X4"
    Then validate json schema login user

  @Tugas
# NegatifCase
  Scenario: Login users with invalid id
    Given post login user with invalid password json
    When send request invalid login user
    Then should return status code 400
    And response body name should be "Missing password"
    Then validate json schema invalid login user