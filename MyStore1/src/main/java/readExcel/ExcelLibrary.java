package readExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLibrary {

	public XSSFWorkbook wb;
	public XSSFSheet sheet;

	public ExcelLibrary() {
		String excelpath = "C:\\Users\\parsharamulu.arukuta\\Downloads\\MyStore1\\MyStore1\\TestData\\TestData1.xlsx";
		try {
			File file = new File(excelpath);
			FileInputStream fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public String readData(String sheetName, int row, int col) {
		sheet = wb.getSheet(sheetName);
		String data = sheet.getRow(row).getCell(col).getStringCellValue();
		return data;
	}

}
