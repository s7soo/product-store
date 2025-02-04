package pages;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static constants.Elements.*;
import static constants.Elements.tester;
import static utilities.CartHelper.*;
import static utilities.ContactHelper.generateValidName;
import static utilities.GenericHelper.*;
import static constants.Links.homePage;

public class CartPage {
    private static WebDriver tester;
    @BeforeClass
    public static void setup(){
        tester = new ChromeDriver();
    }

    @BeforeMethod
    public void openHomePage(){
        tester.navigate().to(homePage);
        tester.manage().window().maximize();
    }
    @Test(priority = 1)
    public void addProduct(){
        logger.info("Case 1");
        WebElement productName = addProductToCart(tester);
        checkElementDisplay(productName);
        logger.info("Case 1: Pass");
    }
    @Test(priority = 1)
    public void deleteProductFromCard(){
        logger.info("Case 2");
        WebElement productName = addProductToCart(tester);
        findElementAndWait(10, tester,deleteProduct).click();
        waitForElementInVisibility(10,tester, productName);
        logger.info("Case 2: Pass");
    }
    @Test(priority = 1)
    public void fillPurchaseFormWithEmptyFields(){
        addProductToCart(tester);
        findElementAndWait(10, tester,placeOrderButton).click();
        String name = "";
        String country = "";
        String city = "";
        String credit = "";
        String month = "";
        String year = "";
        fillPurchaseForm(
                3, name, country,
                city, credit,
                month, year,tester
        );
        String alertText = acceptAlert(10, tester);
        compare(alertText,
                "Please fill out Name, country, city, credit card, month, and year");
    }
    @Test(priority = 1)
    public void fillPurchaseFormWithoutName(){
        addProductToCart(tester);
        findElementAndWait(10, tester,placeOrderButton).click();
        int index = generateRandomNumber();
        String name = "";
        String country = generateValidCountry(index);
        String city = generateValidCity(index);
        String credit = generateValidCard("4",16);
        String month = generateValidMonth();
        String year = String.valueOf(generateValidYear());
        fillPurchaseForm(
                4, name, country,
                city, credit,
                month, year,tester
        );
        String alertText = acceptAlert(10, tester);
        compare(alertText,
                "Please fill out your Name");
    }
    @Test(priority = 1)
    public void fillPurchaseFormWithoutCountry(){
        addProductToCart(tester);
        findElementAndWait(10, tester,placeOrderButton).click();
        int index = generateRandomNumber();
        String name = generateValidName();
        String country = "";
        String city = generateValidCity(index);
        String credit = generateValidCard("4",16);
        String month = generateValidMonth();
        String year = String.valueOf(generateValidYear());
        fillPurchaseForm(
                5, name, country,
                city, credit,
                month, year,tester
        );
        assertion.assertTrue(isAlertVisible(5, tester),
                "Product is confirmed with empty country");
            String alertText = acceptAlert(5, tester);
            compare(alertText,
                    "Please fill out Country");


    }
    @Test(priority = 1)
    public void fillPurchaseFormWithoutCity(){
        addProductToCart(tester);
        findElementAndWait(10,tester, placeOrderButton).click();
        int index = generateRandomNumber();
        String name = generateValidName();
        String country = generateValidCountry(index);
        String city = "";
        String credit = generateValidCard("4",16);
        String month = generateValidMonth();
        String year = String.valueOf(generateValidYear());
        fillPurchaseForm(
                6, name, country,
                city, credit,
                month, year,tester
        );
        assertion.assertTrue(isAlertVisible(5, tester),
                "Product is confirmed with empty city");
        String alertText = acceptAlert(5, tester);
        compare(alertText,
                "Please fill out city");
    }
    @Test(priority = 1)
    public void fillPurchaseFormWithoutCredit(){
        addProductToCart(tester);
        findElementAndWait(10, tester,placeOrderButton).click();
        int index = generateRandomNumber();
        String name = generateValidName();
        String country = generateValidCountry(index);
        String city = generateValidCity(index);
        String credit = "";
        String month = generateValidMonth();
        String year = String.valueOf(generateValidYear());
        fillPurchaseForm(
                7, name, country,
                city, credit,
                month, year,tester
        );
        assertion.assertTrue(isAlertVisible(5, tester),
                "Product is confirmed with empty Credit card");
        String alertText = acceptAlert(5, tester);
        compare(alertText,
                "Please fill out Credit card");
    }

    @Test(priority = 1)
    public void fillPurchaseFormWithoutMonth(){
        addProductToCart(tester);
        findElementAndWait(10,tester, placeOrderButton).click();
        int index = generateRandomNumber();
        String name = generateValidName();
        String country = generateValidCountry(index);
        String city = generateValidCity(index);
        String credit = generateValidCard("4", 16);
        String month = "";
        String year = String.valueOf(generateValidYear());
        fillPurchaseForm(
                8, name, country,
                city, credit,
                month, year,tester
        );
        assertion.assertTrue(isAlertVisible(5, tester),
                "Product is confirmed with empty month");
        String alertText = acceptAlert(5, tester);
        compare(alertText,
                "Please fill out month");
    }
    @Test(priority = 1)
    public void fillPurchaseFormWithoutYear(){
        addProductToCart(tester);
        findElementAndWait(10, tester,placeOrderButton).click();
        int index = generateRandomNumber();
        String name = generateValidName();
        String country = generateValidCountry(index);
        String city = generateValidCity(index);
        String credit = generateValidCard("4", 16);
        String month = generateValidMonth();
        String year = "";
        fillPurchaseForm(
                9, name, country,
                city, credit,
                month, year,tester
        );
        assertion.assertTrue(isAlertVisible(5, tester),
                "Product is confirmed with empty year");
        String alertText = acceptAlert(5, tester);
        compare(alertText,
                "Please fill out year");
    }
    @Test(priority = 1)
    public void fillPurchaseFormWithInvalidCredit(){
        addProductToCart(tester);
        findElementAndWait(10, tester,placeOrderButton).click();
        int index = generateRandomNumber();
        String name = generateValidName();
        String country = generateValidCountry(index);
        String city = generateValidCity(index);
        String credit = generateValidCard("78", 8);
        String month = generateValidMonth();
        String year = String.valueOf(generateValidYear());
        fillPurchaseForm(
                10, name, country,
                city, credit,
                month, year,tester
        );
        assertion.assertTrue(isAlertVisible(5, tester),
                "Product is confirmed with invalid Credit card");
        String alertText = acceptAlert(5, tester);
        compare(alertText,
                "Please use a valid Credit card");
    }
    @Test(priority = 1)
    public void purchaseProduct(){
        addProductToCart(tester);
        findElementAndWait(10, tester,placeOrderButton).click();
        int index = generateRandomNumber();
        String name = generateValidName();
        String country = generateValidCountry(index);
        String city = generateValidCity(index);
        String credit = generateValidCard("4", 16);
        String month = generateValidMonth();
        String year = String.valueOf(generateValidYear());
        fillPurchaseForm(
                10, name, country,
                city, credit,
                month, year,tester
        );
        findElementAndWait(10, tester,confirmButton).click();
    }
    @Test(priority = 1)
    public void closePurchaseForm(){
        addProductToCart(tester);
        findElementAndWait(10, tester,placeOrderButton).click();
        findElementAndWait(10, tester,formPurchaseButton);
        WebElement closeBtn = tester.findElements(formCloseButton).get(2);
        scrollToElement(tester, closeBtn);
        closeBtn.click();
        waitForElementInVisibility(10, tester,closeBtn);
    }

    @AfterClass
    public static void tearDown(){
        tester.quit();
    }
}
