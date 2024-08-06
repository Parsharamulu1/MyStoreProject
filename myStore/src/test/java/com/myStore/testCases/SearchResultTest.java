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
import com.myStore.pageObjects.SearchResultPage;

public class SearchResultTest extends BaseClass {
	public IndexPage indexpage;
	public LoginPage loginpage;
	public HomePage homepage;
	public AccountCreationPage accountpage;
	public SearchResultPage serchresultspage;
    
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
		loginpage= indexpage.clickOnSignIn();
		loginpage.pageTextVerification();
		Thread.sleep(5000);
		homepage=loginpage.login();
		Thread.sleep(5000);
		accountpage.accountPageTextVerification();
		Thread.sleep(5000);
		accountpage.searchText();
		Thread.sleep(5000);
		accountpage.searchonclick();
		
		
		
		
		
		}

}
