package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadPopUp {
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		
		driver.get("https://cgi-lib.berkeley.edu/ex/perl5/fup.html");
		
		// whenEver there is file uploading thing is there then in the DOM, type ="file" should be there. 
		
		driver.findElement(By.name("upfile")).sendKeys("/Users/sivarajareddykotla/Downloads/WhatsApp Image 2024-10-11 at 07.45.35.jpeg");
		

	}

}
