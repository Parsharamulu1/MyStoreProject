package readExcel;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel {
	@Test
	public void readexcel() throws Exception {
		String excelpath = "C:\\Users\\parsharamulu.arukuta\\Downloads\\MyStore1\\MyStore1\\TestData\\TestData1.xlsx";
		String fileNameString = "TestData";
		String sheetName = "Test";
		// create the object of file class to get the excel path
		File file = new File(excelpath);
		// To read the file
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sheetName);
		int totalrowcount = sheet.getLastRowNum();
		System.out.println("Total rows" + totalrowcount);
		String data = sheet.getRow(0).getCell(1).getStringCellValue();
		System.out.println(data);

		for (int i = 0; i <= totalrowcount; i++) {
			Row row = sheet.getRow(i);

			for (int j = 0; j < row.getLastCellNum(); j++) {
				String data1 = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.print(data1 + "  ");

			}
			System.out.println();
		}
		wb.close();

	}

}
