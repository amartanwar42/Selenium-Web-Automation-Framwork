package cms;

import java.awt.AWTException;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utility;
import pom.cms.LLR_RequestPage;
import pom.cms.LoginPage;
import pom.cms.PaymentPage;
import pom.cms.RegisterPage;

public class PaymentWithPaypal_TC8 extends BaseTest{
	
	@Test(priority=8)
	public void paymentWithPaypal() throws InterruptedException, AWTException {
	
		String paypalemail = Utility.getXLData(DATA_PATH, "Sheet1", 6, 0);
		String paypalpassword = Utility.getXLData(DATA_PATH, "Sheet1", 6, 1);
		String loginUsername = Utility.getXLData(DATA_PATH, "Sheet1", 20, 0);
		String loginPassword = Utility.getXLData(DATA_PATH, "Sheet1", 20, 1);
		
		//cms.Valid_Email_TC1 registration = new cms.Valid_Email_TC1();
		PaymentPage pay = new PaymentPage(driver);
		RegisterPage reg = new RegisterPage(driver);
		LLR_RequestPage req = new LLR_RequestPage(driver);
		//registration.testA();
		LoginPage login = new LoginPage(driver);
		login.loginLink();
		login.email(loginUsername);
		login.password(loginPassword);
		login.signIn();
		Thread.sleep(30000);
		pay.checkPaymentSection();
		pay.verifyForAmount();
		pay.payPalOption();
		pay.clickPayPal(driver);
		pay.parentWindow(driver);
		pay.switchToPayPalScreen(driver);
		Thread.sleep(5000);
		pay.enterPaypalEmail(paypalemail);
		pay.clickPaypalNext();
		pay.enterPaypalPassword(paypalpassword);
		pay.clickPaypalLogin();
		Thread.sleep(20000);
		pay.clickContinueToMakePayment();
		pay.clickPaypalAgree();
		Thread.sleep(30000);
		
		pay.switchBack(driver);
		pay.checkPaymentSection();
		Thread.sleep(2000);
		pay.scrollToSubmit(driver);
		pay.clickTerms();
		reg.switchToMainPage(driver);
		pay.clickPrivacy();
		reg.switchToMainPage(driver);
		Thread.sleep(20000);
		pay.clickConfirmSubscription();
		Thread.sleep(10000);
		pay.verifyConfAmount();
		pay.clickConfirm();
		req.checkRequestPage();
	}
}
