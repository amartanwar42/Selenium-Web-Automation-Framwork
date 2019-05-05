package pom.cms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class Profile_uploadimage_page 
{
	//initialization	
			
			@FindBy(xpath="//img[@src='/mgc-direct-web/resources/assets/images/icons/blue-edit.png']")
			private WebElement imageicon;
			
			@FindBy(linkText="Upload Image")
			private WebElement uploadimg;
			
			@FindBy(id="btnCrop")
			private WebElement savebtn;
			
			@FindBy(id="btncancel")
			private WebElement removebtn;
			
			@FindBy(xpath="(//img[@src='/mgc-direct-web/resources/assets/images/icons/close.png'])[4]")
			private WebElement cancelicon;
			
			//declaration
			public Profile_uploadimage_page(WebDriver driver) 
			{
			//this.driver=driver;
					PageFactory.initElements(driver,this);
				}
			
			public void editicon() 
			{
				imageicon.click();
			}
			
			public void uploadimage(String image) 
			{
				uploadimg.clear();
				uploadimg.sendKeys(image);
			}
			
			public void saveimage() 
			{
				savebtn.click();
			}
			
			public void removeimage() 
			{
				removebtn.click();
			}
			
			public void cancelpopup() 
			{
				cancelicon.click();
			}
			
}
