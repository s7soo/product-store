package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import reports.ExtentReportListener;

import static constants.Elements.*;
import static constants.Links.homePage;
import static utilities.AboutUsHelper.checkVideo;
import static utilities.GenericHelper.*;

public class AboutUs {
    private static WebDriver tester;

    @BeforeClass
    public static void setup(){
        tester = new ChromeDriver();
        ExtentReportListener.setDriver(tester);
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

        findElementAndWait(10, tester,videoButton).click();
        WebElement videoElement = findElementAndWait(10, tester,video);
        boolean videoWorking = checkVideo(tester, videoElement);
        assertion.assertTrue(videoWorking);

        logger.info("Case 1: Pass");
    }

    @Test (priority = 2)
    public void closeAboutUs(){
        logger.info("Case 2");

        WebElement section = findElementAndWait(10,tester, aboutUsSectionPath);
        tester.findElements(closeButton3).get(3).click();
        waitForElementInVisibility(10,tester,section);
        checkElementNotDisplayed(section);

        logger.info("Case 2: Pass");
    }
    @AfterClass
    public static void tearDown(){
        tester.quit();
    }

}
