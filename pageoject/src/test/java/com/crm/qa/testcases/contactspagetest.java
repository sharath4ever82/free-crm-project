package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.Contatcspage;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.utilities.Testutilities;

public class contactspagetest extends Testbase {
	WebDriver driver;
	Loginpage loginpage;
	Homepage homepage;
	Contatcspage contactspage;
	Testutilities utilities;
	public contactspagetest()
	{
		super();
	}
   
@BeforeMethod
public void start()
{
	driver=intialize();
    loginpage=new Loginpage();
    utilities=new Testutilities();
    contactspage=new Contatcspage();
    homepage= loginpage.login(p.getProperty("un"),p.getProperty("pwd"));
    homepage=new Homepage();
    switchtoframe();
    
    	
}
@AfterMethod
public void teardown()
{
	driver.quit();
}
@DataProvider
public Object[][] gettestdata() throws InvalidFormatException, IOException
{
Object data[][]= Testutilities.newcontactdata();
return data;
}
@Test(priority=1)
public void checkcontactstext()
{  
	homepage.contactslink();
	Assert.assertTrue(contactspage.contactstext());
}
@Test(priority=2)
public void validatenewcontact()
{   
	homepage.newcontactlink();
	contactspage.newcontactdetails("Mr.","sharath","reddy","wipro");
}
@Test(priority=3,dataProvider="gettestdata")
public void validatenewcontacts(String title,String fname,String lastname,String companyname)
{  
	homepage.newcontactlink();
	contactspage.newcontactdetails(title,fname,lastname,companyname);
}

}
