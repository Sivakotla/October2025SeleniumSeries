package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaitConcept {
	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();

		driver.get("https://rise.anhtester.com/signin");

		By email = By.id("email");
		By password = By.id("password");

		By login = By.xpath("//button[@type='submit']");

		driver.findElement(email).sendKeys("admin523@gamil.com");
		driver.findElement(password).sendKeys("Admin@523");

		driver.findElement(login).click();

		driver.findElement(By.xpath("//span[text()='Notes']")).click();

		driver.findElement(By.xpath("//a[@title='Add note']")).click();

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//		WebElement title = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("title")));
//
//		title.sendKeys("WebDriver waits with ANH tester");
		
		By title = By.id("title");
		By description = By.id("description");
		
		waitForElementPresent(title, 10, 2000).sendKeys("WebDriver waits with ANH tester");
		waitForElementPresent(description,5).sendKeys("We are checking the waits concept with webDriverwait so yeah");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

	public static WebElement waitForElementPresent(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

		// webEle.sendKeys(value);
	}
	
	public static WebElement waitForElementPresent(By locator, int timeOut, int intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofMillis(intervalTime));

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

		// webEle.sendKeys(value);
	}

}
