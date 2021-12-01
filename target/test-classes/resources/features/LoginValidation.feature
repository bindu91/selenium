Feature: login verification for e commerce site

@reg
Scenario Outline: login verification for e commerce site

And click on Sign In button
Then type username as <username> 
And type <password>
Then click on login button 


Examples:

|username|password|
|test2323@gmail.com|assdfds|
|test@gmail.com|asfasd|
|test1@gmail.com|asfasd|
|test2@gmail.com|asfasd|
|test3@gmail.com|asfasd|


Scenario: Execute me multiple times
    Given I open the application
    And validate the credentials
    | username | password  |
      | user1    | password1 |
      | user2    | password2 |
      | user3    | password3 |
    And I close the application
