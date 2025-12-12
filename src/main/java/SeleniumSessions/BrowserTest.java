package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserTest {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.abhibus.com");
		
		//driver.get("https://www.redbus.in");
		
		driver.findElement(By.id("login-link")).click();
		
		System.out.println(driver.getCurrentUrl());
	}

}
