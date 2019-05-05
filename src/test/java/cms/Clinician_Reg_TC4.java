package cms;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utility;
import pom.cms.RegisterPage;


public class Clinician_Reg_TC4 extends BaseTest {

	@Test(priority=4)
	public void clinicianReg() throws InterruptedException {
		
		String fname = Utility.getXLData(DATA_PATH, "Sheet1", 17, 0);
		String lname = Utility.getXLData(DATA_PATH, "Sheet1", 17, 1);
		String email = Utility.getXLData(DATA_PATH, "Sheet1", 17, 2);
		String orgname = Utility.getXLData(DATA_PATH, "Sheet1", 17, 5);
		String message1 = Utility.getXLData(DATA_PATH, "Sheet1", 17, 6);
		
		RegisterPage reg = new RegisterPage(driver);
		reg.setFirstName(fname);
		reg.setLastName(lname);
		reg.email(email);
		reg.emailtooltip(driver);
		Thread.sleep(2000);
		reg.emailtooltiptxt();
		reg.roleClinician();
		reg.sendOrganisationName(orgname);
		reg.sendMessage(message1);
		reg.clickRegisterOthers();
		Thread.sleep(3000);
		reg.checkForRegSuccess();
	}
}
//Your account has been created successfully. sucMsg