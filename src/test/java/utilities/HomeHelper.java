package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static constants.Elements.*;
import static constants.Elements.tester;
import static constants.Values.homeFailed;
import static constants.Values.homePassed;
import static utilities.GenericHelper.*;

public class HomeHelper {
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

    public static void navigateToPage(int caseNum,By path1, String pageUrl){
        logger.info("Case "+caseNum);
        try {
            tester.findElement(path1).click();
            compare(tester.getCurrentUrl(), pageUrl);
            logger.info("Case "+caseNum+": Pass");
        }catch (Exception e){
            logger.info("Case "+caseNum+": Fail - " + e);
        }
    }
    public static void openSection(int caseNum,By path1, By path2){
        logger.info("Case "+caseNum);
        try {
            tester.findElement(path1).click();
            WebElement section = findElementAndWait( 10, path2);
            checkElementDisplay(section);
            logger.info("Case "+caseNum+": Pass");
        }catch (Exception e){
            logger.info("Case "+caseNum+": Fail - " + e);
        }
    }

    public static void switchImagesWithArrow(int caseNum, By button, WebElement activeImage){
        logger.info("Case "+caseNum);

        try {
            tester.findElement(button).click();
            waitForElementInVisibility(10, activeImage);
            checkElementNotDisplayed(activeImage);
            logger.info("Case "+caseNum+": Pass");
        }catch (Exception e){
            logger.info("Case "+caseNum+": Fail - " + e);
        }
    }

    public static void switchImagesWithButton(int caseNum, By button, By slideImage){
        logger.info("Case "+caseNum);

        try {
            tester.findElement(button).click();
            WebElement image = findElementAndWait(5, slideImage);
            checkElementDisplay(image);
            logger.info("Case "+caseNum+": Pass");
        }catch (Exception e){
            logger.info("Case "+caseNum+": Fail - " + e);
        }
    }

    public static void selectCategory(int caseNum, By button, By productInPage){
        logger.info("Case "+caseNum);

        try {
            tester.findElement(button).click();
            WebElement product =  findElementAndWait(10,productInPage);
            checkElementDisplay(product);

            logger.info("Case "+caseNum+": Pass");
        }catch (Exception e){
            logger.info("Case "+caseNum+": Fail - " + e);
        }
    }
}
