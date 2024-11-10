package TestCases;

import BaseTest.baseTest;
import Config.ConfigUtils;
import org.testng.annotations.Test;

public class LoginTest extends baseTest {


    @Test
    public void Login_as_admin(){
        driver.get(ConfigUtils.getInstance().getBaseUrl());
        loginPage.AdminLogin(ConfigUtils.getInstance().getEmail(),
                ConfigUtils.getInstance().getPassword());

    }
}
