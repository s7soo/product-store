package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import static constants.Elements.*;
import static constants.Elements.logger;
import static utilities.GenericHelper.*;
import static utilities.RandomWordGenerator.generateRandomWord;

public class ContactHelper {
    public static void sendMessage(
            int caseNum, String email,
            String name,String message,
            String errorMsg, WebDriver tester
    ){
        logger.info("Case "+caseNum);
            findElementAndWait(10, tester,contactEmail).sendKeys(email);
            findElementAndWait(10, tester,contactName).sendKeys(name);
            findElementAndWait(10, tester,contactMessage).sendKeys(message);
            findElementAndWait(10, tester,sendMessageButton).click();

            Alert alert = waitAlert(10, tester);
            String alertText = alert.getText();
            alert.accept();

            compare(alertText,errorMsg);
    }

    public static String generateValidEmail(){
        return generateRandomWord(8) + "@"+ generateRandomWord(5)+".com";
    }
    public static String generateValidName(){
        return generateRandomWord(5) + " " + generateRandomWord(5);
    }
    public static String generateValidMessage(){
        return generateRandomWord(25);
    }
}
