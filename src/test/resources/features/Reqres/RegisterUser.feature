Feature: Testing Register User
  @Latihan
 Scenario Outline: Register users with valid id
    Given put register user with valid json with id 4
    When send request register user with email <email> and password <password>
    Then should return status code 200
  Examples:
    | email              | password |
    | eve.holt@reqres.in | pistol   |