package SelPracticeSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class LoginWithIDs {

	public static void main(String[] args) {
		

		
		WebDriver driver = new SafariDriver();
		
		driver.get("https://practice.expandtesting.com/login");
		
		
		
		driver.findElement(By.id("username")).sendKeys("practice");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		
		
		driver.findElement(By.id("submit-login")).click();
		
		String flashMessage = driver.findElement(By.id("flash")).getText();
		
		System.out.println(flashMessage);
	}

}
