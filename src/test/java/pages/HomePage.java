package pages;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static constants.Elements.*;
import static constants.Links.*;
import static functions.HomeHelper.waitForElement;


public class HomePage {

    private static WebDriver tester;

    @BeforeAll
    public static void initiateDriver(){
        tester = new ChromeDriver();
    }

    @BeforeEach
    public void openHomePage(){
        tester.get(homePage);
    }

    @Test
    public void navigateToHomePage(){
        tester.findElement(homeNavPath).click();
        Assertions.assertEquals(tester.getCurrentUrl(), homePage);
    }
    @Test
    public void navigateToContactSection(){
        tester.findElement(contactNavPath).click();
        // Wait for the section to become visible
        WebElement section = waitForElement(tester, 10, contactSectionPath);
        Assertions.assertTrue(section.isDisplayed());
    }

    @Test
    public void navigateToAboutUsSection(){
        tester.findElement(aboutUsNavPath).click();

    }

    @Test
    public void navigateToCartPage(){
        tester.findElement(cartNavPath).click();
        Assertions.assertEquals(tester.getCurrentUrl(), cartPage);
    }


    @AfterAll
    public static void disableDriver(){
        tester.quit();
    }
}
