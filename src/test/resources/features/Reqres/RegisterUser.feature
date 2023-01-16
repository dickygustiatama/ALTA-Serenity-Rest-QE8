Feature: Testing Register User
@Tugas
Scenario: Register users with valid id
  Given post register user with valid json email and password
  When send request register user
  Then should return status code 200
  And response body name should be id 4 and token "QpwL5tke4Pnpja7X4"
  Then validate json schema register user