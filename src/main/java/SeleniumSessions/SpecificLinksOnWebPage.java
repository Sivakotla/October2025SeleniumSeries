package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SpecificLinksOnWebPage {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		BrowserUtil b = new BrowserUtil();
		
		 driver = b.initiDriver("Chrome");
		
		b.launchUrl("https://www.w3.org/");
		
//		List<WebElement> headerLinks = driver.findElements(By.xpath("//nav[@id='header-right-nav']/a"));
//		
//		System.out.println(headerLinks.size());
//		
//		for(int i =0; i<headerLinks.size();i++) {
//			String linkText = headerLinks.get(i).getText();
//			System.out.println(linkText);
//			
//			if(linkText.equals("Need Help?")) {
//				headerLinks.get(i).click();
//				break;
//			}
//			
//		}
		
//		By headerLinks = By.xpath("//nav[@id='header-right-nav']/a");
//		
//		doLinkClick(headerLinks, "Login/SignUp");
		
		//By footerLinks = By.xpath("//div[@class='global-footer__links']//a");
		
		//doLinkClick(footerLinks, "W3C on GitHub");
		
		By footerList = By.xpath("//footer//a");
		
		doElementClick(footerList, "liability");
		
		
	}
	
	public static List<WebElement> getElements(By locator){
		return driver.findElements(locator);
	}
	
	public static void doElementClick(By locator, String text) {
		List<WebElement> linkList = getElements(locator);
		System.out.println("Total links: " + linkList.size());
		
		for(WebElement e : linkList) {
			String links = e.getText();
			System.out.println(links);
			if(links.equals(text)) {
				e.click();
				break;
			}
			
		}
		
	}

}
