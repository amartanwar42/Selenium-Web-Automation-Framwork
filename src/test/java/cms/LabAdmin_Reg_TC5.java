package cms;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utility;
import pom.cms.RegisterPage;


public class LabAdmin_Reg_TC5 extends BaseTest {

	@Test(priority=5)
	public void labAdminRegistration() throws InterruptedException {
		
		String fname = Utility.getXLData(DATA_PATH, "Sheet1", 15, 0);
		String lname = Utility.getXLData(DATA_PATH, "Sheet1", 15, 1);
		String email = Utility.getXLData(DATA_PATH, "Sheet1", 15, 2);
		String orgname = Utility.getXLData(DATA_PATH, "Sheet1", 15, 5);
		String message1 = Utility.getXLData(DATA_PATH, "Sheet1", 15, 6);
		
		RegisterPage reg = new RegisterPage(driver);
		reg.setFirstName(fname);
		reg.setLastName(lname);
		reg.email(email);
		reg.emailtooltip(driver);
		Thread.sleep(2000);
		reg.emailtooltiptxt();
		reg.roleLabAdmin();
		reg.sendOrganisationName(orgname);
		reg.sendMessage(message1);
		reg.clickRegisterOthers();
		reg.checkForRegSuccess();
	}
}
