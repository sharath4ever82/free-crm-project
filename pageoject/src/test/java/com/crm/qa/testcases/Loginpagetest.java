package com.crm.qa.testcases;
import java.io.IOException;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.Testbase;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.Loginpage;
public class Loginpagetest extends Testbase{
	
	
	WebDriver driver;
	Loginpage loginpage;
	Homepage homepage;
	public Loginpagetest()
	{
		super();
	}
	
	@BeforeMethod
	public void start() throws IOException
	{  
	driver=intialize();
    loginpage=new Loginpage();
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	@Test(priority=1)
	public void checklogin()
	{	
      homepage= loginpage.login(p.getProperty("un"),p.getProperty("pwd"));
       
    }
	@Test(priority=2)
	public void Titletest()
	{
	  String Title=loginpage.crmtitle();
	  Assert.assertEquals(Title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	@Test(priority=3)
	public void testcrmlogo()
	{
	 loginpage.validateimage();
	}
	
	

}
