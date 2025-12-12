package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CricInfo {
	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();

		driver.get(
				"https://www.espncricinfo.com/series/west-indies-in-new-zealand-2025-26-1491681/new-zealand-vs-west-indies-4th-t20i-1491726/full-scorecard");

		// driver.findElement(By.xpath("//span[text()='Amir Jangoo']/../..")).click();

		String bowler = driver
				.findElement(By.xpath("//span[text()='Alick Athanaze']/ancestor::td/following-sibling::td/span/span"))
				.getText();

		//System.out.println(bowler);

		//By score = By.xpath("//span[text()='Alick Athanaze']/ancestor::td/following-sibling::td");

//		List<WebElement> scoreList = driver.findElements(score);
//
//		for (int i = 1; i < scoreList.size(); i++) {
//			String scoreCard = scoreList.get(i).getText();
//			System.out.println(scoreCard);
//		}
		
		//String scores = "//span[text()='Alick Athanaze']/ancestor::td/following-sibling::td";
		
		batterStats("Amir Jangoo");
		batterStats("Alick Athanaze");
		

	}

	public static void batterStats(String xpath) {
		String score = "//span[text()='"+xpath+"']/ancestor::td/following-sibling::td";
		List<WebElement> scoreList= driver.findElements(By.xpath(score));
		
		for(int i=1; i<scoreList.size(); i++) {
			String scoreCard = scoreList.get(i).getText();
			System.out.println(scoreCard);
		}
	}

}
