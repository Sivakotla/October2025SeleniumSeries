package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDomElement {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://books-pwakit.appspot.com/");
		Thread.sleep(2000);
		
		//driver.findElement(By.id("input")).sendKeys("siva");
		
		//document.querySelector("body > book-app").shadowRoot.querySelector("#input")
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		WebElement input = (WebElement)js.executeScript("return document.querySelector(\"body > book-app\").shadowRoot.querySelector(\"#input\")");
		
		input.sendKeys("RadheShyam");
		
		

	}

}
