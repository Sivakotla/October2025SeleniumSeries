package SeleniumSessions;

import org.openqa.selenium.WebDriver;

public class AmazonTest {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		BrowserUtil b = new BrowserUtil();
		
		b.initiDriver("Chrome");
		
		//driver.get("https://www.youtube.com");java.lang.NullPointerException: Cannot invoke "org.openqa.selenium.WebDriver.get(String)" because "SeleniumSessions.AmazonTest.driver" is null
		//at SeleniumSessions.AmazonTest.main(AmazonTest.java:15)
		
		b.launchUrl("https://www.amazon.in");
		
		System.out.println(b.getPageTitle());
		System.out.println(b.getPageUrl());

	}

}
