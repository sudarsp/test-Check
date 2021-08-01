	import com.thoughtworks.selenium.webdriven.JavascriptLibrary;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bson.json.JsonReader;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.json.Json;
import org.openqa.selenium.support.Color;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.How;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
	import org.openqa.selenium.support.ui.ExpectedCondition;
	import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.ArrayList;
	import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class check_Highchart {
    @Test
	public void abc() throws JSONException
      {
    	 /*
    	 String ss = "{\"took\":3,\"timed_out\":false,\"_shards\":{\"total\":5,\"successful\":5,\"skipped\":0,\"failed\":0},\"hits\":{\"total\":{\"value\":79,\"relation\":\"eq\"},\"max_score\":null,\"hits\":[]},\"aggregations\":{\"FromSource\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":1850517707,\"doc_count\":4,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":394346704,\"doc_count\":1},{\"key\":1161676904,\"doc_count\":1},{\"key\":1442374563,\"doc_count\":1},{\"key\":3118228748,\"doc_count\":1}]}},{\"key\":178913514,\"doc_count\":3,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":3118228735,\"doc_count\":2},{\"key\":782628250,\"doc_count\":1}]}},{\"key\":3277450230,\"doc_count\":3,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":1602235300,\"doc_count\":1},{\"key\":3118228999,\"doc_count\":1},{\"key\":3423116430,\"doc_count\":1}]}},{\"key\":168440724,\"doc_count\":2,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":1571708319,\"doc_count\":1},{\"key\":3113863014,\"doc_count\":1}]}},{\"key\":171180348,\"doc_count\":2,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":2953470920,\"doc_count\":1},{\"key\":2953472240,\"doc_count\":1}]}},{\"key\":178913498,\"doc_count\":2,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":2734115402,\"doc_count\":1},{\"key\":2953470920,\"doc_count\":1}]}},{\"key\":204578947,\"doc_count\":2,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":782624261,\"doc_count\":1},{\"key\":3118228732,\"doc_count\":1}]}},{\"key\":1615549321,\"doc_count\":2,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":394346704,\"doc_count\":1},{\"key\":3483797756,\"doc_count\":1}]}},{\"key\":1850515617,\"doc_count\":2,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":759993837,\"doc_count\":1},{\"key\":1502612497,\"doc_count\":1}]}},{\"key\":1850515845,\"doc_count\":2,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":3118228735,\"doc_count\":1},{\"key\":3118228745,\"doc_count\":1}]}},{\"key\":1850515865,\"doc_count\":2,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":394346704,\"doc_count\":1},{\"key\":3118228735,\"doc_count\":1}]}},{\"key\":1850515868,\"doc_count\":2,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":1841923428,\"doc_count\":1},{\"key\":3118228756,\"doc_count\":1}]}},{\"key\":1850517641,\"doc_count\":2,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":394346701,\"doc_count\":1},{\"key\":3118228949,\"doc_count\":1}]}},{\"key\":168440066,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":2870591764,\"doc_count\":1}]}},{\"key\":171180393,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":394346703,\"doc_count\":1}]}},{\"key\":178258125,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":303810044,\"doc_count\":1}]}},{\"key\":178258162,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":782628250,\"doc_count\":1}]}},{\"key\":178913302,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":1346612386,\"doc_count\":1}]}},{\"key\":178913306,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":2734115335,\"doc_count\":1}]}},{\"key\":178913501,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":2734115529,\"doc_count\":1}]}},{\"key\":178913508,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":3118228734,\"doc_count\":1}]}},{\"key\":178913513,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":782628250,\"doc_count\":1}]}},{\"key\":178913526,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":3118228735,\"doc_count\":1}]}},{\"key\":178913528,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":394346697,\"doc_count\":1}]}},{\"key\":180905151,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":1495218437,\"doc_count\":1}]}},{\"key\":183763294,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":782624261,\"doc_count\":1}]}},{\"key\":212874946,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":1476085492,\"doc_count\":1}]}},{\"key\":244282569,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":394346701,\"doc_count\":1}]}},{\"key\":852408323,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":3483797756,\"doc_count\":1}]}},{\"key\":852649521,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":3483797756,\"doc_count\":1}]}},{\"key\":853878823,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":3110361038,\"doc_count\":1}]}},{\"key\":853878841,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":1347571282,\"doc_count\":1}]}},{\"key\":853878881,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":3483797756,\"doc_count\":1}]}},{\"key\":853878911,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":3483797756,\"doc_count\":1}]}},{\"key\":853878927,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":3118228733,\"doc_count\":1}]}},{\"key\":853879022,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":1347571282,\"doc_count\":1}]}},{\"key\":853879025,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":1476085492,\"doc_count\":1}]}},{\"key\":854321029,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":1571708319,\"doc_count\":1}]}},{\"key\":854321068,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":3483797756,\"doc_count\":1}]}},{\"key\":854321134,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":1347571282,\"doc_count\":1}]}},{\"key\":1194257187,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":1571708319,\"doc_count\":1}]}},{\"key\":1194257203,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":3118228996,\"doc_count\":1}]}},{\"key\":1194257211,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":1347571282,\"doc_count\":1}]}},{\"key\":1267778890,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":2870591822,\"doc_count\":1}]}},{\"key\":1267967285,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":782624261,\"doc_count\":1}]}},{\"key\":1850515650,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":3112973699,\"doc_count\":1}]}},{\"key\":1850515654,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":3118228739,\"doc_count\":1}]}},{\"key\":1850515668,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":782628250,\"doc_count\":1}]}},{\"key\":1850515679,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":3118228733,\"doc_count\":1}]}},{\"key\":1850515680,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":782628250,\"doc_count\":1}]}},{\"key\":1850515764,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":3558162950,\"doc_count\":1}]}},{\"key\":1850515827,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":2734115528,\"doc_count\":1}]}},{\"key\":1850515838,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":3118228758,\"doc_count\":1}]}},{\"key\":1850515839,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":1046910021,\"doc_count\":1}]}},{\"key\":1850515869,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":782628250,\"doc_count\":1}]}},{\"key\":1850515876,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":3118228756,\"doc_count\":1}]}},{\"key\":1850516113,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":782628250,\"doc_count\":1}]}},{\"key\":1850516117,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":765048968,\"doc_count\":1}]}},{\"key\":1850516134,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":2734115528,\"doc_count\":1}]}},{\"key\":1850516141,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":394346697,\"doc_count\":1}]}},{\"key\":1850517722,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":2953470920,\"doc_count\":1}]}},{\"key\":1936815827,\"doc_count\":1,\"ToDestination\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,\"buckets\":[{\"key\":3558162950,\"doc_count\":1}]}}]}}}";
    	 System.out.println(ss);
    	JSONObject obj = new JSONObject(ss);
    	// String pageName = obj.getJSONObject("pageInfo").getString("pageName");

        //System.out.println(pageName);

         org.json.JSONArray arr = obj.getJSONArray("aggregations");
         for (int z = 0; z < arr.length(); z++) {
             Long post_id = arr.getJSONObject(z).getLong("total");
             System.out.println(post_id);
             System.out.println("check");
             */
  //JAVA LONG ARRAY DECLARATION
  long a[];
  //MEMORY ALLOCATION FOR JAVA LONG ARRAY
  a = new long[55];
  //ASSIGNING ELEMENTS TO JAVA LONG ARRAY
  a[0]=454099802L;
  a[1]=1035054349L;
  a[2]=1866715098L;
  a[3]=1989212190L;
  a[4]=1035054187L;
  a[5]=1035054346L;
  a[6]=2937310475L;
  a[7]=661239171L;
  a[8]=1035054350L;
  a[9]=1944484989L;
  a[10]=795771485L;
  a[11]=1999485489L;
  a[12]=2050166868L;
  a[13]=1035054348L;
  a[14]=1035054348L;
  a[15]=1989212190L;
  a[16]=3027609526L;
  a[17]=3078837554L;
  a[18]=1779391651L;
  a[19]=1880781162L;
  a[20]=1848320682L;
  a[21]=2030366316L;
  a[22]=1944484989L;


  //LONG ARRAY OUTPUT
  System.out.println("Java long Array Example");
  for(int i=0;i<a.length;i++)
  {
	  
	  
    //System.out.println("Element at Index : "+ i + " " + a[i]);
    
    Long ipLong = Long.valueOf(a[i]);

  //Long ipLong = Long.valueOf(ip);
  StringBuilder result = new StringBuilder(15);

  for (int j= 0; j < 4; j++) {

      result.insert(0, Long.toString(ipLong & 0xff));
      
      if (j < 3) {

          result.insert(0, '.');

      }

      ipLong = ipLong >> 8;
     
  }
  System.out.println(result.toString());
  }
}
      }
     

/*
 int[] intArray = new int[]{ 1.1.1.1,213,3,4,5,6,7,8,9,10 }; 
 for(int i=0;i)
Long ipLong = Long.valueOf(394346704);

//Long ipLong = Long.valueOf(ip);
StringBuilder result = new StringBuilder(15);

for (int i = 0; i < 4; i++) {

    result.insert(0, Long.toString(ipLong & 0xff));
    
    if (i < 3) {

        result.insert(0, '.');

    }

    ipLong = ipLong >> 8;
    System.out.println(result.toString());

}
*/




/*
 public void tests() throws InterruptedException
	{

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\supaneer\\Desktop\\New folder (2)\\chromedriver.exe");
	//System.setProperty("webdriver.chrome.driver", "C:\\Users\\supaneer\\Downloads\\chromedriver_win32 (5)\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\supaneer\\Desktop\\Chrome\\chromedriver_win32 (6)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://ipcloud.tatacommunications.com/catalyst");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("@tatacommunications.com");
		Thread.sleep(3000);
		//driver.findElement(By.id("password")).sendKeys("Mssdemo@2018#") ;
		
		WebElement webElement = driver.findElement(By.id("username"));//You can use xpath, ID or name whatever you like
		webElement.sendKeys(Keys.TAB);
		
		
		driver.manage().timeouts().implicitlyWait(5000,  TimeUnit.MILLISECONDS);
		Thread.sleep(5000);
		driver.navigate().to("https://ipcloud.tatacommunications.com/catalyst-v4/#/threat-management/siem/alert-dashboard");
		Thread.sleep(10000);
		System.out.println("suxccess");
		
	}
*/
 


