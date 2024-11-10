package BaseTest;

import DriverFactory.factory;
import PageObjects.*;
import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

public class baseTest {
    protected WebDriver driver;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected Faker faker;
    protected InfoTypePage infoTypePage;
    protected DocTypePage docTypePage;
    protected DiscoveryPage discoveryPage;

    @BeforeMethod
    public void setup() {
        driver = factory.intializeDriver();
        loginPage = new LoginPage(driver);
        this.faker = new Faker();
        homePage = new HomePage(driver);
        infoTypePage= new InfoTypePage(driver);
        docTypePage= new DocTypePage(driver);
        discoveryPage= new DiscoveryPage(driver);
    }

    @AfterMethod
    public void take_screen_shot(ITestResult result) throws IOException {


//         driver.close();
        if (ITestResult.FAILURE == result.getStatus()) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("C:\\Users\\Eslam.Elshamy\\IdeaProjects\\dataMind\\bugs"));


        }
    }
}

