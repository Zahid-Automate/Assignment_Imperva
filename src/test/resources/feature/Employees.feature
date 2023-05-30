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
@Employees
Feature: Verify Departments Page

  @EmployeeCreate
  Scenario Outline: User lauches home page and adds an Employees
    When User clicks on Employees
    And In Employee CRUD application page User clicks on Add New Employee
    Then User selects department as <value> from Dept dropdown
    Then User enters the employee name and phone 
    Then User clicks on Save button
    Then User verifies the presence of the newly added employee names in the grid

    Examples: 
      | value                    | 
      | Information Technology   |
  
 @EmployeeNameEdit
  Scenario Outline: User lauches home page and adds an Employees
    When User clicks on Employees
    And In Employee CRUD application page User clicks on Add New Employee
    Then User selects department as <value> from Dept dropdown
    Then User enters the employee name and phone 
    Then User clicks on Save button
    Then User edits the "<name>" of the employee
    
    Examples: 
      | value                    | 
      | Human Resources          |
    
  @EmployeeePhoneEdit
  Scenario Outline: User lauches home page and adds an Employees
    When User clicks on Employees
    And In Employee CRUD application page User clicks on Add New Employee
    Then User selects department as <value> from Dept dropdown
    Then User enters the employee name and phone 
    Then User clicks on Save button
    Then User edits the Phone of the employee
    
   Examples: 
      | value                    | 
      | Finance                  |
  
 @EmployeeNameAndPhoneEdit
  Scenario Outline: User lauches home page and adds an Employees
    When User clicks on Employees
    And In Employee CRUD application page User clicks on Add New Employee
    Then User selects department as <value> from Dept dropdown
    Then User enters the employee name and phone 
    Then User clicks on Save button
    Then User edits the Name and Phone of the employee
    
  Examples: 
      | value                    | 
      | Marketing                |
