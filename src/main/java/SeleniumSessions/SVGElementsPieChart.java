package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SVGElementsPieChart {

	static WebDriver driver;
	public static void main(String[] args) {
		
		String toolTip = "//*[local-name()='svg']//*[name()='g' and contains(@class,'highcharts-tooltip')]";
		
		driver = new ChromeDriver();
		
		driver.get("https://emicalculator.net/");
		
		String listXpath = "//*[local-name()='svg']//*[name()='g']//*[name()='path' and contains(@stroke-linejoin,'round') and contains(@class,'highcharts-point')]";
		
		List<WebElement> list = driver.findElements(By.xpath(listXpath));
		
		System.out.println(list.size());
		
		Actions act = new Actions(driver);
		
		for(WebElement e: list) {
			act.moveToElement(e).perform();
			WebElement listThings = driver.findElement(By.xpath(toolTip));
			System.out.println(listThings.getText());
		}
		

	}

}
