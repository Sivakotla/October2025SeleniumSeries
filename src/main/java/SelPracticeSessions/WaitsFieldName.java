package SelPracticeSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitsFieldName {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		
		driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();
		
		By input = By.xpath("//input[@type='text']");
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		
		WebElement input2 = wait.until(ExpectedConditions.visibilityOfElementLocated(input));
		
		//driver.findElement(input).click();
		
		input2.sendKeys("SivaTest");
		
		

	}

}
