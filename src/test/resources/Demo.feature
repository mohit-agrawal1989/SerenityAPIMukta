Feature: Demonstration of api tests

  Scenario: Find pet by status
    When user find the pet by status "available"
    Then verify the response

  Scenario: post a new pet
    When user enter pet name "automationPet1989"
    And user enter photourl "https://www.google.com"
    And user enter status of pet "available"
    Then verify pet is posted successfully