package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestContactSales {

	
	public static void main(String[] args) {
		
		BrowserUtil b= new BrowserUtil();
		
		WebDriver driver = b.initiDriver("chrome");
		
		b.launchUrl("https://www.orangehrm.com/en/contact-sales");
		
		ElementUtil e = new ElementUtil(driver);
		
		By fullName = By.id("Form_getForm_FullName");
		By email = By.id("Form_getForm_Email");
		By contact = By.id("Form_getForm_Contact");
		By company = By.id("Form_getForm_CompanyName");
		By job = By.id("Form_getForm_JobTitle");
		By comment = By.id("Form_getForm_Comment");
		
		e.doSendKeys(fullName, "SivaSundar");
		e.doSendKeys(email, "siva@gmail.com");
		e.doSendKeys(contact, "9849239573");
		e.doSendKeys(company, "abhibus");
		e.doSendKeys(job, "Automation Engineer");
		e.doSendKeys(comment, "The best deal we are looking here");
		

	}

}
