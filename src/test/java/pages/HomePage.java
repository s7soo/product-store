package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import static constants.Elements.*;
import static constants.Values.*;
import static constants.Links.*;
import static utilities.GenericHelper.*;
import static utilities.HomeHelper.*;
import static utilities.HomeHelper.navigateToPage;


public class HomePage {


    @BeforeTest
    public static void setup(){
        if (tester == null){
            tester = new ChromeDriver();
        }
        if (actions == null){
            actions = new Actions(tester);
        }
    }

    @BeforeMethod
    public void openHomePage(){
        tester.get(homePage);
        tester.manage().window().maximize();
    }

    // 1. navigation menu
    @Test (priority = 2)
    public void navigateToHomePage(){
        navigateToPage(
                1,
                homeNavPath,
                homePage);
    }
    @Test (priority = 2)
    public void openContactSection(){
        openSection(
                2,
                contactNavPath,
                contactSectionPath);
    }

    @Test (priority = 2)
    public void openAboutUsSection(){
        openSection(
                3,
                aboutUsNavPath,
                aboutUsSectionPath);
    }

    @Test (priority = 2)
    public void navigateToCartPage(){
        navigateToPage(
                4,
                cartNavPath,
                cartPage);
    }

    @Test (priority = 2)
    public void openLoginSection(){
        openSection(
                5,
                loginNavPath,
                loginSectionPath);

    }
    @Test (priority = 2)
    public void openSignUpSection(){
        openSection(
                6,
                signUpNavPath,
                signupSectionPath);
    }

    ///////////////////////////////////////////////////////////////////////
    //2. Page Body
    @Test (priority = 3)
    public void pressNextArrow(){
        switchImagesWithArrow(
                7,
                nextArrow,
                getActiveImage()
        );
    }
    @Test (priority = 3)
    public void pressPrevArrow(){
        switchImagesWithArrow(
                8,
                prevArrow,
                getActiveImage()
        );
    }

    @Test (priority = 3)
    public void pressSlideLeftButton(){
        switchImagesWithButton(
                9,
                slideLeftButton,
                slideImage1
        );
    }
    @Test (priority = 3)
    public void pressSlideMiddleButton(){
        switchImagesWithButton(
                10,
                slideMiddleButton,
                slideImage2
        );
    }
    @Test (priority = 3)
    public void pressSlideRightButton(){
        switchImagesWithButton(
                11,
                slideRightButton,
                slideImage3
        );
    }
    @Test (priority = 2)
    public void pressPhoneCategory(){
        selectCategory(
                12,
                phonesCategoryButton,
                expectedItems[0][0]
        );
    }
    @Test (priority = 2)
    public void pressLaptopsCategory(){
        selectCategory(
                13,
                laptopsCategoryButton,
                expectedItems[1][0]
        );

    }
    @Test (priority = 2)
    public void pressMonitorCategory(){
        selectCategory(
                14,
                monitorsCategoryButton,
                expectedItems[2][0]
        );

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
        } catch (Exception e) {
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
        } catch (Exception e) {
            logger.info("Case 16: Fail - Next Page button does not work");
        }
    }


    @AfterTest
    public static void disableDriver(){
        tester.quit();
    }
}
