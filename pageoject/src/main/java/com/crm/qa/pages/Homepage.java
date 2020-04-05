package com.crm.qa.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Testbase;

public class Homepage extends Testbase{
	
@FindBy(xpath="//td[contains(text(),'User: Demo User')]")
WebElement homepagecheck;

@FindBy(xpath="//a[contains(text(),'Contacts')]")
WebElement contacts;

@FindBy(xpath="//a[contains(text(),'Alerts')]")
WebElement Alerts;
@FindBy(xpath="//a[contains(text(),'New Contact')]")
WebElement Newcontact;

	
public Homepage(){
	PageFactory.initElements(driver, this);
}

public Boolean checktextofhomepage()
{
 return homepagecheck.isDisplayed();
}
public Contatcspage contactslink()
{
	contacts.click();
	return new Contatcspage();
}
public void Alertslink()
{
	Alerts.click();
}
public void newcontactlink() 
{
 Actions actions=new Actions(driver);
 actions.moveToElement(contacts).build().perform();
 Newcontact.click();
}
}
