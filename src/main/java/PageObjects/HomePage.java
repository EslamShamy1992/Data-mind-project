package PageObjects;

import Base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By sidebarMenu = By.xpath("//*[@id=\"leftsidebar\"]/div/ul/li[15]/a");
    private By docInput = By.xpath("//*[@id='leftsidebar']/div/ul/li[15]/ul/li[2]/a");
    private By InfoType = By.xpath("/html/body/app-root/div/app-main-layout/app-main/div/section/div/div/div[1]/button");

    private By classificationsidebar= By.xpath("//*[@id=\"leftsidebar\"]/div/ul/li[4]/a/span");
    private By labelsidebar = By.xpath("//*[@id=\"leftsidebar\"]/div/ul/li[4]/ul/li[1]/a");

    private By drmpolicysidebar= By.xpath("//*[@id=\"leftsidebar\"]/div/ul/li[4]/ul/li[2]/a");
    public void clickSidebarMenu() {
      WebElement sidebar= driver.findElement(sidebarMenu);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sidebar);
        sidebar.click();



    }

    public void click_docinput() {
        WebElement subMenuElement = driver.findElement(docInput);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", subMenuElement);
        subMenuElement.click();
    }

    public void clickInfoType() {
        driver.findElement(InfoType).click();
    }

    private WebElement waitUntilClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void navigateToLabelCreation() {
        waitUntilClickable(classificationsidebar).click();
        waitUntilClickable(labelsidebar).click();
    }

    public  void NavigateToPolicyCreation(){
        waitUntilClickable(classificationsidebar).click();
        waitUntilClickable(drmpolicysidebar).click();
    }
}







