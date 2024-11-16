package TestCases;

import BaseTest.baseTest;
import Config.ConfigUtils;
import org.testng.annotations.Test;

public class EndToEndScenariosTest extends baseTest {


    @Test
    public void e2eScenarioToStartNewDiscovery() throws InterruptedException {

        driver.get(ConfigUtils.getInstance().getBaseUrl());
        loginPage.AdminLogin(ConfigUtils.getInstance().getEmail(),
                ConfigUtils.getInstance().getPassword());
        //navigate to Info Page
        homePage.navigateToInfoPage();
        infoTypePage.createInfoType(Info, key
                ,disc);
        Thread.sleep(1000);
        // navigate to Document page
        homePage.click_docinput();
        homePage.clickAddDocTypeButton();
        docTypePage.addDocType(Doc,randomnumber);
        docTypePage.navigateToLastDocType();
        docTypePage.assignFileType(ConfigUtils.getInstance().FileType());
        docTypePage.assignInfoType(Info);
        //navigate to label page
        homePage.navigateToLabelCreation();
        labelpage.createLabelAndAssignMatrix(LabelName,"Top Secret",
                Doc, Info);
        //navigate to discovery
        homePage.openDiscoveryPage();
        discoveryPage.createDiscovery(DiscoveryName, "EndPoint",
                "Qa schedule", ConfigUtils.getInstance().FileType(), Info,
                Doc, "TEST008");
        //print the details
        System.out.println(Info);
        System.out.println(key);
        System.out.println(Doc);
        System.out.println(LabelName);
        System.out.println(DiscoveryName);
    }
}
