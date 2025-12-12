package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementPresent {
	static WebDriver driver;

	public static void main(String[] args) {

		BrowserUtil b = new BrowserUtil();

		driver = b.initiDriver("chrome");

		b.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		By search = By.name("search");

		// List<WebElement> searchElement = driver.findElements(search);

		System.out.println(checkElementDisplayed(search));

	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public static boolean checkElementDisplayed(By locator) {
		if (getElements(locator).size() == 1)
			return true;

		return false;

	}
	
	public static boolean checkElementDisplayed(By locator, int eleOccurance) {
		if(getElements(locator).size() == eleOccurance) 
			return true; 
		return false;
		
	}

}
