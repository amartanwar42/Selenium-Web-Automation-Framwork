package cms;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utility;
import pom.cms.RegisterPage;

public class Invalid_Email_TC2 extends BaseTest {

	@Test(priority=2)
	public void invalidEmail() throws InterruptedException {
		String fname = Utility.getXLData(DATA_PATH, "Sheet1", 0, 0);
		String lname = Utility.getXLData(DATA_PATH, "Sheet1", 0, 1);
		String email = Utility.getXLData(DATA_PATH, "Sheet1", 0, 2);
		String pw = Utility.getXLData(DATA_PATH, "Sheet1", 0, 3);
		String confirmpwd = Utility.getXLData(DATA_PATH, "Sheet1", 0, 4);
		
		RegisterPage reg = new RegisterPage(driver);
		reg.setFirstName(fname);
		reg.setLastName(lname);
		reg.email(email);
		reg.emailtooltip(driver);
		Thread.sleep(2000);
		reg.emailtooltiptxt();
		reg.rolePatient();
		reg.setPassword(pw);
		reg.confirmPassword(confirmpwd);
		reg.clickPlan();
		reg.closePlan();
		reg.clickPromocode();
		reg.getPromocodeTxt();
		reg.clickTerms();
		reg.switchToMainPage(driver);
		reg.clickPrivacy();
		reg.switchToMainPage(driver);
		reg.clickRegisterPatient();
		//Thread.sleep(3000);
		//reg.waitForAccessCodePageLoad(driver);
		reg.checkForAccCodeAfterInvalidEmailID();
	}
}

//Email has been sent successfully.
//Access Code is invalid "id=errMsg"

