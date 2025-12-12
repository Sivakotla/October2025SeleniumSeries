package TestNGFeatures;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestEnableDisable {
	
	@Test
	public void createUserTest() {
		System.out.println("create user");
	}
	

	@Test
	public void updateUserTest() {
		System.out.println("update user");
	}
	

	@Test(enabled = true)
	public void deleteUserTest() {
		System.out.println("delete user");
	}
	
	@Ignore
	@Test(enabled = true, description="this is amzon get user Test....")
	public void getUserTest() {
		System.out.println("get user");
	}

}
