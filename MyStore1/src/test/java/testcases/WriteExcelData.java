package testcases;

import org.testng.annotations.Test;

import writeexcel.WriteExcel;

public class WriteExcelData {
	
	WriteExcel obj= new WriteExcel();
	
	@Test
	public void writeExcel() throws Exception
	{
		obj.writeExcel("Test", "Male", 0, 2);
	}
	
	@Test
	public void writeExcel1() throws Exception
	{
		obj.writeExcel("Test", "Female", 1, 2);
	}
	

}
