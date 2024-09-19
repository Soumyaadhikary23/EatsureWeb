//package com.eatsure.utility;
//
//import java.io.FileInputStream;
//import java.util.Properties;
//
//public class Properties {
//
//
//	public static Properties prop;
//
//	   public static void init(){
//
//			if(prop==null){
//				prop=new Properties();
//				try {
//					//System.getProperty("user.dir")---->
//					//This point to current directoery then give the path of "projectconfigurations.properties file"
//					//to Utilize we need to use"prop.getProperty(url)"
//					FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"src//Variable.properties");
//
//					prop.load(fs);
//					//return prop;
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//			//return prop;
//		}
//
//
//
//}
