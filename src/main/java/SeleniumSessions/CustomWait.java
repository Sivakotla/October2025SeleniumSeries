package SeleniumSessions;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomWait {
	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();

		driver.get("https://rise.anhtester.com/signin");

		driver.findElement(By.id("email")).sendKeys("Automation@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Automation#543");

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		By notes = By.xpath("//span[text()='Notesn']");
		By addNote = By.xpath("//a[@title='Add note']");

		By title = By.xpath("//input[@placeholder='Title']");
		
		retryingElement(notes, 10,200).click();
		
		retryingElement(addNote, 10).click();
		
		retryingElement(title, 10).sendKeys("we are sending the data with retryingElement");
		

	}

	public static WebElement retryingElement(By locator, int timeOut) {

		WebElement element = null;

		int attempts = 0;

		while (attempts < timeOut) {
			try {
				element = driver.findElement(locator);
				break;
			} catch (NoSuchElementException e) {
				System.out.println("Element is not found in attempts: " + attempts);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {

					e1.printStackTrace();
				}

			}
			attempts++;
		}
		
		return element;
	}
	
	public static WebElement retryingElement(By locator, int timeOut, int pollingTime) {

		WebElement element = null;

		int attempts = 0;

		while (attempts < timeOut) {
			try {
				element = driver.findElement(locator);
				break;
			} catch (NoSuchElementException e) {
				System.out.println("Element is not found in attempts: " + attempts);
				try {
					Thread.sleep(pollingTime);
				} catch (InterruptedException e1) {

					e1.printStackTrace();
				}

			}
			attempts++;
		}
		
		return element;
	}
	

}
