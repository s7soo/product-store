package constants;

import org.openqa.selenium.By;

public class Elements {

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
}
