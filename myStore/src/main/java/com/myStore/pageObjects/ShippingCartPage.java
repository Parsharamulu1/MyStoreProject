package com.myStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.myStore.actionDriver.ActionsDriver;
import com.myStore.base.BaseClass;

public class ShippingCartPage extends BaseClass {
	public ActionsDriver actions = new ActionsDriver();

	@FindBy(xpath = "//h1[@id='cart_title']")
	WebElement shoppingCartSummary;

	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	WebElement proceedToCheckout;

	public ShippingCartPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void pageTextVerification() {
		String actualtilte = "SHOPPING-CART SUMMARY";
		String expcetedtitle = shoppingCartSummary.getText();
		Assert.assertEquals(actualtilte, expcetedtitle);
		System.out.println("shoppingCartSummary page title matched");
	}

	public void proceedToCheckOut() {
		actions.click(getDriver(), proceedToCheckout);
	}

}
