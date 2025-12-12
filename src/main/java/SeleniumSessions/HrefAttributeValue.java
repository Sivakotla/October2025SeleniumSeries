package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HrefAttributeValue {

	public static void main(String[] args) {
		
		BrowserUtil b = new BrowserUtil();
		
		WebDriver driver = b.initiDriver("chrome");
		
		b.launchUrl("https://www.amazon.in/");
		
		String hrefValue= driver.findElement(By.linkText("About Amazon")).getAttribute("href");
		
		System.out.println(hrefValue);
		
		String imgValue = driver.
				findElement(By.xpath("//img[@alt=\"PAAM WOOD Modern Console Table, 55 x 15 x 30 inch, White Ribbed Design, Marble Top, Gold Accents, 4-Door Storage...\"]")).getAttribute("src");
		
		System.out.println(imgValue);

	}

}
