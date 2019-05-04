package generic;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Paths;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


public abstract class BaseTest implements AutoConst 
{
	public static WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports reports;
	public static ExtentTest test;
	public static String snap;
	
	
	// Runs before the suites runs and sets up the Reporting Functionality
	@BeforeSuite
	public void settingUpReport()
	{
		htmlReporter= new ExtentHtmlReporter("./Reports/DeltaX_AssignmentReport_"+SystemDate.currentDate()+".html");
		reports= new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		reports.setSystemInfo("Opereating System", "Windows10");
		reports.setSystemInfo("Environment", "QA");
		reports.setSystemInfo("User Name", "Amar");
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("TestURL", "http://adjiva.com/qa-test/");
		
		htmlReporter.config().setDocumentTitle("DeltaX_AssignmentReport");
		htmlReporter.config().setReportName("DeltaX_AssignmentReport");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setChartVisibilityOnOpen(false);
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
	
	// Runs before every method
	// Open  the application
	@BeforeMethod
	public void openApplication(Method method) throws InterruptedException
	{	
		//Open the browser
		System.setProperty(CHROME_KEY,CHROME_VALUE);
		
		driver=new ChromeDriver();

		Dimension d= new Dimension(900, 500);
		driver.manage().window().setSize(d);
		driver.manage().window().maximize();

		//Opening the application
		driver.get("http://adjiva.com/qa-test/");
	
	}
	
	
	//Runs after every method
	//Closes the  application
	@AfterMethod
	public void closeApplication(ITestResult result) throws IOException, InterruptedException
	{
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String name= result.getName();
			String screenshotpath = ScreenShot.takeScreenshot(driver, SNAP_PATH+name);
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" failed becuase of below issue", ExtentColor.RED));
			test.fail(result.getThrowable());
			test.fail("SnapShot Below:", MediaEntityBuilder.createScreenCaptureFromPath(Paths.get("").toAbsolutePath().toString() + screenshotpath).build());
			driver.quit();

		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" is pass ", ExtentColor.GREEN));
			driver.quit();
		}
		
		else
		{
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" is skipped because of below issue ", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
			driver.quit();
		}
		
	}
	
	
	//Runs after the suite
	@AfterSuite
	public void tearDown()
	{
		reports.flush();
	}
	

}
