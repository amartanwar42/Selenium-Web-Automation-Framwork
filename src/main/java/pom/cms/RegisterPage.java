package pom.cms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class RegisterPage {	

	//initialization	
@FindBy(name="firstName")
private WebElement firstname;

@FindBy(name="lastName")
private WebElement lastname;

@FindBy(id="emailId")
private WebElement email;

@FindBy(id="blue-info")
private WebElement emailtooltip;

@FindBy(id="login-tooltip")
private WebElement emailtooltiptxt;

@FindBy(id="role")
private WebElement role;

@FindBy(xpath="//input[@id='userPassword']")
private WebElement password;

@FindBy(xpath="//input[@id='cfnPassword']")
private WebElement conpassword;

@FindBy(xpath="//span[@class='premium__']")
private WebElement plan;

@FindBy(xpath="//div/img")
private WebElement close;

@FindBy(id="premium-plan")
private WebElement promocode;

@FindBy(id="plan-tooltip")
private WebElement promocodetxt;

@FindBy(id="termId1")
private WebElement terms;

@FindBy(id="privacyId1")
private WebElement privacy;

@FindBy(id="signupSubMitId")
private WebElement regBtnPatient;

@FindBy(id="signupPassId")
private WebElement regBtnOthers;

@FindBy(xpath="(//div[@id='sucMsg'])[2]")
private WebElement successmsg1;

@FindBy(id="sucMsg")
private WebElement successmsg;

@FindBy(xpath="//div[@class='login__title']")
private WebElement welcomeMsg;

@FindBy(id="accessCodeId")
private WebElement accessCodeField;

@FindBy(xpath="//input[@name='organizationName']")
private WebElement orgName;

@FindBy(xpath="//input[@name='message']")
private WebElement message;

@FindBy(xpath="//div[@class='pm-pay-details']")
private WebElement paymentSection;

//declaration
public RegisterPage(WebDriver driver) {
//this.driver=driver;
		PageFactory.initElements(driver,this);
	}

public void setFirstName(String fname) {
		firstname.sendKeys(fname);
	}

public void setLastName(String lname) {
		lastname.sendKeys(lname);
	}

public void email(String email1) {
		email.sendKeys(email1);
	}

public void emailtooltip(WebDriver driver) {
		WebElement element = emailtooltip;
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

public void emailtooltiptxt() {
		String txt = emailtooltiptxt.getText();
		System.out.println("The Text is: "+txt);
	}

public void rolePatient() {
		Select sel = new Select(role);
		sel.selectByValue("2");
	}

public void roleClinician() {
		Select sel = new Select(role);
		sel.selectByValue("3");
	}

public void roleLabAdmin() {
		Select sel = new Select(role);
		sel.selectByValue("4");
	}

public void roleOther() {
		Select sel = new Select(role);
		sel.selectByValue("5");
	}

public void setPassword(String pw) {
		password.sendKeys(pw);
	}

public void confirmPassword(String cpw) {
		conpassword.sendKeys(cpw);
	}

public void clickPlan() {
		plan.click();
	}

public void closePlan() {
		close.click();
	}

public void clickPromocode() {
	promocode.click();
}

public void getPromocodeTxt() {
	String promotxt = promocodetxt.getText();
	System.out.println("The Text is: "+promotxt);
}

public void clickTerms() {
		terms.click();
	}

public void clickPrivacy() {
		privacy.click();
	}

public void clickRegisterPatient() {
		regBtnPatient.click();
	}

public void clickRegisterOthers() {
		regBtnOthers.click();
	}

public void checkForAccessCodePage() {
		if(successmsg.isDisplayed())
			Reporter.log("Access Code Page is Displayed.", true);
		else
		{
			Assert.fail();
		}
	}

public void checkForAccCodeAfterInvalidEmailID() {
	if(successmsg.isDisplayed())
			Assert.fail();
	else
	{
		Reporter.log("Did not go to next page and error message is displayed for duplication of email id.", true);
	}
}

public void waitForAccessCodePageLoad(WebDriver driver) {
		WebDriverWait wt = new WebDriverWait(driver,10);
		WebElement expected = welcomeMsg;
		wt.until(ExpectedConditions.textToBePresentInElement(expected, "Welcome to My Gene Counsel!"));
	}

public void switchToMainPage(WebDriver driver) {
		String parent= driver.getWindowHandle();
		driver.switchTo().window(parent);
	}

/*public void checkForPaymentPage() {
	if(paymentSection.isDisplayed())
		Reporter.log("Payment Page is Displayed.", true);
	else
	{
//		String actual = successmsg.getText();
//		String expected= "Account has been created successfully!";
//		SoftAssert a = new SoftAssert();
//		a.assertEquals(actual, expected);
//		Reporter.log("Failed", true);
		Assert.fail();
	}
}*/

public void sendOrganisationName(String oName) {
		orgName.sendKeys(oName);
	}

public void sendMessage(String msg) {
		message.sendKeys(msg);
	}

public void checkForRegSuccess() {
	/*String actual = successmsg1.getText();
	String expected = "Your account has been created successfully.";
	if(actual.equals(expected))
		Reporter.log("Submitted Successfully", true);*/
	if(successmsg1.isDisplayed())
		Reporter.log("Submitted Successfully.", true);
	else
	{
		Assert.fail();
	}
}

}
