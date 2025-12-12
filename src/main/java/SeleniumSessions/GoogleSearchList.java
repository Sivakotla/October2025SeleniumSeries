package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchList {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		
		 driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
//		driver.findElement(By.name("q")).sendKeys("Selenium automation");
//		
//		Thread.sleep(3000);
//		
//		List<WebElement> suggestionList= driver.findElements(By.xpath("//ul[@role='listbox']//div[@class='wM6W7d']/span"));
//		System.out.println(suggestionList.size());
//		
//		for(WebElement e: suggestionList) {
//			String listValues = e.getText();
//			System.out.println(listValues);
//			if(listValues.equals("selenium automation testing with java")) {
//				e.click();
//				break;
//			}
//		}
		
//		By search = By.name("q");
//		By searchList = By.xpath("//ul[@role='listbox']//div[@class='wM6W7d']/span");
//		
//		googleSearchSelect(search, searchList, "Sdelenium", "selenium testing");
		
		By search = By.id("twotabsearchtextbox");
		By searchList = By.xpath("//div[@id='nav-flyout-searchAjax']//div/span");
		
		googleSearchSelect(search, searchList, "Dress", "ing table organiser");

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static List<WebElement> getElements (By locator) {
		return driver.findElements(locator);
	}
	
	public static void googleSearchSelect(By search, By suggestion, String searchKey, String suggestionListValue) throws InterruptedException {
		getElement(search).sendKeys(searchKey);
		
		Thread.sleep(300);
		
		List<WebElement> listValues = getElements(suggestion);
		System.out.println(listValues.size());
		for(WebElement e : listValues) {
			String suggestionList = e.getText();
			System.out.println(suggestionList);
			if(suggestionList.equals(suggestionListValue)) {
				e.click();
				break;
			}
		}
	}

}
