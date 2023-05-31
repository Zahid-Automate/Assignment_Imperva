package stepDefinition;


import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageRepositories.PageRepository;
import rootClass.Rootclass;
import utility.ActionsClass;

public class Departments extends Rootclass {
	ActionsClass act = new ActionsClass();
	PageRepository Departments = new PageRepository();

	private String DepartmentName;

	@When("User clicks on Departments")
	public void user_clicks_on_departments() {
		act.launchUrl();
		Departments.departmentsLoginPageButton.click();
	}

	@When("^User clicks on Add New Department$")
	public void user_clicks_on_add_new_department() {
		Departments.departmentsAddNewButton.click();
	}

	@Then("^User enters the Department Name as (.+)$")
	public void user_enters_the_department_name(String value) throws InterruptedException {
		DepartmentName = generateRandomName();
		Departments.Name.sendKeys(DepartmentName);
		System.out.println("DEBUG : Department name is "+ DepartmentName);
	}

	@Then("^User clicks on Save$")
	public void user_clicks_on_save() {
		Departments.saveButton.click();
	}

	@Then("^User verifies the presence of the name (.+) in the table$")
	public void user_verifies_the_presence_of_the_name_in_the_table() {
		act.waitForElement("//table//tbody/tr/td[contains(text(),'"+DepartmentName+"')]");
	}

	@Then("User updates the {string} in the table")
	public void user_updates_the_department_name_in_the_table() {
		driver.findElement(By.xpath("//td[normalize-space()='"+DepartmentName+"']//following::td//a[contains(text(),'Edit')]")).click();
		Departments.Name.click();
		Departments.Name.sendKeys("_UPDATED");
		Departments.saveButton.click();
		System.out.println("DEBUG : Updated Department name is "+DepartmentName+"_UPDATED");
	}

	@Then("User deletes the {string} in the table")
	public void user_deletes_the_department_name_in_the_table() {
		List<WebElement> rows = driver.findElements(By.xpath("//table//tr"));
		int lastIndex = rows.size() - 1;
		act.waitForElement("(//table[1]/tbody/tr)[last()]");
		String name = driver.findElement(By.cssSelector("tbody tr:nth-child("+lastIndex+") td:nth-child(2)")).getText();
		System.out.println("DEBUG : Deleted Department name is "+name);
		driver.findElement(By.xpath("(//a[@class='btn btn-danger'][normalize-space()='Delete'])["+lastIndex+"]")).click();
	}

	private String generateRandomName() {
		// Generate a random name (8 characters in this example)
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 8; i++) {
			int index = random.nextInt(characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}
}
