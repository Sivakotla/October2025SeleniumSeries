package TestNGFeatures;

import org.testng.annotations.Test;

public class ExpectedExpectionConcept {
	
	String name;
	
	@Test(expectedExceptions = {NullPointerException.class, ArithmeticException.class})
	public void createUseTest() {
		System.out.println("Create User Test");
		int i = 9/0;
		ExpectedExpectionConcept obj = new ExpectedExpectionConcept();
		
		obj = null;
		obj.name = "Ram";
		
	}

}
