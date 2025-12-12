package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseVsQuit {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://WWW.bsrtravels.com");
		
		String title = driver.getTitle();
		System.out.println(title);
		
		System.out.println(driver.getCurrentUrl());
		
		//driver.quit();
		driver.close();
		title = driver.getTitle();
		System.out.println(driver.getCurrentUrl());
		
		System.out.println(title);
		System.out.println(driver.getCurrentUrl());

	}

}
