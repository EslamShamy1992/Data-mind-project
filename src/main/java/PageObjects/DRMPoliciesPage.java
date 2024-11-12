package PageObjects;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DRMPoliciesPage extends BasePage {
    public DRMPoliciesPage(WebDriver driver) {
        super(driver);
    }


    By addpolicybutton= By.xpath("/html/body/app-root/div/app-main-layout/app-policies-list/div/section/app-table-list/div/div[1]/div[3]/div/button[4]/span[2]");





    public void ClickAddPolicyButton(){
        waitElementToBeClickable(addpolicybutton).click();
    }

    public WebElement waitElementToBeClickable(By locator){
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}

