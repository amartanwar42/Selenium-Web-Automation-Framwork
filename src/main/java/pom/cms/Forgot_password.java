package pom.cms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class Forgot_password 
{
	//initialization	
		@FindBy(xpath="//div[@class='login__title'][contains(text(), 'Reset password')]")
		private WebElement pagetitle;
		
		@FindBy(id="emailReg")
		private WebElement email;
		
		@FindBy(id="forgotPassId")
		private WebElement submit;
		
		@FindBy(linkText="Back to Log in")
		private WebElement backtologin;
		
		@FindBy(xpath="//li[contains(text(), 'Email address is invalid')]")
		private WebElement invalemail;
		
		
		@FindBy(xpath="//div[@class='error_msg mt-sm text-center'][contains(text(), 'User is inactive or does not exist.')]")
		private WebElement unregemail;
		
		
		//declaration
		public Forgot_password(WebDriver driver) 
		{
		//this.driver=driver;
				PageFactory.initElements(driver,this);
			}

		public void email(String email2) 
		{
			email.clear();
			email.sendKeys(email2);
		}
		
		public void invalemail()
		{
			String emailinvalid = invalemail.getText();
			System.out.println("The Text is: "+emailinvalid);
		}
		
		public void unregemailerror()
		{
			String frgtunregerr = unregemail.getText();
			System.out.println("The Text is: "+frgtunregerr);
		}
		
			
		
		

}
