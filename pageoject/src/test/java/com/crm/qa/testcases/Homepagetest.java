package com.crm.qa.testcases;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.Contatcspage;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.utilities.Testutilities;


public class Homepagetest extends Testbase {
	WebDriver driver;
	Loginpage loginpage;
	Homepage homepage;
	Contatcspage contactspage;
	Testutilities utilities;
	public Homepagetest(){
		super();
	}
	
	@BeforeMethod
	public void start()
	{
		driver=intialize();
	    loginpage=new Loginpage();
	    contactspage=new Contatcspage();
	    utilities=new Testutilities();
	    homepage= loginpage.login(p.getProperty("un"),p.getProperty("pwd"));
	    switchtoframe();
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	@Test(priority=1)
	public void textcheckinhomepage()
	{
	 
	 Assert.assertTrue(homepage.checktextofhomepage());
	}
	@Test(priority=2)
	public void checkcontactslink()
	{  
	
		contactspage=homepage.contactslink();
		
	}
	@Test(priority=3)
	public void checkAlertslink()
	{
		homepage.Alertslink();
		System.out.println("Alerts link is working");
	}
	@Test(priority=4)
	public void checknewcontactslink() 
	{
	 homepage.newcontactlink();
	 
	}
		
}
