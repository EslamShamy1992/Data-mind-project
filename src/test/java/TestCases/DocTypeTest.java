package TestCases;
import BaseTest.baseTest;
import Config.ConfigUtils;
import org.testng.annotations.Test;
public class DocTypeTest extends baseTest {

    @Test(priority = 2)
    public void Verify_Add_DocType_assign_info_and_file() throws InterruptedException {


        driver.get(ConfigUtils.getInstance().getBaseUrl());
        loginPage.AdminLogin(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword());
        homePage.NavigateToDocTypePage();
        docTypePage.addDocType(Doc, randomnumber);
        Thread.sleep(1000);
        docTypePage.navigateToLastDocType();
        docTypePage.assignFileType(ConfigUtils.getInstance().FileType());
        docTypePage.assignInfoType(ConfigUtils.getInstance().InfoType());
        System.out.println(Doc);
    }
}
