Feature: Testing Create New User
#@Latihan
#Scenario: Post create new user with valid json
#Given post create user with valid json
#When send request post create user
#Then should return status code 201
#And response body name should be "Dicky Gustiatama" and job "QA Engineer"
##Then validate json schema create user

@Tugas
Scenario: Post create new user with valid json
  Given post create user with valid json
  When send request post create user
  Then should return status code 201
  And response body name should be "morpheus" and job "leader"
  Then validate json schema create user