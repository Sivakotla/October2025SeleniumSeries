package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		 driver = new ChromeDriver();
		
		driver.get("https://www.orangehrm.com/en/contact-sales");
		
//		driver.findElement(By.id("Form_getForm_FullName")).sendKeys("sivaSundar");
//		driver.findElement(By.id("Form_getForm_Email")).sendKeys("siva@gmail.com");
		
		By fullName = By.id("Form_getForm_FullName");
		By email = By.id("Form_getForm_Email");
		
//		driver.findElement(email).sendKeys("sivaSundar");
//		driver.findElement(fullName).sendKeys("siva@gmail.com");
		
//		WebElement emailId = driver.findElement(email);
//		WebElement fullNam = driver.findElement(fullName);
		
//		emailId.sendKeys("siva@gmai.com");
//		fullNam.sendKeys("Sivasundar");
		
		// generic functions
		
//		getElement(fullName).sendKeys("SivaSundar");
//		getElement(email).sendKeys("siva@gmail.com");
		
		WebElement fullNam = getElement(fullName);
		WebElement emailId = getElement(email);
		
		fullNam.sendKeys("sivaSundar");
		emailId.sendKeys("siva@gmail.com");

//		doSendKeys(email, "Siva@gmail.com");
//		doSendKeys(fullName, "SivaSundar");
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSendKeys(By locator, String keys) {
		getElement(locator).sendKeys(keys);
	}

}
