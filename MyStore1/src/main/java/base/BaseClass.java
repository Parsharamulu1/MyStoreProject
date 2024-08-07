package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import readExcel.ExcelLibrary;

public class BaseClass {

	public static WebDriver driver;
	public XSSFWorkbook wb;
	public XSSFSheet sheet = null;;
	public XSSFRow row = null;
	ExcelLibrary obj = new ExcelLibrary();

	@BeforeMethod
	public static void launchApp() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
	}

	@AfterMethod
	public static void tearDown() {
		driver.close();
	}
	/*
	 * @DataProvider(name="credentials") public Object[][] getData() { Object[][]
	 * data =new Object[3][2]; data[0][0]="admin"; data[0][1]="admin123";
	 * 
	 * data[1][0]="admin1"; data[1][1]="admin123";
	 * 
	 * data[2][0]="admin2"; data[2][1]="admin";
	 * 
	 * return data;
	 * 
	 * }
	 * 
	 * public void getExcelData() { obj.sheet.getPhysicalNumberOfRows(); }
	 */

	@DataProvider(name="credentials1")
	public String[][] getdata(Method m) throws EncryptedDocumentException, IOException {
		String excelSheetName=m.getName();
		String path="C:\\Users\\parsharamulu.arukuta\\Downloads\\MyStore1\\MyStore1\\TestData\\TestData1.xlsx";
	//	File f = new File(System.getProperty("user.dir") + "\\MyStore1\\TestData\\TestData1.xlsx");
		File f=new File(path);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheet(excelSheetName);
		int totalrows = sheetName.getLastRowNum();
		System.out.println(totalrows);
		Row rowCells = sheetName.getRow(0);
		int totalCols = rowCells.getLastCellNum();
		System.out.println(totalCols);
		DataFormatter format = new DataFormatter();

		String testData[][] = new String[totalrows][totalCols];
		for (int i = 1; i < totalrows; i++) {
			for (int j = 0; j < totalCols; j++) {
				testData[i - 1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
				System.out.println(testData[i - 1][j]);
			}
		}
		return testData;

	}
}
