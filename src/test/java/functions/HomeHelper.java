package functions;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static constants.Elements.*;

public class HomeHelper {

    public static WebElement findElementAndWait(long time, By path){
        WebDriverWait wait = new WebDriverWait(tester, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(path));
    }
    public static Boolean waitForElementVisibility(long time, WebElement element){
        WebDriverWait wait = new WebDriverWait(tester, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.invisibilityOf(element));
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

    public static void scrollToElement(WebElement element){
        actions = new Actions(tester);
        actions.moveToElement(element);
        actions.perform();

    }
    public static void checkElementDisplay(WebElement element){
        assertion.assertTrue(element.isDisplayed());
    }
    public static void checkElementNotDisplayed(WebElement element){
        assertion.assertFalse(element.isDisplayed());
    }
    public static void checkElementEnabled(WebElement element){
        assertion.assertTrue(element.isEnabled());
    }
    public static void compare(String actual,String expected){
        assertion.assertEquals(actual,expected);
    }
    public static void compare(int actual,int expected){
        assertion.assertEquals(actual,expected);
    }
    public static By findElementWithText(String text){
       return  new By.ByXPath("//h4/a[contains(text(), '"+text+"')]");
    }
}
