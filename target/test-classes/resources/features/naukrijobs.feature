#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Naukri job seraching functionality

  Background: 
    Given when the url is provided  mousehover onjobs
    And click on jobsby location
    When switch to child window and enter  the skill and location  as chennai click on search

  @jobs
  Scenario: Job search
    And select the filter as last 3 days  and check the location as chennai
    And scroll down and click on next button  till disapears and click on last link

  @jobs1
  Scenario: Job search for nth page
  
  Then get the no pages and click on tenth page from the pages
  And click on first job profile
  Then take screenshot
   
