package moduleLevel_Scenarios;

import java.util.Map;

import org.testng.annotations.Test;

import generic.BaseTest;
import pom.DeltaXLoginPage;
import testDataProvider_Repository.LoginPageData;

public class DeltaX_LoginPageTest extends BaseTest 
{

	@Test(dataProvider="positveLoginPageTestWithAllFields",dataProviderClass=LoginPageData.class, priority=1)
	
	public void positveLoginPageTestWithAllFields(Map<String, String> map) throws Exception
	{
		test=reports.createTest("Test_"+map.get("ScenarioName"),"Testing LoginPage");
		test.assignCategory("Positive");
		DeltaXLoginPage dlp= new DeltaXLoginPage(driver, test);
		
		dlp.enterfirstName(map.get("FirstName"));
		dlp.enterLastName(map.get("LastName"));
		dlp.enterUserName(map.get("UserName"));
		dlp.selectDepartment(map.get("Department"));
		dlp.enterPassword(map.get("Password"));
		dlp.enterConfirmPassword(map.get("ConfirmPassword"));
		dlp.enterMailId(map.get("EmailId"));
		dlp.enterContactNumber(map.get("ContactNumber"));
		dlp.clickOnSubmitButton();
		
		//Verifying if Thanks Message displayed else fail the scenario
		dlp.VerifyThanksMessage(map.get("ErrorMessageOnTestCaseFailure")); 
	}
	
	
	@Test(dataProvider="negativeLoginPageTestWithAllFields",dataProviderClass=LoginPageData.class,priority=2)
	
	public void negativeLoginPageTestWithAllFields(Map<String, String> map) throws Exception
	{
		test=reports.createTest("Test_"+map.get("ScenarioName"),"Testing LoginPage");
		test.assignCategory("Negative");
		DeltaXLoginPage dlp= new DeltaXLoginPage(driver, test);
		
		dlp.enterfirstName(map.get("FirstName"));
		dlp.enterLastName(map.get("LastName"));
		dlp.enterUserName(map.get("UserName"));
		dlp.selectDepartment(map.get("Department"));
		dlp.enterPassword(map.get("Password"));
		dlp.enterConfirmPassword(map.get("ConfirmPassword"));
		dlp.enterMailId(map.get("EmailId"));
		dlp.enterContactNumber(map.get("ContactNumber"));
		
		try
		{
			dlp.clickOnSubmitButton();
			//Verifying if Thanks Message displayed else fail the scenario
			dlp.VerifyThanksMessageNegative(map.get("ErrorMessageOnTestCaseFailure")); 
		} 
		catch (Exception e) 
		{
			
		}
		
		
		
	}
	
}
