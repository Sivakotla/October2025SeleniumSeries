package TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginNegativeTest extends BaseTest {

	
	@DataProvider
	public Object[] [] getLoginData() {
		
		return new Object [] [] {
			
			{"test@gmail.com", "test@123"},
			{"naveenanimation@gmail.com", "test@123"},
			{"fdjklahguriey3#$%@gamil.com", "test@1234"},
			{"  ", "test@1234"},
			{"  ", "  "}
			
		};
	}
	
	
	
	
	@Test(dataProvider="getLoginData")
	public void loginTest(String username, String password) {

		Assert.assertTrue(doLogin(username, password));
	}

	public boolean doLogin(String username, String password) {
		
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(username);
		
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys(password);
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String error = driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).getText();
		if (error.contains("No match for E-Mail Address and/or Password.")) {
			return true;
		}
		return false;

	}

}
