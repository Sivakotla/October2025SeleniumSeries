package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MoveToElementConcept {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		BrowserUtil b = new BrowserUtil();
		
		 driver = b.initiDriver("chrome");
		
		b.launchUrl("https://www.agriwatch.com/");
		
//		WebElement commodit = driver.findElement(By.linkText("Commodities"));
//		
//		Actions act = new Actions(driver);
//		
//		act.moveToElement(commodit).build().perform();
//		
//		driver.findElement(By.linkText("Sugar")).click();
		
		By parent = By.linkText("Commodities");
		
		By child = By.linkText("Rapeseed Oil");

		parentChildMenuHandle(parent, child);
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static void parentChildMenuHandle(By mainMenu, By subMenu) throws InterruptedException {
		
		Actions act = new Actions(driver);
		
		act.moveToElement(getElement(mainMenu)).build().perform();
		
		Thread.sleep(3000);
		
		getElement(subMenu).click();
	}

}
