package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MrBoolMoveToElement {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		
		BrowserUtil b = new BrowserUtil();
		
		 driver = b.initiDriver("Chrome");
		
		b.launchUrl("https://www.devmedia.com.br/");
		
		ElementUtil e = new ElementUtil(driver);
		
		//By parent = By.xpath("//span[text()='Artigos']");
		
		//By parent = By.id("btn-menu-mobile-artigo");
		
		//By parent = By.className("accordion-menu-title");
		
		By parent = By.id("container-menu-mobile-artigo");
		
		By child = By.linkText("Android");
		
		
		
		Actions act = new Actions(driver);
		
		act.moveToElement(driver.findElement(parent)).build().perform();
		
		//e.parentChildMenuHandle(parent, child);

	}

}
