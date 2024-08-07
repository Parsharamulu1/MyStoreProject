package testcases;

import org.testng.annotations.Test;

import readExcel.ExcelLibrary;

public class ReadExcelData {

	@Test

	public void readExcelTest() throws Exception {
		ExcelLibrary obj = new ExcelLibrary();
		String datastring = obj.readData("Test", 5, 1);
		System.out.println(datastring);

	}

}
