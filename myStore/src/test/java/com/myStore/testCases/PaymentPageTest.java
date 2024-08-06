package com.myStore.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.myStore.base.BaseClass;
import com.myStore.pageObjects.AccountCreationPage;
import com.myStore.pageObjects.AddressPage;
import com.myStore.pageObjects.HomePage;
import com.myStore.pageObjects.IndexPage;
import com.myStore.pageObjects.LoginPage;
import com.myStore.pageObjects.PaymentPage;
import com.myStore.pageObjects.ProductPage;
import com.myStore.pageObjects.ShippingCartPage;
import com.myStore.pageObjects.Shippingpage;

public class PaymentPageTest extends BaseClass {

	public IndexPage indexpage;
	public LoginPage loginpage;
	public HomePage homepage;
	public AccountCreationPage accountpage;
	public ProductPage productpage;
	public ShippingCartPage shippingcartpage;
	public AddressPage addresspage;
	public Shippingpage shippingpage;
	public PaymentPage paymentpage;
	@Parameters("browser")
	@BeforeMethod
	public void setuUP(String browserName) {
		launchApp(browserName);
	}

	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}

	@Test
	public void loginTest() throws InterruptedException {
		indexpage = new IndexPage();
		loginpage = new LoginPage();
		accountpage = new AccountCreationPage();
		productpage = new ProductPage();
		shippingcartpage = new ShippingCartPage();
		addresspage = new AddressPage();
		shippingpage = new Shippingpage();
		paymentpage =new PaymentPage();
		loginpage = indexpage.clickOnSignIn();
		loginpage.pageTextVerification();
		Thread.sleep(5000);
		homepage = loginpage.login();
		Thread.sleep(5000);
		accountpage.accountPageTextVerification();
		Thread.sleep(5000);
		accountpage.searchText();
		Thread.sleep(5000);
		accountpage.searchonclick();
		Thread.sleep(5000);
		// productpage.pageTextVerification();
		// Thread.sleep(5000);
		productpage.productClick();
		Thread.sleep(10000);
		productpage.selectSize();
		Thread.sleep(5000);
		productpage.addToCartClick();
		Thread.sleep(5000);
		productpage.productMessage();
		Thread.sleep(5000);
		productpage.proceedToCheckout();
		Thread.sleep(5000);
		// shippingcartpage.pageTextVerification();
		// Thread.sleep(5000);
		shippingcartpage.proceedToCheckOut();
		Thread.sleep(5000);
		addresspage.pageTextVerification();
		Thread.sleep(5000);
		addresspage.proceedToCheckoutFromAddressPage();
		Thread.sleep(5000);
		shippingpage.pageTextVerification();
		Thread.sleep(5000);
		shippingpage.checkBox();
		Thread.sleep(5000);
		shippingpage.proceedToCheckout();
		Thread.sleep(5000);
	//	paymentpage.pageTextVerification();
	//	Thread.sleep(5000);
		paymentpage.payByBankWire();
		Thread.sleep(5000);


	}

}
