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
@Department
Feature: Verify Departments CRUD operation

  @Departments
  Scenario Outline: User lauches home page and clicks on Departments
    When User clicks on Departments
    And User clicks on Add New Department
    Then User enters the Department Name as "<DepartmentName>"
    Then User clicks on Save 
    
    Then User verifies the presence of the name "<DepartmentName>" in the table
    
    Then User updates the "<DepartmentName>" in the table
    
    Then User deletes the "<DepartmentName>" in the table
    
   
  	
  