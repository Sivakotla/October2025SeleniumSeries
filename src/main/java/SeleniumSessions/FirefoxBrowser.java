package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowser {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.redbus.in");
		
		System.out.println(driver.getCurrentUrl());
		
		System.out.println(driver.getTitle());

	}

}
