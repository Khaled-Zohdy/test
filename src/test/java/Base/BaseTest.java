package Base;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;

public class BaseTest {
    protected ThreadLocal <WebDriver> driver = new ThreadLocal<>();

    public void setDriver(WebDriver driver){
        this.driver.set(driver);
    }
    public WebDriver getDriver(){
        return this.driver.get();
    }

    @BeforeMethod
    public void openWebSite(){
        WebDriver driver;
        String browser = System.getProperty("browser","chrome");
        switch (browser){
            case "chrome":
                driver = new ChromeDriver();
                setDriver(driver);
                break;
            case "firefox":
                 driver = new FirefoxDriver();
                setDriver(driver);
                break;
            default:
                throw new RuntimeException("Browser name invalid");

        }

        getDriver().manage().window().maximize();
        getDriver().get("https://www.demoblaze.com/");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    public void takeScreenShot(String testName) throws IOException {
        File file = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("ScreenShots/"+testName+".png"));
        InputStream inputStream = new FileInputStream(file);
        Allure.addAttachment("ScreensShot",inputStream);
    }

    @AfterMethod
    public void capture(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE){
        String testName = result.getMethod().getMethodName();
        System.out.println("Testcase Fails");
        takeScreenShot(testName);
        }
    }

    @AfterMethod
    public void closeWebSite() throws IOException {
        getDriver().quit();
    }
}
