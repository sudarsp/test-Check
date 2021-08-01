package testpack;
import utils.Read_WriteExcel;
import org.json.*;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import groovy.json.JsonParser;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.internal.support.FileReader;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
 

public class sample_Api {
	@Test(dataProvider = "SearchProvider")
	public void abb(String abcd) throws JSONException
	{
	RestAssured.baseURI="https://ipcloud.tatacommunications.com/fwservicerequest/checkPolicy";
	//Request object
	RequestSpecification abc=RestAssured.given(); 
	
	JSONObject req= new JSONObject();
	req.put("source", "10.8.30.223");
	req.put("destination", "1.1.1.1");
	req.put("servicePort", "22");
	req.put("protocol", "TCP");
	req.put("action", "accept");
	req.put("location", abcd);
	
	abc.header("Content-Type","application/json").header("X-TP-Auth-Header", "6f1c4688-d0f7-4164-97fc-3d3ebd8d19fb");
	abc.body(req.toString());	
	{
	Response res=abc.request(Method.POST);
	int statuscode=res.getStatusCode();
	
	System.out.println(""
			+ "**********************************************"
			+ "**********************************************");
	System.out.println("IP"+ abcd);
	System.out.println(statuscode);
	ResponseBody body = res.getBody();
	
	String bb=body.asString();
	//System.out.println(bb);
	JsonPath response = new JsonPath(bb);

	String responseresult2 =response.get("statusCode");
	String responseresult =response.get("checkPolicyInfo");
	String responseresult1 =response.get("actionStatus");
	String responseresult3 =response.get("statusInfo");
	
	
	
	System.out.println( abcd +  responseresult1+ responseresult);
	//System.out.println(responseresult1);
	//System.out.println(responseresult2);
	
	
	System.out.println("Response:"+ body.asString());
	System.out.println(""
			+ "**********************************************"
			+ "**********************************************");
	
	
	Assert.assertEquals(statuscode,200);
	
	}
	}
	
	
	@DataProvider(name="SearchProvider")
	public static String[][] excel_data() 
	{
		String[][] obj = getExcelData("D:\\USer.xlsx","CreatePolicy");
		//String[][] obj = getExcelData("C:\\Users\\supaneer\\Desktop\\PM\\New folder\\MSS\\New folder (2)\\123\\FW_List.xlsx","CreatePolicy");
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
		    	   System.out.println(row + "cell" + cell);
	   	 	   }
	   	}
	  	}
	  	catch (Exception e) {
	     	   System.out.println("The exception is: " +e.getMessage());
	     	           	}
    	return data;
	}

}