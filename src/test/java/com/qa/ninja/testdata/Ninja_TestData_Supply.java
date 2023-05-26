package com.qa.ninja.testdata;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;



public class Ninja_TestData_Supply {
	public static Properties dataprop;
	public static FileInputStream ip;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	
	public Ninja_TestData_Supply() throws Exception {
	
	dataprop = new Properties();
	FileInputStream ip1 = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\ninja\\propertiesfiles\\testData.properties");
	dataprop.load(ip1);

}
	
@DataProvider(name = "ninjaDataProviderSupply")
	
	public static Object[][] dataSupplyFrom2DimentionalObjectArray() {
		
		Object [][] data = {{dataprop.getProperty("dataProviderUserName1"), dataprop.getProperty("dataProviderPassword1")},
		                    {dataprop.getProperty("dataProviderUserName2"), dataprop.getProperty("dataProviderPassword2")},
		                    {dataprop.getProperty("dataProviderUserName3"), dataprop.getProperty("dataProviderPassword3")}};
		                   
		return data;
	}
	 
@DataProvider(name = "ninjaExcellDataWithDataProvider")
public static Object[][] excelSheetDataSupply() throws Exception{
	Object[][] data = Ninja_TestData_Supply.getNinjaTestDataFromExcelSheet("LoginData");
	return data;
	
}

	
	
public static Object[][] getNinjaTestDataFromExcelSheet(String sheetName) throws Exception{
	ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\qa\\ninja\\testdata\\NinjaTestData.xlsx");
	workbook = new XSSFWorkbook(ip);
	sheet =workbook.getSheet(sheetName);
	int rows = sheet.getLastRowNum();
	int cols = sheet.getRow(0).getLastCellNum();
	
	Object[][] data = new Object[rows][cols];
	
	for(int i=0; i<rows; i++) {
		XSSFRow row = sheet.getRow(i+1);
		 
		for(int j=0; j<cols; j++) {
			XSSFCell cell = row.getCell(j);
			CellType celltype = cell.getCellType();
			
			switch(celltype) {
			
			case STRING:
				data[i][j] = cell.getStringCellValue();
				break;
				
			case NUMERIC:
				data[i][j] = Integer.toString((int)cell.getNumericCellValue());
				break;
				
			case BOOLEAN:
				data[i][j] = cell.getBooleanCellValue();
				break;
			}
		}
	}
	return data;
	


	
	
	
	

	
	

}
}

