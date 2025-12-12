package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectHTMLTagDropDown {
		static WebDriver driver;
	public static void main(String[] args) {

		BrowserUtil b = new BrowserUtil();

		 driver = b.initiDriver("chrome");

		b.launchUrl("https://www.orangehrm.com/en/book-a-free-demo");

//		WebElement country = driver.findElement(By.id("Form_getForm_Country"));

//		Select sel = new Select(country);

		//sel.selectByIndex(4);
		
		//sel.selectByValue("Afghanistan");
		
//		sel.selectByVisibleText("India");
//		String text = sel.getFirstSelectedOption().getText();
//		System.out.println(text);
		
		By country = By.id("Form_getForm_Country");
		
		doSelectByVisibleText(country, "Bhutan");

	}
	
	public static WebElement getElement(By locator) {
		return  driver.findElement(locator);
	}
	
	public static void doSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	public static boolean doSelectByVisibleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
		return isDropDownValueSelected(select, text);
		
	}
	
	public static void doSelectByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);
	}
	
	public static boolean isDropDownValueSelected(Select select, String value) {
		String exceValue = select.getFirstSelectedOption().getText();
		System.out.println(exceValue+" is selected");
		if(exceValue.contains(value)) 
			return true;
		return false;
	}

}
