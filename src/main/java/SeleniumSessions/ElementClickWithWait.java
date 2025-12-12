package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementClickWithWait {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		ElementUtil e = new ElementUtil(driver);
		
		By name = By.name("proceed");
		
		e.ClickWhenReady(name, 3);

	}

}
