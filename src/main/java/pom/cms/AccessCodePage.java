package pom.cms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccessCodePage {
	
//initialization	
@FindBy(id="sucMsg")
private WebElement successMsg;
	
@FindBy(id="errMsg")
private WebElement errMsg;	
	
@FindBy(id="accessCodeId")
private WebElement accessCodeField;

@FindBy(id="accessCodeBtn")
private WebElement submitBtn;

@FindBy(id="sendActivationMail")
private WebElement resendEmail;

@FindBy(id="signoutId")
private WebElement signout;

//declaration
public AccessCodePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

public void sendAccessCode(String accessCode) {
		accessCodeField.sendKeys(accessCode);
	}

public void clickSubmit() {
		submitBtn.click();
	}

public void clickResendEmail() {
		resendEmail.click();
	}

public void clickSignOut() {
		signout.click();
	}
}