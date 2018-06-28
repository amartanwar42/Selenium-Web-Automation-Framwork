package testDataProvider_Repository;

import org.testng.annotations.DataProvider;

import generic.DataProviderGenerator;

public class LoginPageData extends DataProviderGenerator 

{
			// Back end Lease Data Provider
	@DataProvider(name ="positveLoginPageTestWithAllFields")
	public static Object[][] positveLoginPageTestWithAllFields()
	{
		
		String excelName = "DeltaX_LoginPage_PositiveTestCase_TestData";
		Object[][] leaseData=objectGeneratorWithMultiSheet(excelName);
		return leaseData; 
	
	}
	
	@DataProvider(name ="negativeLoginPageTestWithAllFields")
	public static Object[][] negativeLoginPageTestWithAllFields()
	{
		
		String excelName = "DeltaX_LoginPage_NegativeTestCase_TestData";
		Object[][] leaseData=objectGeneratorWithMultiSheet(excelName);
		return leaseData; 
	
	}
	
}
