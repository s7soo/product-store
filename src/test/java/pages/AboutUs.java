package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static constants.Elements.*;
import static constants.Links.homePage;
import static utilities.AboutUsHelper.checkVideo;
import static utilities.GenericHelper.*;

public class AboutUs {

    @BeforeTest
    public static void setup(){
        if (tester == null)
            tester = new ChromeDriver();
    }

    @BeforeMethod
    public void openHomePage(){
        tester.navigate().to(homePage);
        tester.manage().window().maximize();
        tester.findElement(aboutUsNavPath).click();
    }
    @Test (priority = 2)
    public void playAboutUsVideo(){
        logger.info("Case 1");

        findElementAndWait(10, videoButton).click();
        WebElement videoElement = findElementAndWait(10, video);
        boolean videoWorking = checkVideo(tester, videoElement);
        assertion.assertTrue(videoWorking);

        logger.info("Case 1: Pass");
    }

    @Test (priority = 2)
    public void closeAboutUs(){
        logger.info("Case 2");

        WebElement section = findElementAndWait(10, aboutUsSectionPath);
        tester.findElements(closeButton3).get(3).click();
        waitForElementInVisibility(10, section);
        checkElementNotDisplayed(section);

        logger.info("Case 2: Pass");
    }
    @AfterTest
    public static void disableDriver(){
        tester.quit();
    }

}
