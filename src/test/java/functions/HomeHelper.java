package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static constants.Elements.contactSectionPath;

public class HomeHelper {
    public static WebElement waitForElement(WebDriver tester, long time, By path){
        WebDriverWait wait = new WebDriverWait(tester, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(path));
    }
}
