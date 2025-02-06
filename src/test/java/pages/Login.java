package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import reports.ExtentReportListener;

import static constants.Elements.*;
import static constants.Links.homePage;

import static utilities.GenericHelper.*;
import static utilities.LoginHelper.*;
import static utilities.RandomWordGenerator.generateRandomWord;

public class Login {
    private static Alert alert;
    private static WebDriver tester;
    @BeforeClass
    public static void setup(){
        tester = new ChromeDriver();
        ExtentReportListener.setDriver(tester);
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
                "Please fill out Username and Password.",
                tester
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
                "Please fill out Username.",
                tester
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
                "Please fill out Password.",
                tester
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
                "Wrong password.",
                tester
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
                "Wrong password.",
                tester
        );
    }
    @Test (priority = 1)
    public void loginWithValidData(){
        String username = "Mohamed1234";
        String password = "P@ssw0rd";
        validLogin(
                6,
                username,
                password,
                tester
        );
    }
    @Test (priority = 2)
    public void closeSignUp(){
        WebElement section = findElementAndWait(10,tester, loginSectionPath);
        tester.findElements(closeButton2).get(2).click();
        waitForElementInVisibility(10,tester, section);
        checkElementNotDisplayed(section);
    }

    @AfterClass
    public static void tearDown(){
        tester.quit();
    }
}
