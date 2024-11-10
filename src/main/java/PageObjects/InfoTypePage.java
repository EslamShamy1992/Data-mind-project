package PageObjects;
import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InfoTypePage extends BasePage {
    public InfoTypePage(WebDriver driver) {
        super(driver);
    }


    private By NewButton = By.xpath("/html/body/app-root/div/app-main-layout/app-information-types-list/div/section/app-table-list/div/div[1]/div[3]/div/button[4]/span[2]");
    private By nameENInput = By.id("mat-input-3");
    private By nameARInput = By.id("mat-input-4");
    private By keyInput = By.xpath("//*[@id='multiselectelement']/div/div/span[3]/input");
    private By descInput = By.id("mat-input-5");
    private By submitButton = By.xpath("/html/body/app-root/div/app-main-layout/app-information-types-add-edit/div/section/div/form/div[4]/div/app-button[1]/button/span[2]");



    public void clickNewButton() {
        driver.findElement(NewButton).click();
    }

    public void enterNameEN(String name) {
        driver.findElement(nameENInput).sendKeys(name);
    }

    public void enterNameAR(String name) {
        driver.findElement(nameARInput).sendKeys(name);
    }

    public void enterKey(String key) {
        WebElement keyElement = driver.findElement(keyInput);
        keyElement.sendKeys(key);
        keyElement.sendKeys(Keys.RETURN);
    }

    public void enterDescription(String description) {
        driver.findElement(descInput).sendKeys(description);
    }

    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }
}

