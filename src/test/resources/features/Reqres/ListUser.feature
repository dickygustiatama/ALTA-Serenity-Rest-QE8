Feature: Testing List User
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