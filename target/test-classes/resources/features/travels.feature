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
Feature: Mercury hotel booking

Background: Given url of mercury travels and verify the title

  @hotel
  Scenario: Mercury travels hotel booking functionality
  
  Then  click on the hotels link and fill in the details
  And click on search hotels
  
  @faq
  Scenario: Faq
    Then mousehover on foriegn exchange
    And go to FAQ menu
    And click on 'Businees Travel'
    And click on 'Higher Studies'
    And click on 'Holiday Travel'
    
      

