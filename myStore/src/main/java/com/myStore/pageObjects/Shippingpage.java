package com.myStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.myStore.actionDriver.ActionsDriver;
import com.myStore.base.BaseClass;

public class Shippingpage extends BaseClass {

	public ActionsDriver actions = new ActionsDriver();

	@FindBy(xpath = "//h1[@class='page-heading']")
	WebElement shoppingText;

	@FindBy(xpath = "//input[@name='cgv']")
	WebElement checkBox;

	@FindBy(xpath = "//button[@name='processCarrier']")
	WebElement proceedToCheckOut;

	public Shippingpage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void pageTextVerification() {
		String actualtilte = "SHIPPING:";
		String expcetedtitle = shoppingText.getText();
		Assert.assertEquals(actualtilte, expcetedtitle);
		System.out.println("shipping page title matched");
	}

	public void checkBox() {
		actions.click(getDriver(), checkBox);
	}

	public void proceedToCheckout() {
		actions.click(getDriver(), proceedToCheckOut);

	}

}
