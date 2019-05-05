package pom.mgc;

import com.aventstack.extentreports.ExtentTest;
import generic.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage
{
    @FindBy(id="emailLogin")
    private WebElement emailId;

    @FindBy(id="passwordLogin")
    private WebElement pwd;

    @FindBy(id="siginNoteBtnId")
    private WebElement loginButton;


   public LoginPage(WebDriver driver, ExtentTest test){
       super(driver, test);
       PageFactory.initElements(driver, this);
   }

    public void enterEmaiilId(String emId) {
        WebDriverWait wt= new WebDriverWait(driver,10);
        wt.until(ExpectedConditions.elementToBeClickable(emailId));
        emailId.sendKeys(emId);
    }

    public void enterPwd(String password) {
        WebDriverWait wt= new WebDriverWait(driver,10);
        wt.until(ExpectedConditions.elementToBeClickable(pwd));
        pwd.sendKeys(password);
    }

    public void clickOnLoginButton() {
        WebDriverWait wt= new WebDriverWait(driver,10);
        wt.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }
}
