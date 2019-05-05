package pom.cms;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CMSPage {
	
		//initialization	
		@FindBy(id="username")
		private WebElement username;
		
		@FindBy(id="password")
		private WebElement password;
		
		@FindBy(id="login")
		private WebElement loginBtn;
		
		@FindBy(xpath="//i[@class='repo-icon']")
		private WebElement repository;
		
		@FindBy(xpath="//a[contains(text(),'Data Definition Model')]")
		private WebElement ddm;
		
		@FindBy(id="ContentPlaceHolder1_dlDataDefinitionModel1_dlSubTags1_0_lnkDDMSubTags1_1")
		private WebElement testType;
		
		@FindBy(id="ContentPlaceHolder1_dlDataDefinitionModel1_dlSubTags1_1_lnkDDMSubTags1_10")
		private WebElement subSpeciality;
		
		@FindBy(id="ContentPlaceHolder1_dlDataDefinitionModel_dlSubTags_2_lnkDDMSubTags_8")
		private WebElement resultType;
		
		@FindBy(id="ContentPlaceHolder1_dlDataDefinitionModel_dlSubTags_3_lnkDDMSubTags_6")
		private WebElement geneType;
		
		@FindBy(id="ContentPlaceHolder1_dlDataDefinitionModel_dlSubTags_4_lnkDDMSubTags_106")
		private WebElement mutation;
		
		//declaration
		public CMSPage(WebDriver driver) {
				PageFactory.initElements(driver,this);
			}

		public void sendUsername(String usrname) {
				username.clear();
				username.sendKeys(usrname);
			}

		public void sendPassword(String pwd) {
				password.clear();
				password.sendKeys(pwd);
			}

		public void clickLogin() {
				loginBtn.click();
			}

		public void clickRepository(WebDriver driver) {
				WebDriverWait wait = new WebDriverWait(driver,20);
				wait.until(ExpectedConditions.elementToBeClickable(repository));
				repository.click();
			}
		
		public void clickDDM(WebDriver driver) {
				WebDriverWait wait = new WebDriverWait(driver,20);
				wait.until(ExpectedConditions.elementToBeClickable(ddm));
				ddm.click();
		}
		
		public void selectTestType(WebDriver driver) {
				WebDriverWait wait = new WebDriverWait(driver,20);
				wait.until(ExpectedConditions.elementToBeClickable(testType));
				testType.click();
				Alert alert = driver.switchTo().alert();
				alert.accept();
		}
		
		public void selectSubSpeciality(WebDriver driver) {
				WebDriverWait wait = new WebDriverWait(driver,50);
				wait.until(ExpectedConditions.elementToBeClickable(subSpeciality));
				subSpeciality.click();
			}
		
		public void selectResultType(WebDriver driver) {
				WebDriverWait wait = new WebDriverWait(driver,20);
				wait.until(ExpectedConditions.elementToBeClickable(resultType));
				resultType.click();	
		}
		
		public void selectGeneTested(WebDriver driver) {
				WebDriverWait wait = new WebDriverWait(driver,20);
				wait.until(ExpectedConditions.elementToBeClickable(geneType));
				geneType.click();
		}
		
		public void selectMutations(WebDriver driver) {
				WebDriverWait wait = new WebDriverWait(driver,20);
				wait.until(ExpectedConditions.elementToBeClickable(mutation));
				mutation.click();
		}
}