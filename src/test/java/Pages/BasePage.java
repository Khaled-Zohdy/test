package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage { 
    protected WebDriver driver;


    public BasePage(WebDriver driver){
        this.driver=driver;
    }

    protected WebDriverWait waits(){
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected static void clickOnElement(WebElement element) {
        element.click();
    }

    protected static void setTxtElement(WebElement element, String text) {
        element.sendKeys(text);
    }
}
