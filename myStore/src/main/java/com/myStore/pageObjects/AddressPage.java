package com.myStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.myStore.actionDriver.ActionsDriver;
import com.myStore.base.BaseClass;

public class AddressPage extends BaseClass {
	public ActionsDriver actions = new ActionsDriver();

	@FindBy(xpath = "//h1[@class='page-heading']")
	WebElement addressText;

	@FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
	WebElement proceedToCheckout;

	public AddressPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void pageTextVerification() {
		String actualtilte = "ADDRESSES";
		String expcetedtitle = addressText.getText();
		Assert.assertEquals(actualtilte, expcetedtitle);
		System.out.println("Address page title matched");
	}

	public void proceedToCheckoutFromAddressPage() {
		actions.click(getDriver(), proceedToCheckout);
		
	}

}
