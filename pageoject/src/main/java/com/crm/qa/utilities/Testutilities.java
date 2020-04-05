package com.crm.qa.utilities;


import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

import com.crm.qa.base.Testbase;

public class Testutilities extends Testbase {
	public static int rowcount;
    public static int cellcount;
    public static int i;
    public static int j;
    public static WebDriver driver;
   

    
	
	public static Object[][] newcontactdata() throws InvalidFormatException, IOException 
	{
		Object a[][] = new Object [3][4];
	    FileInputStream f=new FileInputStream("/Users/sharathkoppera/Desktop/Workbook3.xlsx");
        Workbook wb=WorkbookFactory.create(f);
        Sheet s=wb.getSheetAt(0);
        rowcount=s.getLastRowNum();
        for (i=0;i<rowcount;i++)
        {
         Row r=s.getRow(i+1);
         cellcount=r.getLastCellNum();
         for(j=0;j<cellcount;j++)
         {
          Cell c=r.getCell(j); 
          if(c.getCellType()==c.CELL_TYPE_STRING)		
         	{
         	  a[i][j]=c.getStringCellValue();
         	}
         	else if(c.getCellType()==c.CELL_TYPE_NUMERIC)
         	{
         	  a[i][j]=c.getStringCellValue();
         	}
       	}
         }
         return a;
        }
	
	
}