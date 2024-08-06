package com.myStore.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.myStore.actionDriver.ActionsDriver;
import com.myStore.base.BaseClass;

public class SearchResultPage extends BaseClass {
	public WebDriver driver;
	public ActionsDriver actions=new ActionsDriver();
	
	@FindBy(xpath = "//h1[@class='page-heading  product-listing']")
	WebElement searchPageText;
	
	@FindBy(xpath = "//input[@class='search_query form-control ac_input']")
	WebElement searchBox;

	@FindBy(xpath = "//button[@name='submit_search']")
	WebElement surchbutton;

	@FindBy(xpath = "//div[@id='best-sellers_block_right']/descendant::li[1]")
	WebElement productSelect;
	
	
	
	
	
	public SearchResultPage()
	{
		PageFactory.initElements(driver, this);
	}
		
	
	public void clickSearchBox( )
	{
		actions.click(driver, searchBox);
		actions.sendKeysMethod(searchBox, "T-shirts", 10);
	}
	
	public void  clickSearchButton()
	{
		actions.click(driver, surchbutton); 
	}
	
	public ProductPage productSelect()
	{
		actions.click(driver, productSelect);
		return new ProductPage();
	}
	

	
}
