package TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FreshWorksTest extends BaseTest{

	
	@Test(priority=1)
	public void titleTest() {
		
		String title = driver.getTitle();
		Assert.assertEquals(title, "Freshworks: Uncomplicated Software | IT Service, Customer Service");
	}

	@Test(priority=2)
	public void logoTest() {
		Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='freshworks-logo']")).isDisplayed());
	}

	
}
