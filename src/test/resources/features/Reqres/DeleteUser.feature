Feature: Testing Delete User
  @Latihan
#Scenario Outline: Delete users with valid id
#Given delete user with valid id <id>
#When send request delete user
#Then should return status code 204
#Examples:
#| id |
#| 1  |
#| 2  |

 @Tugas
# PositifCase
  Scenario Outline: Delete users with valid id
    Given delete user with valid id <id>
    When send request delete user
    Then should return status code 204
      Examples:
        | id |
        | 10 |