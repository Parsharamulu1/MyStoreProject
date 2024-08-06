package com.myStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.myStore.actionDriver.ActionsDriver;
import com.myStore.base.BaseClass;

public class LoginPage extends BaseClass {
	public ActionsDriver actions = new ActionsDriver();


	@FindBy(xpath = "//input[@id='email']")
	WebElement userName;

	@FindBy(xpath = "//input[@id='passwd']")
	WebElement passWord;

	@FindBy(id = "SubmitLogin")
	WebElement signInBtn;

	@FindBy(xpath = "//input[@id='email_create']")
	WebElement emailForNewAccount;

	@FindBy(id = "SubmitCreate")
	WebElement createNewAccount;
	
	@FindBy(xpath= "//h1[@class='page-heading']")
	WebElement pageText;

	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public HomePage login() {
		actions.sendKeysMethod(userName, prop.getProperty("username"), 10);
		actions.sendKeysMethod(passWord, prop.getProperty("password"), 10);
	//	actions.sendKeysMethod(userName, uname, 10);
	//	actions.sendKeysMethod(passWord, pwd, 10);
		actions.click(getDriver(), signInBtn);
		return new HomePage();
	}

	public AccountCreationPage createNewAccount() {
		actions.sendKeysMethod(createNewAccount, "email", 10);
		actions.click(getDriver(), createNewAccount);
		return new AccountCreationPage();
	}
		
		public HomePage clickOnSignIn() {
			actions.click(getDriver(), signInBtn);
			return new HomePage();
	}
		public void pageTextVerification()
		{
			String actualtilte="AUTHENTICATION";
			String expcetedtitle=pageText.getText();
			Assert.assertEquals(actualtilte, expcetedtitle);
			System.out.println("page title matched");
		}

}
