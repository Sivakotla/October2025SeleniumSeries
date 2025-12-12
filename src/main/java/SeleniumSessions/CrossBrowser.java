package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class CrossBrowser {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		String browser = "ie";
		
		if(browser.equalsIgnoreCase("chrome")) {
			 driver = new ChromeDriver();
			
		}else if(browser.equalsIgnoreCase("firefox")) {
			 driver = new FirefoxDriver();
				
		}else if(browser.equalsIgnoreCase("safari")) {
			 driver = new SafariDriver();
				
		}else {
			System.out.println("please pass the correct browser: "+ browser);
		}
		
		driver.get("https://www.redbus.in");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.close();

	}

}
