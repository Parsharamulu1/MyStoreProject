package com.myStore.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class NewExcelLibrary {

		public String[][] getdata(String excelSheetName) throws EncryptedDocumentException, IOException {
			File f = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\TestData.xlsx");
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


	

	


