package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static constants.Elements.*;
import static constants.Links.homePage;

import static utilities.GenericHelper.*;
import static utilities.LoginHelper.*;
import static utilities.RandomWordGenerator.generateRandomWord;

public class Login {
    private static Alert alert;
    @BeforeTest
    public static void setup(){
        if (tester == null)
            tester = new ChromeDriver();
    }

    @BeforeMethod
    public void openHomePage(){
        tester.navigate().to(homePage);
        tester.manage().window().maximize();
        tester.findElement(loginNavPath).click();
    }

    @Test (priority = 1)
    public void loginWithEmptyUsernameAndPassword(){
        String username = "";
        String password = "";
        login(
                1,
                username,
                password,
                "Please fill out Username and Password."
        );
    }
    @Test (priority = 1)
    public void loginWithEmptyUsername(){
        String username = "";
        String password = "P@ssw0rd";
        login(
                2,
                username,
                password,
                "Please fill out Username."
        );
    }
    @Test (priority = 1)
    public void loginWithEmptyPassword(){
        String username = "Mohamed1234";
        String password = "";
        login(
                3,
                username,
                password,
                "Please fill out Password."
        );
    }
    @Test (priority = 1)
    public void loginWithInCorrectPassword(){
        String username = "Mohamed1234";
        String password = "p@ssw0rd";
        login(
                4,
                username,
                password,
                "Wrong password."
        );
    }
    @Test (priority = 1)
    public void loginWithNotExistingUsername(){
        String username = generateRandomWord(10);
        String password = "p@ssw0rd";
        login(
                5,
                username,
                password,
                "Wrong password."
        );
    }
    @Test (priority = 1)
    public void loginWithValidData(){
        String username = "Mohamed1234";
        String password = "P@ssw0rd";
        validLogin(
                6,
                username,
                password
        );
    }
    @Test (priority = 2)
    public void closeSignUp(){
        WebElement section = findElementAndWait(10, loginSectionPath);
        tester.findElements(loginCloseButton).get(2).click();
        waitForElementInVisibility(10, section);
        checkElementNotDisplayed(section);
    }

    @AfterTest
    public static void disableDriver(){
        tester.quit();
    }
}
