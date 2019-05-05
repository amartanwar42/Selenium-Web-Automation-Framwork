package pom.cms;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

public class LLR_RequestPage {

	//initialization	
	@FindBy(xpath="//span[@class='user__tbl__title user__tbl__title_dk']")
	private WebElement llrRequestPage;
		
    @FindBy(xpath="//img[@src='/mgc-direct-web/resources/assets/images/user-logo/logo.png']")
	private WebElement logo;
    
    @FindBy(xpath="//a[contains(text(), 'My Reports')]")
    private WebElement myrreport;
    
    @FindBy(xpath="//a[contains(text(), 'Notification Settings')]")
	private WebElement notificationsetting;
    
    @FindBy(xpath="//a[contains(text(), 'Surveys')]")
    private WebElement surveys;
    
    @FindBy(xpath="//a[@class='dropdown-toggle user__profile']")
    private WebElement profile;
    
    @FindBy(xpath="//a[contains(text(), 'My Profile')]")
    private WebElement myprofile;
    
    @FindBy(xpath="//a[contains(text(), 'Logout')]")
    private WebElement logout;
    
    @FindBy(id="backBtn")
    private WebElement back;
    
    @FindBy(id="laboratoryId")
    private WebElement laboratoryname;
    
    @FindBy(xpath="//option[@class='editable'][contains(text(),'Enter the laboratory Name')]")
    private WebElement labOption;
    
    @FindBy(id="labNameId")
    private WebElement labName;
    
    @FindBy(xpath="//option[contains(text(), 'Enter the laboratory Name')]")
    private WebElement labdropdownenterlabname ;
    
    @FindBy(xpath="//option[contains(text(), 'BTC')]")
    private WebElement labdropdown;

    @FindBy(id="datepicker")
    private WebElement date;
    
    @FindBy(xpath="//td[@class='today active start-date active end-date available']")
    private WebElement picktodaysdate ;
    
    @FindBy(id="testTypeId")
    private WebElement geneticdropdown;
    
    @FindBy(id="subSpecialityId")
    private WebElement subspeciality;
    
    @FindBy(id="resultTypeId0")
    private WebElement testresult;
   
    @FindBy(id="geneTestType0")
    private WebElement geneType;
    
    @FindBy(id="mutationNameId0")
    private WebElement mutationField;
    
    @FindBy(xpath="//li[@class='es-visible selected']")
    private WebElement mutationName;
    
    @FindBy(xpath="(//input[@name='imageFile'])[1]")
    private WebElement img;
    
    @FindBy(id="termId1")
    private WebElement terms;
    
    @FindBy(id="privacyId1")
    private WebElement privacy;
    
    /*@FindBy(xpath="//a[@class='btn btn-default margin__initial mr-sm'][contains(text(), 'CANCEL')]")
    private WebElement cancel;*/
    
    @FindBy(linkText="CANCEL")
    private WebElement cancel;
    
   /*@FindBy(xpath="//a[@class='btn btn-primary margin__initial submit_btn'][contains(text(), 'SUBMIT')]")
    private WebElement submit;*/
    
    @FindBy(linkText="SUBMIT")
    private WebElement submit;
    
    @FindBy(xpath="(//a[contains(text(), 'Contact')])[2]")
    private WebElement contact;
    
    @FindBy(id="faqFooterId1")
    private WebElement faq;
    
    @FindBy(id="cancelPolicyFooterId1")
    private WebElement cancelpolicy;
    
    @FindBy(xpath="(//input[@id='inlineRadio6'])[1]")
    private WebElement clickIdoNotHave;
    
    @FindBy(xpath="(//input[@id='inlineRadio5'])[1]")
    private WebElement clickIHave;
    	
    @FindBy(id="submit_btn")
    private WebElement submitBtn;
    	
    @FindBy(xpath="(//button[@class='close close__ close_mb']/img)[1]")
    private WebElement closeBtn;
    	
    @FindBy(xpath="//button[@class='btn btn-primary']")
    private WebElement finalSubmit;
    	
    @FindBy(xpath="//button[@class='btn btn-default']")
	private WebElement finalCancel;
    			
	//declaration
	public LLR_RequestPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}

	public void checkRequestPage() {
			if(llrRequestPage.isDisplayed())
				Reporter.log("Payment is confirmed and in request creation page.", true);
			else
				Assert.fail();
	}
	
	public void selectLabName(String labNam) {
			laboratoryname.click();
			labOption.click();
			labName.sendKeys(labNam);
		}
	
	public void selectDateField() {
			date.click();
	}
	
	public void selectDate() {
			picktodaysdate.click();
	}
	
	public void selectTestType(String testType) {	
			geneticdropdown.click();
			Select sel = new Select(geneticdropdown);
			sel.selectByVisibleText(testType);		
	}
	
	public void selectSubSpeciality(String subSpec) {	
			subspeciality.click();
			Select sel = new Select(subspeciality);
			sel.selectByVisibleText(subSpec);
	}
	
	public void selectResultType(String resType) {	
			testresult.click();
			Select sel = new Select(testresult);
			sel.selectByVisibleText(resType);
	}
	
	public void selectgeneTestType(String genType) {	
			geneType.click();
			Select sel = new Select(geneType);
			sel.selectByVisibleText(genType);
	}
	
	public void selectmutationName(String mutation) {	
			mutationField.click();
			mutationField.sendKeys(mutation);
			mutationName.click();
	}
	
	public void uploadFile(String imgPath) {	
			img.sendKeys(imgPath);
	}
	
	public void clickTerms() {	
			terms.click();
	}
	
	public void clickPrivacy() {	
			privacy.click();
	}
	
	public void clickSubmit() {	
			submit.click();
	}
	
	public void clickCancel() {	
			cancel.click();
	}
	
	public void clickIHave() {	
			clickIHave.click();
	}
	
	public void clickIDoNotHave() {	
			clickIdoNotHave.click();
	}
	
	public void clickSubmitBtn() {	
			submitBtn.click();
	}
	
	public void clickCloseBtn() {	
			closeBtn.click();
	}
	
	public void clickFinalSubmit() {	
			finalSubmit.click();
	}
	
	public void clickFinalCancel() {	
			finalCancel.click();
	}
	
	public void checkForEditing() {
			if(!labName.isEnabled() && !date.isEnabled())
			{
				Reporter.log("The Report is not editable.", true);
			}
			else
			{
				Reporter.log("The Report is editable.", true);
				Assert.fail();
			}
	}
	
	public void logOut() {
			profile.click();
			logout.click();
	}
	
	public void downKeys(WebDriver driver) throws AWTException
	{	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", geneType);
		
	}
	
	public void downToSubmit(WebDriver driver) throws AWTException
	{	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", submit);
		
	}
	
}


/*To get all the links and click on the link which we want
 
  public void clickLinkByHref(String href, int position) {
 
    List<WebElement> anchors = driver.findElements(By.tagName("a");
    Iterator<WebElement> i = anchors.iterator();

    int j = 0;
    while(i.hasNext()) {
        WebElement anchor = i.next();

        if(anchor.getAttribute("href").contains(href)) {
            j++;
        }

        if(anchor.getAttribute("href").contains(href)
                && j == position) {
            anchor.click();
            break;
        }
    }
}
*/