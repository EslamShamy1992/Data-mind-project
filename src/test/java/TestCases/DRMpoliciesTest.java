package TestCases;
import BaseTest.baseTest;
import Config.ConfigUtils;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DRMpoliciesTest extends baseTest {

    
    @Test(invocationCount = 1)
    public void AddNewAutoPolicy() throws InterruptedException {
        String Policyname = faker.name().lastName();
        driver.get(ConfigUtils.getInstance().getBaseUrl());
        loginPage.AdminLogin(ConfigUtils.getInstance().getEmail(),
                ConfigUtils.getInstance().getPassword());
        homePage.NavigateToPolicyCreation();
     drmPoliciesPage.createPolicy(Policyname,"11/20/2025");


    }}
