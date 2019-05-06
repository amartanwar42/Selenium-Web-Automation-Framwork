package cms;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utility;
import pom.cms.RegisterPage;

public class Others_Reg_TC6 extends BaseTest {

	@Test(priority=6)
	public void otherRegistration() throws InterruptedException {
		
		String fname = Utility.getXLData(DATA_PATH, "Sheet1", 16, 0);
		String lname = Utility.getXLData(DATA_PATH, "Sheet1", 16, 1);
		String email = Utility.getXLData(DATA_PATH, "Sheet1", 16, 2);
		String orgname = Utility.getXLData(DATA_PATH, "Sheet1", 16, 5);
		String message1 = Utility.getXLData(DATA_PATH, "Sheet1", 16, 6);
		
		RegisterPage reg = new RegisterPage(driver);
		reg.setFirstName(fname);
		reg.setLastName(lname);
		reg.email(email);
		reg.emailtooltip(driver);
		Thread.sleep(2000);
		reg.emailtooltiptxt();
		reg.roleOther();
		reg.sendOrganisationName(orgname);
		reg.sendMessage(message1);
		reg.clickRegisterOthers();
		reg.checkForRegSuccess();
	}
}