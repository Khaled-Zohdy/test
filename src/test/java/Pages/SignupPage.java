package Pages;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SignupPage extends BasePage{

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    Faker faker = new Faker();

    By signupButton = By.cssSelector("#signin2");
    By userName = By.cssSelector("#sign-username");
    By password = By.cssSelector("#sign-password");
    By signupSubmit = By.xpath("//button[contains(text(),'Sign up')]");

    String name = faker.name().username();
    String pass = faker.internet().password();

    public void clickSignupButton(){
        clickOnElement(driver.findElement(signupButton));
    }
    public void enterName(){
        setTxtElement(driver.findElement(userName),name);
    }
    public void enterPassword(){
        driver.findElement(password).sendKeys(pass);
    }
    public void clickSignupSubmit(){
        driver.findElement(signupSubmit).click();
    }
    public String alertHandle(){
        waits().until(ExpectedConditions.alertIsPresent());
        String actual = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return actual;
    }

    @Step
    public LoginPage checkAlert(){

        String expected = "Sign up successful.";
        String actual = alertHandle();
        Assert.assertEquals(actual,expected);
        return new LoginPage(driver);
    }
    @Step
    public SignupPage signup(){
        clickSignupButton();
        enterName();
        enterPassword();
        clickSignupSubmit();
        return this;
    }




}
