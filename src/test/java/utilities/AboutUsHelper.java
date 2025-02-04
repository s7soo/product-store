package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AboutUsHelper {
    public static boolean checkVideo(WebDriver driver, WebElement videoElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Get current play time
        Number startTime =
                (Number) js.executeScript("return arguments[0].currentTime;", videoElement);

        double start = startTime.doubleValue();
        // Wait for a few seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Get play time after waiting
        Number endTime =
                (Number) js.executeScript("return arguments[0].currentTime;", videoElement);
        double end = endTime.doubleValue();
        // Validate if video is playing
        return end > start;
    }
}
