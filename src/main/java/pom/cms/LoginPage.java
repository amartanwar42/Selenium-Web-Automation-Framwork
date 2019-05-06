package pom.cms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPage 
{

	//initialization	
	@FindBy(linkText="REGISTER")
	private WebElement registertab;
	
	@FindBy(linkText="LOG IN")
	private WebElement logintab;
	
	@FindBy(xpath="//div[@class='login__title'][contains(text(), 'Log in to your account')]")
	private WebElement pagetitle;
	
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="siginNoteBtnId")
	private WebElement loginbtn;
	
	@FindBy(linkText="Forgot Password?")
	private WebElement forgotpwd;
	
	@FindBy(xpath="(//input[@data-pattern-error='Email address is invalid'])[1]")
	private WebElement emailerror;
	
	@FindBy(xpath="//div[@class='error_msg mt-sm text-center'][contains(text(), 'Invalid email or password. Please try again.')]")
	private WebElement unregemailerror;
	
	
	//declaration
	public LoginPage(WebDriver driver) 
	{
	//this.driver=driver;
			PageFactory.initElements(driver,this);
		}

	public void registerLink() 
	{
		registertab.click();
	}
	
	public void loginLink() 
	{
		logintab.click();
	}
	
	public void pageTitle() 
	{
		String title = pagetitle.getText();
		System.out.println("The Text is: "+title);
	}
	
	public void email(String email1) 
	{
		email.clear();
		email.sendKeys(email1);
	}
	
	public void password(String password1) 
	{
		password.clear();
		password.sendKeys(password1);
	}
	
	public void signIn() 
	{
		loginbtn.click();
	}
	
	public void forgotPwd() 
	{
		forgotpwd.click();
	}
	
	public void emailError()
	{
		String error = emailerror.getText();
		System.out.println("The Text is: "+error);
	}
	
	public void unRegEmailError()
	{
		String unregerr = unregemailerror.getText();
		System.out.println("The Text is: "+unregerr);
	}
}
