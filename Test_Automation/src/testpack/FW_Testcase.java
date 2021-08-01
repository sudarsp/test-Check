package testpack;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bson.json.JsonReader;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class FW_Testcase {
	
	public String create_policy(String response) throws JSONException
	{
		RestAssured.baseURI="https://stg.opstic.tatacommunications.com/fwservicerequest/createPolicy";
		//Request object
		RequestSpecification abc=RestAssured.given(); 
		//Response object	
	
		abc.header("Content-Type","application/json").header("X-TP-Auth-Header", "6f1c4688-d0f7-4164-97fc-3d3ebd8d19fb");
		abc.body(response);
		Response res=abc.request(Method.POST);
		ResponseBody body = res.getBody();
		String ss = body.asString();
		System.out.println("response"+body.asString());
		JsonPath responsee = new JsonPath(ss);
		System.out.println("body"+body);
		System.out.println("resp"+response);
		
		//String responseresult2 =responsee.get("serviceRequestId");
		//String responseresult3 =responsee.get("statusCode");
		String responseresult =responsee.get("statusInfo");
		String responseresult1 =responsee.get("actionStatus");
		System.out.println(responseresult+ responseresult1);
		
		return ss;
		
		
	}
	
	//@Test(dataProvider = "SearchProvider")
	public String jsonobjectt(String SourceAddress,String DestinationAddress,String Protocol,String Vdom,String ServiceID,String nat, String action) throws JSONException
	{
		JSONObject req= new JSONObject();
		req.put("nat", nat);
		req.put("serviceRequestId", ServiceID);
		req.put("destination",DestinationAddress);
		req.put("source",SourceAddress);
		req.put("automationStatus", "true");
		req.put("protocol",Protocol);
		req.put("vdom", Vdom);
		req.put("location", "198.19.190.16");
		req.put("servicePort", "22");
		req.put("action", action);		
		System.out.println(nat +"  "+ ServiceID + "  "+DestinationAddress +"  "+SourceAddress+"  "+Protocol+"  "+Vdom + "  " + action);
		String response= req.toString();
		return response;

	}
	
	
	public void checkparam(String ss)
	{

		System.out.println("Print Success" + ss );
		JsonPath responsee = new JsonPath(ss);
			
		String responseresult =responsee.get("statusInfo");
		String responseresult1 =responsee.get("actionStatus");
		System.out.println("\n ******************************************************************************************* " );
		System.out.println("response for check purpose"+ responseresult1 + responseresult);
		System.out.println("******************************************************************************************* ");
		
		
		String responseres =responsee.get("policyid");
		String responseres1 =responsee.get("name");
		String responseres2 =responsee.get("policyStatus");
		String responseres3 =responsee.get("statusInfo");
		System.out.println("******************************************************************************************* ");
		System.out.println("Policy ID: "+ responseres);
		System.out.println("Policy Name: "+ responseres1);
		System.out.println("Policy Status: "+responseres2);
		System.out.println("statusInfo"+responseres3);
			
	}
	
	
	public void deletepolicy() throws JSONException
	{
		RestAssured.baseURI="https://stg.opstic.tatacommunications.com/fwservicerequest/deletePolicy";
		//Request object
		RequestSpecification abc=RestAssured.given(); 
		//Response object	
	
		
		
		JSONObject req= new JSONObject();
		req.put("serviceRequestId", "REQTCL0294369_1-Policy");
		req.put("policyid", "310");
		req.put("location","198.19.190.16");
		abc.header("Content-Type","application/json").header("X-TP-Auth-Header", "6f1c4688-d0f7-4164-97fc-3d3ebd8d19fb");
		abc.body(req.toString());
		Response res=abc.request(Method.POST);
		ResponseBody body = res.getBody();
		
		System.out.println(body.asString());
		int statuscode=res.getStatusCode();
		
		System.out.println(statuscode);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+ "Delete Policy"+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
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
	
	public void ValidateQuery()
	{
		String aaa="{\"serviceRequestId\":\"406518\",\"policyid\":\"323\",\"name\":\"406518-Policy\",\"policyStatus\":\"created\",\"actionStatus\":\"success\",\"statusInfo\":\"New policy has been created\",\"capturedTask\":[{\"command\":\"Create new address object\",\"api\":\"address/add\",\"input\":{\"name\":\"160.23.4.1\",\"destination\":\"160.23.4.1\",\"location\":\"198.19.190.16\",\"vdom\":[\"root\"],\"fwip\":\"198.19.190.16\",\"interface\":\"wan2\"},\"response\":{\"statusInfo\":\"New address object has been created\",\"actionStatus\":\"success\",\"name\":\"160.23.4.1\"}},{\"command\":\"Create new address object\",\"api\":\"address/add\",\"input\":{\"name\":\"90.234.12.20\",\"destination\":\"90.234.12.20\",\"location\":\"198.19.190.16\",\"vdom\":[\"root\"],\"fwip\":\"198.19.190.16\",\"interface\":\"wan2\"},\"response\":{\"statusInfo\":\"New address object has been created\",\"actionStatus\":\"success\",\"name\":\"90.234.12.20\"}},{\"command\":\"Create new policy\",\"api\":\"policy/add\",\"input\":{\"name\":\"406518-Policy\",\"srcaddr\":[\"160.23.4.1\"],\"dstaddr\":[\"90.234.12.20\"],\"service\":[\"SSH\"],\"vdom\":[\"root\"],\"srcintf\":[\"wan2\"],\"dstintf\":[\"wan2\"],\"nat\":\"disable\",\"schedule\":\"always\",\"action\":\"accept\",\"logtraffic\":\"all\",\"location\":\"198.19.190.16\",\"fwip\":\"198.19.190.16\"},\"response\":{\"serviceRequestId\":\"406518\",\"policyid\":\"323\",\"name\":\"406518-Policy\",\"policyStatus\":\"created\",\"actionStatus\":\"success\",\"statusInfo\":\"New policy has been created\"}}]}";
		JsonPath response = new JsonPath(aaa);
		
		String responseresult2 =response.get("policyid");
		String responseresult =response.get("name");
		String responseresult1 =response.get("policyStatus");
		String responseresult3 =response.get("statusInfo");
		
		System.out.println("Policy ID: "+ responseresult2);
		System.out.println("Policy Name: "+ responseresult);
		System.out.println("Policy Status: "+responseresult1);
		System.out.println("statusInfo"+responseresult3);
		
	
	}

	

	
	
}
