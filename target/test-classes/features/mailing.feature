Feature: Creating an email on yandex.com

@testTag
Scenario Outline: Mailing
Given user logins yandex
When creates an email 
And sent to <user>
Then the email should be sent to <user>

Examples:
|user|
|user1@test.am|
|user2@test.am|