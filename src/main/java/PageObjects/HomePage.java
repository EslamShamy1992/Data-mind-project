package PageObjects;

import Base.BasePage;
import org.openqa.selenium.*;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By sidebarMenu = By.xpath("//*[@id='leftsidebar']/div/ul/li[15]/a");
    private By docInput = By.xpath("//*[@id='leftsidebar']/div/ul/li[15]/ul/li[2]/a");
    private By InfoType = By.xpath("/html/body/app-root/div/app-main-layout/app-main/div/section/div/div/div[1]/button");


    public void clickSidebarMenu() {
        driver.findElement(sidebarMenu).click();
    }

    public void click_docinput() {
        WebElement subMenuElement = driver.findElement(docInput);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", subMenuElement);
        subMenuElement.click();
    }

    public void clickInfoType() {
        driver.findElement(InfoType).click();
    }

}







