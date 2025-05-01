package Pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    By loginButton = By.cssSelector("#login2");
    By userName = By.cssSelector("#loginusername");
    By password = By.cssSelector("#loginpassword");
    By loginSubmit = By.xpath("//button[contains(text(),'Log in')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Login click")
    public LoginPage clickLoginButton(){
        clickOnElement(driver.findElement(loginButton));
        return this;
    }
    @Step ("Enter user Name")
    public LoginPage enterName(String name){
        setTxtElement(driver.findElement(userName),name);
        return this;
    }
    @Step
    public LoginPage enterPassword(String pass) throws InterruptedException {
        driver.findElement(password).sendKeys(pass);
        Thread.sleep(2000);
        return this;
    }

    public LoginPage clickLoginSubmit(){
        driver.findElement(loginSubmit).click();
        return this;
    }
    @Step
    public String greetingMessage(){
        return waits().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#nameofuser"))).getText();
    }


}
