package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

import static constants.Elements.*;
import static constants.Elements.logger;
import static utilities.GenericHelper.*;

public class LoginHelper {
    public static void login(
            int caseNum, String user,
            String pass, String errorMsg
    ){
        logger.info("Case "+caseNum);
        try {
            findElementAndWait(10, loginUsername).sendKeys(user);
            findElementAndWait(10, loginPassword).sendKeys(pass);
            findElementAndWait(10,loginButton).click();
            Alert alert = waitAlert(10);
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
            String pass
    ){
        logger.info("Case "+caseNum);
        try {
            findElementAndWait(10, loginUsername).sendKeys(user);
            findElementAndWait(10, loginPassword).sendKeys(pass);
            findElementAndWait(10,loginButton).click();

            WebElement name = findElementAndWait(10, visibleName);
            compare(name.getText(), "Welcome "+user);
            logger.info("Case "+caseNum+": Pass");
        }catch (Exception e){
            logger.info("Case "+caseNum+": Fail - " + e);
        }
    }
}
