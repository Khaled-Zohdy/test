package Helper;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Helper {

    public void captureScreen(String testCaseName , WebDriver driver) {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("ScreenShoots/"+testCaseName+".png"));
        } catch (IOException e) {
            throw new RuntimeException("Can't find path" + e);
        }
    }
}
