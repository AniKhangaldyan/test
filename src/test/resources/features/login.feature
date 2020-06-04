Feature: Login yandex.com

@testTag
Scenario: Yandex login
Given user navigates to yandex.com
When enters user credentials
And  submit login button
Then yandex home page is displayed