package com.eatsure.utils;

import org.testng.annotations.DataProvider;

public class DataProviderUtility {

	@DataProvider
	public Object[][] getData() {
		//Row stands for how many different data types test should run
		//column stands for how many values per each test

		//Array size is 1 for rown and 4 for column


//		Object[][] data=new Object[2][4];
		Object[][] data=new Object[1][4];
		//0th row
		data[0][0]="Nerul east";
		data[0][1]="7220022001";
		data[0][2]="Ishaani";
		data[0][3]="ranjan.gvit3@gmail.com";


		//1st row
//		data[1][0]="Nerul west";
//		data[1][1]="1111111112";
//		data[1][2]="Ishaani1";
//		data[1][3]="ranjan.gvit@gmail.com";
		return data;
	}

}
