package TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotations {
	
	// design testCases
	//golbal pre-condition 
	//pre condition 
	//test steps 
	//actual result vs expected result
	
	// status PASS/FAIL Executions
	
	@BeforeSuite
	public void connectWithDB() {
		System.out.println("BS- ConnectWithDB");

	}
	
	@BeforeTest
	public void createUser() {
		System.out.println("BT - create User");
	}
	
	@BeforeClass
	public void launchBrowser() {
		System.out.println("BC - launchBrowser");
	}
	
	@BeforeMethod
	public void loginToApplication() {
		System.out.println("BM - loginToApplication");
	}
	
	@Test
	public void homePageHeaderTest() {
		System.out.println("homePageHeaderTest");
	}
	
	@Test
	public void homePageTitleTest() {
		System.out.println("homePageTitleTest");
	}
	
	@Test
	public void searchTest() {
		System.out.println("SearchTest");
	}
	
	
	@AfterMethod
	public void logout() {
		System.out.println("AM - logOut");
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("AC - close browser");
	}
	
	@AfterTest
	public void deleteUser() {
		System.out.println("AT - delete User");
	}
	
	@AfterSuite
	public void disconnectWithDB() {
		System.out.println("AS - disconnectWithDB");
	}
	

}
