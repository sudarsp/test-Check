package com.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class page1 {
	WebDriver driver;
public page1(WebDriver driver)
{
	this.driver=driver;
	}


public Boolean abcde() throws InterruptedException
{Boolean ab=false;
	String abcdee=driver.findElement(By.xpath("(//div[@class='col-md-7 ticket-comments'])[7]/table/tbody/tr[2]/td[2]")).getText();
	Thread.sleep(10000);
	String cc=driver.findElement(By.xpath("(//div[@class='col-md-7 ticket-comments'])[1]/table/tbody/tr[2]/td[2]")).getText();
	
	System.out.println(abcdee);
	System.out.println(cc);
	if(cc.contains("Policy ID"))
	{
		ab=true;
	}
	
	if(abcdee.contains("Risk Exist"))
	{
		ab=true;
	}
	
	return ab;
}

}
