package TestCases;
import BaseTest.baseTest;
import Config.ConfigUtils;
import org.testng.annotations.Test;
public class DiscoverTest extends baseTest {

    @Test
    public void Add_New_Discovery() throws InterruptedException {
        String discoveryname = faker.name().lastName();
        driver.get(ConfigUtils.getInstance().getBaseUrl());
        loginPage.AdminLogin(ConfigUtils.getInstance().getEmail(),
                ConfigUtils.getInstance().getPassword());
        discoveryPage.openDiscoveryPage();
        discoveryPage.clickNewDiscoveryButton();
        discoveryPage.enterDiscoveryName(discoveryname);
        discoveryPage.selectTaregtType("EndPoint");
        discoveryPage.selectDirectory();
        Thread.sleep(1000);
        discoveryPage.selectSchedule("Qa schedule");
        discoveryPage.uploadDiscoveryFile("excel file");
        discoveryPage.enterDiscoveryInfo("excel info");
        discoveryPage.uploadDiscoveryDocument("Doc excel");
        discoveryPage.clickSaveButton();
        discoveryPage.clickLastActionButton();
        discoveryPage.completeAssignment("TEST008");
        System.out.println(discoveryname);
        Thread.sleep(1000);
        discoveryPage.clickLastActionButton();
        discoveryPage.StartDiscovery();
}

}
