package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import static constants.Elements.*;
import static constants.Elements.logger;
import static utilities.GenericHelper.*;

public class SignUpHelper {
    public static void signUp(
                              int caseNum, String user,
                              String pass, String errorMsg
                              ){
        logger.info("Case "+caseNum);
        try {
            findElementAndWait(10, signUsername).sendKeys(user);
            findElementAndWait(10, signPassword).sendKeys(pass);
            findElementAndWait(10,signupButton).click();
            Alert alert = waitAlert(10);
            String alertText = alert.getText();
            alert.accept();
            compare(alertText,errorMsg);
            logger.info("Case "+caseNum+": Pass");
        }catch (Exception e){
            logger.info("Case "+caseNum+": Fail - " + e);
        }
    }
}
