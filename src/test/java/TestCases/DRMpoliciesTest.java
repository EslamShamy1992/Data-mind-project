package TestCases;
import BaseTest.baseTest;
import Config.ConfigUtils;

import org.testng.annotations.Test;

public class DRMpoliciesTest extends baseTest {

    
    @Test(invocationCount = 1)
    public void AddNewAutoPolicy()  {
        String Policyyname = faker.name().lastName();
        driver.get(ConfigUtils.getInstance().getBaseUrl());
        loginPage.AdminLogin(ConfigUtils.getInstance().getEmail(),
                ConfigUtils.getInstance().getPassword());
        homePage.NavigateToPolicyCreation();
        drmPoliciesPage.createPolicy(Policyyname,"1/31/2025");


    }}
