package TestNGFeatures;

import org.testng.annotations.Test;

public class DependsOnMethods {
	
	@Test(dependsOnMethods = "loginTest")
	public void homePageTest() {
		System.out.println("Home page test");
	}
	@Test
	public void loginTest() {
		System.out.println("Login page test");
		int i = 9/0;
	}
	@Test(dependsOnMethods = "loginTest")
	public void searchTest() {
		System.out.println("Search test");
	}
	
	
	
	// CRUD - dependsOnMethod. not advisable
	
	
	public void createUser(String name, int age) {
		System.out.println(name + " : "+ age);
	}
	
	public void updateUser(String name, int age) {
		System.out.println(name + " : "+ age);
	}
	
	public void deleteUser(String name, int age) {
		System.out.println(name +" : "+ age);
	}
	
	public void getUser(String name) {
		System.out.println(name);
	}
	
//	@Test
//	public void createUserTest() {
//		System.out.println("Create user Test");
//		createUser("tom", 10);
//	}
//	
//	@Test(dependsOnMethods = "createUserTest")
//	public void updateUserTest() {
//		System.out.println("Update user Test");
//		updateUser("tom", 20);
//		
//		
//	}
	
	// the point is, what-if the create user method fails, that would impact the updateUserTest isn't it? cause it is dependent on createUser method. 
	
	// all the test should always be independent to each other.
	
	@Test
	public void createUserTest() {
		System.out.println("create user Test");
		createUser("tom", 23);
	}
	
	@Test
	public void updateUserTest() {
		System.out.println("update user Test");
		createUser("tom", 25);
		updateUser("tom", 30);
	}
	
	@Test
	public void deleteUserTest() {
		System.out.println("delete user Test");
		createUser("peter", 25);
		deleteUser("peter", 25);
	}
	@Test
	public void getUserTest() {
		System.out.println("get user Test");
		createUser("peter", 25);
		getUser("peter");
	}

}
