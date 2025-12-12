package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EcommSearch {

	public static void main(String[] args) throws InterruptedException {
		
		BrowserUtil b = new BrowserUtil();
		
		WebDriver driver = b.initiDriver("chrome");
		
		b.launchUrl("http://www.automationpractice.pl/index.php");
		
		driver.findElement(By.id("search_query_top")).sendKeys("Dress");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//li[contains(text(), 'Casual Dresses > Printed')]")).click();

	}

}
