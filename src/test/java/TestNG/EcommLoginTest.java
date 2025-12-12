package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EcommLoginTest {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();

		driver.manage().window().fullscreen();

		driver.manage().deleteAllCookies();

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	}
	
	@Test
	public void userNameTest() {
		Assert.assertTrue(driver.findElement(By.id("input-email")).isDisplayed());
		
	}
	
	@Test
	public void passwordTest() {
		Assert.assertTrue(driver.findElement(By.id("input-password")).isDisplayed());
		
	}
	
	@Test
	public void submitButtonTest() {
		Assert.assertTrue(driver.findElement(By.xpath("//input[@type='submit']")).isEnabled());
	}
	
	@Test
	public void forgotPassWordTest() {
		Assert.assertTrue(driver.findElement(By.linkText("Forgotten Password")).isEnabled());
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
