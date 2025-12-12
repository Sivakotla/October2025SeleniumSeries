package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandle {
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		
		driver.get("https://www.londonfreelance.org/courses/frames/index.html");
		
		//driver.switchTo().frame(2);
		driver.switchTo().frame("main");
		
		String frame = driver.findElement(By.xpath("/html/body/h2")).getText();
		
		System.out.println(frame);
		

	}

}
