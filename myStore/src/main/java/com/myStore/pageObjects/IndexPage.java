package com.myStore.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myStore.actionDriver.ActionsDriver;
import com.myStore.base.BaseClass;

public class IndexPage extends BaseClass {
	public ActionsDriver actions = new ActionsDriver();

	@FindBy(xpath = "//a[@class='login']")
	WebElement signInBtn;

	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement myStoreLogo;

	@FindBy(xpath = "//input[@name='search_query']")
	WebElement searchProductBox;

	@FindBy(xpath = "//button[@name='submit_search']")
	WebElement searchbutton;

	public IndexPage() {
		// instead of driver written getDriver() in all places wherever required
		PageFactory.initElements(getDriver(), this);
	}

	public LoginPage clickOnSignIn() {
		actions.click(getDriver(), signInBtn);
		return new LoginPage();
	}

	public boolean validateLogo() {
		return actions.isElementPresent(myStoreLogo);
	}

	public SearchResultPage searchProduct() {
		actions.sendKeysMethod(searchProductBox, "prodcutname", 10);
		actions.click(getDriver(), searchbutton);
		return new SearchResultPage();
	}

}
