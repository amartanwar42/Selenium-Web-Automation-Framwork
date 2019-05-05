package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class Utility {
	public static String getPhoto(WebDriver driver, String folder) {
		Date d = new Date();
		String dateTime = d.toString().replaceAll(":", "_");
		String path = folder+"/"+dateTime+".png";
		
		try {
			TakesScreenshot t = (TakesScreenshot) driver;
			File srcFile = t.getScreenshotAs(OutputType.FILE);
			File destFile = new File(path);
			FileUtils.copyFile(srcFile, destFile);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}

	public static WebDriver openBrowser(String ip, String browser)
	{
		WebDriver driver;
		if(ip.equals("localhost"))
		{
			if(browser.equals("chrome"))
			{
				driver=new ChromeDriver();
			}
			else {
				driver=new FirefoxDriver();
			}
		}
		else {
			try {
				URL url = new URL("http://"+ip+":4444/wd/hub");
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(browser);
				driver= new RemoteWebDriver(url,cap);
			}
			catch (Exception e)
			{
				e.printStackTrace();
				driver = new ChromeDriver();
			}
		}
		return driver;
	}

	public static String getXLData(String path, String sheet, int r, int c) {
		String v ="";
		try {
			Workbook w = WorkbookFactory.create(new FileInputStream(path));
			v = w.getSheet(sheet).getRow(r).getCell(c).toString();		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return v;
	}

	public static String getPropertyValue(String path, String key) {
		String v="";
		try {
			Properties p = new Properties();
			p.load(new FileInputStream(path));
			v=p.getProperty(key);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return v;
	}

	public static void writeResultToXL(String path, int passCount, int failCount)
	{
		try {
			Workbook w = WorkbookFactory.create(new FileInputStream(path));
			w.getSheet("Sheet1").getRow(1).getCell(0).setCellValue(passCount);
			w.getSheet("Sheet1").getRow(1).getCell(1).setCellValue(failCount);
			w.write(new FileOutputStream(path));
			w.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}