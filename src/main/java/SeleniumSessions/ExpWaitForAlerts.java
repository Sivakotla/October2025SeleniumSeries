package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExpWaitForAlerts {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		 driver = new ChromeDriver();
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.name("proceed")).click();
		
//		Alert alert = driver.switchTo().alert();
//		
//		String alertText = alert.getText();
//		
//		System.out.println(alertText);
//		
//		alert.accept();
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		
//		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//		
//		String alertText = alert.getText();
//
//		System.out.println(alertText);
//		
//		alert.accept();
		Alert alert = waitForJSAlert(10);
		
		System.out.println(alert.getText());
		
		alert.accept();
		
	}
	
	public static Alert waitForJSAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());
	
	}
	
	public static void acceptAlert(int timeOut) {
		waitForJSAlert(timeOut).accept();
	}
	
	public static void dismissAlert(int timeOut) {
		waitForJSAlert(timeOut).dismiss();
	}
	
	public  static String alertGetText(int timeOut) {
		 Alert alert = waitForJSAlert(timeOut);
		 String alertText =  alert.getText();
		  alert.accept();
		  return alertText;
	}
	
	public static void alertSendKeys(int timeOut, String value) {
		waitForJSAlert(timeOut).sendKeys(value);
	}

}
