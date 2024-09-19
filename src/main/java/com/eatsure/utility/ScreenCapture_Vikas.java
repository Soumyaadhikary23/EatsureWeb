package com.eatsure.utility;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

public class ScreenCapture_Vikas {
	public static void screenCaptureofDesktop()
	{
		try{
				Robot robot=new Robot();
				Dimension desktop=Toolkit.getDefaultToolkit().getScreenSize();
				Rectangle screenRect=new Rectangle(desktop);
				BufferedImage img=robot.createScreenCapture(screenRect);
				SimpleDateFormat s=new SimpleDateFormat("YYYY_MM_dd_hh_mm_ss");
				String d=s.format(new Date());
				ImageIO.write(img, "png", new File("C:/Temp/Temp/workspace/AutPracticeOCT/ScreenShot/"+d+".png"));

			}
		catch(Exception e){}
	}

}
