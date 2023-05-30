package baseClass;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import rootClass.Rootclass;
import utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass extends Rootclass {

	Utility ut = new Utility();

	/**
	 * Method:initialSetup() will initiate the Web-driver and launch browser for
	 * executing scripts Browser name is parameterized from config.properties
	 * 
	 * @return Void
	 */
	@Before
	/**
	* Method: "initialSetup" is used to initiate execution 
	* @return void
	*/
	public void initialSetup() {
		
		System.out.println("initialSetup() is getting executed");
		String browserIE = ut.readProperty("ie", "config");
		String browserChrome = ut.readProperty("chrome", "config");
		String browserFirefox = ut.readProperty("firefox", "config");

		if (browserIE.equalsIgnoreCase("Yes")) {
	        WebDriverManager.chromedriver().setup();
			// Initialize browser
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
		} else if (browserChrome.equalsIgnoreCase("Yes")) {
	        WebDriverManager.chromedriver().setup();
			// Initialize browser
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--remote-allow-origins=*");
	        driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().getImplicitWaitTimeout();

		} else if (browserFirefox.equalsIgnoreCase("Yes")) {
			WebDriverManager.firefoxdriver().setup();
			// Initialize browser
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
	}

	/**
	 * Method:closeBrowser() is used to close the browser after execution
	 * 
	 * @return Void
	 */
	@After
	public void closeBrowser() {
		driver.quit();
	}
	//Merge conflict
}
