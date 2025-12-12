package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {
		
		BrowserUtil b = new BrowserUtil();
		
		WebDriver driver = b.initiDriver("chrome");
		
		b.launchUrl("https://jqueryui.com/droppable/");
		
		WebElement sourceEle = driver.findElement(By.id("draggable"));
		WebElement targetEle = driver.findElement(By.id("droppable"));
		
		Actions act =new Actions(driver);
		
		//act.clickAndHold(sourceEle).moveToElement(targetEle).release().build().perform();
		
		act.dragAndDrop(sourceEle, targetEle).build().perform();

	}

}
