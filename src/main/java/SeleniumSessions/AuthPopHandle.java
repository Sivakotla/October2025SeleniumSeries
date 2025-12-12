package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthPopHandle {
	
	static WebDriver driver;
	

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		
		String userName = "admin";
		String passWord = "admin";
		
		driver.get("https://"+userName+":"+passWord+"@the-internet.herokuapp.com/basic_auth");

	}

}
