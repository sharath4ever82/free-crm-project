package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.Testbase;

public class Contatcspage extends Testbase {


@FindBy(xpath="//td[contains(text(),'Contacts')]")
WebElement contacts;
@FindBy(xpath="//input[@id='first_name']")
WebElement firstname;
@FindBy(xpath="//input[@id='surname']")
WebElement surname;
@FindBy(xpath="//input[@name='client_lookup']")
WebElement company;
@FindBy(xpath="//input[@type='submit' and @value='Save']")
WebElement save;
@FindBy(xpath="//select[@name='title']")
WebElement Title;

public Contatcspage(){
	PageFactory.initElements(driver,this);
}

public Boolean contactstext()
{
 return contacts.isDisplayed();
}
public void newcontactdetails(String title,String fname,String lastname,String companyname)
{   
	
	Select select=new Select(Title);
	select.selectByVisibleText(title);
	firstname.sendKeys(fname);
	surname.sendKeys(lastname);
	company.sendKeys(companyname);
	save.click();
	System.out.println("new contact created succesfully");
}


	
	
	
}
