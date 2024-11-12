package TestCases;
import BaseTest.baseTest;
import Config.ConfigUtils;
import org.testng.annotations.Test;

public class LabelTest extends baseTest {


    @Test
    public void AddNewLabel() throws InterruptedException {

        String labelyname = faker.name().lastName();
        driver.get(ConfigUtils.getInstance().getBaseUrl());
        loginPage.AdminLogin(ConfigUtils.getInstance().getEmail(),
                ConfigUtils.getInstance().getPassword());
        homePage.navigateToLabelCreation();
        // Click "Add Label" button
        labelpage.clickAddLabelButton();
        // Enter a label name
        labelpage.enterLabelName(labelyname);
        // Select sensitivity "Top Secret"
        labelpage.selectSensitivity("Top Secret");
        // Save the label
        labelpage.saveLabel();
        // Perform an action on the last label
        labelpage.performActionOnLastLabel();
        // Select the document type "doc excel"
        labelpage.selectDocumentType(ConfigUtils.getInstance().DocType());
        // Select the info type "excel info"
        labelpage.selectInfoType(ConfigUtils.getInstance().InfoType());
        // Confirm the matrix assignment
        labelpage.confirmMatrixAssignment();


    }



        }
