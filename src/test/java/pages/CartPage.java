package pages;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static constants.Elements.*;
import static utilities.CartHelper.*;
import static utilities.ContactHelper.generateValidName;
import static utilities.GenericHelper.*;
import static constants.Links.homePage;

public class CartPage {
    @BeforeTest
    public static void setup(){
        if (tester == null)
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
        WebElement productName = addProductToCart();
        checkElementDisplay(productName);
        logger.info("Case 1: Pass");
    }
    @Test(priority = 1)
    public void deleteProductFromCard(){
        logger.info("Case 2");
        WebElement productName = addProductToCart();
        findElementAndWait(10, deleteProduct).click();
        waitForElementInVisibility(10, productName);
        logger.info("Case 2: Pass");
    }
    @Test(priority = 1)
    public void fillPurchaseFormWithEmptyFields(){
        addProductToCart();
        findElementAndWait(10, placeOrderButton).click();
        String name = "";
        String country = "";
        String city = "";
        String credit = "";
        String month = "";
        String year = "";
        fillPurchaseForm(
                3, name, country,
                city, credit,
                month, year
        );
        String alertText = acceptAlert(10);
        compare(alertText,
                "Please fill out Name, country, city, credit card, month, and year");
    }
    @Test(priority = 1)
    public void fillPurchaseFormWithoutName(){
        addProductToCart();
        findElementAndWait(10, placeOrderButton).click();
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
                month, year
        );
        String alertText = acceptAlert(10);
        compare(alertText,
                "Please fill out your Name");
    }
    @Test(priority = 1)
    public void fillPurchaseFormWithoutCountry(){
        addProductToCart();
        findElementAndWait(10, placeOrderButton).click();
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
                month, year
        );
        assertion.assertTrue(isAlertVisible(5),
                "Product is confirmed with empty country");
            String alertText = acceptAlert(5);
            compare(alertText,
                    "Please fill out Country");


    }
    @Test(priority = 1)
    public void fillPurchaseFormWithoutCity(){
        addProductToCart();
        findElementAndWait(10, placeOrderButton).click();
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
                month, year
        );
        assertion.assertTrue(isAlertVisible(5),
                "Product is confirmed with empty city");
        String alertText = acceptAlert(5);
        compare(alertText,
                "Please fill out city");
    }
    @Test(priority = 1)
    public void fillPurchaseFormWithoutCredit(){
        addProductToCart();
        findElementAndWait(10, placeOrderButton).click();
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
                month, year
        );
        assertion.assertTrue(isAlertVisible(5),
                "Product is confirmed with empty Credit card");
        String alertText = acceptAlert(5);
        compare(alertText,
                "Please fill out Credit card");
    }

    @Test(priority = 1)
    public void fillPurchaseFormWithoutMonth(){
        addProductToCart();
        findElementAndWait(10, placeOrderButton).click();
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
                month, year
        );
        assertion.assertTrue(isAlertVisible(5),
                "Product is confirmed with empty month");
        String alertText = acceptAlert(5);
        compare(alertText,
                "Please fill out month");
    }
    @Test(priority = 1)
    public void fillPurchaseFormWithoutYear(){
        addProductToCart();
        findElementAndWait(10, placeOrderButton).click();
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
                month, year
        );
        assertion.assertTrue(isAlertVisible(5),
                "Product is confirmed with empty year");
        String alertText = acceptAlert(5);
        compare(alertText,
                "Please fill out year");
    }
    @Test(priority = 1)
    public void fillPurchaseFormWithInvalidCredit(){
        addProductToCart();
        findElementAndWait(10, placeOrderButton).click();
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
                month, year
        );
        assertion.assertTrue(isAlertVisible(5),
                "Product is confirmed with invalid Credit card");
        String alertText = acceptAlert(5);
        compare(alertText,
                "Please use a valid Credit card");
    }
    @Test(priority = 1)
    public void purchaseProduct(){
        addProductToCart();
        findElementAndWait(10, placeOrderButton).click();
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
                month, year
        );
        findElementAndWait(10, confirmButton).click();
    }
    @Test(priority = 1)
    public void closePurchaseForm(){
        addProductToCart();
        findElementAndWait(10, placeOrderButton).click();
        findElementAndWait(10, formPurchaseButton);
        WebElement closeBtn = tester.findElements(formCloseButton).get(2);
        scrollToElement(closeBtn);
        closeBtn.click();
        waitForElementInVisibility(10, closeBtn);
    }

    @AfterTest
    public static void disableDriver(){
        tester.quit();
    }
}
