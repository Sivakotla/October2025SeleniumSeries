package SelPracticeSessions;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FluentWaitConcept {
	static WebDriver driver;
	public static void main(String[] args) {
		
		 driver = new ChromeDriver();
		
		driver.get("https://www.hyrtutorials.com/p/waits-demo.html");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		WebElement eleClick = wait.until(ExpectedConditions.elementToBeClickable(By.id("btn1")));
		
		eleClick.click();
		
		
		Wait<WebDriver> fwait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofSeconds(500)).ignoring(NoSuchElementException.class);
		
		fwait.until(driver -> driver.findElement(By.id("btn2"))).click();

	}

}
