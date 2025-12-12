package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HandleAtrribute {
	static WebDriver driver;
	public static void main(String[] args) {
		
		BrowserUtil b = new BrowserUtil();
		
		 driver = b.initiDriver("chrome");
		
		b.launchUrl("https://classic.freecrm.com/register/");
		
		By name = By.name("first_name");
		
		String value = driver.findElement(name).getAttribute("type");
		
		System.out.println(value);
		
//		String attriValue = driver.findElement(By.id("submitButton")).getAttribute("disabled");
//		
//		System.out.println(attriValue);
		
//		if(value.equals("true")) {
//			System.out.println("element is disabled");
//			
//		}
		
		boolean attributeValue = checkElementDisabled(name, value);
		
		System.out.println(attributeValue);
		
		

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	
	public static String doGetAttributeValue(By locator, String attriName) {
		return getElement(locator).getAttribute(attriName);
	}
	public static boolean checkElementDisabled(By locator, String attriName) {
		String attriValue =doGetAttributeValue(locator, attriName);
		if(attriValue.equals("true")) {
			return true;
		}
		return false;
	}

}
