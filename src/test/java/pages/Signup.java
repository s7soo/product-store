package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static constants.Elements.*;
import static constants.Values.*;
import static constants.Links.homePage;
import static utilities.GenericHelper.*;
import static utilities.RandomWordGenerator.*;
import static utilities.SignUpHelper.*;

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
        tester.findElement(signUpNavPath).click();

    }

    @Test (priority = 1)
    public void leaveUsernameAndPasswordEmpty(){
        String username = "";
        String password = "";
        signUp(
                1,
                username,
                password,
                "Please use a password more than 8 characters."
        );
    }

    @Test (priority = 1)
    public void leaveUsernameEmpty(){
        String username = "";
        String password = "P@ssw0rd";
        signUp(
                2,
                username,
                password,
                "Please use a password more than 8 characters."
        );
    }

    @Test (priority = 1)
    public void leavePasswordEmpty(){
        String username = generateRandomWord(10);
        String password = "";
        signUp(
                3,
                username,
                password,
                "Please use a password more than 8 characters."
        );
    }
    @Test (priority = 1)
    public void usePasswordLessThanEight(){
        String username = generateRandomWord(10);
        String password = "P@sw0rd";
        signUp(
                4,
                username,
                password,
                "Please use a password more than 8 characters."
        );
    }
    @Test (priority = 1)
    public void usePasswordWithoutNumbers(){
        String username = generateRandomWord(10);
        String password = "P@ssword";
        signUp(
                5,
                username,
                password,
                "Please use numbers in your password."
        );
    }
    @Test (priority = 1)
    public void usePasswordWithoutSpecialCharacters(){
        String username = generateRandomWord(10);
        String password = "Passw0rd";
        signUp(
                6,
                username,
                password,
                "Please use uppercase letters in your password."
        );
    }
    @Test (priority = 1)
    public void usePasswordWithoutUpperCase(){
        String username = generateRandomWord(10);
        String password = "p@ssw0rd";
        signUp(
                7,
                username,
                password,
                "Please use uppercase letters in your password."
        );
    }
    @Test (priority = 1)
    public void usePasswordWithoutLowerCase(){
        String username = generateRandomWord(10);
        String password = "P@SSW0RD";
        signUp(
                8,
                username,
                password,
                "Please use lowercase letters in your password."
        );
    }
    @Test (priority = 1)
    public void usePasswordWithoutLetters(){
        String username = generateRandomWord(10);
        String password = "123$5678";
        signUp(
                9,
                username,
                password,
                "Please use a Strong Password."
        );
    }
    @Test (priority = 1)
    public void signUpWithSameUsername(){
        String username = generateRandomWord(10);
        String password = "P@ssw0rd";
        try {
            signUp(
                    10,
                    username,
                    password,
                    "Sign up successful."
            );
            openHomePage();
            signUp(
                    10,
                    username,
                    password,
                    "This user already exist."
            );
        }catch (Exception e){
            logger.info("--> Error: "+e);
        }

    }

    @Test (priority = 1)
    public void validSignUp(){
        String username = generateRandomWord(10);
        String password = "P@ssw0rd";
        signUp(
                11,
                username,
                password,
                "Sign up successful."
        );
    }
    @Test (priority = 2)
    public void closeSignUp(){
        WebElement section = findElementAndWait(10, signupSectionPath);
        tester.findElements(signupCloseButton).get(1).click();
        waitForElementInVisibility(10, section);
        checkElementNotDisplayed(section);
    }

    @AfterTest
    public static void disableDriver(){
        tester.quit();
    }
}
