package Base;

import Helper.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;


public class BaseTest {
    Helper helper = new Helper();
    protected ThreadLocal <WebDriver> driver = new ThreadLocal<>() ;

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

        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String testCaseName = result.getMethod().getMethodName();
            System.out.println("Execution Failed!");
            helper.captureScreen(testCaseName, getDriver());
        }
    }


    @AfterMethod (dependsOnMethods = "takeScreenShotOnFailure")
    public void closeWebSite() {
        getDriver().quit();
    }
}
