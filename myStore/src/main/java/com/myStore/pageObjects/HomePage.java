package com.myStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myStore.actionDriver.ActionsDriver;
import com.myStore.base.BaseClass;

public class HomePage extends BaseClass {

	public ActionsDriver actions;

	@FindBy(xpath = "//span[contains(text(),'Order history and details')]")
	WebElement orderHistory;

	@FindBy(xpath = "//span[contains(text(),'My credit slips')]")
	WebElement myCreditSlips;

	@FindBy(xpath = "//span[contains(text(),'My addresses')]")
	WebElement myAddress;

	@FindBy(xpath = "//span[contains(text(),'My personal information')]")
	WebElement myPersonalInformation;

	@FindBy(id = "SubmitCreate")
	WebElement createNewAccount;

	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void validateOredrHistory() {
		actions.isElementPresent(orderHistory);
	}

}
