package SeleniumSessions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExpWaitForListElements {

	static WebDriver driver;

	public static void main(String[] args) {

		 driver = new ChromeDriver();

		driver.get("https://www.freshworks.com/");

//		By footerList = By.xpath("//ul[@class='sc-ace17a57-0 sc-63e0c791-1 kTjuIu dRHBZS']/li");
//
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//
//		List<WebElement> footerEleList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(footerList));
//
//		for (WebElement e : footerEleList) {
//			System.out.println(e.getText());
//		}
		By footerList = By.xpath("//ul[@class='sc-ace17a57-0 sc-63e0c791-1 kTjuIu dRHBZS']/li");
		System.out.println(getElementsTextList(footerList, 5).size());
		
		printElementsTextList(footerList, 5);

	}
	
	public static void waitForElementsVisible(By locator, int timeOut){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public static List<WebElement> waitForElementForPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));

	}
	
	public static List<String> getElementsTextList(By locator, int timeOut) {
		List<WebElement> listEle = waitForElementForPresence(locator, timeOut);
		
		List<String> EleListValues = new ArrayList<String>();
		
		for(WebElement e:listEle) {
			EleListValues.add(e.getText());
		}
		return EleListValues;
	}
	
	public static void printElementsTextList(By locator, int timeOut) {
		List<WebElement> listEle = waitForElementForPresence(locator, timeOut);
		
		for(WebElement e:listEle) {
			System.out.println(e.getText());
		}
	}

}
