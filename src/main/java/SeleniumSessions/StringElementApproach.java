package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StringElementApproach {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		//By email = By.id("input-email");
		
		String email = "email";
		
		By emailId = getBy("id", email);
		
		//getElement(emailId).sendKeys("siva@gmail.com");\
		
		driver = new ChromeDriver();
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//doSendKeys(emailId, "siva@gmail.com");
		
		doSendKeys("name", email, "siva@gmail.com");

	}
	
	public static By getBy(String locatorType, String locatorValue) {
		
		System.out.println("type: "+ locatorType+" and " + " value: "+ locatorValue);
		By  locator = null;
		switch (locatorType.toLowerCase()) {
		case "id":
			locator = By.id(locatorValue);
			break;
		case "name":
			locator = By.name(locatorValue);
			break;
		case "xpath":
			locator = By.xpath(locatorValue);
			break;
		case "css":
			locator = By.cssSelector(locatorValue);
			break;
		case "linkText":
			locator = By.linkText(locatorValue);
			break;
		case "partialLinkText":
			locator = By.partialLinkText(locatorValue);
			break;
		case "classname":
			locator = By.className(locatorValue);
			break;
		case "tagName":
			locator = By.tagName(locatorValue);
			break;

		default:
			System.out.println("please pass the correct locator type.....");
			break;
		}
		
		return locator;
		
	}
	
	
	
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSendKeys(By locator, String value) {
		  getElement(locator).sendKeys(value);
	}
	
	public static void doSendKeys(String locatorType, String locatorValue, String value) {
		  getElement(getBy(locatorType, locatorValue)).sendKeys(value);
	}

}
