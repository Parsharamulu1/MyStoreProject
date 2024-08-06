package com.myStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.myStore.actionDriver.ActionsDriver;
import com.myStore.base.BaseClass;

public class OrderConfirmationPage extends BaseClass{
	
	public ActionsDriver actions = new ActionsDriver();
	
	@FindBy(xpath="//h1[@class='page-heading']")
	WebElement orderConfirmationText;
	
	@FindBy(xpath="//p[@class='alert alert-success']")
	WebElement successMessage;
	
	@FindBy(xpath="//a[@class='logout']")
	WebElement signOut;
	
	
	public OrderConfirmationPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	public void pageTextVerification() {
		String actualtilte = "ORDER CONFIRMATION";
		String expcetedtitle = orderConfirmationText.getText();
		Assert.assertEquals(actualtilte, expcetedtitle);
		System.out.println("shipping page title matched");
	}
	
	public void orderSuccessMessage() {
		String actualtilte = "Your order on My Shop is complete.";
		String expcetedtitle = successMessage.getText();
		Assert.assertEquals(actualtilte, expcetedtitle);
		System.out.println("shipping page title matched");
	}
	
	public void signout()
	{
		actions.click(getDriver(), signOut);
	}
	
	

}
