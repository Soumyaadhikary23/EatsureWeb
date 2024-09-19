package com.eatsure.utility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelRead {

	public static int getRowCount(String xlPath,String Sheet)
	{
		int rc=0;

		try
		{
			FileInputStream fis=new FileInputStream(xlPath);
			Workbook wb=WorkbookFactory.create(fis);
			rc=wb.getSheet(Sheet).getLastRowNum();
		}
		catch(Exception e)
		{

		}
		return rc;
	}

	public static String getCellValue(String xlPath,String Sheet,int r, int c)
	{
		String v="";
		try
		{
			FileInputStream fis=new FileInputStream(xlPath);
			Workbook wb=WorkbookFactory.create(fis);
			v=wb.getSheet(Sheet).getRow(r).getCell(c).toString();
		}
		catch(Exception e)
		{

		}
		return v;

	}

}
