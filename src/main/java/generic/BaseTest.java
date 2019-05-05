package generic;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
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
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import pom.mgc.LoginPage;


public abstract class BaseTest implements IAutoConst
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
		htmlReporter= new ExtentHtmlReporter("Reports/MGC_TestReport_"+SystemDate.currentDate()+".html");
		reports= new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		reports.setSystemInfo("Opereating System", "mac");
		reports.setSystemInfo("Environment", "QA");
		reports.setSystemInfo("User Name", "Sumit");
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("TestURL", "screenshotpathhttps://mgcuat.com/mgc-direct-web/userin.do/log");
		
		htmlReporter.config().setDocumentTitle("MGC");
		htmlReporter.config().setReportName("MGC_TestReport");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setChartVisibilityOnOpen(false);
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
	
	// Runs before every method
	// Open  the application
	@BeforeMethod
	public void openApplication(Method method) throws InterruptedException
	{
        test=reports.createTest(method.getName());
		//Open the browser
		System.setProperty(CHROME_KEY,CHROME_VALUE);
		
		driver=new ChromeDriver();

		Dimension d= new Dimension(900, 500);
		driver.manage().window().setSize(d);
		driver.manage().window().maximize();

		//Opening the application
		driver.get("https://mgcuat.com/mgc-direct-web/user/login.do");
        LoginPage loginPage=new LoginPage(driver,test);
        loginPage.enterEmaiilId("sumitk+2@boston-technology.com");
        loginPage.enterPwd("loveuPap@9");
        loginPage.clickOnLoginButton();
	}
	
	
	//Runs after every method
	//Closes the  application
	@AfterMethod
	public void closeApplication(ITestResult result) throws IOException, InterruptedException
	{
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String name= result.getName();
			String screenshotpath = ScreenShot.takeScreenshot(driver, SCREEN_SHOTS+name);
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" failed becuase of below issue", ExtentColor.RED));
			test.fail(result.getThrowable());

            try {
                File file = new File(screenshotpath);
                String absolutePath = file.getAbsolutePath();
                System.out.println(absolutePath);
                test.addScreenCaptureFromPath(absolutePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
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
