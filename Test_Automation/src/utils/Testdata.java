package utils;
import org.json.JSONException;
import org.testng.annotations.DataProvider;
import testpack.sample_Api;

public class Testdata {
			
@DataProvider(name="SearchProvider")
public static String[][] getDataFromDataprovider() throws JSONException{
return new String[][] {
{ "14.142.123.250" },
{ "14.142.123.250" },
{ "14.142.123.250" }};  
}
}


