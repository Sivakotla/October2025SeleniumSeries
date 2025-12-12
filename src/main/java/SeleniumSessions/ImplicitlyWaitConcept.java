package SeleniumSessions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitlyWaitConcept {

	//@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://rise.anhtester.com/signin");
		
		By email = By.id("email");
		By password = By.id("password");
		
		By login = By.xpath("//button[@type='submit']");
		
		driver.findElement(email).sendKeys("admin523@gamil.com");
		driver.findElement(password).sendKeys("Admin@523");
		
		driver.findElement(login).click();
		
		driver.findElement(By.xpath("//span[text()='Notes']")).click();
		
		driver.findElement(By.xpath("//a[@title='Add note']")).click();
		
		driver.findElement(By.id("title")).sendKeys("My first Thing with ANH tester");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

}
