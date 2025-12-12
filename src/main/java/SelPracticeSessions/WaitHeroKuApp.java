package SelPracticeSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHeroKuApp {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading");
		driver.findElement(By.xpath("//a[text()='Example 1: Element on page that is hidden']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Start']")).click();
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement element =wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish")));
		
		String text = element.getText();
		
		System.out.println(text);
		
		
	}

}
