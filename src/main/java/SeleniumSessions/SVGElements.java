package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SVGElements {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		//*[local-name()='svg']//*[name()='g']
		//*[local-name()='svg']//*[name()='g' and @clip-path='url(#logo_svg__a)'], this is also giving one of one 
		
		//*[local-name()='svg']//*[name()='g' and contains(@clip-path,'url(#logo_svg__a)')], this is also giving one of one
		
		 driver = new ChromeDriver();
		 
		 driver.get("https://emicalculator.net/");
		 
		 Thread.sleep(3000);
		 
		 String vartiXpath = "//*[local-name()='svg']//*[name()='g' and @class='highcharts-series-group']//*[name()='rect']";
		 
		 String toolTipXpath = "//*[local-name()='svg']//*[name()='g' and contains(@class,'highcharts-tooltip')]//*[name()='text']";
		 
		 List<WebElement> barsList = driver.findElements(By.xpath(vartiXpath));
		 
		 System.out.println(barsList.size());
		 
		 Actions act = new Actions(driver);
		 
		 for(WebElement e:barsList) {
			 act.moveToElement(e).perform();
			 //Thread.sleep(500);
			 String text = driver.findElement(By.xpath(toolTipXpath)).getText();
			 System.out.println(text);
		 }

	}

}
