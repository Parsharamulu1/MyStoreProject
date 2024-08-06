package com.myStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.myStore.actionDriver.ActionsDriver;
import com.myStore.base.BaseClass;

public class OrderSummaryPage extends BaseClass {
	public ActionsDriver actions = new ActionsDriver();

	@FindBy(xpath = "//h1[@class='page-heading']")
	WebElement orderSummaryText;

	@FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
	WebElement confirmMyOrder;

	public OrderSummaryPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void pageTextVerification() {
		String actualtilte = "ORDER SUMMARY";
		String expcetedtitle = orderSummaryText.getText();
		Assert.assertEquals(actualtilte, expcetedtitle);
		System.out.println("shipping page title matched");
	}

	public void iConfirmMyOrder() {
		actions.click(getDriver(), confirmMyOrder);
		
	}

}
