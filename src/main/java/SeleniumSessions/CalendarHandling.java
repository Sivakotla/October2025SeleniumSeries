package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarHandling {
	static WebDriver driver;
	public static void main(String[] args) {
	driver = new ChromeDriver();
	
	driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
	
	driver.findElement(By.id("datepicker")).click();
	
	//selectDate("30");
	
//	String actMonthYear = driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();
//	
//	System.out.println(actMonthYear);
	
//	String expMonthYear = "November 2030";
	
//	while(!actMonthYear.equals(expMonthYear)) {
//		//click on next
//		driver.findElement(By.xpath("//span[text()='Next']")).click();
//		actMonthYear = driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();
//	}
//	selectDay("10");
	
	selectDate("November 2027", "30");
	
	}
	
	public static void selectDate(String expMonthYear, String day) {
		
		if(Integer.parseInt(day)>=30) {
			System.out.println("wrong day passed... please pass the correct Day between 1 to 31");
		}
		
		String actMonthYear = driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();
		
		//System.out.println(actMonthYear);
		
		while(!actMonthYear.equalsIgnoreCase(expMonthYear)) {
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			actMonthYear = driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();
		}
		selectDay(day);
	}
	
	public static void selectDay(String date) {
		driver.findElement(By.xpath("//a[text()='"+date+"']")).click();
	}
	
}
