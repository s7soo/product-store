package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static constants.Elements.*;
import static constants.Elements.tester;
import static constants.Links.homePage;
import static utilities.ContactHelper.*;
import static utilities.GenericHelper.*;
import static utilities.RandomWordGenerator.generateRandomWord;

public class Contact {
    @BeforeTest
    public static void setup(){
        if (tester == null)
            tester = new ChromeDriver();
    }

    @BeforeMethod
    public void openHomePage(){
        tester.navigate().to(homePage);
        tester.manage().window().maximize();
        tester.findElement(contactNavPath).click();
    }
    @Test(priority = 1)
    public void sendEmptyMessage(){
        String email = "";
        String name = "";
        String message = "";
        String alertText = "Please fill out email, name, and message";
        sendMessage(
                1,
                email,
                name,
                message,
                alertText
        );
    }

    @Test(priority = 1)
    public void sendMessageWithoutEmail(){
        String email = "";
        String name = generateValidName();
        String message = generateValidMessage();
        String alertText = "Please fill out your email";
        sendMessage(
                2,
                email,
                name,
                message,
                alertText
        );
    }
    @Test(priority = 1)
    public void sendMessageWithoutName(){
        String email = generateValidEmail();
        String name = "";
        String message = generateValidMessage();
        String alertText = "Please fill out your name";
        sendMessage(
                3,
                email,
                name,
                message,
                alertText
        );
    }
    @Test(priority = 1)
    public void sendMessageWithoutMessage(){
        String email = generateValidEmail();
        String name = generateValidName();
        String message = "";
        String alertText = "Please fill out your message";
        sendMessage(
                4,
                email,
                name,
                message,
                alertText
        );
    }
    @Test(priority = 1)
    public void sendMessageWithInvalidEmail(){
        String email = generateRandomWord(10);
        String name = generateValidName();
        String message = generateValidMessage();
        String alertText = "Please use a valid email";
        sendMessage(
                5,
                email,
                name,
                message,
                alertText
        );
    }
    @Test(priority = 1)
    public void sendValidMessage(){
        String email = generateValidEmail();
        String name = generateValidName();
        String message = generateValidMessage();
        String alertText = "Thanks for the message!!";
        sendMessage(
                6,
                email,
                name,
                message,
                alertText
        );
    }
    @Test (priority = 2)
    public void closeContact(){
        WebElement section = findElementAndWait(10, contactSectionPath);
        tester.findElements(closeButton0).getFirst().click();
        waitForElementInVisibility(10, section);
        checkElementNotDisplayed(section);
    }
    @AfterTest
    public static void disableDriver(){
        tester.quit();
    }
}
