package Tests;

import Base.BaseTest;
import Pages.SignupPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Feature("Signup Feature")
public class SignupTest extends BaseTest {

    @Story("This is a valid Signup")
    @Description("valid credentials")
    @Owner("Khaled Zohdy")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 0 , description = "User should login with valid signup credentials")
    public void userShouldSignupSuccessfully(){
        SignupPage signupPage = new SignupPage(getDriver());
        signupPage.signup().checkAlert();
    }

    @Story("invalid Signup")
    @Test(priority = 1 , description = "User can't login with invalid signup credentials")
    public void userShouldNotRegisterWithExistingCred(){
        SignupPage signupPage = new SignupPage(getDriver());
        signupPage.signup().checkAlert();
    }
}
