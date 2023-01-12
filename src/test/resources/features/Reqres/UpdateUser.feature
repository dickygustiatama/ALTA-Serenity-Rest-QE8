Feature: Testing Update User
@Latihan
Scenario: Put update user with valid json
Given put update user with valid json with id 2
When send request put update user
Then should return status code 200
And response body name should be "Dicky Gustiatama" and job "QA Engineer"
And validate json schema update user


@Tugas
Scenario: Put update user with valid json
Given put update user with valid json with id 2
When send request put update user
Then should return status code 400