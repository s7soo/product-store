package constants;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Elements {

    // ----- Web Driver ----- \\
    public static WebDriver tester;


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


}
