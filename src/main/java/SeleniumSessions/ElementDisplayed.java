package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementDisplayed {

	public static void main(String[] args) {
		
		
		BrowserUtil b = new BrowserUtil();
		
		WebDriver driver = b.initiDriver("chrome");
		
		b.launchUrl("https://classic.freecrm.com/register/");
		
//		boolean elementDisplay = driver.findElement(By.linkText("Home")).isDisplayed();
//		
//		System.out.println(elementDisplay);
		
		//boolean elemEnable = driver.findElement(By.name("username")).isEnabled();
		
		//boolean tagEnable = driver.findElement(By.tagName("h3")).isEnabled();
		
		//System.out.println(tagEnable);
		
		WebElement element = driver.findElement(By.id("submitButton"));
		
		System.out.println(element.isDisplayed());
		System.out.println(element.isEnabled());
		
		WebElement agreeCheck = driver.findElement(By.name("agreeTerms"));
		
		System.out.println(agreeCheck.isSelected());
		
		agreeCheck.click();
		
		System.out.println(agreeCheck.isSelected());
		
		System.out.println(element.isEnabled());
		
		//b.quitBrowser();

	}

}
