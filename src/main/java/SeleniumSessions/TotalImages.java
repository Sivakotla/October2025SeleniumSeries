package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TotalImages {

	public static void main(String[] args) {

		BrowserUtil b = new BrowserUtil();

		WebDriver driver = b.initiDriver("chrome");

		b.launchUrl("https://www.amazon.in/");

//		List<WebElement> imgList = driver.findElements(By.tagName("img"));
//		
//		System.out.println("Total images: " + imgList.size());
//		
//		for(int i=0; i<imgList.size(); i++) {
//			String srcValue = imgList.get(i).getAttribute("src");
//			String altValue = imgList.get(i).getAttribute("alt");
//			
//			System.out.println(srcValue + " : "+ altValue);
//	}

		List<WebElement> totalLinks = driver.findElements(By.tagName("a"));
		
		System.out.println("Total Links : " + totalLinks.size());
		
		for(int i =0; i<totalLinks.size(); i++) {
			String totalHrefs = totalLinks.get(i).getAttribute("href");
			String hrefTexts = totalLinks.get(i).getText();
			
			System.out.println(hrefTexts +" : "+ totalHrefs);
		}

	}

}
