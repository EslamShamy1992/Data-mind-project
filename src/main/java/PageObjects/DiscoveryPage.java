package PageObjects;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DicoveryPage extends BasePage {
    public DicoveryPage(WebDriver driver) {
        super(driver);
    }

    private By menuToggle = By.xpath("//*[@id=\"leftsidebar\"]/div/ul/li[3]/a");
    private By discoveryLink = By.xpath("//*[@id=\"leftsidebar\"]/div/ul/li[3]/ul/li/a");
    private By newDiscoveryButton = By.xpath("/html/body/app-root/div/app-main-layout/app-discovery-list/div/section/app-table-list/div/div[1]/div[3]/div/button[4]");
    private By discoveryNameField = By.id("mat-input-3");
    private By endpointSelect = By.xpath("//*[@id=\"mat-select-value-5\"]/span");
    private By endpointOption = By.xpath("//span[text()='EndPoint']");
    private By targetOptions = By.className("mdc-list-item__primary-text");
    private By scheduleSelect = By.id("mat-select-6");
    private By scheduleOption = By.xpath("//*[@id=\"mat-option-13\"]");
    private By scheduleManagerField = By.xpath("//*[@formcontrolname='scheduleManagerId']");
    private By scheduleOptions = By.cssSelector(".mdc-list-item__primary-text");
    private By discoveryFileInput = By.xpath("//input[@formcontrolname='discoveryFile']");
    private By discoveryInfoInput = By.xpath("//input[@formcontrolname='discoveryInfo']");
    private By discoveryDocumentInput = By.xpath("//input[@formcontrolname='discoveryDocument']");
    private By docExcelInput = By.xpath("//*[@id=\"mat-input-5\"]");
    private By saveButton = By.xpath("/html/body/app-root/div/app-main-layout/app-discovery-add-edit/div/section/div/div/form/div[9]/div/button[1]");
    private By actionButtons = By.cssSelector(".mat-mdc-menu-trigger.table-action-menu-btn");



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
    public void selectEndpoint() {
        driver.findElement(endpointSelect).click();
        List<WebElement> targets = driver.findElements(targetOptions);
        for (WebElement tar : targets) {
            if (tar.getText().equals("EndPoint")) {
                tar.click();
                break;
            }
        }
    }

    // Method to select a schedule from the dropdown
    public void selectSchedule() {
        driver.findElement(scheduleSelect).click();
        driver.findElement(scheduleOption).click();
    }

    // Method to select the Schedule Manager
    public void selectScheduleManager(String scheduleName) {
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




}
