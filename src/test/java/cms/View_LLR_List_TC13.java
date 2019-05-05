package cms;

import generic.BaseTest;
import generic.Utility;
import org.testng.annotations.Test;
import pom.cms.LLR_Listing_Page;
import pom.cms.LLR_RequestPage;
import pom.cms.LoginPage;

public class View_LLR_List_TC13 extends BaseTest {
	
	@Test(priority=13)
	public void view_LLR_List() throws InterruptedException {
		
		String email1 = Utility.getXLData(DATA_PATH, "Sheet1", 2, 0);
		String password1 = Utility.getXLData(DATA_PATH, "Sheet1", 2, 1);
	
		LLR_Listing_Page list = new LLR_Listing_Page(driver);
		LLR_RequestPage req = new LLR_RequestPage(driver);
		LoginPage login = new LoginPage(driver);
		
		login.loginLink();
		login.email(email1);
		login.password(password1);
		login.signIn();
		
		list.checkListingPage();
		list.clickActionIcon();
		list.clickViewRequest();
		req.checkForEditing();	
	}
}
