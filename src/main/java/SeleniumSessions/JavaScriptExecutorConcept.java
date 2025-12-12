package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rise.anhtester.com/signin");
		
		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
		
		System.out.println(jsUtil.getTitleByJS());
		
		String innerText = jsUtil.getPageInnerText();
		
		//System.out.println(innerText);
		
		//jsUtil.generateAlert("i love the programming");
		
		jsUtil.refreshBrowserByJS();

	}

}
