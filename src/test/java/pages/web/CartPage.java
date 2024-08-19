package pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Map;

import static helper.Utility.driver;
import static helper.Utility.explicitWaitClickable;
import static org.junit.Assert.assertTrue;

public class CartPage {

    By buttonPlaceOrder = By.xpath("//button[contains(text(),'Place Order')]");
    By buttonPurchase = By.xpath("//button[contains(text(),'Purchase')]");
    By orderName = By.id("name");
    By orderCountry = By.id("country");
    By orderCity = By.id("city");
    By orderCard = By.id("card");
    By orderMonth = By.id("month");
    By orderYear = By.id("year");

    public void clickButtonPlace(){
        explicitWaitClickable(buttonPlaceOrder);
        WebElement placeOrderButton = driver.findElement(By.className("btn-success"));
        placeOrderButton.click();

    }

    public void fill_order(Map<String,String> details){
        explicitWaitClickable(orderName);
        driver.findElement(orderName).sendKeys(details.get("Name"));
        driver.findElement(orderCountry).sendKeys(details.get("Country"));
        driver.findElement(orderCity).sendKeys(details.get("City"));
        driver.findElement(orderCard).sendKeys(details.get("Credit card"));
        driver.findElement(orderMonth).sendKeys(details.get("Month"));
        driver.findElement(orderYear).sendKeys(details.get("Year"));
    }

    public void clickButton(String buttonName){
        driver.findElement(By.xpath("//button[contains(text(),'" + buttonName + "')]")).click();
    }

    public void confirmationMessage() {
        WebElement confirmation = driver.findElement(By.cssSelector(".sweet-alert"));
        assertTrue(confirmation.isDisplayed());
        String message = confirmation.getText();
        assertTrue(message.contains("Thank you for your purchase!"));
        // Validasi lebih lanjut jika diperlukan
    }

}
