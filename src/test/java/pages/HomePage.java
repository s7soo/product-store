package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import static constants.Elements.*;
import static constants.Values.*;
import static constants.Links.*;
import static functions.GenericHelper.*;


public class HomePage {


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
            compare(tester.getCurrentUrl(), homePage);
            homePassed+=1;
            logger.info("Case 1: Pass");
        }catch (Exception e){
            logger.info("Case 1: Fail - Cause: " + e);
            homeFailed+=1;
        }

    }
    @Test (priority = 2)
    public void openContactSection(){
        logger.info("Case 2: Pressing contact button");


        try {
            tester.findElement(contactNavPath).click();
            WebElement section = findElementAndWait( 10, contactSectionPath);
            checkElementDisplay(section);
            homePassed+=1;
            logger.info("Case 2: Pass");
        }catch (Exception e){
            logger.info("Case 2: Fail - Cause: " + e);
            homeFailed+=1;
        }
    }

    @Test (priority = 2)
    public void openAboutUsSection(){
        logger.info("Case 3: Pressing about us button");


        try {
            tester.findElement(aboutUsNavPath).click();
            WebElement section = findElementAndWait( 10, aboutUsSectionPath);
            checkElementDisplay(section);
            logger.info("Case 3 --> Pass");
            homePassed+=1;
        } catch (Exception e) {
            homeFailed+=1;
            logger.info("Case 3: Fail - Cause: " + e);
        }


    }

    @Test (priority = 2)
    public void navigateToCartPage(){
        logger.info("Case 4: Pressing cart button");


    try {
        tester.findElement(cartNavPath).click();
        compare(tester.getCurrentUrl(), cartPage);
        logger.info("Case 4:Pass");
        homePassed+=1;
    } catch (Exception e) {
        homeFailed+=1;
        logger.info("Case 4: Fail - Cause: " + e);
    }

    }

    @Test (priority = 2)
    public void openLoginSection(){
        logger.info("Case 5: Pressing login button");


        try {
            tester.findElement(loginNavPath).click();
            WebElement section = findElementAndWait(10, loginSectionPath);
            checkElementDisplay(section);
            logger.info("Case 5: Pass");
            homePassed+=1;
        } catch (Exception e) {
            homeFailed+=1;
            logger.info("Case 5: Fail - Cause: " + e);
        }

    }
    @Test (priority = 2)
    public void openSignUpSection(){
        logger.info("Case 6: Pressing sign up button");

        try {
            tester.findElement(signUpUsNavPath).click();
            WebElement section = findElementAndWait(10, signupSectionPath);
            checkElementDisplay(section);
            logger.info("Case 6: Pass");
            homePassed+=1;
        } catch (Exception e) {
            homeFailed+=1;
            logger.info("Case 6: Fail - Cause: " + e);
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
            checkElementNotDisplayed(activeImage);
            logger.info("Case 7: Pass");
            homePassed+=1;
        } catch (Exception e) {
            homeFailed+=1;
            logger.info("Case 7: Fail - Cause: " + e);
        }
    }
    @Test (priority = 3)
    public void pressPrevArrow(){
        logger.info("Case 8: Pressing previous Arrow..");


        try {
            WebElement activeImage = getActiveImage();
            tester.findElement(prevArrow).click();
            waitForElementInVisibility(10, activeImage);
            checkElementNotDisplayed(activeImage);
            logger.info("Case 8: Pass");
            homePassed+=1;
        } catch (Exception e) {
            homeFailed+=1;
            logger.info("Case 8: Fail - Cause: " + e);
        }
    }

    @Test (priority = 3)
    public void pressSlideLeftButton(){
        logger.info("Case 9: Press left slide button");

        try {
            tester.findElement(slideLeftButton).click();
            WebElement image = findElementAndWait(5, slideImage1);
            checkElementDisplay(image);

            logger.info("Case 9: Pass");
            homePassed+=1;
        } catch (Exception e) {
            homeFailed+=1;
            logger.info("Case 9: Fail - Cause: " + e);
        }
    }
    @Test (priority = 3)
    public void pressSlideMiddleButton(){
        logger.info("Case 10: Press middle slide button");

        try {
            tester.findElement(slideMiddleButton).click();
            WebElement image = findElementAndWait(5, slideImage2);
            checkElementDisplay(image);

            logger.info("Case 10: Pass");
            homePassed+=1;
        } catch (Exception e) {
            homeFailed+=1;
            logger.info("Case 10: Fail - Cause: " + e);
        }
    }
    @Test (priority = 3)
    public void pressSlideRightButton(){
        logger.info("Case 11: Press right slide button");

        try {
            tester.findElement(slideRightButton).click();
            WebElement image = findElementAndWait(5, slideImage3);
            checkElementDisplay(image);
            logger.info("Case 11: Pass");
            homePassed+=1;
        } catch (Exception e) {
            homeFailed+=1;
            logger.info("Case 11: Fail - Cause: " + e);
        }
    }
    @Test (priority = 2)
    public void pressPhoneCategory(){
        logger.info("Case 12: Press phones category button");


        try {
            tester.findElement(phonesCategoryButton).click();
            WebElement phone =  findElementAndWait(10,expectedItems[0][0]);
            checkElementDisplay(phone);

            logger.info("Case 12 --> Pass");
            homePassed+=1;
        } catch (Exception e) {
            homeFailed+=1;
            logger.info("Case 12: Fail - Cause: " + e);
        }

    }
    @Test (priority = 2)
    public void pressLaptopsCategory(){
        logger.info("Case 13: Press laptop category button");

        try {
            tester.findElement(laptopsCategoryButton).click();
            WebElement laptop = findElementAndWait(10,expectedItems[1][0]);
            checkElementDisplay(laptop);

            logger.info("Case 13 --> Pass");
            homePassed+=1;
        } catch (Exception e) {
            homeFailed+=1;
            logger.info("Case 13: Fail - Cause: " + e);
        }

    }
    @Test (priority = 2)
    public void pressMonitorCategory(){
        logger.info("Case 14: Press monitor category button");

        try {
            tester.findElement(monitorsCategoryButton).click();
            WebElement monitor = findElementAndWait(10,expectedItems[2][0]);
            checkElementDisplay(monitor);

            logger.info("Case 14: Pass");
            homePassed+=1;
        } catch (Exception e) {
            homeFailed+=1;
            logger.info("Case 14: Fail - Cause: " + e);
        }

    }
    @Test (priority = 2)
    public void pressNextPageInCategorySection() throws InterruptedException {
        logger.info("Case 15: Press next page button");

        try {
            tester.findElement(categoryButton).click();
            WebElement next = tester.findElement(nextPage);
            scrollToElement(next);
            next.click();
            WebElement monitor = findElementAndWait(10, expectedItems[2][0]);
            checkElementDisplay(monitor);

            logger.info("Case 15: Pass");
            homePassed+=1;
        } catch (Exception e) {
            homeFailed+=1;
            logger.info("Case 15: Fail - Cause: " + e);
        }
    }
    @Test (priority = 2)
    public void pressPrevPageInCategorySection() {
        logger.info("Case 16: Press previous page button");
        try {
            tester.findElement(categoryButton).click();
            WebElement prev = tester.findElement(prevPage);
            scrollToElement(prev);
            prev.click();
            WebElement laptop = findElementAndWait(10, expectedItems[1][0]);
            checkElementDisplay(laptop);

            logger.info("Case 16 --> Pass");
            homePassed += 1;
        } catch (Exception e) {
            homeFailed += 1;
            logger.info("Case 16: Fail - Next Page button does not work");
        }
    }


    @AfterTest
    public static void disableDriver(){
        logger.info("Final Result\nPass: "+homePassed+"\n"+"Fail: "+homeFailed);
        tester.quit();
    }
}
