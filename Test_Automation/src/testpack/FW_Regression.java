package testpack;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
fhjhj
public class FW_Regression {
	public void Check_CreatePolicy()
	{
	RestAssured.baseURI="https://stg.opstic.tatacommunications.com/fwservicerequest/createPolicy";
	RequestSpecification rs= RestAssured.given();
	JSONObject jobject = new JSONObject();
	jobject.put("nat", value);
	jobject.put("serviceRequestId", value);
	jobject.put("destination", value);
	jobject.put("source", value);
	jobject.put(key, value);
	jobject.put(key, value);
	 /*{
			RestAssured.baseURI="https://stg.opstic.tatacommunications.com/fwservicerequest/createPolicy";
			//Request object
			RequestSpecification abc=RestAssured.given(); 
			//Response object
			Response r= abc.request(Method.GET);
			
			JSONObject req= new JSONObject();
			req.put("nat", "disable");
			req.put("serviceRequestId", "405506");
			req.put("destination",DestinationAddress);
			req.put("source",SourceAddress);
			req.put("automationStatus", "true");
			req.put("protocol",Protocol);
			req.put("vdom", Vdom);
			req.put("location", "198.19.190.16");
			req.put("servicePort", "22");
			req.put("action", "accept");
			abc.header("Content-Type","application/json").header("X-TP-Auth-Header", "6f1c4688-d0f7-4164-97fc-3d3ebd8d19fb");
			abc.body(req.toString());
			Response res=abc.request(Method.POST);
			ResponseBody body = r.getBody();
			
			
		
			
			System.out.println("response"+body.asString());
			
			
			return body;
			
		}
		
		@DataProvider(name="SearchProvider")
	public static String[][] excel_data () throws JSONException 
	{
		String[][] obj = getExcelData("C:\\GEM-UsersList.xlsx","EPP_Users");
		System.out.println(obj);
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

	

	
	*/
		
	}

}
