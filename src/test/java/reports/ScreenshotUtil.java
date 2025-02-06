package reports;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
//    public static String takeScreenshot(WebDriver driver, String testName) {
//        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
//        String screenshotPath = System.getProperty("user.dir") + "/test-output/screenshots/" + testName + "_" + timestamp + ".png";
//
//        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        File destFile = new File(screenshotPath);
//
//        try {
//            FileUtils.copyFile(srcFile, destFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return screenshotPath;
//    }
public static String takeScreenshot(WebDriver driver, String testName) {
    String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    String screenshotDir = "test-output/screenshots/";
    String screenshotPath = screenshotDir + testName + "_" + timestamp + ".png";

    File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    File destFile = new File(screenshotPath);

    try {
        FileUtils.copyFile(srcFile, destFile);
    } catch (IOException e) {
        e.printStackTrace();
    }

    return screenshotPath; // Return relative path
}
}

