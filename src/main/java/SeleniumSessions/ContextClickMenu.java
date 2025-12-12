package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextClickMenu {
	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();

		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

//		WebElement rightClick = driver.findElement(By.xpath("//span[text()='right click me']"));
//		
//		Actions act = new Actions(driver);
//		//act.moveToElement(rightClick).build().perform(); = this will not perform the right click. 
//		
//		act.contextClick(rightClick).perform();
//		
//		List<WebElement> list = driver.findElements(By.xpath("//ul[@class='context-menu-list context-menu-root']/li/span"));
//		
//		System.out.println(list.size());
//		
//		for(WebElement e: list) {
//			String listEle = e.getText();
//			//System.out.println(listEle);
//			
//			
//			
//			
//		}

		By targetEle = By.xpath("//span[text()='right click me']");

		By menuList = By.xpath("//ul[@class='context-menu-list context-menu-root']/li/span");

//		List<String> actList = getRightClickList(targetEle, menuList);
//		
//		if(actList.contains("Copy")) {
//			System.out.println("Copy is present");
//		}

//		int size = getRightClickItemsCount(targetEle, menuList);
//
//		System.out.println(size);
		
		ClickOnRightClickItem(targetEle, menuList, "Cut");

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public static int getRightClickItemsCount(By rightClick, By list) {
		return getRightClickList(rightClick, list).size();
	}

	public static void ClickOnRightClickItem(By rightClick, By list, String Item) {
		

		WebElement rightClickEle = getElement(rightClick);

		Actions act = new Actions(driver);

		act.contextClick(rightClickEle).perform();

		List<WebElement> listVal = getElements(list);
		System.out.println(listVal.size());
		for (WebElement e : listVal) {
			String text = e.getText();

			System.out.println(text);
			
			if(text.equals(Item)) {
				e.click();
				break;
			}

		}
	}

	public static List<String> getRightClickList(By rightClick, By list) {

		ArrayList<String> rightClickValList = new ArrayList<>();

		WebElement rightClickEle = getElement(rightClick);

		Actions act = new Actions(driver);

		act.contextClick(rightClickEle).perform();

		List<WebElement> listVal = getElements(list);
		System.out.println(listVal.size());
		for (WebElement e : listVal) {
			String text = e.getText();

			rightClickValList.add(text);

		}
		return rightClickValList;
	}

}
