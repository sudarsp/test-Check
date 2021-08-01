package com.fw;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Ticket_Page {
	WebDriver driver;
	
	public WebDriver abcd() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\supaneer\\Desktop\\New folder (2)\\chromedriver.exe" );
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://stg.opstic.tatacommunications.com/catalyst-v4/#/itsm/sr/details/REQTCL0298623");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Thread.sleep(10000);
		driver.findElement(By.name("username")).sendKeys("Tat321@gmail.com");
		WebElement pass=driver.findElement(By.name("password"));
		pass.sendKeys("Tat321@gmail.com");
		pass.sendKeys(Keys.TAB);
		
		driver.findElement(By.name("login")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[contains(text(),'comments')]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[contains(text(),'Refresh')]")).click();
		Thread.sleep(10000);
	     return driver;
		
		
		}

}
