package pom.cms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class Change_password 
{

	//initialization	
			@FindBy(xpath="//div[@class='modal-title'][contains(text(), 'Change Password')]")
			private WebElement changepwdtitle;
			
			@FindBy(id="oldPassword")
			private WebElement currentpwd;
			
			@FindBy(id="password")
			private WebElement newpwd;
			
			@FindBy(id="cfnPassword")
			private WebElement cnfmpwd;
			
			@FindBy(id="changePasswordBtn")
			private WebElement updatebtn;
			
			@FindBy(xpath="(//img[@src='/mgc-direct-web/resources/assets/images/icons/close.png'])[2]")
			private WebElement closebtn;
			
			
			
			
			
			
}
