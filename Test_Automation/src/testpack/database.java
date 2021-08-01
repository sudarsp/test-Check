package testpack;
// TODO Auto-generated method stub
	
import java.io.FileInputStream;
import  java.sql.Connection;		
import  java.sql.Statement;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import  java.sql.ResultSet;		
import  java.sql.DriverManager;		
import  java.sql.SQLException;	
public class database {

	@DataProvider(name="SearchProvider")
	public static String[][] excel_data() 
	{
		String[][] obj = getExcelData("C:\\GEM-UsersList.xlsx","CreatePolicy");
		return obj;
	}
	public static String[][] getExcelData(String fileName, String sheetName){
    	
    	String[][] data = null;   	
	  	try
	  	{  //C:\\Book2
	   	FileInputStream fis = new FileInputStream(fileName);
	   	XSSFWorkbook wb = new XSSFWorkbook(fis);
	   	XSSFSheet sh = wb.getSheet(sheetName);
	   	XSSFRow row = sh.getRow(0);
	   	int noOfRows = sh.getPhysicalNumberOfRows();
	   	int noOfCols = row.getLastCellNum();
	   	XSSFCell cell;
	   	data = new String[noOfRows-1][noOfCols];
	   	for(int i =1; i<noOfRows;i++){
		     for(int j=0;j<noOfCols;j++){
		    	   row = sh.getRow(i);
		    	   cell= row.getCell(j);
		    	   data[i-1][j] = cell.getStringCellValue();
	   	 	   }
	   	}
	  	}
	  	catch (Exception e) {
	     	   System.out.println("The exception is: " +e.getMessage());
	     	           	}
    	return data;
	}
}
	
