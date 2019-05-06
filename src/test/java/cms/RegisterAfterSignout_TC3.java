package cms;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utility;
import pom.cms.AccessCodePage;
import pom.cms.RegisterPage;


public class RegisterAfterSignout_TC3 extends BaseTest {

	@Test(priority=3)
	public void regAfterSignOut() throws InterruptedException {
		
		String fname = Utility.getXLData(DATA_PATH, "Sheet1", 0, 0);
		String lname = Utility.getXLData(DATA_PATH, "Sheet1", 0, 1);
		String email = Utility.getXLData(DATA_PATH, "Sheet1", 1, 2);
		String pw = Utility.getXLData(DATA_PATH, "Sheet1", 0, 3);
		String confirmpwd = Utility.getXLData(DATA_PATH, "Sheet1", 0, 4);
		String email1 = Utility.getXLData(DATA_PATH, "Sheet1", 1, 6);
		
		RegisterPage reg = new RegisterPage(driver);
		AccessCodePage access = new AccessCodePage(driver);
		reg.setFirstName(fname);
		reg.setLastName(lname);
		reg.email(email);
		reg.rolePatient();
		reg.setPassword(pw);
		reg.confirmPassword(confirmpwd);
		reg.clickRegisterPatient();
		reg.waitForAccessCodePageLoad(driver);
		reg.checkForAccessCodePage();
		access.clickSignOut();
		reg.setFirstName(fname);
		reg.setLastName(lname);
		reg.email(email1);
		reg.rolePatient();
		reg.setPassword(pw);
		reg.confirmPassword(confirmpwd);
		reg.clickRegisterPatient();
		reg.waitForAccessCodePageLoad(driver);
		reg.checkForAccessCodePage();
	}
}
