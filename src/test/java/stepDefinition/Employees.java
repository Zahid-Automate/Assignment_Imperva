package stepDefinition;


import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageRepositories.PageRepository;
import rootClass.Rootclass;
import utility.ActionsClass;
import com.github.javafaker.Faker;


public class Employees extends Rootclass {
	PageRepository employees = new PageRepository();
	ActionsClass act = new ActionsClass();
	
	private Faker faker;
    private String randomName;
    private String randomPhoneNumber;

   
	@When("User clicks on Employees")
	public void user_clicks_on_employees() {
		act.launchUrl();
		driver.findElement(By.xpath("//div[contains(text(),'Employees')]")).click();
	}

	@When("In Employee CRUD application page User clicks on Add New Employee")
	public void in_employee_crud_application_page_user_clicks_on_add_new_employee() {
		String pageHeading = driver.findElement(By.cssSelector("div[class='navbar-header'] h1")).getText();
		Assert.assertEquals(pageHeading, "Employee CRUD Application");
		driver.findElement(By.xpath("//a[normalize-space()='Add New Employee']")).click();
	}

	@Then("^User selects department as (.+) from Dept dropdown$")
	public void user_selects_department_as_information_technology_from_dept_dropdown(String value) {
		employees.selectDropDown(employees.deptDropDown, "value", value);
	}
	

	@Then("User enters the employee name and phone")
	public void user_enters_the_employee_name_and_phone() {
		randomName = faker.name().fullName();
        randomPhoneNumber = faker.phoneNumber().cellPhone();

		driver.findElement(By.id("name")).sendKeys(randomName);
		driver.findElement(By.id("phone")).sendKeys(randomPhoneNumber);
		
	}

	@Then("User clicks on Save button")
	public void user_clicks_on_save_button() {
		driver.findElement(By.id("save")).click();
	}

	@Then("User verifies the presence of the newly added employee names in the grid")
	public void user_verifies_the_presence_of_the_newly_added_employee_names_in_the_grid() throws InterruptedException {
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul//li[@id='tb-employee_next']/preceding::*[1]")));
	    act.isEnableAndDisplay(employees.deptDropDown);
		driver.findElement(By.xpath("//ul//li[@id='tb-employee_next']/preceding::*[1]"));
		String lastPageNumber = driver.findElement(By.xpath("//ul//li[@id='tb-employee_next']/preceding::*[1]")).getText();
	
		//WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='"+lastPageNumber+"']")));
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        //element.click();
		String name = driver.findElement(By.xpath("//table//tbody/tr/td[contains(text(),'"+randomName+"')]")).getText();
		String phone = driver.findElement(By.xpath("//table//tbody/tr/td[contains(text(),'"+randomPhoneNumber+"')]")).getText();
		Assert.assertEquals(name,randomName);
		Assert.assertEquals(phone,randomPhoneNumber);
	}

	@Then("User edits the {string} of the employee")
	public void user_edits_the_name_of_the_employee(String string){
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul//li[@id='tb-employee_next']/preceding::*[1]")));
		driver.findElement(By.xpath("//ul//li[@id='tb-employee_next']/preceding::*[1]"));
		String lastPageNumber = driver.findElement(By.xpath("//ul//li[@id='tb-employee_next']/preceding::*[1]")).getText();
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='"+lastPageNumber+"']"))).click();
		driver.findElement(By.xpath("//a[normalize-space()='"+lastPageNumber+"']")).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[last()]/td[2]")));
		String name = driver.findElement(By.xpath("//table/tbody/tr[last()]/td[2]")).getText();
	    System.out.println("DEBUG : Employee name is "+name);
	    
	    //To click on edit button
	    List<WebElement> rows2 = driver.findElements(By.xpath("//table//tr"));
		int lastIndex2 = rows2.size();
		driver.findElement(By.xpath("(//a[@class='btn btn-primary'][normalize-space()='Edit'])['"+lastIndex2+"']")).click();
		driver.findElement(By.id("name")).sendKeys("_UPDATED");
		driver.findElement(By.xpath("//input[@id='save']")).click();
	
	}

	@Then("User edits the Phone of the employee")
	public void user_edits_the_phone_of_the_employee() {
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul//li[@id='tb-employee_next']/preceding::*[1]")));
		driver.findElement(By.xpath("//ul//li[@id='tb-employee_next']/preceding::*[1]"));
		String lastPageNumber = driver.findElement(By.xpath("//ul//li[@id='tb-employee_next']/preceding::*[1]")).getText();
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='"+lastPageNumber+"']"))).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[last()]/td[2]")));
		String name = driver.findElement(By.xpath("//table/tbody/tr[last()]/td[2]")).getText();
	    System.out.println("DEBUG : Employee name is "+name);
	    
	    //To click on edit button
	    List<WebElement> rows2 = driver.findElements(By.xpath("//table//tr"));
		int lastIndex2 = rows2.size();
		driver.findElement(By.xpath("(//a[@class='btn btn-primary'][normalize-space()='Edit'])['"+lastIndex2+"']")).click();
		String updatedPhone = "1-222-202-2010";
		driver.findElement(By.id("phone")).clear();
		driver.findElement(By.id("phone")).sendKeys(updatedPhone);
		driver.findElement(By.xpath("//input[@id='save']")).click();
	}

	@Then("User edits the Name and Phone of the employee")
	public void user_edits_the_name_and_phone_of_the_employee() {
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul//li[@id='tb-employee_next']/preceding::*[1]")));
		driver.findElement(By.xpath("//ul//li[@id='tb-employee_next']/preceding::*[1]"));
		String lastPageNumber = driver.findElement(By.xpath("//ul//li[@id='tb-employee_next']/preceding::*[1]")).getText();
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='"+lastPageNumber+"']"))).click();
		driver.findElement(By.xpath("//a[normalize-space()='"+lastPageNumber+"']")).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[last()]/td[2]")));
		
		String name = driver.findElement(By.xpath("//table/tbody/tr[last()]/td[2]")).getText();
	    System.out.println("DEBUG : Employee name is "+name);
	    
	    //To click on edit button
	    List<WebElement> rows2 = driver.findElements(By.xpath("//table//tr"));
		int lastIndex2 = rows2.size();
		driver.findElement(By.xpath("(//a[@class='btn btn-primary'][normalize-space()='Edit'])['"+lastIndex2+"']")).click();
		String updatedPhone = "1-222-202-2010";
		driver.findElement(By.id("phone")).clear();
		driver.findElement(By.id("phone")).sendKeys(updatedPhone);
		
		String updatedName = "AutomationTester";
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys(updatedName);
		driver.findElement(By.xpath("//input[@id='save']")).click();
	}
	
	 @Before
	    public void setup() {
	        faker = new Faker();
	    }
		 
}
