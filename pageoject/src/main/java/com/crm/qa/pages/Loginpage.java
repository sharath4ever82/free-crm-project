package com.crm.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Testbase;

public class Loginpage extends Testbase {

	@FindBy(xpath="//*[@id='loginForm']/div/input[1]")
	WebElement username;
	
	@FindBy(xpath="//*[@id='loginForm']/div/input[2]")
	WebElement password;
	
	@FindBy(xpath="//*[@id='loginForm']/div/div/input")
	WebElement login;
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement logo;
	
	public Loginpage(){
	 PageFactory.initElements(driver,this);
	}
	public Homepage login(String x,String y)
	{
	  username.sendKeys(x);
	  password.sendKeys(y);
	  login.sendKeys(Keys.ENTER);
	  return new Homepage();
	}
	public String crmtitle()
	{
		String x=driver.getTitle();
		return x;
	}
	public boolean validateimage()
	{
	 return logo.isDisplayed();
	}
}
