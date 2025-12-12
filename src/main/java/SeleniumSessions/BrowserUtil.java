package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserUtil {
	
	static WebDriver driver;
	
	public WebDriver initiDriver(String browser) {
		
		System.out.println("Browser name is: "+ browser);
		
		if(browser.equalsIgnoreCase("chrome")) {
			 driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			 driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("safari")) {
			 driver = new ChromeDriver();
		}else {
			System.out.println("please pass the correct browser");
		}
		
		return driver;
	}
	
	public void launchUrl(String url) {
		if(url==null ||url.isEmpty()) {
			System.out.println("palease pass the correct url");
			return;
		}
		driver.get(url);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	public void quitBrowser() {
		driver.quit();
	}

}
