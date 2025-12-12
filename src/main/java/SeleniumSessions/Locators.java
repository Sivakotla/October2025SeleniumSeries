package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		 driver = new ChromeDriver();
		
		driver.get("https://www.freshworks.com/");
		
		By fullName = By.id("Form_getForm_FullName");
		
		//driver.findElement(fulName).sendKeys("SivaSundar");
		
		By name = By.name("FullName");
		//driver.findElement(name).sendKeys("RajaGopal");
		
		By inputText = By.className("input");
		
		//driver.findElement(inputText).sendKeys("Siva");
		
		
		By fulName= By.xpath("//*[@id=\"Form_getForm_FullName\"]");
		
		//driver.findElement(fulName).sendKeys("ShivaRajaKumar");
		
		
		By cssSelector = By.cssSelector("#Form_getForm_Contact");
		
		//driver.findElement(cssSelector).sendKeys("RamDevBaba");
		
		By linkText = By.linkText("Pricing");
		
		//driver.findElement(linkText).click();
		
		By parLinkText = By.partialLinkText("Platform");
		
		//driver.findElement(parLinkText).click();
		
		doClick(parLinkText);
		
		By tag = By.tagName("h2");
		
		//String textName = driver.findElement(tag).getText();
		
		//String textName = doGetText(tag);
		
		//System.out.println(textName);
		
		

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doClick(By locator) {
		getElement(locator).click();
	}
	
	public static String doGetText(By locator) {
		return getElement(locator).getText();
	}

}
