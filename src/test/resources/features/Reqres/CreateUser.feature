Feature: Testing Create New User
  @Latihan
#Scenario: Post create new user with valid json
#Given post create user with valid json
#When send request post create user
#Then should return status code 201
#And response body name should be "Dicky Gustiatama" and job "QA Engineer"
##Then validate json schema create user


  @Tugas
  #PositifCase
  Scenario: Post create new user with valid json
    Given post create user with valid json
    When send request post create user
    Then should return status code 201
    And response body name should be "morpheus" and job "leader"
    Then validate json schema create user

  @Tugas
  #PositifCase
  Scenario: Post create new user without fill user job field json
    Given post create user without fill user job field json
    When send request post create user without fill user job field
    Then should return status code 201
    And response body name should be "morpheus" without job status
    Then validate json schema create user without fill user job field

  @Tugas
  #PositifCase
  Scenario: Post create new user without fill user name field json
    Given post create user without fill user name field json
    When send request post create user without fill user name field
    Then should return status code 201
    And response body job should be "leader" without name
    Then validate json schema create user without fill user name field