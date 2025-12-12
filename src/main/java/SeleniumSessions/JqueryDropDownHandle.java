package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JqueryDropDownHandle {

	static WebDriver driver;

	public static void main(String[] args) {

		BrowserUtil b = new BrowserUtil();

		driver = b.initiDriver("Chrome");

		b.launchUrl("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

		driver.findElement(By.id("justAnInputBox")).click();

		// List<WebElement> choiceList =
		// driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));

		By choices = By.xpath("//span[@class='comboTreeItemTitle']");
		// single selection
		// selectChoice(choices, "choice 1");

		// multi selection
		// selectChoice(choices, "choice 1", "choice 3", "choice 6 2 3");

		// all Selection
		selectChoice(choices, "ALL");

	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

//	public static void selchoice(By locator, String...value) {
//		List<WebElement> choiceList = getElements(locator);
//		for(int i=0; i<choiceList.size(); i++) {
//			WebElement list =  choiceList.get(i);
//			String listText = list.getText();
//		}
//	}
/**
 * This is method is used to select the choices from the drop down of single value selection or multiValue selection, All.
 * 1.single value
 * 2.multiple values
 * 3.all(please pass the value as all, All, ALL)
 * 
 * @param locator
 * @param value
 * 
 */
	public static void selectChoice(By locator, String... value) {

		List<WebElement> choiceList = getElements(locator);
		if (!value[0].equalsIgnoreCase("All")) {
			for (WebElement e : choiceList) {
				String text = e.getText();
				System.out.println(text);
				for (int i = 0; i < value.length; i++) {
					if (text.equals(value[i])) {
						e.click();
						break;
					}
				}
			}

		} else {
			try {
			for(WebElement e: choiceList) {
				e.click();
				break;
			}
			}catch(Exception e) {
				System.out.println("All choices selected.....");
			}
		}
	}

}
