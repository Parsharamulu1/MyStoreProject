package com.myStore.dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviders {

	@DataProvider(name ="credentials")

	public String[][] getdata(Method m) throws EncryptedDocumentException, IOException {
		String excelSheetName=m.getName();
		String path="C:\\Users\\parsharamulu.arukuta\\Project\\myStore\\src\\test\\resources\\testData\\TestData1.xlsx";
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
