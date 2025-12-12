package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForUrlAndTitle {
	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

//		if (wait.until(ExpectedConditions.titleContains("Login"))) {
//			System.out.println(driver.getTitle());
//		}

//		driver.findElement(By.linkText("Register")).click();
//		
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

//		if(wait.until(ExpectedConditions.urlContains("route=account/register"))) {
//			System.out.println(driver.getCurrentUrl());
//		}

//		if(wait.until(ExpectedConditions.urlToBe("https://naveenautomationlabs.com/opencart/index.php?route=account/register"))) {
//			System.out.println(driver.getCurrentUrl());
//		}

//		if(waitForUrlContains("route=account/register", 5)) {
//			System.out.println("register url is correct");
//		}
		
//		System.out.println(waitForTitleContains(5, "Login"));
		
		String title = waitForTitleContains(5, "Login");
		
		System.out.println(title);
		
		driver.findElement(By.linkText("Register")).click();
		
		String titleReg = waitForTitleContains(5, "Register");
		System.out.println(titleReg);

	}

	public static boolean waitForUrlContains(String urlFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.urlContains(urlFraction));
	}

	public static boolean waitForUrlToBe(String urlValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.urlToBe(urlValue));
	}

	public static String waitForTitleContains(int timeOut, String titleFraction) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if(wait.until(ExpectedConditions.titleContains(titleFraction))){
			return driver.getTitle();
		}
		return null;
	}
	
	public static String WaitForTitleToBe(int timeOut, String title) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if(wait.until(ExpectedConditions.titleIs(title))) {
			return driver.getTitle();
		}
		return null;
	}

}
