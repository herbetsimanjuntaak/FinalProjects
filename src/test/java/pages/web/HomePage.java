package pages.web;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

import static helper.Utility.*;
import static org.junit.Assert.*;

public class HomePage {

    By categories = By.id("cat");
    By productHeader = By.xpath("//h2[@class='name']");
    By productPrice = By.xpath("//h2[@class='name']");
    By productDesc = By.xpath("//*[@id='more-information']");
    By listProduct = By.xpath("//*[@class='card-block']");

    By listProductNames = By.xpath("//div[@class='card-block']/h4/a");
    By listPrice = By.xpath("//div[@class='card-block']/h5");
    By listDesc = By.xpath("//div[@class='card-block']/p");

    By cartLink = By.id("cartur");



    public void demoBlazeHomePage() {
        driver.get("https://www.demoblaze.com/");
        explicitWaitPresence(categories);
    }

    public void getProduct(String productTitle) {
        driver.findElement(By.linkText(productTitle)).click();
    }

    public void validateProduct(String productTitle) {
        explicitWaitPresence(productHeader);
        assertEquals(productTitle, driver.findElement(productHeader).getText());
    }

    public void validatePrice() {
        explicitWaitPresence(productPrice);
        assertTrue(driver.findElement(productPrice).isDisplayed());
    }

    public void validateDesc() {
        explicitWaitPresence(productDesc);
        assertTrue(driver.findElement(productDesc).isDisplayed());
    }

    public void productByCategory(String category) {
        explicitWaitPresence(categories);
        driver.findElement(By.linkText(category)).click();
    }

    public void listProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(listProduct));
        List<WebElement> product = driver.findElements(listProduct);
        assertFalse("No product categories found", product.isEmpty());
    }

    public void validateListProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(listProduct));


        List<WebElement> name = driver.findElements(listProductNames);
        List<WebElement> price = driver.findElements(listPrice);
        List<WebElement> description = driver.findElements(listDesc);

        assertNotNull("product name is missing", name);
        assertNotNull("product price is missing", price);
        assertNotNull("product description is missing", description);
    }

    public void clickButton(String buttonText) {
        explicitWaitClickable(By.linkText(buttonText));
        driver.findElement(By.linkText(buttonText)).click();

    }

    public void clickCartLink(){
        explicitWaitClickable(cartLink);
        driver.findElement(cartLink).click();

        // Verify the product is listed in the cart
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productInCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbodyid")));
        assertTrue(productInCart.isDisplayed());
    }

    public void getMessage(String message){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);
        assertTrue(alertText.contains(message));
        driver.switchTo().alert().accept();
    }

}