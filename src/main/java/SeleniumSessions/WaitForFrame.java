package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForFrame {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();

		driver.get("https://www.londonfreelance.org/courses/frames/index.html");

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		
//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("main"));
//		
//		String frameText = driver.findElement(By.xpath("html/body/h2")).getText();
//		
//		System.out.println(frameText);
//		
//		driver.switchTo().defaultContent();

//		waitForFrameUsingIDOrName("main", 5);
//
//		String frameText = driver.findElement(By.xpath("html/body/h2")).getText();
//
//		System.out.println(frameText);
		
		By frameLocator = By.name("main");
		
		waitForFrameUsingByLocator(5, frameLocator);
		
		String frameText = driver.findElement(By.xpath("html/body/h2")).getText();
		
		System.out.println(frameText);

	}

	public static void waitForFrameUsingIDOrName(String frameIDOrName, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIDOrName));

	}
	
	public static void waitForFrameUsingIndex(int frameIndex, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}
	
	public static void waitForFrameUsingByLocator(int tiemOut, By frameLocator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(tiemOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}
	
	public static void waitForFrameUsingWebElement(int timeOut, WebElement frameElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}

}
