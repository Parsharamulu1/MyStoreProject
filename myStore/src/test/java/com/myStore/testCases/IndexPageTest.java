package com.myStore.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.myStore.base.BaseClass;
import com.myStore.pageObjects.IndexPage;

public class IndexPageTest extends BaseClass {
	public IndexPage indexpage;
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
	public void signIn() {
		indexpage = new IndexPage();
		indexpage.clickOnSignIn();
		}

}
