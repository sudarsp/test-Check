package testpack;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.response.ResponseBody;
import utils.Read_WriteExcel;

public class Testcase_main {
	

	//@Test(dataProvider ="SearchProvider",dataProviderClass = Read_WriteExcel.class)
	@Test(dataProvider ="SearchProvider")
	public void testmain(String SA, String DA,String P,String R,String E,String T,String Y) throws JSONException
	//@Test
	//public void testmain() throws JSONException
	{
		FW_Testcase oFW_Testcase = new FW_Testcase();	
		oFW_Testcase.ValidateQuery();
		//
		//System.out.println(SA +"  "+ DA + "  "+P +"  "+R+"  "+E + "  "+T + "  "+Y);
		String resp =oFW_Testcase.create_policy(oFW_Testcase.jsonobjectt(SA, DA, P, R,E,T,Y));
		//String resp =oFW_Testcase.create_policy(oFW_Testcase.jsonobject("160.29.4.1", "90.235.12.30", "TCP", "root" ));
		//"192.168.93.130", "192.168.10.3", "TCP", "root"	
		oFW_Testcase.checkparam(resp);
		//System.out.println("qwwqw");
		//oFW_Testcase.deletepolicy();
	}
	
	
	
	@DataProvider(name="SearchProvider")
	public static String[][] excel_data () throws JSONException 
	{
		String[][] obj = getExcelData("C:\\Users\\supaneer\\Desktop\\PM\\New folder\\MSS\\New folder (2)\\123\\GEM-UsersList.xlsx","EPP_Users");
		System.out.println("obj"+obj);
		return obj;
	}
	public static String[][] getExcelData(String fileName, String sheetName){
    	
    	String[][] data = null;   
    	
    	
    	//string sss= "{\"serviceRequestId\":\"406518\",\"policyid\":\"323\",\"name\":\"406518-Policy\",\"policyStatus\":\"created\",\"actionStatus\":\"success\",\"statusInfo\":\"New policy has been created\",\"capturedTask\":[{\"command\":\"Create new address object\",\"api\":\"address\/add\",\"input\":{\"name\":\"160.23.4.1\",\"destination\":\"160.23.4.1\",\"location\":\"198.19.190.16\",\"vdom\":[\"root\"],\"fwip\":\"198.19.190.16\",\"interface\":\"wan2\"},\"response\":{\"statusInfo\":\"New address object has been created\",\"actionStatus\":\"success\",\"name\":\"160.23.4.1\"}},{\"command\":\"Create new address object\",\"api\":\"address\/add\",\"input\":{\"name\":\"90.234.12.20\",\"destination\":\"90.234.12.20\",\"location\":\"198.19.190.16\",\"vdom\":[\"root\"],\"fwip\":\"198.19.190.16\",\"interface\":\"wan2\"},\"response\":{\"statusInfo\":\"New address object has been created\",\"actionStatus\":\"success\",\"name\":\"90.234.12.20\"}},{\"command\":\"Create new policy\",\"api\":\"policy\/add\",\"input\":{\"name\":\"406518-Policy\",\"srcaddr\":[\"160.23.4.1\"],\"dstaddr\":[\"90.234.12.20\"],\"service\":[\"SSH\"],\"vdom\":[\"root\"],\"srcintf\":[\"wan2\"],\"dstintf\":[\"wan2\"],\"nat\":\"disable\",\"schedule\":\"always\",\"action\":\"accept\",\"logtraffic\":\"all\",\"location\":\"198.19.190.16\",\"fwip\":\"198.19.190.16\"},\"response\":{\"serviceRequestId\":\"406518\",\"policyid\":\"323\",\"name\":\"406518-Policy\",\"policyStatus\":\"created\",\"actionStatus\":\"success\",\"statusInfo\":\"New policy has been created\"}}]}";
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
	   	for(int i =1; i<noOfRows; i++){
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
