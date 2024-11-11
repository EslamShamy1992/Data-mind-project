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
//        driver.findElement(By.xpath("//*[@id=\"leftsidebar\"]/div/ul/li[4]/a/span")).click();
//        driver.findElement(By.xpath("//*[@id=\"leftsidebar\"]/div/ul/li[4]/ul/li[1]/a")).click();
//        driver.findElement(By.xpath("/html/body/app-root/div/app-main-layout/app-labels-list/div/section/app-table-list/div/div[1]/div[3]/div/button[4]/span[2]")).click();
//        driver.findElement(By.xpath("//*[@formcontrolname='labelNameFL']")).sendKeys(labelyname);
//        driver.findElement(By.xpath("//*[@formcontrolname='sensitivityId']")).click();
//
//        Thread.sleep(1000);
//        List<WebElement> sensetivity = driver.findElements(By.xpath("//*[@role='option']/span"));
//
//        for (WebElement sen : sensetivity)
//            if (sen.getText().equals("Top Secret")) {
//
//                sen.click();
//            }
//        driver.findElement(By.xpath("/html/body/app-root/div/app-main-layout/labels-type-add-edit/div/section/div/form/div[5]/div/button[1]/span[2]")).click();
//
//        List<WebElement> lastlabel = driver.findElements(By.cssSelector(".mat-mdc-menu-trigger.table-action-menu-btn"));
//
//        lastlabel.get(lastlabel.size() - 1).click();
//        driver.findElement(By.id("Matrix")).click();
//
//        driver.findElement(By.id("doctype-matrix")).click();
//
//        Thread.sleep(1000);
//        List<WebElement> docs = driver.findElements(By.cssSelector(".p-multiselect-item"));
//
//        for (WebElement doc : docs)
//            if (doc.getText().equals("doc excel")) {
//                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", doc);
//
//                doc.click();
//            }
//
//            driver.findElement(By.id("infotype-matrix")).click();
//
//
//        Thread.sleep(1000);
//        List<WebElement> infos = driver.findElements(By.cssSelector(".p-multiselect-item"));
//
//        for (WebElement info : infos)
//            if (info.getText().equals("excel info")) {
//                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", info);
//
//                info.click();
//            }
//
//        driver.findElement(By.xpath("//*[@id=\"mat-mdc-dialog-0\"]/div/div/app-matrix-assign-dialog/div/div/div[2]/form/div[2]/button[1]")).click();
//
//            }

        }
