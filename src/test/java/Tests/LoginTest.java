package Tests;

import Base.BaseTest;
import Pages.SignupPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Login Feature")
public class LoginTest extends BaseTest {

    @Story("Valid Login")
    @Owner("Khaled Zohdy")
    @Severity(SeverityLevel.BLOCKER)
    @Test (description = "User can login successfully")
    public void userLoggedInSuccessfully() throws InterruptedException {
        SignupPage signupPage = new SignupPage(getDriver());
        String actual =
                signupPage.
                signup().
                checkAlert().
                clickLoginButton().
                enterName("sjdkhsjh").
                enterPassword("kskhkdhaks").
                clickLoginSubmit().
                greetingMessage();
        Assert.assertTrue(actual.contains("Welcome"));
    }
}
