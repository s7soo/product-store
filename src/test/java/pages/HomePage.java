package pages;

import org.apache.logging.log4j.core.net.Priority;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
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
    public static void initiateDriver(){
        if (tester == null){
            tester = new ChromeDriver();
        }
    }

    @BeforeMethod
    public void openHomePage(){
        tester.get(homePage);
    }

    // 1. navigation menu
    @Test (priority = 2)
    public void navigateToHomePage(){
        logger.info("Case 1: Pressing Home Button");

        tester.findElement(homeNavPath).click();
        Assert.assertEquals(tester.getCurrentUrl(), homePage);

        logger.info("Case 1 --> Pass");

    }
    @Test (priority = 2)
    public void openContactSection(){
        logger.info("Case 2: Pressing contact button");

        tester.findElement(contactNavPath).click();
        // Wait for the section to become visible
        WebElement section = waitForElementVisibility( 10, contactSectionPath);
        Assert.assertTrue(section.isDisplayed(), "The contact section is not displayed");

        logger.info("Case 2 --> Pass");
    }

    @Test (priority = 2)
    public void openAboutUsSection(){
        logger.info("Case 3: Pressing about us button");

        tester.findElement(aboutUsNavPath).click();
        // Wait for the section to become visible
        WebElement section = waitForElementVisibility( 10, aboutUsSectionPath);
        Assert.assertTrue(section.isDisplayed(), "The about us section is not displayed");

        logger.info("Case 3 --> Pass");
    }

    @Test (priority = 2)
    public void navigateToCartPage(){
        logger.info("Case 4: Pressing cart button");

        tester.findElement(cartNavPath).click();
        Assert.assertEquals(tester.getCurrentUrl(), cartPage);

        logger.info("Case 4 --> Pass");
    }

    @Test (priority = 2)
    public void openLoginSection(){
        logger.info("Case 5: Pressing login button");

        tester.findElement(loginNavPath).click();
        // Wait for the section to become visible
        WebElement section = waitForElementVisibility(10, loginSectionPath);
        Assert.assertTrue(section.isDisplayed(), "The login section is not displayed");

        logger.info("Case 5 --> Pass");
    }
    @Test (priority = 2)
    public void openSignUpSection(){
        logger.info("Case 6: Pressing sign up button");

        tester.findElement(signUpUsNavPath).click();
        // Wait for the section to become visible
        WebElement section = waitForElementVisibility(10, signupSectionPath);
        Assert.assertTrue(section.isDisplayed(), "The sign up section is not displayed");

        logger.info("Case 6 --> Pass");
    }

    ///////////////////////////////////////////////////////////////////////
    //2. Body
    @Test (priority = 3)
    public void pressNextArrow(){
        logger.info("Case 7: Pressing next Arrow..");

        WebElement activeImage = getActiveImage();
        tester.findElement(nextArrow).click();
        waitForElementInVisibility(10, activeImage);
        Assert.assertFalse(activeImage.isDisplayed());

        logger.info("Case 7 --> Pass");
    }
    @Test (priority = 3)
    public void pressPrevArrow(){
        logger.info("Case 8: Pressing previous Arrow..");

        WebElement activeImage = getActiveImage();
        tester.findElement(prevArrow).click();
        waitForElementInVisibility(10, activeImage);
        Assert.assertFalse(activeImage.isDisplayed());

        logger.info("Case 8 --> Pass");
    }

    @Test (priority = 3)
    public void pressSlideLeftButton(){
        logger.info("Case 9: Press slide button 1");

        tester.findElement(slideLeftButton).click();
        waitForElementVisibility(5, slideImage1);
        Assert.assertTrue(tester.findElement(slideImage1).isDisplayed());

        logger.info("Case 9 --> Pass");
    }
    @Test (priority = 3)
    public void pressSlideMiddleButton(){
        logger.info("Case 10: Press slide button 1");

        tester.findElement(slideMiddleButton).click();
        waitForElementVisibility(5, slideImage2);
        Assert.assertTrue(tester.findElement(slideImage2).isDisplayed());

        logger.info("Case 10 --> Pass");
    }
    @Test (priority = 3)
    public void pressSlideRightButton(){
        logger.info("Case 10: Press slide button 1");

        tester.findElement(slideRightButton).click();
        waitForElementVisibility(5, slideImage3);
        Assert.assertTrue(tester.findElement(slideImage3).isDisplayed());

        logger.info("Case 10 --> Pass");
    }

    @AfterTest
    public static void disableDriver(){
        tester.quit();
    }
}
