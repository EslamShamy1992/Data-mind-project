package TestCases;
import BaseTest.baseTest;
import Config.ConfigUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InfoTypeTest extends baseTest {


    @Test(priority = 1)
    public void Verify_Add_Info_Type() {
        String infoName= faker.name().firstName();
        driver.get(ConfigUtils.getInstance().getBaseUrl());
        loginPage.AdminLogin(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword());
        homePage.clickSidebarMenu();
        homePage.click_docinput();
        homePage.clickInfoType();
        infoTypePage.clickNewButton();
        infoTypePage.enterNameEN(infoName);
        infoTypePage.enterNameAR(faker.name().name());
        infoTypePage.enterKey(faker.name().name());
        infoTypePage.enterDescription(faker.name().lastName());
        infoTypePage.clickSubmitButton();
        //assert that info type is added successfully
        Assert.assertTrue(loginPage.LogoIsDisplayed());
        System.out.println(infoName);
    }
}
