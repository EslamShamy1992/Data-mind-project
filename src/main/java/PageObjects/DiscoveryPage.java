package PageObjects;
import Base.BasePage;
import org.openqa.selenium.*;
import java.util.List;

public class DiscoveryPage extends BasePage {
    public DiscoveryPage(WebDriver driver) {
        super(driver);
    }


    private By newDiscoveryButton = By.xpath("/html/body/app-root/div/app-main-layout/app-discovery-list/div/section/app-table-list/div/div[1]/div[3]/div/button[4]");
    private By discoveryNameField = By.xpath("//*[@formcontrolname='discoveryNameFL']");
    private By endpointSelect = By.xpath("//*[@formcontrolname='targetTypeId']");
    private By targetOptions = By.className("mdc-list-item__primary-text");
    private By Selectdirectory = By.xpath("//*[@formcontrolname='directoryId']");
    private By currentuserDirectory = By.className("mdc-list-item__primary-text");
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
    private By assignButton = By.xpath("//*[@buttontitle='add']");
    private By confirmButton = By.xpath("//*[@id='mat-mdc-dialog-0']/div/div/app-add-assigning/div/div/div[2]/form/div/app-button");
    private By startDiscovery= By.id("StartDiscovery");
    private By closeIcon = By.xpath("//*[@aria-label='Close']");





    // Method to navigate to the Discovery page


    // Method to click on the New Discovery button
    public void clickNewDiscoveryButton() {
        driver.findElement(newDiscoveryButton).click();
    }

    // Method to enter discovery name
    public void enterDiscoveryName(String discoveryName) {
        driver.findElement(discoveryNameField).sendKeys(discoveryName);
    }

    // Method to select an endpoint from the dropdown
    public void selectTaregtType(String endpoint) throws InterruptedException {
        driver.findElement(endpointSelect).click();
        Thread.sleep(1000);
        List<WebElement> targets = driver.findElements(targetOptions);
        for (WebElement tar : targets) {
            if (tar.getText().equals(endpoint)) {
                tar.click();
                break;
            }
        }
    }

    // Method to select a schedule from the dropdown
    public void selectDirectory() throws InterruptedException {
        driver.findElement(Selectdirectory).click();
//        driver.findElement(currentuserDirectory).click();
        Thread.sleep(1000);
        List<WebElement> user = driver.findElements(currentuserDirectory);
        for (WebElement use : user) {
            if (use.getText().equals("Current User Profile")) {
                use.click();
                break;
            }
        }

        // Current User Profile
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
    public void completeAssignment(String endpointName) throws InterruptedException {
        clickAssignEndpointButton();
        clickMultiselectTrigger();
        selectEndpoint(endpointName);
        clickCloseIcon();
        clickAssignButton();
//        clickConfirmButton();
    }

    public void StartDiscovery(){
        driver.findElement(startDiscovery).click();
    }
    public void clickCloseIcon() {
        driver.findElement(closeIcon).click();
    }

    public void createDiscovery(String discoveryName,String endpoint, String schedule, String fileType, String infoType, String docType, String assignmentId) throws InterruptedException {
        clickNewDiscoveryButton();
        enterDiscoveryName(discoveryName);
        selectTaregtType(endpoint);
        selectDirectory();
        Thread.sleep(1000);
        selectSchedule(schedule);
        uploadDiscoveryFile(fileType);
        enterDiscoveryInfo(infoType);
        uploadDiscoveryDocument(docType);
        clickSaveButton();
        clickLastActionButton();
        completeAssignment(assignmentId);
        Thread.sleep(1000);
        clickLastActionButton();
        StartDiscovery();
    }
}
