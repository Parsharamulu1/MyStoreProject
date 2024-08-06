package com.myStore.pageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.myStore.actionDriver.ActionsDriver;
import com.myStore.base.BaseClass;

public class ProductPage extends BaseClass{
	
	
	
	public ActionsDriver actions=new ActionsDriver();
	
	@FindBy(xpath = "//div[@class='product-content']/descendant::a")
	WebElement productClick;
	
	@FindBy(xpath = "//select[@class='form-control attribute_select no-print']")
	WebElement clickSize;
	
	@FindBy(xpath = "//h1[@class='page-heading  product-listing']")
	WebElement searchtext;
	
	@FindBy(xpath = "//button[@class='exclusive']")
	WebElement addToCart;
	
	@FindBy(xpath = "//div[@class='layer_cart_product col-xs-12 col-md-6']/descendant::h2")
	WebElement productMessage;
	
	@FindBy(xpath ="//a[@class='btn btn-default button button-medium']")
	WebElement proceedToCheckout;
	
	
	
	
	
	public ProductPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void productClick() {
		actions.click(getDriver(), productClick);
	}

	public void selectSize() {
		actions.selectByIndex(clickSize, 2);
	}
	
	public void addToCartClick() {
		actions.click(getDriver(), addToCart);
	}
	public void pageTextVerification()
	{
		String actualtilte="SEARCH T-SHIRTS";
		String expcetedtitle=searchtext.getText();
		Assert.assertEquals(actualtilte, expcetedtitle);
		System.out.println("search page title matched");
	}
	public void productMessage()
	{
		actions.verifyTextElement(productMessage.getText(), productMessage, "Product successfully added to your shopping cart",10);
	
	}
	public ProductPage proceedToCheckout()
	{
		actions.JSClick(getDriver(), proceedToCheckout);
		return new ProductPage();
	}
	

}
