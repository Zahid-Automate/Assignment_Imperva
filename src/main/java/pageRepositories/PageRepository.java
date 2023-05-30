package pageRepositories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import rootClass.Rootclass;
import utility.ActionsClass;
import utility.Log;


public class PageRepository extends Rootclass {
	
	//========= OBJECTS INITIALIZATION =======//
	ActionsClass act = new ActionsClass();
	

	public PageRepository() {
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	//========= WEB ELEMENTS ==========//

	@FindBy(xpath = "//div[contains(text(),'Departments')]")
	public WebElement departmentsLoginPageButton;

	@FindBy(xpath = "//a[normalize-space()='Add New Department']")
	public WebElement departmentsAddNewButton;

	@FindBy(id = "name")
	public WebElement departmentName;

	@FindBy(id = "save")
	public WebElement saveButton;

	@FindBy(xpath = "//input[@data-qa='signup-email']")
	public WebElement signUpEmailField;
	
	@FindBy(xpath = "//input[@placeholder='Name']")
	public WebElement name;

	public static String table= "//table//tr";
	
	@FindBy(xpath="//select[@id='sel-dept']")
	public WebElement deptDropDown;
	
	
	//=====Reusable Methods======//
	
	public void selectDropDown(WebElement dropDown,String howTo, String value) {
		Select dropDownElement = new Select(dropDown);
		
		switch (howTo) {
		case "index":
		      dropDownElement.deselectByIndex(Integer.parseInt(value));
		      Log.info("DropDown value choosen is "+value);
		      break;
		case "value":
			  dropDownElement.selectByVisibleText(value);
			  Log.info("DropDown value choosen is "+value);
			  break;
		case "text":
			  dropDownElement.selectByValue(value);
			  Log.info("DropDown value choosen is "+value);
			  break;
		default : 
			Log.info("Please provide a valid value from the feature file, valid values are index , value , text");
			break;
		}	
	}
	

	

}
