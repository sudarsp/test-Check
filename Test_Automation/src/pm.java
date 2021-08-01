import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class pm {
	

 public WebDriver abcde(String Patchname) throws InterruptedException
 
 {
	 
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\supaneer\\Desktop\\New folder (2)\\chromee\\chromedriver.exe");
	 WebDriver driver = new ChromeDriver();
	 driver.get("https://stg.opstic.tatacommunications.com/catalyst-v4/#/pm/schedule-action");
		Thread.sleep(10000);
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("cspmigrationuser");
		Thread.sleep(3000);
		driver.findElement(By.id("password")).sendKeys("Tata@1234") ;
		Thread.sleep(3000);
		driver.findElement(By.name("login")).click() ;
		Thread.sleep(25000);
		System.out.println("done");
		driver.findElement(By.xpath("//span[@class='selected-item ng-star-inserted']/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.className("dropdown-btn")).click();
		Thread.sleep(3000);
		//String patchname= "Patch_Winn";
		//driver.findElement(By.xpath("//div[@class='multiselect-dropdown']/div//*[text()='"+patchname+"']/./parent::*/div")).click();
		
		driver.findElement(By.xpath("//div[@class='dropdown-list']/ul/li/*[text()='"+Patchname+"']")).click();
		//driver.findElement(By.xpath("//div[@class='dropdown-list']/ul/li[39]")).click();	
		Thread.sleep(3000);
		System.out.println("pending on click table");
		Thread.sleep(3000);	
		
	
		
			//driver.findElement(By.xpath("(//table[@class='table ng-star-inserted']/tbody//*[text()='"+intArray[i]+"']/preceding-sibling::*)")).click();
	
	
		return driver;
		
 }
 
 public void inc(WebDriver driver, String CIname) throws InterruptedException
 {
		driver.findElement(By.xpath("(//table[@class='table ng-star-inserted']/tbody//*[text()='"+CIname+"']/preceding-sibling::*)")).click();
		//driver.findElement(By.xpath("(//table[@class='table ng-star-inserted']/tbody/tr[3]/td/./child::*)[1]")).click();
		Thread.sleep(3000);
		System.out.println("successfully clicked the expected icon");
	    driver.findElement(By.xpath("//div[@class='col-md-6 pull-right p-all-0 m-b-15 ng-star-inserted']/button")).click();		
		//driver.findElement(By.xpath("//div[@class='multiselect-dropdown']/div//*[text()='"+patchname+"']/./parent::*/div")).click();
		Thread.sleep(3000);
		scheduleapprove(driver);
		Get_details(driver,CIname);
 }
/*
public void approve()
{
	driver.findElement(By.xpath("//div[@class='col-md-6 pull-right p-all-0 m-b-15 ng-star-inserted']/button")).click();
	
	}
	
*/

public void scheduleapprove(WebDriver driver) throws InterruptedException
{
	System.out.println("sys sys");
	driver.findElement(By.name("scheduleName")).sendKeys("Schedule");
	driver.findElement(By.xpath("//div[@class='col-xs-offset-10 col-xs-2']/button")).click();
	Thread.sleep(3000);
}

public void refresh_content(WebDriver driver) throws InterruptedException
{
	//instead click and unclick particular patch 
	driver.navigate().refresh();	
	Thread.sleep(15000);
	System.out.println("it is refreshed ");
	//driver.findElement(By.xpath("//span[@class='selected-item ng-star-inserted']/a")).click();
	// click on the compose button as soon as the "compose" button is visible
	driver.findElement(By.xpath("//span[@class='selected-item ng-star-inserted']/a")).click();
	Thread.sleep(3000);
}

public String Get_details(WebDriver driver, String CIname) throws InterruptedException
{
	  Actions actions = new Actions(driver);

	    // Scroll Down using Actions class
	    //actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();

	    // Scroll Up using Actions class
	    actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
		
		System.out.println("SEarching for elementss");
		Thread.sleep(5000);
		//WebDriverWait wait = new WebDriverWait(driver,60);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dropdown-btn")));
		
		driver.findElement(By.className("dropdown-btn")).click();	
		System.out.println("found");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='dropdown-list']/ul/li/*[text()='qqq_Qqq']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='dropdown-list']/ul/li/*[text()='qqq_Qqq']")).click();	
		
		Thread.sleep(10000);
		//driver.findElement(By.xpath("//span[@class='selected-item ng-star-inserted']/a")).click();
		//Thread.sleep(5000);
		//driver.findElement(By.className("dropdown-btn")).click();
		//Thread.sleep(3000);
		
		  String SR=driver.findElement(By.xpath("(//table[@class='table ng-star-inserted']/tbody//*[text()='"+CIname+"']/following-sibling::*)[2]")).getText();
		//String SR=driver.findElement(By.xpath("//table[@class='table ng-star-inserted']/tbody/tr[3]/td[4]")).getText();
		System.out.println("SR id:  "+SR);
		Thread.sleep(3000);
		//String ScheduleTime=driver.findElement(By.xpath("//table[@class='table ng-star-inserted']/tbody/tr[3]/td[5]")).getText();
		String ScheduleTime=driver.findElement(By.xpath("(//table[@class='table ng-star-inserted']/tbody//*[text()='"+CIname+"']/following-sibling::*)[3]")).getText();
		System.out.println("Start time:   "+ScheduleTime);
		return SR;
	}
}
