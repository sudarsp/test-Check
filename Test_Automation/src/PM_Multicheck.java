import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class PM_Multicheck {
	

 public WebDriver login() throws InterruptedException
 
 {
	 
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\supaneer\\Desktop\\New folder (2)\\chromee\\chromedriver.exe");
	 WebDriver driver = new ChromeDriver();
	 driver.get("https://stg.opstic.tatacommunications.com/catalyst-v4/#/pm/schedule-action");
	 //driver.get("https://stg.opstic.tatacommunications.com/catalyst-v4/#/pm");
		Thread.sleep(10000);
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("cspmigrationuser");
		Thread.sleep(3000);
		driver.findElement(By.id("password")).sendKeys("Tata@1234") ;
		Thread.sleep(3000);
		driver.findElement(By.name("login")).click() ;
		Thread.sleep(25000);
		
		//driver.findElement(By.)
		System.out.println("Logged in to portal");
		return driver;
		
		
 }
 
 
 public void Create_Advisory(WebDriver driver)
 { 
	 Select category = new Select(driver.findElement(By.name("category")));
	 category.selectByValue("Windows");
	 driver.findElement(By.name("name")).sendKeys("Patch_Patch");
	 
	 
	 Select type = new Select(driver.findElement(By.name("type")));
	 type.selectByValue("Security");
	 
	 Select severity = new Select(driver.findElement(By.name("type")));
	 type.selectByValue("severity");
	 
	 Select version = new Select(driver.findElement(By.id("version")));
	 type.selectByValue("version");
	 
	 driver.findElement(By.name("expiryDate")).sendKeys("20-06-2021");
	 
	 driver.findElement(By.name("KBNumber")).sendKeys("KB_005");
	 
	 driver.findElement(By.xpath("//div[@class='col-sm-2 m-tb-30 col-sm-offset-5']/button[text()='Create']"));
	 	
 }
 
 public String SelectPatch(WebDriver driver,String patchname) throws InterruptedException
 {
	 driver.findElement(By.xpath("//span[@class='selected-item ng-star-inserted']/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.className("dropdown-btn")).click();
		Thread.sleep(3000);
		//String patchname= "Patch_Winn";
		//driver.findElement(By.xpath("//div[@class='multiselect-dropdown']/div//*[text()='"+patchname+"']/./parent::*/div")).click();
		driver.findElement(By.xpath("//div[@class='dropdown-list']/ul/li/*[text()='"+patchname+"']")).click();
		
		//driver.findElement(By.xpath("//div[@class='dropdown-list']/ul/li[39]")).click();		
		Thread.sleep(3000);
		Thread.sleep(3000);
		return patchname;
 }
 
 public String inc(WebDriver driver) throws InterruptedException, ClassNotFoundException, SQLException
 {
	 int i;
	 String[] intArray = new String[5];
//	 intArray[0]="SG03MINITAVMT01";
	 intArray[0]="SG03MINITAVMT01";
	 intArray[1]="CHNINITMSKMS01";
	 intArray[2]="MUMMINITCER01";
	 	 
	for(i=0;i<=2;i++)
	{
		
		Thread.sleep(3000);
		 System.out.println(intArray.length);
        System.out.println(intArray[i]);
		driver.findElement(By.xpath("(//table[@class='table ng-star-inserted']/tbody//*[text()='"+intArray[i]+"']/preceding-sibling::*/./child::*)")).click();
	
	//driver.findElement(By.xpath("(//table[@class='table ng-star-inserted']/tbody//*[text()='SG03MINITAVMT01']/preceding-sibling::*)")).click();
	//driver.findElement(By.xpath("(//table[@class='table ng-star-inserted']/tbody/tr[3]/td/./child::*)[1]")).click();
	Thread.sleep(3000);
	System.out.println("successfully clicked the expected CI   "+ intArray[i]);
   // driver.findElement(By.xpath("//div[@class='col-md-6 pull-right p-all-0 m-b-15 ng-star-inserted']/button")).click();		
	//driver.findElement(By.xpath("//div[@class='multiselect-dropdown']/div//*[text()='"+patchname+"']/./parent::*/div")).click();
	Thread.sleep(3000);
	approve(driver);
	scheduleapprove(driver);
	Cilck_schedule(driver);
	String SRR=Get_details(driver,intArray[i]);
	sql_Connection.sqlfunc(intArray[i],SRR);
	System.out.println("Scheduled patch for"+ intArray[i]);
	
	}
	return intArray[i];
	}

public void approve(WebDriver driver)
{
	driver.findElement(By.xpath("//div[@class='col-md-6 pull-right p-all-0 m-b-15 ng-star-inserted']/button")).click();
	
	}

public void scheduleapprove(WebDriver driver) throws InterruptedException
{
	Thread.sleep(10000);
	WebElement abc=driver.findElement(By.name("scheduleName"));
	
	JavascriptExecutor js = (JavascriptExecutor)driver;	            
    // WebElement element = driver.findElement(By.Id("User"));

    js.executeScript("arguments[0].value='patchh'", abc);
	abc.sendKeys("Patch");	
	Thread.sleep(5000);
	driver.findElement(By.xpath("//button[@class='close pull-right']/span")).click();
	Thread.sleep(5000);
	approve(driver);
	Thread.sleep(10000);
	WebElement abc1=driver.findElement(By.name("scheduleName"));
	
	JavascriptExecutor js1 = (JavascriptExecutor)driver;
	js1.executeScript("arguments[0].value='patchh'", abc1);
	abc1.sendKeys("Patch");	
}
public void Cilck_schedule(WebDriver driver) throws InterruptedException
{
	
	System.out.println("Entered the schedule name");
	Thread.sleep(10000);
	driver.findElement(By.xpath("//div[@class='col-xs-offset-10 col-xs-2']/button")).click();
	Thread.sleep(10000);
	System.out.println("Schedule approved!!!");
}


public void refresh_content_Multi(WebDriver driver) throws InterruptedException
{
driver.navigate().refresh();
	
	Thread.sleep(20000);
	System.out.println("it is refreshed ");
}

public String Get_details(WebDriver driver,String intArray ) throws InterruptedException
{
	 Actions actions = new Actions(driver);

	    // Scroll Down using Actions class
	    //actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();

	    // Scroll Up using Actions class
	    actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
		Thread.sleep(5000);
		driver.findElement(By.className("dropdown-btn")).click();	
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='dropdown-list']/ul/li/*[text()='Patch_check_007']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='dropdown-list']/ul/li/*[text()='Patch_check_007']")).click();	
				Thread.sleep(10000);   
    String SR=driver.findElement(By.xpath("(//table[@class='table ng-star-inserted']/tbody//*[text()='"+intArray+"']/following-sibling::*)[2]")).getText();
	//String SR=driver.findElement(By.xpath("//table[@class='table ng-star-inserted']/tbody/tr[3]/td[4]")).getText();
	System.out.println("SR id:  "+SR);
	Thread.sleep(3000);
	String ScheduleTime=driver.findElement(By.xpath("(//table[@class='table ng-star-inserted']/tbody//*[text()='"+intArray+"']/following-sibling::*)[3]")).getText();
	System.out.println("Start time: "+ScheduleTime);
	return SR;
	}

public String multi_Check(WebDriver driver) throws InterruptedException, ClassNotFoundException, SQLException
{
	 int i;
	 String[] intArray = new String[5];
	 intArray[0]="CHNINITMSKMS01";
	 intArray[1]="MUMMINITCER01";
	 
	for(i=0;i<=1;i++)
	{
		//Thread.sleep(3000);
		System.out.println(intArray[i]);
        driver.findElement(By.xpath("(//table[@class='table ng-star-inserted']/tbody//*[text()='"+intArray[i]+"']/preceding-sibling::*/./child::*)")).click();
		System.out.println("Clicked on the selected CI to schedule");
	}
	i--;
	approve(driver);
	scheduleapprove(driver);
	Cilck_schedule(driver);
	String SRR=Get_details(driver, intArray[i]);
	sql_Connection.sqlfunc(intArray[i],SRR);
	return intArray[i];

}


}
