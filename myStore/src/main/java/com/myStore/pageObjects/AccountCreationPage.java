package com.myStore.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.myStore.actionDriver.ActionsDriver;
import com.myStore.base.BaseClass;

public class AccountCreationPage extends BaseClass {
	public ActionsDriver actions = new ActionsDriver();

	@FindBy(xpath = "//input[@class='search_query form-control ac_input']")
	WebElement searchbox;
	@FindBy(xpath = "//h1[@class='page-heading']")
	WebElement accountpagetext;
	@FindBy(xpath = "//button[@name='submit_search']")
	WebElement clickOnSearch;

	public AccountCreationPage() {

		PageFactory.initElements(getDriver(), this);
		//PageFactory.initElements(getDriver(), this);
	}

	public String searchText() {
		actions.click(getDriver(), searchbox);
		return actions.sendKeysMethod(searchbox, "T-shirt", 2);
	}

	public void searchonclick() {
		clickOnSearch.click();	

	}

	public void accountPageTextVerification() {

		String actualtilte = "MY ACCOUNT";
		String expcetedtitle = accountpagetext.getText();
		Assert.assertEquals(actualtilte, expcetedtitle);
		System.out.println("page title matched");
	}

}
