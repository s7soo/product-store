package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static constants.Elements.*;
import static constants.Values.*;
import static functions.GenericHelper.*;
import static constants.Links.homePage;

public class Signup {
    private static Alert alert;
    @BeforeTest
    public static void setup(){
        if (tester == null)
            tester = new ChromeDriver();
        signupPassed = 0;
        signupFailed = 0;
    }

    @BeforeMethod
    public void openHomePage(){
        tester.navigate().to(homePage);
        tester.manage().window().maximize();
        tester.findElement(signUpUsNavPath).click();

    }

    @Test (priority = 1)
    public void leaveUsernameAndPasswordEmpty(){
        logger.info("Case 1");
        try {
            findElementAndWait(10,username).sendKeys("");
            findElementAndWait(10,password).sendKeys("");
            findElementAndWait(10,signupButton).click();

            alert = waitAlert(10);
            String alertText = alert.getText();
            alert.accept();

            compare(alertText,"Please fill out Username and Password.");

            logger.info("Case 1: Pass");
            signupPassed+=1;
        }catch (Exception e){
            logger.info("Case 1: Fail - " + e);
            signupFailed+=1;
        }
    }

    @Test (priority = 1)
    public void leaveUsernameEmpty(){
        logger.info("Case 2");
        try {
            findElementAndWait(10,username).sendKeys("");
            findElementAndWait(10,password).sendKeys("P@ssw0rd");
            findElementAndWait(10,signupButton).click();

            alert = waitAlert(10);
            String alertText = alert.getText();
            alert.accept();

            compare(alertText,"Please fill out Username.");

            logger.info("Case 2: Pass");
            signupPassed+=1;
        }catch (Exception e){
            logger.info("Case 2: Fail - " + e);
            signupFailed+=1;
        }
    }

    @Test (priority = 1)
    public void leavePasswordEmpty(){
        logger.info("Case 3");
        try {
            findElementAndWait(10,username).sendKeys("Mohamed123");
            findElementAndWait(10,password).sendKeys("");
            findElementAndWait(10,signupButton).click();

            alert = waitAlert(10);
            String alertText = alert.getText();
            alert.accept();

            compare(alertText,"Please fill out Password.");

            logger.info("Case 3: Pass");
            signupPassed+=1;
        }catch (Exception e){
            logger.info("Case 3: Fail - " + e);
            signupFailed+=1;
        }
    }



//    @AfterMethod
//    public void closeSection(){
//
//    }
    @AfterTest
    public static void disableDriver(){
        logger.info("Final Result\nPass: "+signupPassed+"\n"+"Fail: "+signupFailed);
        tester.quit();
    }
}
