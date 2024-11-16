package TestCases;
import BaseTest.baseTest;
import Config.ConfigUtils;
import org.testng.annotations.Test;

public class LabelTest extends baseTest {


    @Test(invocationCount = 1)
    public void AddNewLabel() throws InterruptedException {

        driver.get(ConfigUtils.getInstance().getBaseUrl());
        loginPage.AdminLogin(ConfigUtils.getInstance().getEmail(),
                ConfigUtils.getInstance().getPassword());
        homePage.navigateToLabelCreation();
        labelpage.createLabelAndAssignMatrix(LabelName,"Top Secret",
                ConfigUtils.getInstance().DocType(),
                ConfigUtils.getInstance().InfoType());

        System.out.println(LabelName);
    }



        }
