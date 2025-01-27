package pages;

import org.apache.logging.log4j.core.net.Priority;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.logging.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static constants.Elements.*;
import static constants.Links.*;
import static functions.HomeHelper.*;


public class HomePage {
    static final Logger logger = Logger.getLogger(String.valueOf(HomePage.class));



    @BeforeTest
    public static void setup(){
        if (tester == null){
            tester = new ChromeDriver();
        }
        if (actions == null){
            actions = new Actions(tester);
        }
        homeFailed = 0;
        homePassed = 0;
    }

    @BeforeMethod
    public void openHomePage(){
        tester.get(homePage);
        tester.manage().window().maximize();
    }

    // 1. navigation menu
    @Test (priority = 2)
    public void navigateToHomePage(){
        logger.info("Case 1: Pressing Home Button");

        try {
            tester.findElement(homeNavPath).click();
            Assert.assertEquals(tester.getCurrentUrl(), homePage);
            homePassed+=1;
            logger.info("Case 1: Pass");
        }catch (Exception e){
            logger.info("Case 1: Fail");
            homeFailed+=1;
        }

    }
    @Test (priority = 2)
    public void openContactSection(){
        logger.info("Case 2: Pressing contact button");


        try {
            tester.findElement(contactNavPath).click();
            WebElement section = waitForElementVisibility( 10, contactSectionPath);
            Assert.assertTrue(section.isDisplayed());
            homePassed+=1;
            logger.info("Case 2: Pass");
        }catch (Exception e){
            logger.info("Case 2: Fail");
            homeFailed+=1;
        }
    }

    @Test (priority = 2)
    public void openAboutUsSection(){
        logger.info("Case 3: Pressing about us button");


        try {
            tester.findElement(aboutUsNavPath).click();
            WebElement section = waitForElementVisibility( 10, aboutUsSectionPath);
            Assert.assertTrue(section.isDisplayed());
            logger.info("Case 3 --> Pass");
            homePassed+=1;
        } catch (Exception e) {
            homeFailed+=1;
            logger.info("Case 3: Fail - The about us section is not displayed");
        }


    }

    @Test (priority = 2)
    public void navigateToCartPage(){
        logger.info("Case 4: Pressing cart button");


    try {
        tester.findElement(cartNavPath).click();
        Assert.assertEquals(tester.getCurrentUrl(), cartPage);
        logger.info("Case 4:Pass");
        homePassed+=1;
    } catch (Exception e) {
        homeFailed+=1;
        logger.info("Case 4: Fail");
    }

    }

    @Test (priority = 2)
    public void openLoginSection(){
        logger.info("Case 5: Pressing login button");


        try {
            tester.findElement(loginNavPath).click();
            WebElement section = waitForElementVisibility(10, loginSectionPath);
            Assert.assertTrue(section.isDisplayed());
            logger.info("Case 5: Pass");
            homePassed+=1;
        } catch (Exception e) {
            homeFailed+=1;
            logger.info("Case 5: Fail");
        }

    }
    @Test (priority = 2)
    public void openSignUpSection(){
        logger.info("Case 6: Pressing sign up button");


        try {
            tester.findElement(signUpUsNavPath).click();
            WebElement section = waitForElementVisibility(10, signupSectionPath);
            Assert.assertTrue(section.isDisplayed());
            logger.info("Case 6: Pass");
            homePassed+=1;
        } catch (Exception e) {
            homeFailed+=1;
            logger.info("Case 6: Fail");
        }
    }

    ///////////////////////////////////////////////////////////////////////
    //2. Body
    @Test (priority = 3)
    public void pressNextArrow(){
        logger.info("Case 7: Pressing next Arrow..");


        try {
            WebElement activeImage = getActiveImage();
            tester.findElement(nextArrow).click();
            waitForElementInVisibility(10, activeImage);
            Assert.assertFalse(activeImage.isDisplayed());
            logger.info("Case 7: Pass");
            homePassed+=1;
        } catch (Exception e) {
            homeFailed+=1;
            logger.info("Case 7: Fail");
        }
    }
    @Test (priority = 3)
    public void pressPrevArrow(){
        logger.info("Case 8: Pressing previous Arrow..");


        try {
            WebElement activeImage = getActiveImage();
            tester.findElement(prevArrow).click();
            waitForElementInVisibility(10, activeImage);
            Assert.assertFalse(activeImage.isDisplayed());
            logger.info("Case 8: Pass");
            homePassed+=1;
        } catch (Exception e) {
            homeFailed+=1;
            logger.info("Case 8: Fail");
        }
    }

    @Test (priority = 3)
    public void pressSlideLeftButton(){
        logger.info("Case 9: Press left slide button");

        try {
            tester.findElement(slideLeftButton).click();
            waitForElementVisibility(5, slideImage1);
            Assert.assertTrue(tester.findElement(slideImage1).isDisplayed());
            logger.info("Case 9: Pass");
            homePassed+=1;
        } catch (Exception e) {
            homeFailed+=1;
            logger.info("Case 9: Fail");
        }
    }
    @Test (priority = 3)
    public void pressSlideMiddleButton(){
        logger.info("Case 10: Press middle slide button");

        try {
            tester.findElement(slideMiddleButton).click();
            waitForElementVisibility(5, slideImage2);
            Assert.assertTrue(tester.findElement(slideImage2).isDisplayed());
            logger.info("Case 10: Pass");
            homePassed+=1;
        } catch (Exception e) {
            homeFailed+=1;
            logger.info("Case 10: Fail");
        }
    }
    @Test (priority = 3)
    public void pressSlideRightButton(){
        logger.info("Case 11: Press right slide button");

        try {
            tester.findElement(slideRightButton).click();
            waitForElementVisibility(5, slideImage3);
            Assert.assertTrue(tester.findElement(slideImage3).isDisplayed());
            logger.info("Case 11: Pass");
            homePassed+=1;
        } catch (Exception e) {
            homeFailed+=1;
            logger.info("Case 11: Fail");
        }
    }
    @Test (priority = 2)
    public void pressPhoneCategory(){
        logger.info("Case 12: Press phones category button");


        try {
            tester.findElement(phonesCategoryButton).click();
            waitForElementVisibility(10,expectedItems[0][0]);
            WebElement phone = tester.findElement(expectedItems[0][0]);
            Assert.assertTrue(phone.isDisplayed());
            logger.info("Case 12 --> Pass");
            homePassed+=1;
        } catch (Exception e) {
            homeFailed+=1;
            logger.info("Case 12: Fail");
        }

    }
    @Test (priority = 2)
    public void pressLaptopsCategory(){
        logger.info("Case 13: Press laptop category button");

        try {
            tester.findElement(laptopsCategoryButton).click();
            waitForElementVisibility(10,expectedItems[1][0]);
            WebElement laptop = tester.findElement(expectedItems[1][0]);
            Assert.assertTrue(laptop.isDisplayed());
            logger.info("Case 13 --> Pass");
            homePassed+=1;
        } catch (Exception e) {
            homeFailed+=1;
            logger.info("Case 13: Fail");
        }

    }
    @Test (priority = 2)
    public void pressMonitorCategory(){
        logger.info("Case 14: Press monitor category button");

        try {
            tester.findElement(monitorsCategoryButton).click();
            waitForElementVisibility(10,expectedItems[2][0]);
            WebElement monitor = tester.findElement(expectedItems[2][0]);
            Assert.assertTrue(monitor.isDisplayed());
            logger.info("Case 14: Pass");
            homePassed+=1;
        } catch (Exception e) {
            homeFailed+=1;
            logger.info("Case 14: Fail");
        }

    }
    @Test (priority = 2)
    public void pressNextPageInCategorySection() throws InterruptedException {
        logger.info("Case 15: Press next page button");

        try {
            WebElement next = tester.findElement(nextPage);
            scrollToElement(next);
            Thread.sleep(1000);
            next.click();
            waitForElementVisibility(10, expectedItems[2][0]);
            WebElement monitor = tester.findElement(expectedItems[2][0]);
            Assert.assertTrue(monitor.isDisplayed());
            logger.info("Case 15: Pass");
            homePassed+=1;
        } catch (Exception e) {
            homeFailed+=1;
            logger.info("Case 15: Fail");
        }
    }
    @Test (priority = 2)
    public void pressPrevPageInCategorySection(){
//        logger.info("Case 16: Press previous page button");
//        try {
//            logger.info("Case 16 --> Pass");
//            homePassed+=1;
//        } catch (Exception e) {
//            homeFailed+=1;
//            logger.info("Case 16: Fail - Next Page button does not work");
//        }
    }

    @AfterTest
    public static void disableDriver(){
        logger.info("Final Result\nPass: "+homePassed+"\n"+"Fail: "+homeFailed);
        tester.quit();
    }
}
