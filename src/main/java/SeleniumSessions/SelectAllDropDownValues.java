package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectAllDropDownValues {
		static WebDriver driver;
	public static void main(String[] args) {
		
		
		BrowserUtil b = new BrowserUtil();
		
		 driver = b.initiDriver("chrome");
		
		b.launchUrl("https://www.orangehrm.com/en/book-a-free-demo");
		
//		WebElement country = driver.findElement(By.id("Form_getForm_Country"));
		
//		Select select = new Select(country);
//		
//		List<WebElement> totalList = select.getOptions();
//		
//		System.out.println("Total coutries list : " + totalList.size());
//		
//		for(WebElement e:totalList) {
//			String allCountries = e.getText();
//			System.out.println(allCountries);
//			if(allCountries.equals("India")) {
//				e.click();
//				break;
//			}
//		}
		
//		By dropDownElenent = By.id("Form_getForm_Country");
//		
//		doSelectDropDown(dropDownElenent);
		
//		List<WebElement> optionsList = driver.findElements(By.xpath("//select[@id='Form_getForm_Country']/option"));
//		
//		for(WebElement e:optionsList) {
//			String listValues = e.getText();
//			if(listValues.equals("Iran")) {
//				e.click();
//				break;
//			}
//		}
		
		By dropDownList= By.xpath("//select[@id='Form_getForm_Country']/option");
		
		selectDropDownWithOutSelectClass(dropDownList, "Iran");
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static void doSelectDropDown(By locator, String value) {
		Select select = new Select(getElement(locator));
		List<WebElement> dropDownList = select.getOptions();
		System.out.println("Total list Values: " + dropDownList.size());
		
		for(WebElement e:dropDownList) {
			String dropDownText = e.getText();
			System.out.println(dropDownText);
			if(dropDownText.equals(value)) {
				e.click();
				break;
			}
		}
	}
	
	public static void selectDropDownWithOutSelectClass(By locator, String value) {
		List<WebElement> optionsList = getElements(locator);
		
		for(WebElement e:optionsList) {
			String optionValues = e.getText();
			if(optionValues.equals(value)) {
				e.click();
				break;
			}
		}
	}
	
	public static void iteratedropDownAndSelect(List<WebElement> optionsList, String value) {
		
		System.out.println(optionsList.size());
		
		for(WebElement e: optionsList) {
			
			String listValue =e.getText();
			if(listValue.equals(value)) {
				e.click();
				break;
			}
		}
		
	}
	

}
