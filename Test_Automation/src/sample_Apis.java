import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;


import org.hamcrest.Matchers;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

public class sample_Apis {
	
		public static void main(String[] args) throws JSONException {

//public void abb () throws JSONException

RestAssured.baseURI="https://ipcloud.tatacommunications.com/fwservicerequest/checkPolicy";
//Request object
RequestSpecification abc=RestAssured.given(); 
//Response object
Response r= abc.request(Method.GET);
JSONObject req= new JSONObject();
req.put("source", "10.8.30.223");
req.put("destination", "1.1.1.1");
req.put("servicePort", "22");
req.put("source", "10.8.30.223");
req.put("protocol", "TCP");
req.put("action", "accept");
req.put("location", "14.142.123.250");
System.out.println("adwqwdqdw");
abc.header("Content-Type","application/json").header("X-TP-Auth-Header", "6f1c4688-d0f7-4164-97fc-3d3ebd8d19fb");
abc.body(req.toString());
Response res=abc.request(Method.POST);
//Response resp=given().header("Content-Type","application/json").header("X-TP-Auth-Header", "6f1c4688-d0f7-4164-97fc-3d3ebd8d19fb").body(req.toString()).post("https://ipcloud.tatacommunications.com/fwservicerequest/checkPolicy");
//String responsebody=abc.getBody().asString();
int statuscode=res.getStatusCode();
System.out.println(statuscode);
System.out.println("God");
Assert.assertEquals(statuscode, 200);
	
}

}