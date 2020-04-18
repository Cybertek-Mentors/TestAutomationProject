@activities
Feature: Create calendar event
  As user, I want to be able to create calendar events.

  Scenario: Create calendar event as sales manager
    Given user is on the login page
    When user logs in as a sales manager
    And user navigates to "Activities" and "Calendar Events"
    Then user clicks on create calendar event button
    And user enters "On this meeting we discuss what went well, what went wrong and what can be improved" as a description
    And user enters "Sprint Retrospective" as a title
    Then user click on save and close button
    And user verifies that description of new calendar event is "On this meeting we discuss what went well, what went wrong and what can be improved"
    And user verifies that title of new calendar event is "Sprint Retrospective"


  @create_calendar_event_2
  Scenario: Create calendar event as sales manager with data table
    Given user is on the login page
    When user logs in as a sales manager
    And user navigates to "Activities" and "Calendar Events"
    Then user clicks on create calendar event button
    And user enters new calendar event information:
      | description | On this meeting we discuss what went well, what went wrong and what can be improved |
      | title       | Sprint Retrospective                                                                |
    Then user click on save and close button
    And user verifies new calendar event was created successfully
      | description | On this meeting we discuss what went well, what went wrong and what can be improved |
      | title       | Sprint Retrospective                                                                |