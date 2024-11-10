package PageObjects;
import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class DocTypePage extends BasePage {
    public DocTypePage(WebDriver driver) {
        super(driver);
    }

    private By addDocTypeButton = By.xpath("/html/body/app-root/div/app-main-layout/app-main/div/section/div/div/div[2]/button");
    private By addButton = By.xpath("/html/body/app-root/div/app-main-layout/app-document-types-list/div/section/div/app-table-list/div/div[1]/div[3]/div/button[4]/span[1]");
    private By doctypeNameInput = By.id("mat-input-3");
    private By randomNumberInput = By.id("mat-input-5");
    private By saveButton = By.xpath("/html/body/app-root/div/app-main-layout/app-document-types-add-edit/div/section/div/div/form/div[6]/div/app-button[1]/button/span[2]");
    private By paginatorNextButton = By.xpath("/html/body/app-root/div/app-main-layout/app-document-types-list/div/section/div/app-table-list/div/div[3]/mat-paginator/div/div/div[2]/button[4]");
    private By actionButtons = By.cssSelector(".mat-mdc-menu-trigger.table-action-menu-btn");
    private By infoButton = By.id("Information");
    private By fileTypeTab = By.id("mat-tab-label-1-1");
    private By assignButton = By.xpath("/html/body/app-root/div/app-main-layout/app-document-types-root/div/section/app-document-type-file-types/div/section/div/app-table-list/div/div[1]/div[3]/div/button[4]");
    private By menuButton = By.cssSelector("#pn_id_3");
    private By closeIcon = By.xpath("//*[@id=\"pn_id_3_list\"]/div[1]/button");
    private By confirmButton = By.xpath("//*[@id=\"mat-mdc-dialog-0\"]/div/div/app-file-types-dialog/div/div/div[2]/div/button[1]");
    private By infoTypeTab = By.id("mat-tab-label-1-2");
    private By selectInfoButton = By.xpath("/html/body/app-root/div/app-main-layout/app-document-types-root/div/section/app-document-type-information-types/div/section/div/app-table-list/div/div[1]/div[3]/div/button[4]/span[1]");
    private By multiSelectTrigger = By.className("p-multiselect-trigger");
    private By multiSelectItems = By.cssSelector(".p-multiselect-item");
    private By removeInfoButton = By.xpath("//*[@id=\"pn_id_7_list\"]/div[1]/button/timesicon");
    private By assignInfoConfirmButton = By.xpath("//*[@id=\"mat-mdc-dialog-1\"]/div/div/app-assign-info-types-dialog/div/div/div[2]/div/button[1]");



    public void clickAddDocTypeButton() {
        driver.findElement(addDocTypeButton).click();
    }

    public void clickAddButton() {
        driver.findElement(addButton).click();
    }

    public void enterDocTypeName(String name) {
        driver.findElement(doctypeNameInput).sendKeys(name);
    }

    public void enterRandomNumber(int number) {
        driver.findElement(randomNumberInput).sendKeys(String.valueOf(number));
    }

    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }

    public void clickPaginatorNext() {
        driver.findElement(paginatorNextButton).click();
    }

    public void clickLastActionButton() {
        List<WebElement> actionButtonsList = driver.findElements(actionButtons);
        actionButtonsList.get(actionButtonsList.size() - 1).click();
    }

    public void clickDetailsButton() {
        driver.findElement(infoButton).click();
    }

    public void clickFileTypeTab() {
        driver.findElement(fileTypeTab).click();
    }

    public void clickAssignButton() {
        driver.findElement(assignButton).click();
    }

    public void clickMenuButton() {
        driver.findElement(menuButton).click();
    }

    public void selectFile(String text) {
//       List<WebElement> choose=driver.findElements(multiSelectItems);
//       choose.get(choose.size()-1).click();
        List<WebElement> items = driver.findElements(multiSelectItems);
        for (WebElement item : items) {
            if (item.getText().equals(text)) {
                item.click();
                break; // Exit the loop after selecting the item
            }
        }
    }

    public void clickCloseIcon() {
        driver.findElement(closeIcon).click();
    }

    public void clickConfirmButton() {
        driver.findElement(confirmButton).click();
    }

    public void clickInfoTypeTab() {
        driver.findElement(infoTypeTab).click();
    }

    public void clickAssignInfoButton() {
        driver.findElement(selectInfoButton).click();
    }

    public void clickMultiSelectTrigger() {
        driver.findElement(multiSelectTrigger).click();
    }

    public void selectLastInfo(String text) {
//        List<WebElement> infoItems = driver.findElements(multiSelectItems);
//        infoItems.get(infoItems.size() - 1).click();
        List<WebElement> Infoitems = driver.findElements(multiSelectItems);
        for (WebElement item : Infoitems) {
            if (item.getText().equals(text)) {
                item.click();
                break; // Exit the loop after selecting the item
            }
        }
    }

    public void clickXicon() {
        driver.findElement(removeInfoButton).click();
    }

    public void clickAssignInfoConfirmButton() {
        driver.findElement(assignInfoConfirmButton).click();
    }

    public void addDocType(String name, int number) throws InterruptedException {
        clickAddDocTypeButton();
        clickAddButton();
        enterDocTypeName(name);
        enterRandomNumber(number);
        clickSaveButton();
        Thread.sleep(1000); // Consider replacing with an explicit wait
        clickPaginatorNext();
    }

    public void navigateToLastDocType() throws InterruptedException {
        clickLastActionButton();
        Thread.sleep(1000); // Consider replacing with an explicit wait
        clickDetailsButton();
        clickFileTypeTab();
    }

    public void assignFileType(String filename) throws InterruptedException {
        clickAssignButton();
        clickMenuButton();
        selectFile(filename);
        clickCloseIcon();
        clickConfirmButton();
    }

    public void assignInfoType(String infoname) throws InterruptedException {
        clickInfoTypeTab();
        clickAssignInfoButton();
        clickMultiSelectTrigger();
        selectLastInfo(infoname);
        clickXicon();
        clickAssignInfoConfirmButton();
    }
}
