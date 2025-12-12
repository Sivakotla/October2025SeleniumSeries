package SeleniumSessions;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
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

		driver.get("https://www.freshworks.com/");

		By reSource = By.linkText("Try it free11");

//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//										.withTimeout(Duration.ofSeconds(10))
//											.withMessage("Element is not found.....")
//												.pollingEvery(Duration.ofMillis(2000))
//													.ignoring(StaleElementReferenceException.class);
//		
//		wait.until(ExpectedConditions.presenceOfElementLocated(reSource)).click();

		waitForElementPresentWithFluentWait(reSource, 10, 2000).click();

	}

	public static void waitForElementPresentWithWebDriverWait(By locator, int timeOut, int pollingTime) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

		wait.withMessage(Error.TIME_OUT_WEB_ELEMENT_MESG).pollingEvery(Duration.ofMillis(pollingTime))
				.ignoring(StaleElementReferenceException.class, NoSuchElementException.class);

	}

	public static WebElement waitForElementPresentWithFluentWait(By locator, int timeOut, int pollingTime) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.withMessage(Error.TIME_OUT_WEB_ELEMENT_MESG).pollingEvery(Duration.ofMillis(pollingTime))
				.ignoring(StaleElementReferenceException.class, NoSuchElementException.class);

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	public static Alert waitForAlertPresentWithFluentWait(int timeOut, int pollingTime) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.withMessage(Error.TIME_OUT_ALERT_MESG).pollingEvery(Duration.ofMillis(pollingTime))
				.ignoring(NoAlertPresentException.class);

		return wait.until(ExpectedConditions.alertIsPresent());

	}
	
	public static WebDriver waitForFramePresentWithFluentWait(By frameLocator, int timeOut, int pollingTime) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.withMessage(Error.TIME_OUT_FRAME_MESG).pollingEvery(Duration.ofMillis(pollingTime))
				.ignoring(NoAlertPresentException.class);

		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));

	}

}
