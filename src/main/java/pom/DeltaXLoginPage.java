package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;
import org.testng.Assert;


public class DeltaXLoginPage extends BasePage 
{

	public DeltaXLoginPage(WebDriver driver, ExtentTest test) 
	{
		super(driver, test);
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(name="first_name")
	private WebElement firstName;
	
	@FindBy(name="last_name")
	private WebElement lastName;
	
	@FindBy(name="department")
	private WebElement department;
	
	@FindBy(name="user_name")
	private WebElement userName;
	
	@FindBy(name="user_password")
	private WebElement password;
	
	@FindBy(name="confirm_password")
	private WebElement confirmPassword;
	
	@FindBy(name="email")
	private WebElement emailId;
	
	@FindBy(name="contact_no")
	private WebElement contactNumber;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	private WebElement submitButton;
	//b[text()='Thanks']
	
	@FindBy(xpath="//b[text()='Thanks']")
	private WebElement thanksMessage;
	
	public void enterfirstName(String fName)
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(firstName));
		firstName.sendKeys(fName);
	}
	
	
	public void enterLastName(String lName)
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(lastName));
		lastName.sendKeys(lName);
	}
	
	public void enterDepartment(String dpart)
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(lastName));
		lastName.sendKeys(dpart);
	}
	
	public void enterUserName(String uName)
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(userName));
		userName.sendKeys(uName);
	}
	
	public void selectDepartment(String dep)
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(department));
		
		department.click();
		Select sc= new Select(department);
		sc.selectByVisibleText(dep);
	}
	
	public void enterPassword(String pwd)
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(password));
		password.sendKeys(pwd);
	}
	
	public void enterConfirmPassword(String cpwd)
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(confirmPassword));
		confirmPassword.sendKeys(cpwd);
	}
	
	public void enterMailId(String dpart)
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(emailId));
		emailId.sendKeys(dpart);
	}
	
	public void enterContactNumber(String conNumber)
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(contactNumber));
		contactNumber.sendKeys(conNumber);
	}
	
	public void clickOnSubmitButton()
	{
			WebDriverWait wt= new WebDriverWait(driver, 5);
			wt.until(ExpectedConditions.elementToBeClickable(submitButton));
			submitButton.click();
	}
	
	public void VerifyThanksMessage(String errorMessage)
	{
		try 
		{
			WebDriverWait wt= new WebDriverWait(driver,2);
			wt.until(ExpectedConditions.elementToBeClickable(thanksMessage));
		} 
		catch (Exception e)
		{
			Assert.fail(errorMessage);
		}

	}
	
	public  void VerifyThanksMessageNegative(String errorMessage) 
	{
		try 
		{
			WebDriverWait wt= new WebDriverWait(driver,2);
			wt.until(ExpectedConditions.elementToBeClickable(thanksMessage));
			Assert.fail(errorMessage);
			
		} 
		catch (Exception e)
		{
			
		}
		
	}
}
