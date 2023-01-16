Feature: Testing Update User
  @Latihan
#Scenario: Put update user with valid json
#Given put update user with valid json with id 2
#When send request put update user
#Then should return status code 200
#And response body name should be "Dicky Gustiatama" and job "QA Engineer"
#Then validate json schema update user


  @Tugas
# PositifCase
  Scenario: Put update user with valid json
    Given put update user with valid json with id 2
    When send request put update user
    Then should return status code 200
    And response body name should be "morpheus" and job "zion resident"
    Then validate json schema update user

  @Tugas
# NegatifCase
  Scenario: Put update user with invalid json
    Given put update user with invalid json with id 50
    When send request put update user
    Then should return status code 400
    And response body name should be "Username not yet registered"