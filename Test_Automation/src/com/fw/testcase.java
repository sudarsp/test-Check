package com.fw;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class testcase {
WebDriver driver;
	@Test
	public void abaas() throws InterruptedException
	{
		Ticket_Page Tp = new Ticket_Page();
		driver=Tp.abcd();
		page1 p1= new page1(driver);
		Boolean abc=p1.abcde();
		Assert.assertTrue("true",abc);
		driver.close();
	}
}
