package PageObjects;


import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver) {
        super(driver);
    }


    By adminemail= By.id("mat-input-0");
    By LoginButton1= By.xpath("/html/body/app-root/div/app-auth-layout/app-signin/div/div/div[2]/div/div[2]/app-login-id/form/div[2]/button");
    By adminpassword= By.id("mat-input-1");
    By LoginButton2= By.xpath("/html/body/app-root/div/app-auth-layout/app-signin/div/div/div[2]/div/div[2]/app-full-login/form/div[2]/button");
    By Logo= By.xpath("/html/body/app-root/div/app-main-layout/app-header/div/nav/div/div[1]/a[3]/span");
    public void AdminLogin(String email, String pass){
        driver.findElement(adminemail).sendKeys(email);
        driver.findElement(LoginButton1).click();
        driver.findElement(adminpassword).sendKeys(pass);
        driver.findElement(LoginButton2).click();
    }

    public boolean LogoIsDisplayed(){
       return driver.findElement(Logo).isDisplayed();
    }
}
