package constants;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import pages.HomePage;

import java.util.logging.Logger;

public class Elements {

    // ----- Web Driver ----- \\
    public static WebDriver tester;
    public static Actions actions;
    public static Assertion assertion = new Assertion();
    public static final Logger logger = Logger.getLogger(String.valueOf(HomePage.class));


    // 1. Navigation Buttons
    public static By homeNavPath =
            new By.ByXPath("//a[contains(text(), 'Home ')]");
    public static By contactNavPath =
            new By.ByXPath("//a[contains(text(), 'Contact')]");
    public static By aboutUsNavPath =
            new By.ByXPath("//a[contains(text(), 'About us')]");
    public static By cartNavPath =
            new By.ByXPath("//a[contains(text(), 'Cart')]");
    public static By loginNavPath =
            new By.ByXPath("//a[contains(text(), 'Log in')]");
    public static By logoutNavPath =
            new By.ByXPath("//a[contains(text(), 'Log out')]");
    public static By signUpUsNavPath =
            new By.ByXPath("//a[contains(text(), 'Sign up')]");


    // 2. Sections
    public static By contactSectionPath =
            new By.ByXPath("//div/div/h5[contains(text(), 'New message')]");
    public static By aboutUsSectionPath =
            new By.ByXPath("//div/div/h5[contains(text(), 'About us')]");
    public static By loginSectionPath =
            new By.ByXPath("//div/div/h5[contains(text(), 'Log in')]");
    public static By signupSectionPath =
            new By.ByXPath("//div/div/h5[contains(text(), 'Sign up')]");


    //3. images section
    public static By imageSliderPath =
            new By.ByXPath("//div[@class='carousel-inner']");
    public static By slideImage1 =
            new By.ByXPath("//div/div/img[@alt='First slide']");
    public static By slideImage2 =
            new By.ByXPath("//div/div/img[@alt='Second slide']");
    public static By slideImage3 =
            new By.ByXPath("//div/div/img[@alt='Third slide']");
    public static By nextArrow =
            new By.ByXPath("//a[@data-slide='next']");
    public static By prevArrow =
            new By.ByXPath("//a[@data-slide='prev']");
    public static By slideLeftButton =
            new By.ByXPath("//li[@data-slide-to='0']");
    public static By slideMiddleButton =
            new By.ByXPath("//li[@data-slide-to='1']");
    public static By slideRightButton =
            new By.ByXPath("//li[@data-slide-to='2']");

    // 4. category section

    public static By categoryButton =
            new By.ByXPath("//a[contains(text(), 'CATEGORIES')]");
    public static By phonesCategoryButton =
            new By.ByXPath("//a[contains(text(), 'Phones')]");
    public static By laptopsCategoryButton =
            new By.ByXPath("//a[contains(text(), 'Laptops')]");
    public static By monitorsCategoryButton =
            new By.ByXPath("//a[contains(text(), 'Monitors')]");

    public static By[][] expectedItems = {
            {new By.ByXPath("//h4/a[contains(text(), 'Samsung galaxy s6')]")},
            {new By.ByXPath("//h4/a[contains(text(), 'Sony vaio i5')]")},
            {new By.ByXPath("//h4/a[contains(text(), 'Apple monitor 24')]")}
    };

    public static By nextPage =
            new By.ByXPath("//button[@id='next2']");
    public static By prevPage =
            new By.ByXPath("//button[@id='prev2']");


    // Signup Elements
    public static By username =
            new By.ByXPath("//input[@id='sign-username']");

    public static By password =
            new By.ByXPath("//input[@id='sign-password']");
    public static By signupButton =
            new By.ByXPath("//button[contains(text(), 'Sign up')]");
    public static By closeButton =
            new By.ByXPath("//button[contains(text(), 'Close')]");
}
