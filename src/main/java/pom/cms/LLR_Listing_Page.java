package pom.cms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class LLR_Listing_Page {
		
		//initialization	
		@FindBy(xpath="//div[@class='user__tbl__title']")
		private WebElement llrListingPage;
			
	    @FindBy(xpath="//td[@class='dataTables_empty']/a")
		private WebElement requestFromEmptyTable;
	    
	    @FindBy(id="createNewRequestSpanId")
		private WebElement request;
	    
	    @FindBy(xpath="//button[@class='btn btn-primary']")
		private WebElement clickOK;
	    	  
	    @FindBy(xpath="//button[@class='dropdown-togglee ml-xs']/img")
		private WebElement clickThreeDots;
	  
	    @FindBy(linkText="View Request")
		private WebElement viewRequest;
	    
	    //td[@class='pending']
	    
	  //declaration
		public LLR_Listing_Page(WebDriver driver) {
				PageFactory.initElements(driver,this);
			}

		public void checkListingPage() {
				if(llrListingPage.isDisplayed())
					Reporter.log("LLR Request List Page is displayed.", true);
				else
					Assert.fail();
		}
		
		public void clickRequestFromEmptyTable() {
				requestFromEmptyTable.click();
		}
		
		public void clickRequest() {
				request.click();
		}
		
		public void clickOK() {
				clickOK.click();
		}
		
		public void clickActionIcon() {
				clickThreeDots.click();
		}
		
		public void clickViewRequest() {
				viewRequest.click();
		}
}
