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
                , disc);
        Thread.sleep(1000);
        // navigate to Document page
        homePage.click_docinput();
        homePage.clickAddDocTypeButton();
        docTypePage.addDocType(Doc, randomnumber);
        docTypePage.navigateToLastDocType();
        docTypePage.assignFileType(ConfigUtils.getInstance().FileType());
        docTypePage.assignInfoType(Info);
        //navigate to label page
        homePage.navigateToLabelCreation();
        labelpage.createLabelAndAssignMatrix(LabelName, "Top Secret",
                Doc, Info);
        //navigate to drm policy
        homePage.clickPolicySideBar();
        drmPoliciesPage.createPolicy(Policyname, "11/20/2025");
        //navigate to discovery
        homePage.openDiscoveryPage();
        discoveryPage.createDiscovery(DiscoveryName, "EndPoint",
                "Qa schedule", ConfigUtils.getInstance().FileType(), Info,
                Doc, "TEST008");
        //print the details
        System.out.println("Information type is :" + Info);
        System.out.println("Key is :" + key);
        System.out.println("Document type is :" + Doc);
        System.out.println("Label name is :" + LabelName);
        System.out.println("Discovery name is :" + DiscoveryName);
        System.out.println("Policy name is :" + Policyname);
    }
}
