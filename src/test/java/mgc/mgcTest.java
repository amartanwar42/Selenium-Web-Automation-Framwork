package mgc;

import generic.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.mgc.CreateUserPage;
import pom.mgc.MyGeneConsolePage;

public class mgcTest extends BaseTest {

    @Test
    public void createUserTest() throws InterruptedException {
        MyGeneConsolePage myGeneConsolePage=new MyGeneConsolePage(driver,test);
        myGeneConsolePage.clickOnLlr();


        CreateUserPage UP=new CreateUserPage(driver,test);
        UP.Newuser();
        UP.selectCompany("colour-Test3");
        UP.selectreport("Hereditary Heart Conditions");
        UP.nextBTN1();
        UP.testResult("Positive (also called pathogenic variant or mutation");
        UP.geneType("APC");
        UP.geneName("c.3927_3931delAAAGA");
        UP.Nextbtn2();
        UP.file();
    }
}
