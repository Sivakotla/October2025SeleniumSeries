package TestNGFeatures;

import org.testng.annotations.Test;

public class PriorityConcept {
	
	@Test(priority= 2)
	public void a_test() {
		System.out.println("A test");
	}

	@Test(priority= 3)
	public void b_test() {
		System.out.println("B test");
	}

	@Test(priority= 6)
	public void c_test() {
		System.out.println("C test");
	}

	@Test(priority= 5)
	public void d_test() {
		System.out.println("D test");
	}

	@Test(priority= 4)
	public void e_test() {
		System.out.println("E test");
	}

	@Test(priority= 1)
	public void f_test() {
		System.out.println("F test");
	}

}
