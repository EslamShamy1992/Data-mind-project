package PageObjects;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LabelPage extends BasePage {

    public LabelPage(WebDriver driver) {
        super(driver);

    }



    // Locators
    private By addLabelButton = By.xpath("/html/body/app-root/div/app-main-layout/app-labels-list/div/section/app-table-list/div/div[1]/div[3]/div/button[4]/span[2]");
    private By labelNameInput = By.xpath("//*[@formcontrolname='labelNameFL']");
    private By sensitivityDropdown = By.xpath("//*[@formcontrolname='sensitivityId']");
    private By sensitivityOptions = By.xpath("//*[@role='option']/span");
    private By saveLabelButton = By.xpath("/html/body/app-root/div/app-main-layout/labels-type-add-edit/div/section/div/form/div[5]/div/button[1]/span[2]");

    private By labelActionButtons = By.cssSelector(".mat-mdc-menu-trigger.table-action-menu-btn");
    private By matrixButton = By.id("Matrix");
    private By documentTypeMatrixDropdown = By.id("doctype-matrix");
    private By documentTypeOptions = By.cssSelector(".p-multiselect-item");
    private By infoTypeMatrixDropdown = By.id("infotype-matrix");
    private By infoTypeOptions = By.className("p-multiselect-item");
    private By confirmButton = By.xpath("//*[@id=\"mat-mdc-dialog-2\"]/div/div/app-matrix-assign-dialog/div/div/div[2]/form/div[2]/button[1]");




    // Method to open sidebar and navigate to label creation


    // Method to click "Add Label" button
    public void clickAddLabelButton() {
        waitUntilClickable(addLabelButton).click();
    }

    // Method to enter label name
    public void enterLabelName(String labelName) {
        waitUntilVisible(labelNameInput).sendKeys(labelName);
    }

    // Method to open and select sensitivity option
    public void selectSensitivity(String sensitivityName) throws InterruptedException {
        waitUntilClickable(sensitivityDropdown).click();
        Thread.sleep(1000);
        List<WebElement> sensitivityList = driver.findElements(sensitivityOptions);
        for (WebElement sensitivity : sensitivityList) {
            if (sensitivity.getText().equals(sensitivityName)) {
                sensitivity.click();
                break;
            }
        }
    }

    // Method to save the label
    public void saveLabel() {
        waitUntilClickable(saveLabelButton).click();
    }

    // Method to perform actions on the last label in the list (click action button)
    public void performActionOnLastLabel() {

        List<WebElement> labelActions = driver.findElements(labelActionButtons);
        labelActions.get(labelActions.size() - 1).click();
        waitUntilClickable(matrixButton).click();// Click the last action button
    }

    // Method to select document type in matrix
    public void selectDocumentType(String documentType){
        waitUntilClickable(documentTypeMatrixDropdown).click();
        selectItemFromDropdown(documentTypeOptions, documentType);
    }

    // Method to select info type in matrix
    public void selectInfoType(String infoType) throws InterruptedException {
       driver.findElement(infoTypeMatrixDropdown).click();
       Thread.sleep(1000);
        selectItemFromDropdown(infoTypeOptions, infoType);

    }

    // Method to confirm the matrix assignment
    public void confirmMatrixAssignment() throws InterruptedException {
        waitUntilClickable(confirmButton).click();
        Thread.sleep(1000);
    }

    // Helper method to wait until an element is clickable
    private WebElement waitUntilClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Helper method to wait until an element is visible
    private WebElement waitUntilVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Helper method to select an item from a dropdown
    private void selectItemFromDropdown(By dropdownItemsLocator, String itemName) {
        List<WebElement> items = driver.findElements(dropdownItemsLocator);
        for (WebElement item : items) {
            if (item.getText().equals(itemName)) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item);
                item.click();
                break;
            }
        }

    }


    public void createLabelAndAssignMatrix(String labelName, String sensitivity, String docType, String infoType) throws InterruptedException {
        clickAddLabelButton();
        enterLabelName(labelName);
        selectSensitivity(sensitivity);
        saveLabel();
        performActionOnLastLabel();
        selectDocumentType(docType);
        selectInfoType(infoType);
        confirmMatrixAssignment();
    }







}
