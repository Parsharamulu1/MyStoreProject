package com.myStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.myStore.actionDriver.ActionsDriver;
import com.myStore.base.BaseClass;

public class PaymentPage extends BaseClass {
	public ActionsDriver actions = new ActionsDriver();

	@FindBy(xpath = "//h1[@class='page-heading']")
	WebElement paymentText;

	@FindBy(xpath = "//a[@class='bankwire']")
	WebElement payBankWire;

	public PaymentPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void pageTextVerification() {
		String actualtilte = "PLEASE CHOOSE YOUR PAYMENT METHOD";
		String expcetedtitle = paymentText.getText();
		Assert.assertEquals(actualtilte, expcetedtitle);
		System.out.println("shipping page title matched");
	}

	public OrderSummaryPage payByBankWire() {
		actions.click(getDriver(), payBankWire);
		return new OrderSummaryPage();
	}

}
