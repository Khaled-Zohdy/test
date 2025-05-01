package Tests;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProductTest extends BaseTest {
    @Test
    @Step
    public void productAddedToCartSuccessfully() throws InterruptedException {
//        driver.findElement(By.cssSelector("#login")).click();
//        driver.findElement(By.cssSelector("#loginusername")).sendKeys("samass");
//        driver.findElement(By.cssSelector("#loginpassword")).sendKeys("123456asd");
//        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
//        WebDriverWait wait = new WebDriverWait(driver.get(),Duration.ofSeconds(10));
//        Thread.sleep(2000);
//        driver.findElement(By.linkText("Samsung galaxy s6")).click();
//        driver.findElement(By.linkText("Add to cart")).click();
//        wait.until(ExpectedConditions.alertIsPresent());
//        String actual = driver.switchTo().alert().getText();
//        String expected = "Product added.";
//        driver.switchTo().alert().accept();
//        Assert.assertEquals(actual,expected);
    }
}
