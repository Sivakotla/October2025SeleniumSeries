package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionClickSendKeys {
	static WebDriver driver;
	public static void main(String[] args) {
		
		BrowserUtil b = new BrowserUtil();
		
		 driver = b.initiDriver("chrome");
		
		b.launchUrl("https://www.orangehrm.com/en/book-a-free-demo");
		
//		WebElement name= driver.findElement(By.id("Form_getForm_FullName"));
//		WebElement email = driver.findElement(By.id("Form_getForm_Email"));
		
		By name = By.id("Form_getForm_FullName");
		By email = By.name("Email");
		
		By privacyPolicy = By.linkText("Privacy Policy.");
		
		//driver.findElement(email).sendKeys("siva@gmail.com");
		
		//driver.findElement(privacyPolicy).click();
		
		Actions act = new Actions(driver);
		
		//act.sendKeys(driver.findElement(name), "Siva").perform();
		//System.out.println("name value is put in name box");
		act.sendKeys(driver.findElement(email), "siva@gmail.com").perform();
		
		act.click(driver.findElement(privacyPolicy)).perform();
		
		

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doActionSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).perform();
	}
	
	public static void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}

}
