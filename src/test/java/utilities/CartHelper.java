package utilities;

import org.openqa.selenium.WebElement;

import java.util.Random;

import static constants.Elements.*;
import static constants.Values.countryCities;
import static constants.Values.months;
import static utilities.GenericHelper.*;

public class CartHelper {
    public static WebElement addProductToCart(){
        String phoneName = findElementAndWait(10, phoneProduct).getText();
        tester.findElement(phoneProduct).click();
        findElementAndWait(10, addToCartButton).click();

        String alertText = acceptAlert(10);

        tester.findElement(cartNavPath).click();
        return findElementAndWait(10, findElementWithText("td",phoneName));
    }

    public static void fillPurchaseForm(
            int caseNum,
            String name,
            String country,
            String city,
            String credit,
            String month,
            String year
    ){
        logger.info("Case "+caseNum);
        findElementAndWait(10, formName).sendKeys(name);
        findElementAndWait(10, formCountry).sendKeys(country);
        findElementAndWait(10, formCity).sendKeys(city);
        findElementAndWait(10, formCredit).sendKeys(credit);
        findElementAndWait(10, formMonth).sendKeys(month);
        findElementAndWait(10, formYear).sendKeys(year);
        findElementAndWait(10, formPurchaseButton).click();

    }
    public static int generateRandomNumber(){
        Random random = new Random();
        return random.nextInt(countryCities.length);
    }
    public static String generateValidCountry(int index){
        return countryCities[index][0];
    }
    public static String generateValidCity(int index){
        return countryCities[index][1];
    }

    public static String generateValidMonth(){
        Random random = new Random();
        return months[random.nextInt(12)];
    }
    public static int generateValidYear(){
        Random random = new Random();
        return random.nextInt(2024 - 1900 + 1) + 1955;
    }

    // Generate a credit card number with a given prefix and length
    public static String generateValidCard(String prefix, int length) {
        StringBuilder cardNumber = new StringBuilder(prefix);
        Random random = new Random();

        // Generate random digits until the second-to-last digit
        while (cardNumber.length() < length - 1) {
            cardNumber.append(random.nextInt(10)); // Append a random digit (0-9)
        }

        // Calculate and add the Luhn checksum digit
        cardNumber.append(getLuhnChecksum(cardNumber.toString()));

        return cardNumber.toString();
    }

    // Compute Luhn check digit
    private static int getLuhnChecksum(String cardNumber) {
        int sum = 0;
        boolean alternate = true;

        // Process digits from right to left
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(cardNumber.charAt(i));

            if (alternate) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9; // Subtract 9 if doubled value is greater than 9
                }
            }

            sum += digit;
            alternate = !alternate;
        }

        return (10 - (sum % 10)) % 10; // Return the Luhn check digit
    }

}
