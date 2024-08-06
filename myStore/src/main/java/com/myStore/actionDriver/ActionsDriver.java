package com.myStore.actionDriver;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.myStore.base.BaseClass;

public class ActionsDriver extends BaseClass {
	public WebDriver driver;
	
	public void explicitlyWaitForElement(WebElement element, long waitTimeInSeceonds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSeceonds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void clickAndWait(WebElement element, long waitTimeInSeceonds) {
		try {
			wait(waitTimeInSeceonds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		explicitlyWaitForElement(element, waitTimeInSeceonds);
		element.click();
	}

	public boolean isElementPresent(WebElement element) {
		boolean flag = false;
		try {
			if (element.isDisplayed() || element.isEnabled()) {
				flag = true;
			}
		} catch (NoSuchElementException | StaleElementReferenceException e) {
			flag = false;
			System.out.println("Element is not displayed/ enabled");
		}
		return flag;
	}

	public void selectByVisibleText(WebElement dropDown, String visibleText) {
		Select sel = new Select(dropDown);
		sel.selectByVisibleText(visibleText);

	}

	public void selectByIndex(WebElement dropDown, int index) {
		Select sel = new Select(dropDown);
		sel.selectByIndex(index);
	}

	public void selectByValue(WebElement dropDown, String value) {
		Select sel = new Select(dropDown);
		sel.selectByValue(value);
	}

	public String sendKeysMethod(WebElement element, String value, long waitTimeInSeconds) {
		explicitlyWaitForElement(element, waitTimeInSeconds);
		element.click();
		element.clear();
		element.sendKeys(value);
		return value;
	}

	public void verifyTextElement(String comparingText, WebElement actualElement, String elementDescription,
			long waitTimeInSeconds) {
		explicitlyWaitForElement(actualElement, waitTimeInSeconds);
		String actualText = actualElement.getText();
		if (actualText.equals(comparingText)) {
			System.out.println("Text is matched");
		} else {
			System.out.println("Text is not matched");
		}
	}
	

	public void acceptAlert(WebElement alert) {
		alert.click();
	}

	public void scrollByVisibilityofElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
	}
	
	public void JSClick(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);
	}

	public void click(WebDriver ldriver, WebElement locatorName) {
		Actions act = new Actions(ldriver);
		act.moveToElement(locatorName).click().build().perform();
	}
	
	public void gettingPageTitle(WebDriver driver, String title)
	{
	  	title=driver.getTitle();
	}

	

}
