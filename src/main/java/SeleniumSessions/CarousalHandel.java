package SeleniumSessions;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CarousalHandel {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		
		driver.get("https://www.noon.com/uae-en/");
		
		Thread.sleep(5000);
		
		String xpath = "//h2[text()='Recommended for you']//parent::div//parent::div//following-sibling::div//h2[@data-qa='product-box-name']";
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//
//		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
//		    By.xpath("//h2[contains(.,'Recommended for you')]/ancestor::div[1]/following-sibling::div[1]//h2[@data-qa='product-box-name']")));
		
		
		List<WebElement> recommList = driver.findElements(By.xpath("//h2[text()='Recommended for you']//parent::div//parent::div//following-sibling::div//h2[@data-qa='product-box-name']"));
		System.out.println(recommList.size());
		
		for(WebElement e : recommList) {
			String list = e.getText();
			System.out.println(list);
		}
		
		String button = "//h2[text()='Recommended for you']//parent::div//parent::div//following-sibling::div//button/*[local-name()='svg']//parent::button[contains(@class, 'EmblaCarouselArrowButtons-module-scss-module__YNpIRW__emblaNext')]";
//		List<String> prodList = new ArrayList<>(); 
		Set<String>  prodList = new TreeSet<>();
		
//		while(!driver.findElement(By.xpath(button)).getAttribute("type").contains("disabled")) {
//			for(WebElement e:recommList) {
//				String text = e.getText();
//				System.out.println(text);
//				if(!text.isEmpty()) {
//					prodList.add(text);
//				}
//			}
//			// click on next
////			driver.findElement(By.xpath(button)).click();
////			recommList = driver.findElements(By.xpath(xpath));
//		}
		// traverse the prod list
		
//		for(String e: prodList) {
//			System.out.println(e);
//		}
	}

}
