package PageObjects;
import Base.BasePage;
import org.openqa.selenium.*;
import java.util.List;

public class DiscoveryPage extends BasePage {
    public DiscoveryPage(WebDriver driver) {
        super(driver);
    }

    private By menuToggle = By.xpath("//*[@id=\"leftsidebar\"]/div/ul/li[3]/a");
    private By discoveryLink = By.xpath("//*[@id=\"leftsidebar\"]/div/ul/li[3]/ul/li/a");
    private By newDiscoveryButton = By.xpath("/html/body/app-root/div/app-main-layout/app-discovery-list/div/section/app-table-list/div/div[1]/div[3]/div/button[4]");
    private By discoveryNameField = By.id("mat-input-3");
    private By endpointSelect = By.xpath("//*[@id=\"mat-select-value-5\"]/span");
    private By targetOptions = By.className("mdc-list-item__primary-text");
    private By Selectdirectory = By.id("mat-select-6");
    private By currentuserDirectory = By.xpath("//*[@id=\"mat-option-13\"]");
    private By scheduleManagerField = By.xpath("//*[@formcontrolname='scheduleManagerId']");
    private By scheduleOptions = By.cssSelector(".mdc-list-item__primary-text");
    private By discoveryFileInput = By.xpath("//input[@formcontrolname='discoveryFile']");
    private By discoveryInfoInput = By.xpath("//input[@formcontrolname='discoveryInfo']");
    private By discoveryDocumentInput = By.xpath("//input[@formcontrolname='discoveryDocument']");
    private By docExcelInput = By.xpath("//*[@id=\"mat-input-5\"]");
    private By saveButton = By.xpath("/html/body/app-root/div/app-main-layout/app-discovery-add-edit/div/section/div/div/form/div[9]/div/button[1]");
    private By actionButtons = By.cssSelector(".mat-mdc-menu-trigger.table-action-menu-btn");
    private By assignEndpointButton = By.id("AssignEndpoint");
    private By multiselectTrigger = By.className("p-multiselect-trigger");
    private By multiselectItem = By.cssSelector(".p-multiselect-item");
    private By assignButton = By.xpath("//*[@id='pn_id_3_list']/div[1]/button");
    private By confirmButton = By.xpath("//*[@id='mat-mdc-dialog-0']/div/div/app-add-assigning/div/div/div[2]/form/div/app-button");






    // Method to navigate to the Discovery page
    public void openDiscoveryPage() {
        driver.findElement(menuToggle).click();
        driver.findElement(discoveryLink).click();
    }

    // Method to click on the New Discovery button
    public void clickNewDiscoveryButton() {
        driver.findElement(newDiscoveryButton).click();
    }

    // Method to enter discovery name
    public void enterDiscoveryName(String discoveryName) {
        driver.findElement(discoveryNameField).sendKeys(discoveryName);
    }

    // Method to select an endpoint from the dropdown
    public void selectTaregtType(String endpoint) {
        driver.findElement(endpointSelect).click();
        List<WebElement> targets = driver.findElements(targetOptions);
        for (WebElement tar : targets) {
            if (tar.getText().equals(endpoint)) {
                tar.click();
                break;
            }
        }
    }

    // Method to select a schedule from the dropdown
    public void selectDirectory() {
        driver.findElement(Selectdirectory).click();
        driver.findElement(currentuserDirectory).click();
    }

    // Method to select the Schedule Manager
    public void selectSchedule(String scheduleName) {
        driver.findElement(scheduleManagerField).click();
        List<WebElement> scheduleList = driver.findElements(scheduleOptions);
        for (WebElement sch : scheduleList) {
            if (sch.getText().equals(scheduleName)) {
                sch.click();
                break;
            }
        }
    }

    // Method to upload a discovery file
    public void uploadDiscoveryFile(String filePath) {
        driver.findElement(discoveryFileInput).sendKeys(filePath, Keys.RETURN);
    }

    // Method to upload discovery info
    public void enterDiscoveryInfo(String info) {
        driver.findElement(discoveryInfoInput).sendKeys(info, Keys.RETURN);
    }

    // Method to upload discovery document
    public void uploadDiscoveryDocument(String docPath) {
        driver.findElement(discoveryDocumentInput).sendKeys(docPath, Keys.RETURN);
    }

    // Method to enter document Excel input
    public void enterDocExcel(String docPath) {
        driver.findElement(docExcelInput).sendKeys(docPath);
    }

    // Method to save the discovery
    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }

    // Method to click the last action button in the list
    public void clickLastActionButton() {
        List<WebElement> actionButtonsList = driver.findElements(actionButtons);
        actionButtonsList.get(actionButtonsList.size() - 1).click();
    }

    public void clickAssignEndpointButton() {
        driver.findElement(assignEndpointButton).click();
    }

    // Click on the multi-select dropdown trigger
    public void clickMultiselectTrigger() {
        driver.findElement(multiselectTrigger).click();
    }

    // Select an endpoint from the list
    public void selectEndpoint(String endpointName) {
        List<WebElement> endpoints = driver.findElements(multiselectItem);
        for (WebElement endpoint : endpoints) {
            if (endpoint.getText().equals(endpointName)) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", endpoint);
                endpoint.click();
                break;
            }
        }
    }

    // Click the "Assign" button
    public void clickAssignButton() {
        driver.findElement(assignButton).click();
    }

    // Click the confirmation button
    public void clickConfirmButton() {
        driver.findElement(confirmButton).click();
    }

    // Complete assignment process
    public void completeAssignment(String endpointName) {
        clickAssignEndpointButton();
        clickMultiselectTrigger();
        selectEndpoint(endpointName);
        clickAssignButton();
        clickConfirmButton();
    }


}
