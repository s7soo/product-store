package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static constants.Elements.*;
import static constants.Elements.logger;
import static utilities.GenericHelper.*;

public class LoginHelper {
    public static void login(
            int caseNum, String user,
            String pass, String errorMsg, WebDriver tester
    ){
        logger.info("Case "+caseNum);
        try {
            findElementAndWait(10, tester, loginUsername).sendKeys(user);
            findElementAndWait(10, tester, loginPassword).sendKeys(pass);
            findElementAndWait(10, tester, loginButton).click();
            Alert alert = waitAlert(10, tester);
            String alertText = alert.getText();
            alert.accept();
            compare(alertText,errorMsg);
            logger.info("Case "+caseNum+": Pass");
        }catch (Exception e){
            logger.info("Case "+caseNum+": Fail - " + e);
        }
    }
    public static void validLogin(
            int caseNum, String user,
            String pass, WebDriver tester
    ){
        logger.info("Case "+caseNum);
        try {
            findElementAndWait(10, tester, loginUsername).sendKeys(user);
            findElementAndWait(10, tester, loginPassword).sendKeys(pass);
            findElementAndWait(10, tester,loginButton).click();

            WebElement name = findElementAndWait(10, tester, visibleName);
            compare(name.getText(), "Welcome "+user);
            logger.info("Case "+caseNum+": Pass");
        }catch (Exception e){
            logger.info("Case "+caseNum+": Fail - " + e);
        }
    }
}
