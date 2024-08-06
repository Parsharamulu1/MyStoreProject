package com.myStore.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.myStore.base.BaseClass;
import com.myStore.dataProvider.DataProviders;
import com.myStore.pageObjects.HomePage;
import com.myStore.pageObjects.IndexPage;
import com.myStore.pageObjects.LoginPage;
import com.myStore.utility.Log;

public class LoginPageTest extends BaseClass {

	public IndexPage indexpage;
	public LoginPage loginpage;
	public HomePage homepage;
	
	@Parameters("browser")
	@BeforeMethod
	public void setuUP(String browserName) {
		launchApp(browserName);
	}

	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	
	public void loginTest() throws InterruptedException {
		indexpage = new IndexPage();
		loginpage = new LoginPage();
	//	Log.startTestCase("loginTest");
		loginpage= indexpage.clickOnSignIn();
	//	Log.info("User cliked sign in button");
		loginpage.pageTextVerification();
//		Log.info("page text verified");
		Thread.sleep(10000);
		//homepage=loginpage.login();
		homepage=loginpage.login();
	//	Log.info("user  logged succesfully");
		Thread.sleep(10000);
	//	Log.endTestCase("loginTest");
	
	

	/*@Test(dataProvider="credentials", dataProviderClass=DataProviders.class)
	public void loginTest(String uname, String pwd) throws InterruptedException {
		indexpage = new IndexPage();
		loginpage = new LoginPage();
		Log.startTestCase("loginTest");
		loginpage= indexpage.clickOnSignIn();
		Log.info("User cliked sign in button");
		loginpage.pageTextVerification();
		Log.info("page text verified");
		Thread.sleep(10000);
		//homepage=loginpage.login();
		homepage=loginpage.login(uname, pwd);
		Log.info("user  logged succesfully");
		Thread.sleep(10000);
		Log.endTestCase("loginTest");
		}*/

}
}
