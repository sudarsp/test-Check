package testpack;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class SIEM_AlertSearch {
	@Test
		public void keyclockbearer() throws ParseException, JSONException
	{
		
		RestAssured.baseURI="https://stg.opstic.tatacommunications.com/mss-siem2/api/alert/search";
		//Request object
		RequestSpecification abc=RestAssured.given(); 
		String Sample=  "type:\"CORRELATION\"" ;
		
		//Response object
		
		/*
		String text=  "	{  \"access_token\": \"eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJIdTRjcTVOWTRlRWl3bGFEczBBQzl1NEtxblJFMnNrU1JYd2s1eHlyWl9zIn0.eyJqdGkiOiIxMDA5ZDc2Ni1kZjllLTRjMTEtYTdkZS02ZDM5YTdjYmUzYzUiLCJleHAiOjE2MTIzMjA0ODEsIm5iZiI6MCwiaWF0IjoxNjEyMzIwMTgxLCJpc3MiOiJodHRwczovL3N0Zy5vcHN0aWMudGF0YWNvbW11bmljYXRpb25zLmNvbS9hdXRoL3JlYWxtcy9zcG90bGlnaHQiLCJhdWQiOiJhY2NvdW50Iiwic3ViIjoiNzRlZDY3MmEtYjFjMy00YTJkLTg5NjctMWM5NzQ4YTZjNWQxIiwidHlwIjoiQmVhcmVyIiwiYXpwIjoiaXBjIiwiYXV0aF90aW1lIjowLCJzZXNzaW9uX3N0YXRlIjoiNTc5ZjZmM2UtMDkyYi00MTBmLWIwM2YtZGY3YjJiOGJhZDYyIiwiYWNyIjoiMSIsImFsbG93ZWQtb3JpZ2lucyI6WyIqIl0sInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJvZmZsaW5lX2FjY2VzcyIsInVtYV9hdXRob3JpemF0aW9uIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJlbWFpbCBwcm9maWxlIiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJuYW1lIjoidGNsZGVtb2VuZ2luZWVyIHRjbGRlbW9lbmdpbmVlciIsInByZWZlcnJlZF91c2VybmFtZSI6InRjbGRlbW9lbmdpbmVlciIsImdpdmVuX25hbWUiOiJ0Y2xkZW1vZW5naW5lZXIiLCJmYW1pbHlfbmFtZSI6InRjbGRlbW9lbmdpbmVlciIsImVtYWlsIjoidGNsZGVtb2VuZ2luZWVyQGFiYy5jb20iLCJ1c2VyX2dyb3VwcyI6W119.fkq-yQdvfKdjjQcm_PnEaUFfnCXHMzVz0zinxYmPAQ9Vdb7UNrD8K8hbTgVT1Dpm_WJDDqy616hiLhqciNTlnva38K1xJQe1rnPxpfM-xisXhcFBw38nQdBkgOBo6luwiKU__nyxo9x8mDrtSzfAvWTLrxPUHRTpDOEpSCEXckSBkBCvi9sOf64VtYC10WZsklgp0qJcizS211BN9VufZ4Uvzn2l72NkF-N3J3Mnz1fAdJBDRJ4vZcM2zsMFh7iLtUIsfyIUqQRAi-cU_G-8eXl3Hwhz6gxMh15T7lbCVLLkViAJaHhkXS7efDNfAQcPG7TIy_haYGUFVwgso3E69g\",\r\n" + 
				"    \"expires_in\": 300,\r\n" + 
				"    \"refresh_expires_in\": 1800,\r\n" + 
				"    \"refresh_token\": \"eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI1YTMyMmMzMy1kYThhLTQyYzktYjY2Ny0yY2YwNThmMTU1ZTEifQ.eyJqdGkiOiJjNTkyMzllOS02M2NiLTRmOTUtOWFiNS0yNWVmZTZhZTJlOGEiLCJleHAiOjE2MTIzMjE5ODEsIm5iZiI6MCwiaWF0IjoxNjEyMzIwMTgxLCJpc3MiOiJodHRwczovL3N0Zy5vcHN0aWMudGF0YWNvbW11bmljYXRpb25zLmNvbS9hdXRoL3JlYWxtcy9zcG90bGlnaHQiLCJhdWQiOiJodHRwczovL3N0Zy5vcHN0aWMudGF0YWNvbW11bmljYXRpb25zLmNvbS9hdXRoL3JlYWxtcy9zcG90bGlnaHQiLCJzdWIiOiI3NGVkNjcyYS1iMWMzLTRhMmQtODk2Ny0xYzk3NDhhNmM1ZDEiLCJ0eXAiOiJSZWZyZXNoIiwiYXpwIjoiaXBjIiwiYXV0aF90aW1lIjowLCJzZXNzaW9uX3N0YXRlIjoiNTc5ZjZmM2UtMDkyYi00MTBmLWIwM2YtZGY3YjJiOGJhZDYyIiwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHByb2ZpbGUifQ.UKi9xKsKcm0jx5N3N77-tKqLAmTf-RQTW9CGyVMHu84\",\r\n" + 
				"    \"token_type\": \"bearer\",\r\n" + 
				"    \"not-before-policy\": 0,\r\n" + 
				"    \"session_state\": \"579f6f3e-092b-410f-b03f-df7b2b8bad62\",\r\n" + 
				"    \"scope\": \"email profile\"\r\n" + 
				"}";
				*/
		String Text ="\"type:CORRELATION\"";
		//String textt=\"type:CORRELATION\"  ;
		//String myjson="\"{\\\"engagementId\\\":542,\\\"searchOptions\\\":{\\\"query\\\":\\\"Sample\\\",\\\"startDateTime\\\":\\\"1444415400000\\\",\\\"endDateTime\\\":\\\"1611227226629\\\",\\\"eventIds\\\":[\\\"ticket.ticketId\\\"]},\\\"pagination\\\":{\\\"pageNumber\\\":0,\\\"pageSize\\\":10,\\\"totalElements\\\":1000}}\"";
		
		//String myjson=" \"{\\\"engagementId\\\":99999,\\\"searchOptions\\\":{\\\"query\\\":\\\"type:\\\\\"CORRELATION\\\\\"\\\",\\\"startDateTime\\\":\\\"1444415400000\\\",\\\"endDateTime\\\":\\\"1611227226629\\\",\\\"eventIds\\\":[\\\"ticket.ticketId\\\"]},\\\"pagination\\\":{\\\"pageNumber\\\":0,\\\"pageSize\\\":10,\\\"totalElements\\\":1000}}\"";			
		String myjson="{\"engagementId\":99999,\"searchOptions\":{\"query\":\"type:CORRELATION\",\"startDateTime\":\"1444415400000\",\"endDateTime\":\"1611227226629\",\"eventIds\":[\"ticket.ticketId\"]},\"pagination\":{\"pageNumber\":0,\"pageSize\":10,\"totalElements\":1000}}";
		System.out.println(myjson);
		String check= "{\"engagementId\":99999,\"searchOptions\":{\"query\":" +Text+",\"startDateTime\":\"1444415400000\",\"endDateTime\":\"1611227226629\",\"eventIds\":[\"ticket.ticketId\"]},\"pagination\":{\"pageNumber\":0,\"pageSize\":10,\"totalElements\":1000}}";
		System.out.println(check);
		String token="eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJIdTRjcTVOWTRlRWl3bGFEczBBQzl1NEtxblJFMnNrU1JYd2s1eHlyWl9zIn0.eyJqdGkiOiIyYmQwZTcwMi0yYTgyLTQ2YTctYTM2Ni1mNDk3Y2FlMTk2Y2QiLCJleHAiOjE2MTI0MTY2MDcsIm5iZiI6MCwiaWF0IjoxNjEyNDE2MzA3LCJpc3MiOiJodHRwczovL3N0Zy5vcHN0aWMudGF0YWNvbW11bmljYXRpb25zLmNvbS9hdXRoL3JlYWxtcy9zcG90bGlnaHQiLCJhdWQiOiJhY2NvdW50Iiwic3ViIjoiNzRlZDY3MmEtYjFjMy00YTJkLTg5NjctMWM5NzQ4YTZjNWQxIiwidHlwIjoiQmVhcmVyIiwiYXpwIjoiaXBjIiwiYXV0aF90aW1lIjowLCJzZXNzaW9uX3N0YXRlIjoiODFlMjYzMmItZTk2OS00N2ZmLThlZjctNmFhNDQyZGZhOWY2IiwiYWNyIjoiMSIsImFsbG93ZWQtb3JpZ2lucyI6WyIqIl0sInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJvZmZsaW5lX2FjY2VzcyIsInVtYV9hdXRob3JpemF0aW9uIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJlbWFpbCBwcm9maWxlIiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJuYW1lIjoidGNsZGVtb2VuZ2luZWVyIHRjbGRlbW9lbmdpbmVlciIsInByZWZlcnJlZF91c2VybmFtZSI6InRjbGRlbW9lbmdpbmVlciIsImdpdmVuX25hbWUiOiJ0Y2xkZW1vZW5naW5lZXIiLCJmYW1pbHlfbmFtZSI6InRjbGRlbW9lbmdpbmVlciIsImVtYWlsIjoidGNsZGVtb2VuZ2luZWVyQGFiYy5jb20iLCJ1c2VyX2dyb3VwcyI6W119.VwqUhVq-iQR5cZliMScxeVH2B0SgmUmML5YyeZxw1eqh1FGSUzZgqxPxNBW86N7muEHj2MrMQtX7lsSbEglEM0GJOlAA8K_kwOxQoCW5uId1RsNInupsLdfSlMzAJYEqey3OPtZaRivTjEGBIR4tGTLqbojCCb9zqcgJxH9PPuHTE0b-tnvrUPMHEkbg-zhQIC3kh7bog9az8hKgRBP9Q-XFRUu7Jgma0yc4rvygR0VUYHCNinecRxlxKfSMtnpjCkz6JEtJWC6srbH0YdTOjUKQbHQeCoazE5VRlNn58PoFgSeXnOZ-GyJ0DyEjfXtbgE4JTMWZ0R844lKFcVRdww";
		RequestSpecification ddd =abc.header("Host","<calculated when request is sent>").header("Content-Type","application/json").header("Authorization", "Bearer "+ token);
				//abc.body(myjson);
	
		
				
			System.out.println(ddd);
		Response res=abc.request(Method.POST);
		
		
		int statuscode=res.getStatusCode();
		
		ResponseBody body = res.getBody();
		System.out.println("res"+body.asString());
		System.out.println(statuscode);
		
		
 
		//abc.header("Content-Type","application/x-www-form-urlencoded").header("Content-Length", "");
	  //   System.out.println(text);
		//JsonPath response = new JsonPath(text);
	//	String responseresult =response.get("access_token");
		//System.out.println(responseresult);
				
				
		//JSONParser parse1 = new JSONParser(); 

		 //JSONObject jobj = (JSONObject)parse1.parse(text);
		 
		/* 
		 JSONArray jsonarr_1 = (JSONArray) jobj.get(jobj); 
		 System.out.println(jsonarr_1);
		 System.out.println("jsonarr"+jsonarr_1);
		 System.out.println("jobj"+jobj);
		 
		 System.out.println("length"+jsonarr_1.length());
		 for (int i=1; i<= jsonarr_1.length();i++)
		 {
			 System.out.println("Check");
			 JSONObject jsonobj1 = (JSONObject) jsonarr_1.get(i);
			 System.out.println("Check1"+jsonobj1.get(0));
			 System.out.println("Checkwe");
			 System.out.println(jsonobj1.get("status"));
			 
		 }
		 
		 
		System.out.println(jobj);
		*/
		
		
		
		
		
		
		
		
		
	}
}