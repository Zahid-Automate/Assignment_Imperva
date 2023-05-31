package stepDefinition;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pageRepositories.PageRepository;
import rootClass.Rootclass;
import utility.ActionsClass;

public class Employees extends Rootclass {
	PageRepository employees = new PageRepository();
	ActionsClass act = new ActionsClass();

	private String randomName;
	private String randomPhoneNumber;

	@When("User clicks on Employees")
	public void user_clicks_on_employees()  {
		act.launchUrl();
		employees.employeesLoginPageButton.click();
	}

	@When("In Employee CRUD application page User clicks on Add New Employee")
	public void in_employee_crud_application_page_user_clicks_on_add_new_employee() {
		String pageHeading = employees.pageHeading.getText();
		Assert.assertEquals(pageHeading, "Employee CRUD Application");
		employees.addNewEmployeeButton.click();
	}

	@Then("^User selects department as (.+) from Dept dropdown$")
	public void user_selects_department_as_information_technology_from_dept_dropdown(String value) {
		act.isEnableAndDisplay(employees.deptDropDown);
		employees.selectDropDown(employees.deptDropDown, "value", value);
	}


	@Then("User enters the employee name and phone")
	public void user_enters_the_employee_name_and_phone() {
		randomName = faker.name().fullName();
		randomPhoneNumber = faker.phoneNumber().cellPhone();
		employees.Name.sendKeys(randomName);
		employees.Phone.sendKeys(randomPhoneNumber);
	}

	@Then("User clicks on Save button")
	public void user_clicks_on_save_button() {
		employees.saveButton.click();
	}

	@Then("User verifies the presence of the newly added employee names in the grid")
	public void user_verifies_the_presence_of_the_newly_added_employee_names_in_the_grid()  {
		act.isEnableAndDisplay(employees.employeesLastPageNumberButton);
		String lastPageNumber = employees.employeesLastPageNumberButton.getText();
		System.out.println("DEBUG : Last page number in Employees is "+ lastPageNumber);
		employees.employeesLastPageNumberButton.click();

		//Capture name and phone present in the employees table
		String name = driver.findElement(By.xpath("//table//tbody/tr/td[contains(text(),'"+randomName+"')]")).getText();
		String phone = driver.findElement(By.xpath("//table//tbody/tr/td[contains(text(),'"+randomPhoneNumber+"')]")).getText();
		Assert.assertEquals(name,randomName);
		Assert.assertEquals(phone,randomPhoneNumber);
	}

	@Then("User edits the name of the employee")
	public void user_edits_the_name_of_the_employee() {
		act.isEnableAndDisplay(employees.employeesLastPageNumberButton);
		String lastPageNumber = employees.employeesLastPageNumberButton.getText();
		System.out.println("DEBUG : Last page number in Employees is "+ lastPageNumber);
		employees.employeesLastPageNumberButton.click();

		String name = employees.employeeNameLastrecord.getText();
		System.out.println("DEBUG : Employee name is "+name);

		//To click on edit button for a Employee Name
		employees.lastRecordEditButton.click();
		employees.Name.sendKeys("_UPDATED");
		employees.saveButton.click();
		act.clickOnElement(employees.employeesLastPageNumberButton);

		String employeeName = act.getText(employees.employeeNameLastrecord);
		System.out.println("DEBUG : Updated Employee name is "+employeeName);
		String actualName = employees.employeeNameLastrecord.getText();
		Assert.assertEquals(actualName,name+"_UPDATED");

	}

	@Then("User edits the Phone of the employee")
	public void user_edits_the_phone_of_the_employee() {
		act.isEnableAndDisplay(employees.employeesLastPageNumberButton);
		String lastPageNumber = employees.employeesLastPageNumberButton.getText();
		System.out.println("DEBUG : Last page number in Employees is "+ lastPageNumber);
		employees.employeesLastPageNumberButton.click();

		String phone = employees.employeePhoneLastrecord.getText();
		System.out.println("DEBUG : Employee Phone is "+phone);

		//To click on edit button for a updated Employee Phone
		employees.lastRecordEditButton.click();

		//act.clickOnElement(employees.employeesLastPageNumberButton);
		String updatedPhone = "1-222-202-2010";
		employees.Phone.clear();
		employees.Phone.sendKeys(updatedPhone);
		employees.saveButton.click();

		String employeePhone = act.getText(employees.employeePhoneLastrecord);
		System.out.println("DEBUG : Updated Employee Phone is "+employeePhone);
		String actualPhone = employees.employeePhoneLastrecord.getText();
		Assert.assertEquals(actualPhone,updatedPhone);

	}

	@Then("User edits the Name and Phone of the employee")
	public void user_edits_the_name_and_phone_of_the_employee() {
		act.isEnableAndDisplay(employees.employeesLastPageNumberButton);
		String lastPageNumber = employees.employeesLastPageNumberButton.getText();
		System.out.println("DEBUG : Last page number in Employees is "+ lastPageNumber);
		employees.employeesLastPageNumberButton.click();

		String name = employees.employeeNameLastrecord.getText();
		System.out.println("DEBUG : Employee name is "+name);

		String phone = employees.employeePhoneLastrecord.getText();
		System.out.println("DEBUG : Employee Phone is "+phone);

		//To click on edit button for a updated Employee Phone
		employees.lastRecordEditButton.click();

		String updatedPhone = "1-222-202-2010";
		employees.Phone.clear();
		employees.Phone.sendKeys(updatedPhone);

		//Update the Employee name
		employees.Name.sendKeys("_UPDATED");
		employees.saveButton.click();

		String employeeName = act.getText(employees.employeeNameLastrecord);
		System.out.println("DEBUG : Updated Employee name is "+employeeName);
		String actualName = employees.employeeNameLastrecord.getText();
		Assert.assertEquals(actualName,name+"_UPDATED");

		String employeePhone = act.getText(employees.employeePhoneLastrecord);
		System.out.println("DEBUG : Updated Employee Phone is "+employeePhone);
		String actualPhone = employees.employeePhoneLastrecord.getText();
		Assert.assertEquals(actualPhone,updatedPhone);

	}


}
