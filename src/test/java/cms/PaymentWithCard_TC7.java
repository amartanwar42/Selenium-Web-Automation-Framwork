package cms;

import java.awt.AWTException;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utility;
import pom.cms.LLR_RequestPage;
import pom.cms.LoginPage;
import pom.cms.PaymentPage;
import pom.cms.RegisterPage;

public class PaymentWithCard_TC7 extends BaseTest{
	
	@Test(priority=7)
	public void paymentWithCard() throws InterruptedException, AWTException {
		
		String email1 = Utility.getXLData(DATA_PATH, "Sheet1", 0, 2);
		String password1 = Utility.getXLData(DATA_PATH, "Sheet1", 0, 3);
		String cardNum = Utility.getXLData(DATA_PATH, "Sheet1", 3, 0);
		String expiry = Utility.getXLData(DATA_PATH, "Sheet1", 3, 1);
		
		LoginPage login = new LoginPage(driver);
		PaymentPage pay = new PaymentPage(driver);
		RegisterPage reg = new RegisterPage(driver);
		LLR_RequestPage req = new LLR_RequestPage(driver);
		login.loginLink();
		login.email(email1);
		login.password(password1);
		login.signIn();
		Thread.sleep(5000);
		pay.checkPaymentSection();
		pay.verifyForAmount();
		Thread.sleep(20000);
		pay.clickCardOption();
		pay.enterCardNumber(driver, cardNum);
		Thread.sleep(5000);
		pay.enterExpiry(driver, expiry);
		Thread.sleep(5000);
		pay.scrollToSubmit(driver);
		pay.clickTerms();
		reg.switchToMainPage(driver);
		pay.clickPrivacy();
		reg.switchToMainPage(driver);
		Thread.sleep(5000);
		pay.clickConfirmSubscription();
		Thread.sleep(8000);
		pay.verifyConfAmount();
		pay.clickConfirm();
		req.checkRequestPage();
	}
}
