package pom.cms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class Reset_Password 
{

	//initialization	
		@FindBy(xpath="//div[@class='login__title pb-xs'][contains(text(), 'Reset Password')]")
		private WebElement resettitle;
		
		@FindBy(xpath="//input[@name='accessCode']")
		private WebElement accesscode;
		
		@FindBy(xpath="//input[@id='password']")
		private WebElement password;
		
		@FindBy(xpath="//input[@id='cfnPassword']")
		private WebElement cfnpassword;
		
		@FindBy(id="resetPasswordBut")
		private WebElement submitbtn;
		
		@FindBy(id="backToLogin")
		private WebElement bcktologin;
		
		@FindBy(xpath="//div[@class='error_msg text-center msg'][contains(text(), 'Invalid access code.')]")
		private WebElement errinvalidaccess;
		
		@FindBy(xpath="//div[@class='error_msg text-center msg'][contains(text(), 'New Password should not be the same as the last 10 passwords.')]")
		private WebElement errlast10pwd;
		
		@FindBy(xpath="//li[contains(text(), 'Password is invalid')]")
		private WebElement errinvalidpwd;
		
		//declaration
				public Reset_Password(WebDriver driver) 
				{
				//this.driver=driver;
						PageFactory.initElements(driver,this);
					}
				
				public void resetpwdtitle()
				{
					String title = resettitle.getText();
					System.out.println("The Text is: "+title);
				}
		
				public void accessfield(String access) 
				{
					accesscode.clear();
					accesscode.sendKeys(access);
				}
				
				public void pwdfield(String paswrd) 
				{
					password.clear();
					password.sendKeys(paswrd);
				}
				
				public void cnfmpwdfield(String cnfmpaswrd) 
				{
					cfnpassword.clear();
					cfnpassword.sendKeys(cnfmpaswrd);
				}
				
				public void submit() 
				{
					submitbtn.click();
				}
				
				public void backtologin() 
				{
					bcktologin.click();
				}
				
				public void invalidaccesserr()
				{
					String accesserror = errinvalidaccess.getText();
					System.out.println("The Text is: "+accesserror);
				}
				
				public void last10pwds()
				{
					String last10pwd = errlast10pwd.getText();
					System.out.println("The Text is: "+last10pwd);
				}
				
				public void invalidpwderr()
				{
					String invpwderr = errinvalidpwd.getText();
					System.out.println("The Text is: "+invpwderr);
				}
				
				
}
