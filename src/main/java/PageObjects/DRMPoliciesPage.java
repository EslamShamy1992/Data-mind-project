package PageObjects;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class DRMPoliciesPage extends BasePage {
    public DRMPoliciesPage(WebDriver driver) {
        super(driver);
    }


    By addpolicybutton= By.xpath("/html/body/app-root/div/app-main-layout/app-policies-list/div/section/app-table-list/div/div[1]/div[3]/div/button[4]/span[2]");
    By POLICY_NAME_INPUT = By.xpath("//*[@formcontrolname='policyNameFL']");
    By POLICY_DATE_INPUT = By.id("ej2-datepicker_0_input");
    By BUTTON = By.className("mdc-button__label");
    By LAST_ACTION_BUTTON = By.cssSelector(".mat-mdc-menu-trigger.table-action-menu-btn");
    By SLIDE_TOGGLE_BUTTON = By.xpath("//*[@role='switch']");




    public void ClickAddPolicyButton(){
        waitElementToBeClickable(addpolicybutton).click();
    }

    public WebElement waitElementToBeClickable(By locator){
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }




    // Method to wait for the policy name input field and enter the policy name
    public void enterPolicyName(String policyName) {
        WebElement policyNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(POLICY_NAME_INPUT));
        policyNameField.sendKeys(policyName);
    }

    // Method to wait for the date picker input and enter the policy date
    public void enterPolicyDate(String date) {
        WebElement dateField = wait.until(ExpectedConditions.elementToBeClickable(POLICY_DATE_INPUT));
        dateField.sendKeys(date, Keys.RETURN);
    }

    // Method to wait for the last action button, click it
    public void clickLastActionButton() {
        List<WebElement> lastActionButton = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(LAST_ACTION_BUTTON));
        WebElement lastButton = lastActionButton.get(lastActionButton.size() - 1); // Click last button
        lastButton.click();
    }

    // Method to wait for the slide toggle button and click it
    public void clickSlideToggleButton() {
        WebElement slideToggleButton = wait.until(ExpectedConditions.elementToBeClickable(SLIDE_TOGGLE_BUTTON));
        slideToggleButton.click();
    }

    // Method to perform all actions
    public void createPolicy(String policyName, String policyDate) {
        ClickAddPolicyButton();
        enterPolicyName(policyName);
        enterPolicyDate(policyDate);
        clickLastActionButton();
        clickSlideToggleButton();
        System.out.println(policyName);
    }


}

