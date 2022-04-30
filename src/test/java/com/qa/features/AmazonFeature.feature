#Author: JyothiCyril
Feature: Validate the amazon application

  Background: invoke amazon application
    Given the user launches the browser
    When the url is entered
    Then the user should be landed on the home page

	@End2EndTest
  Scenario Outline: validate search an item feature in amazon web application
    Given the user selects "<Category>" as category
    Then the user types "<ItemName>" in the search text field
    When the magnifier button is clicked
    Then the title of the page should have "<ItemName>"
    Then the items related to search term should be loaded
    Then close the browser

    Examples: 
      | Category    | ItemName         |
      | Books       | Da Vinci Code    |
      | Electronics | Mobile Phones    |
      | Appliances  | Washing Machines |

	@RegressionTest
  Scenario: validate new user registration in amazon web application
    Given the user does mouse over on accounts and list element
    When the strat here link should be clicked
    Then the user should be navigated to registration page
    Then type "Roger Blake" as customer name
    Then close the browser

	@SmokeTest
  Scenario: validate the footer links present on the amazon home page
    Given the user to fetch all the footer links present on the page
    Then close the browser