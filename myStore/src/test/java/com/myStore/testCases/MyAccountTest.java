package com.myStore.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.myStore.base.BaseClass;
import com.myStore.pageObjects.AccountCreationPage;
import com.myStore.pageObjects.HomePage;
import com.myStore.pageObjects.IndexPage;
import com.myStore.pageObjects.LoginPage;
import com.myStore.utility.Log;

public class MyAccountTest extends BaseClass {
	
	public IndexPage indexpage;
	public LoginPage loginpage;
	public HomePage homepage;
	public AccountCreationPage accountpage;
    
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
		accountpage =new AccountCreationPage();
		Log.startTestCase("loginTest");
		loginpage= indexpage.clickOnSignIn();
		Log.info("User cliked sign in button");
		loginpage.pageTextVerification();
		Log.info("Page text is matching");
		Thread.sleep(5000);
		homepage=loginpage.login();
		Log.info("sucessfully login into application");
		Thread.sleep(5000);
		accountpage.accountPageTextVerification();
		Log.info("account page text is matching");
		Thread.sleep(5000);
		accountpage.searchText();
		Log.info("Entered product name in search box");
		Thread.sleep(5000);
		accountpage.searchonclick();
		Log.info("clicked on search button");
		Thread.sleep(5000);
		
		
		
		
		
		}


}
