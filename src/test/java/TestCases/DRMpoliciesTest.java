package TestCases;
import BaseTest.baseTest;
import Config.ConfigUtils;
import org.testng.annotations.Test;

public class DRMpoliciesTest extends baseTest {




    @Test
    public void AddNewPolicy(){

        String Policyyname = faker.name().lastName();
        driver.get(ConfigUtils.getInstance().getBaseUrl());
        loginPage.AdminLogin(ConfigUtils.getInstance().getEmail(),
                ConfigUtils.getInstance().getPassword());
        homePage.NavigateToPolicyCreation();
        drmPoliciesPage.ClickAddPolicyButton();

    }

}
