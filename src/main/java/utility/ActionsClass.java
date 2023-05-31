package utility;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rootClass.Rootclass;

public class ActionsClass extends Rootclass{


	Utility ut = new  Utility();

	/**
	 * Method: "getText" is used get the text of the element passed
	 * @param: "ele" the webelement should be passed to get text
	 * @return      String
	 */
	public String getText(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ele));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ele.getText();
	}

	/**
	 * Method: "waitForElement" is used get the text of the element passed
	 * @param: "ele" the Xpath String should be passed to get text
	 * @return      String
	 */
	public String waitForElement(String ele) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(ele)));
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(ele)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ele;
	}

	/**
	 * Method: "getAttribute" is used get the attribute of the element passed
	 * @param: "ele" the webelement should be passed to get the attribute
	 * @return      String
	 */
	public String getAttribute(String attribute, WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ele));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ele.getAttribute(attribute);
	}



	/**
	 * Method: "isEnableAndDisplay" is used check the webelement is present on the screen or not
	 * @param: "ele" the webelement should be passed
	 * @return      boolean
	 */
	public boolean isEnableAndDisplay(WebElement ele) {

		boolean status = false;
		try {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			if (ele.isDisplayed() && ele.isEnabled()) {
				status = true;
			}
		} catch (Exception e) {
			System.out.println("Element is not enabled and displayed");
		}

		return status;
	}

	/**
	 * Method: "clickOnElement" is used to click on the webelement
	 * @param: "ele" the webelement should be passed to click
	 * @return      void
	 */
	public void clickOnElement(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method: "javascriptClick" is used to click on the webelement using JS
	 * @param: "ele" the webelement should be passed to click
	 * @return      void
	 */
	public void javascriptClick(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", ele);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method: "getTheListOfStringFromFindElements" is used to get the list of String
	 * @param: "xpath" String should be passed to retrieve the corresponding List<String>
	 * @return      List<String>
	 */
	public List<String> getTheListOfStringFromFindElements(String xpath) {
		List<String> list = new ArrayList<String>();
		List<WebElement> we = driver.findElements(By.xpath(xpath));
		try {
			for (WebElement webElement : we) {
				list.add(webElement.getText());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * Method: "switchToChildWindow" is used to switch the browser windows
	 * @return      void
	 */
	public void switchToChildWindow() {

		String parentWindow = driver.getWindowHandle();
		try {
			for (String s : driver.getWindowHandles()) {
				if (!s.equals(parentWindow)) {
					driver.switchTo().window(s);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method: "launchUrl" is used to launch the desired URL
	 * URL is taken from the config.properties file
	 * @return      void
	 */
	public void launchUrl() {
		try {
			driver.get(ut.readProperty("url", "config"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
