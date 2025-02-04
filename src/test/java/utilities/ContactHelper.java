package utilities;

import org.openqa.selenium.Alert;

import static constants.Elements.*;
import static constants.Elements.logger;
import static utilities.GenericHelper.*;
import static utilities.RandomWordGenerator.generateRandomWord;

public class ContactHelper {
    public static void sendMessage(
            int caseNum, String email,
            String name,String message,
            String errorMsg
    ){
        logger.info("Case "+caseNum);
        try {
            findElementAndWait(10, contactEmail).sendKeys(email);
            findElementAndWait(10, contactName).sendKeys(name);
            findElementAndWait(10, contactMessage).sendKeys(message);
            findElementAndWait(10,sendMessageButton).click();

            Alert alert = waitAlert(10);
            String alertText = alert.getText();
            alert.accept();

            compare(alertText,errorMsg);
            logger.info("Case "+caseNum+": Pass");
        }catch (Exception e){
            logger.info("Case "+caseNum+": Fail - " + e);
        }
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
