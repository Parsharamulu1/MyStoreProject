package dataDrivenTest;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;

public class DataDrivenTest extends BaseClass {
	
	
	@Test(dataProviderClass=BaseClass.class, dataProvider="credentials1")
	public void loginTest(String username, String password) throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		
	}
	
	

}
