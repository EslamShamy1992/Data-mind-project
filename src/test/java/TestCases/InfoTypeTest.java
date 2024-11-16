package TestCases;
import BaseTest.baseTest;
import Config.ConfigUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InfoTypeTest extends baseTest {


    @Test(priority = 1)
    public void Verify_Add_Info_Type() {

        driver.get(ConfigUtils.getInstance().getBaseUrl());
        loginPage.AdminLogin(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword());
        homePage.navigateToInfoPage();
        infoTypePage.createInfoType(Info,faker.name().lastName()
                ,faker.name().lastName());
        Assert.assertTrue(loginPage.LogoIsDisplayed());
        System.out.println(Info);
    }
}
