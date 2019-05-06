package pom.mgc;

import com.aventstack.extentreports.ExtentTest;
import generic.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyGeneConsolePage extends BasePage {

    @FindBy(id="createNewRequestSpanId")
    private WebElement llr;

    public MyGeneConsolePage(WebDriver driver, ExtentTest test) {
        super(driver, test);
        PageFactory.initElements(driver,this);
    }

    public void clickOnLlr() {
        WebDriverWait wt=new WebDriverWait(driver,10);
        wt.until(ExpectedConditions.elementToBeClickable(llr));

        llr.click();
    }
}
