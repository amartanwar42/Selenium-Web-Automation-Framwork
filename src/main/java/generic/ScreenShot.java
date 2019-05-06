package generic;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public  class ScreenShot 
{
	
	public static  String takeScreenshot(WebDriver driver,String folder) 
	{
		TakesScreenshot t= (TakesScreenshot)driver;
		Date d=new Date();
		String date=d.toString().replace(":", "-");
		String dst=folder+date+".png";
		System.out.println(dst);
		File srcFile=t.getScreenshotAs(OutputType.FILE);
		File dstfile= new File(dst);
		try
		{
			FileUtils.copyFile(srcFile, dstfile);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return dst;
	}
}
