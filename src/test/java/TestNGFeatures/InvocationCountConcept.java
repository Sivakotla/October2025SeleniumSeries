package TestNGFeatures;

import org.testng.annotations.Test;

public class InvocationCountConcept {
	
	@Test(invocationCount = 10)
	public void createUserTest() {
		System.out.println("create User Test");
	}

	@Test(invocationCount = 100)
	public void getUserTest() {
		System.out.println("create User Test");
	}
}
