package functions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static constants.Elements.*;

public class HomeHelper {

    public static WebElement waitForElementVisibility(long time, By path){
        WebDriverWait wait = new WebDriverWait(tester, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(path));
    }
    public static void waitForElementInVisibility(long time, WebElement element){
        WebDriverWait wait = new WebDriverWait(tester, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
    public static WebElement getActiveImage(){
        By activeImage;
        if (tester.findElement(slideImage3).isDisplayed()){
            activeImage = slideImage3;
        }else if (tester.findElement(slideImage2).isDisplayed()){
            activeImage = slideImage2;
        }else {
            activeImage = slideImage1;
        }
        return tester.findElement(activeImage);
    }
}
