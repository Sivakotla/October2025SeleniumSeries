package SeleniumSessions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public void doSendKeys(By locator, String keys) {
		getElement(locator).sendKeys(keys);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public String doGetText(By locator) {
		return getElement(locator).getText();
	}

	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public boolean doIsenabled(By locator) {
		return getElement(locator).isEnabled();
	}

	public boolean doIsSelected(By locator) {
		return getElement(locator).isSelected();
	}

	public String doGetAttributeValue(By locator, String attriName) {
		return getElement(locator).getAttribute(attriName);
	}

	public boolean checkElementDisabled(By locator, String attriName) {
		String attriValue = doGetAttributeValue(locator, attriName);
		if (attriValue.equals("true")) {
			return true;
		}
		return false;
	}

	public void doLinkClick(By locator, String linkValue) {
		List<WebElement> linksList = getElements(locator);
		System.out.println(linksList.size());

		for (WebElement e : linksList) {
			String linkText = e.getText();
			System.out.println(linkText);
			if (linkText.trim().equals(linkValue)) {

				e.click();
				break;

			}
		}
	}

	public boolean checkElementDisplayed(By locator) {
		if (getElements(locator).size() == 1)
			return true;

		return false;

	}

	public boolean checkElementDisplayed(By locator, int eleOccurance) {
		if (getElements(locator).size() == eleOccurance)
			return true;
		return false;

	}

	// ***************************************** Select dropDown Utils
	// *********************************************

	public void doSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public void doSelectByVisibleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}

	public void doSelectByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);
	}

	public static boolean isDropDownValueSelected(Select select, String value) {
		String exceValue = select.getFirstSelectedOption().getText();
		System.out.println(exceValue + " is selected");
		if (exceValue.equals(value))
			return true;
		return false;
	}

	public void doSelectDropDown(By locator, String value) {
		Select select = new Select(getElement(locator));
		List<WebElement> dropDownList = select.getOptions();
		iteratedropDownAndSelect(dropDownList, value);
	}

	public void selectDropDownWithOutSelectClass(By locator, String value) {
		List<WebElement> optionsList = getElements(locator);

		iteratedropDownAndSelect(optionsList, value);
	}

	private static void iteratedropDownAndSelect(List<WebElement> optionsList, String value) {

		System.out.println(optionsList.size());

		for (WebElement e : optionsList) {

			String listValue = e.getText();
			if (listValue.equals(value)) {
				e.click();
				break;
			}
		}

	}

	// ************************************* Actions Classes
	// ******************************************

	public void parentChildMenuHandle(By mainMenu, By subMenu) throws InterruptedException {

		Actions act = new Actions(driver);

		act.moveToElement(getElement(mainMenu)).build().perform();

		Thread.sleep(3000);

		doClick(subMenu);
	}

	public int getRightClickItemsCount(By rightClick, By list) {
		return getRightClickList(rightClick, list).size();
	}

	public void ClickOnRightClickItem(By rightClick, By list, String Item) {

		WebElement rightClickEle = getElement(rightClick);

		Actions act = new Actions(driver);

		act.contextClick(rightClickEle).perform();

		List<WebElement> listVal = getElements(list);
		System.out.println(listVal.size());
		for (WebElement e : listVal) {
			String text = e.getText();

			System.out.println(text);

			if (text.equals(Item)) {
				e.click();
				break;
			}

		}
	}

	public List<String> getRightClickList(By rightClick, By list) {

		ArrayList<String> rightClickValList = new ArrayList<>();

		WebElement rightClickEle = getElement(rightClick);

		Actions act = new Actions(driver);

		act.contextClick(rightClickEle).perform();

		List<WebElement> listVal = getElements(list);
		System.out.println(listVal.size());
		for (WebElement e : listVal) {
			String text = e.getText();

			rightClickValList.add(text);

		}
		return rightClickValList;
	}

	public void doActionSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).perform();
	}

	public void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}

	// 888888888888888888888888888888888888888888888888888888888 wait utils
	// **********************************

	public Alert waitForJSAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());

	}

	public void acceptAlert(int timeOut) {
		waitForJSAlert(timeOut).accept();
	}

	public void dismissAlert(int timeOut) {
		waitForJSAlert(timeOut).dismiss();
	}

	public String alertGetText(int timeOut) {
		Alert alert = waitForJSAlert(timeOut);
		String alertText = alert.getText();
		alert.accept();
		return alertText;
	}

	public void alertSendKeys(int timeOut, String value) {
		waitForJSAlert(timeOut).sendKeys(value);
	}

	public void waitForFrameUsingIDOrName(String frameIDOrName, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIDOrName));

	}

	public void waitForFrameUsingIndex(int frameIndex, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}

	public void waitForFrameUsingByLocator(int tiemOut, By frameLocator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(tiemOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}

	public void waitForFrameUsingWebElement(int timeOut, WebElement frameElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}

	public boolean waitForUrlContains(String urlFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.urlContains(urlFraction));
	}

	public boolean waitForUrlToBe(String urlValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.urlToBe(urlValue));
	}

	public String waitForTitleContains(int timeOut, String titleFraction) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if (wait.until(ExpectedConditions.titleContains(titleFraction))) {
			return driver.getTitle();
		}
		return null;
	}

	public String WaitForTitleToBe(int timeOut, String title) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if (wait.until(ExpectedConditions.titleIs(title))) {
			return driver.getTitle();
		}
		return null;
	}

	public WebElement waitForElementPresent(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

		// webEle.sendKeys(value);
	}

	public WebElement waitForElementPresent(By locator, long timeOut, long intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofMillis(intervalTime));

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

		// webEle.sendKeys(value);
	}

	public WebElement waitForElementVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement waitForElementToBeClickable(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));

	}

	public void ClickWhenReady(By locator, int timeOut) {
		waitForElementToBeClickable(locator, 10).click();
	}

	public List<WebElement> waitForElementForPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));

	}

	public List<String> getElementsTextList(By locator, int timeOut) {
		List<WebElement> listEle = waitForElementForPresence(locator, timeOut);

		List<String> EleListValues = new ArrayList<String>();

		for (WebElement e : listEle) {
			EleListValues.add(e.getText());
		}
		return EleListValues;
	}

	public void printElementsTextList(By locator, int timeOut) {
		List<WebElement> listEle = waitForElementForPresence(locator, timeOut);

		for (WebElement e : listEle) {
			System.out.println(e.getText());
		}
	}

	public List<String> getVisibleElementsTextList(By locator, int timeOut) {
		List<WebElement> listEle = waitForElementsVisible(locator, timeOut);

		List<String> EleListValues = new ArrayList<String>();

		for (WebElement e : listEle) {
			EleListValues.add(e.getText());
		}
		return EleListValues;
	}

	public List<WebElement> waitForElementsVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public void waitForElementPresentWithWebDriverWait(By locator, int timeOut, int pollingTime) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

		wait.withMessage(Error.TIME_OUT_WEB_ELEMENT_MESG).pollingEvery(Duration.ofMillis(pollingTime))
				.ignoring(StaleElementReferenceException.class, NoSuchElementException.class);

	}

	public WebElement waitForElementPresentWithFluentWait(By locator, int timeOut, int pollingTime) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.withMessage(Error.TIME_OUT_WEB_ELEMENT_MESG).pollingEvery(Duration.ofMillis(pollingTime))
				.ignoring(StaleElementReferenceException.class, NoSuchElementException.class);

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	public Alert waitForAlertPresentWithFluentWait(int timeOut, int pollingTime) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.withMessage(Error.TIME_OUT_ALERT_MESG).pollingEvery(Duration.ofMillis(pollingTime))
				.ignoring(NoAlertPresentException.class);

		return wait.until(ExpectedConditions.alertIsPresent());

	}

	public WebDriver waitForFramePresentWithFluentWait(By frameLocator, int timeOut, int pollingTime) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.withMessage(Error.TIME_OUT_FRAME_MESG).pollingEvery(Duration.ofMillis(pollingTime))
				.ignoring(NoAlertPresentException.class);

		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));

	}

	// ************************************************ Custom Util
	// *******************************************

	public WebElement retryingElement(By locator, int timeOut) {

		WebElement element = null;

		int attempts = 0;

		while (attempts < timeOut) {
			try {
				element = driver.findElement(locator);
				break;
			} catch (NoSuchElementException e) {
				System.out.println("Element is not found in attempts: " + attempts);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {

					e1.printStackTrace();
				}

			}
			attempts++;
		}

		return element;
	}

	public WebElement retryingElement(By locator, int timeOut, int pollingTime) {

		WebElement element = null;

		int attempts = 0;

		while (attempts < timeOut) {
			try {
				element = driver.findElement(locator);
				break;
			} catch (NoSuchElementException e) {
				System.out.println("Element is not found in attempts: " + attempts);
				try {
					Thread.sleep(pollingTime);
				} catch (InterruptedException e1) {

					e1.printStackTrace();
				}

			}
			attempts++;
		}
		if(element == null) {
			try {
			throw new Exception("");
			}catch(Exception e) {
				System.out.println("Element is not found exception...tried for: " + timeOut+ "with interval time of 500 ms");
			}
		}

		return element;
	}

}
