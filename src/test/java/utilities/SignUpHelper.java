package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import static constants.Elements.*;
import static constants.Elements.logger;
import static utilities.GenericHelper.*;

public class SignUpHelper {
    public static void signUp(
                              int caseNum, String user,
                              String pass, String errorMsg, WebDriver tester
                              ){
        logger.info("Case "+caseNum);
            findElementAndWait(10,tester, signUsername).sendKeys(user);
            findElementAndWait(10,tester, signPassword).sendKeys(pass);
            findElementAndWait(10,tester, signupButton).click();
            Alert alert = waitAlert(10, tester);
            String alertText = alert.getText();
            alert.accept();
            compare(alertText,errorMsg);
            logger.info("Case "+caseNum+": Pass");
    }
}
