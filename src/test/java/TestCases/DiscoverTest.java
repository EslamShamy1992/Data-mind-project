package TestCases;

import BaseTest.baseTest;
import Config.ConfigUtils;
import org.testng.annotations.Test;

public class DiscoverTest extends baseTest {

    @Test
    public void Add_New_Discovery() throws InterruptedException {

        driver.get(ConfigUtils.getInstance().getBaseUrl());
        loginPage.AdminLogin(ConfigUtils.getInstance().getEmail(),
                ConfigUtils.getInstance().getPassword());
        homePage.openDiscoveryPage();
        discoveryPage.createDiscovery(DiscoveryName, "EndPoint",
                "Qa schedule", ConfigUtils.getInstance().FileType(),
                ConfigUtils.getInstance().InfoType(),
                ConfigUtils.getInstance().DocType(), "TEST008");


    }
}