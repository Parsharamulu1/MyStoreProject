package com.myStore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.myStore.utility.Log;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static Properties prop;
	// public static WebDriver driver;

// Declare Thread Local driver
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		// Get Driver from thread local map
		return driver.get();
	}

	
//	  @BeforeSuite public  void beforeSuite() {
//	  BasicConfigurator.configure(); // DOMConfigurator.configure("log4j2.xml");
//	  Log.info("This is beforeSuite method");
//	  
//	  }
//	  
//	  @AfterSuite public  void afterSuite() {
//	  
//	  Log.info("This is afterSuite method"); }
	 

	@BeforeTest
	public static void readConfig() {
		try {
			prop = new Properties();
			FileInputStream fs = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration folder\\config.properties");
			prop.load(fs);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public static void launchApp(String browserName) {
		WebDriverManager.chromedriver().setup();
		// String browserName = prop.getProperty("browser"); //comment this line of code 0508
		if (browserName.equalsIgnoreCase("Chrome")) {
			// driver = new ChromeDriver();
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			// driver = new FirefoxDriver();
			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("Edge")) {
			// driver = new EdgeDriver();
			driver.set(new EdgeDriver());
		}
		getDriver().get(prop.getProperty("url"));
	}
	
	public static void tearDown() {
		getDriver().quit();
	}

}
