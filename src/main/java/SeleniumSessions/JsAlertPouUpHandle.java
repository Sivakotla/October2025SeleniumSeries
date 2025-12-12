package SeleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JsAlertPouUpHandle {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//driver.findElement(By.name("proceed")).click();
		
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		
		Alert alert = driver.switchTo().alert();
		
		Thread.sleep(5000);
		
		alert.sendKeys("This is my alert testing");
		
		String text = alert.getText();
		
		System.out.println(text);
		
		alert.accept();
		
		//alert.dismiss();
		
		//driver.switchTo().defaultContent();
		
		
		
		
		

	}

}
