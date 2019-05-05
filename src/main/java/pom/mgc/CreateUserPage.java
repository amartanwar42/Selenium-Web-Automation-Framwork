package pom.mgc;

import com.aventstack.extentreports.ExtentTest;
import generic.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateUserPage extends BasePage {

    @FindBy(xpath = "//label[@for='toggle-on'][1]")
    private WebElement genericTest;


    @FindBy(id = "laboratoryId")
    private WebElement company;

    @FindBy(id = "appendDynamicSubspeciality")
    private WebElement report;

    @FindBy(id = "centerButtonEnabled")
    private WebElement nextBtn;

    @FindBy(id = "resultTypeIds")
    private WebElement resultoftest;

    @FindBy(id="geneTestType")
    private WebElement genetype;

    @FindBy(id="mutationNameId")
    private WebElement genename;


    @FindBy(id = "rightButtonEnabledStep3")
    private WebElement Nextbtn;

    @FindBy(id = "file-drag")
    private WebElement uploadfile;

    public CreateUserPage(WebDriver driver, ExtentTest test) {
        super(driver,test);
        PageFactory.initElements(driver, this);
    }

    public void Newuser() {
        WebDriverWait wt = new WebDriverWait(driver         , 10);
        wt.until(ExpectedConditions.elementToBeClickable(genericTest));
        genericTest.click();
    }

    public void selectCompany(String com) {
        WebDriverWait wt = new WebDriverWait(driver, 10);
        wt.until(ExpectedConditions.elementToBeClickable(company));
        company.sendKeys(com);
    }


    public void selectreport(String Report) {
        WebDriverWait wt = new WebDriverWait(driver, 10);
        wt.until(ExpectedConditions.elementToBeClickable(report));
        report.sendKeys(Report);
    }

    public void geneType(String gene) {
        WebDriverWait wt = new WebDriverWait(driver, 10);
        wt.until(ExpectedConditions.elementToBeClickable(genetype));
        genetype.sendKeys(gene);

    }

    public void geneName(String name) {
        WebDriverWait wt = new WebDriverWait(driver, 10);
        wt.until(ExpectedConditions.elementToBeClickable(genename));
        genename.sendKeys(name);
    }

    public void nextBTN1() {
        WebDriverWait wt= new WebDriverWait(driver,10);
        wt.until(ExpectedConditions.elementToBeClickable(nextBtn));
        nextBtn.click();
}

    public void testResult(String res) throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wt = new WebDriverWait(driver, 20);
        wt.until(ExpectedConditions.elementToBeClickable(resultoftest));
     //   Actions actions=new Actions(driver);
     //   actions.moveToElement(resultoftest).click().perform();
        resultoftest.sendKeys(res);
    }

    public void Nextbtn2() {
        WebDriverWait wt = new WebDriverWait(driver, 10);
        wt.until(ExpectedConditions.elementToBeClickable(Nextbtn));
        Nextbtn.click();
}
    public void file() {
        WebDriverWait wt = new WebDriverWait(driver, 10);
        wt.until(ExpectedConditions.elementToBeClickable(uploadfile));
        uploadfile.click();

    }
}