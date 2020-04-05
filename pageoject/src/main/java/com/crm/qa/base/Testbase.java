package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.utilities.listener;

public class Testbase {

public static WebDriver driver;
public static Properties p;
public Testbase(){
try{
	p=new Properties();
 FileInputStream f=new FileInputStream("/Users/sharathkoppera/Documents/workspace/pageoject/src/main/java/com/crm/qa/config/config.properties");
  p.load(f);
}
catch(FileNotFoundException e)
{
 e.printStackTrace();
}
catch(IOException e)
{
	e.printStackTrace();
}
}
public static WebDriver intialize()
{
String browser= p.getProperty("browsername");
if(browser.equals("ff"))
{
	  System.setProperty("webdriver.gecko.driver","/Users/sharathkoppera/Downloads/geckodriver");
	  driver=new FirefoxDriver();
}
else if(browser.equals("chrome"))
{
	  System.setProperty("webdriver.chrome.driver","/Users/sharathkoppera/Downloads/chromedriver");
	    driver=new ChromeDriver();  
}

  EventFiringWebDriver ed=new EventFiringWebDriver(driver);
  listener l=new listener();
  ed.register(l);
  driver=ed;
  driver.manage().window().maximize();
  driver.manage().deleteAllCookies();
  driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  driver.get(p.getProperty("url")); 
  return driver;
}
public static  void switchtoframe()
{
   driver.switchTo().frame("mainpanel");
  
}

}
