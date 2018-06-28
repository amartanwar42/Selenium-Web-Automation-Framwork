package generic;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public abstract class BasePage implements AutoConst 
{
	public  WebDriver driver;
	public  ExtentTest test;
	
	public BasePage(WebDriver driver,ExtentTest test)
	{	
		
		this.driver=driver;
		this.test=test;
	}

	public void verfyTittle(String eTitle,String msg) throws IOException, InterruptedException
	{
		WebDriverWait wait= new WebDriverWait(driver,5);
		
		try
		{
			wait.until(ExpectedConditions.titleIs(eTitle));
//			Reporter.log("Pass:Title is Matching",true);
		}
		catch(Exception e)
		{
			Reporter.log(msg,true);
			try 
			{
				System.out.println("verifying title");
				Assert.fail();
			}
			finally 
			{
				test.log(Status.FAIL, "Title is not matching"+"Expected Title is " +eTitle);
			}
			
		}
	}
	
	
}
