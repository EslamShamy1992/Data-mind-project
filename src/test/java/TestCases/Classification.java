package TestCases;

import BaseTest.baseTest;
import Config.ConfigUtils;
import org.testng.annotations.Test;

public class Classification extends baseTest {


    @Test
    public void AddNewLabel() throws InterruptedException {

        String labelyname = faker.name().lastName();
        driver.get(ConfigUtils.getInstance().getBaseUrl());
        loginPage.AdminLogin(ConfigUtils.getInstance().getEmail(),
                ConfigUtils.getInstance().getPassword());
        classificationPage.navigateToLabelCreation();
        // Click "Add Label" button
        classificationPage.clickAddLabelButton();
        // Enter a label name
        classificationPage.enterLabelName(labelyname);
        // Select sensitivity "Top Secret"
        Thread.sleep(1000);
        classificationPage.selectSensitivity("Top Secret");
        // Save the label
        classificationPage.saveLabel();
        // Perform an action on the last label
        classificationPage.performActionOnLastLabel();
        // Select the document type "doc excel"
        classificationPage.selectDocumentType("doc excel");
        // Select the info type "excel info"
        classificationPage.selectInfoType("excel info");
        // Confirm the matrix assignment
        classificationPage.confirmMatrixAssignment();






    }

        }
