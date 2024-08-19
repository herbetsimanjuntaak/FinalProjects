package stepDef.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.web.CartPage;
import pages.web.HomePage;
import pages.web.LoginPage;

import java.util.List;
import java.util.Map;

import static helper.Utility.*;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartDef {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    CartPage cartPage = new CartPage();


    @Given("The user is on the DemoBlaze homepage")
    public void theUserIsOnTheDemoBlazeHomepage() {
        homePage.demoBlazeHomePage();
    }

    @And("The user clicks on the {string} button")
    public void theUserClicksOnTheButton(String buttonText) {
        driver.findElement(By.xpath("//a[text()='" + buttonText + "']")).click();
    }


    @Given("The user navigates to the homepage")
    public void theUserNavigatesToTheHomepage() {
        explicitWaitPresence(By.id("cat"));
        driver.findElement(By.id("cat")).click();
    }

    @When("The user selects a product category {string}")
    public void theUserSelectsAProductCategory(String category) {
        driver.findElement(By.linkText(category)).click();
    }

    @And("The user selects a product {string}")
    public void theUserSelectsAProduct(String productName) {
        explicitWaitPresence(By.linkText(productName));
        driver.findElement(By.linkText(productName)).click();
    }

    @Then("A confirmation alert {string} should be displayed")
    public void aConfirmationAlertShouldBeDisplayed(String expectedAlertMessage) {
        homePage.getMessage(expectedAlertMessage);
    }

    @And("The product should be visible in the Cart")
    public void theProductShouldBeVisibleInTheCart() {
        driver.findElement(By.id("cartur")).click();
        List<WebElement> cartItems = driver.findElements(By.xpath("//tbody[@id='tbodyid']/tr"));
        assertFalse(cartItems.isEmpty());
    }



    @Given("The user is on the Demoblaze homepage")
    public void theUserIsOnTheDemoblazeHomepage() {
        homePage.demoBlazeHomePage();
    }



    @Given("The user has added items to the Cart")
    public void theUserHasAddedItemsToTheCart() {
        homePage.getProduct("Samsung galaxy s7");
        homePage.clickButton("Add to cart");
        homePage.getMessage("Product added");
    }

    @Then("The Cart page should display the added products")
    public void theCartPageShouldDisplayTheAddedProducts() {
        List<WebElement> cartItems = driver.findElements(By.xpath("//tbody[@id='tbodyid']/tr"));
        assertFalse(cartItems.isEmpty()); // Assert that cart contains items
    }

    @And("The total price should be calculated correctly")
    public void theTotalPriceShouldBeCalculatedCorrectly() {
        List<WebElement> prices = driver.findElements(By.xpath("//tbody[@id='tbodyid']/tr/td[3]"));
        int total = prices.stream().mapToInt(e -> Integer.parseInt(e.getText())).sum();
        int displayedTotal = Integer.parseInt(driver.findElement(By.id("totalp")).getText());
        assertEquals(total, displayedTotal);
    }

    @Given("User is on the Cart page")
    public void userIsOnTheCartPage() {
        homePage.demoBlazeHomePage();
        loginPage.clickLinkLogin();
        loginPage.inputUsernameAndPassword("ronaldo", "Password");
        loginPage.clickButtonLogin();
        loginPage.validateLogin();
        loginPage.validateUsername("ronaldo");
        homePage.productByCategory("Phones");
        homePage.getProduct("Samsung galaxy s7");
        homePage.clickButton("Add to cart");
        homePage.getMessage("Product added");
        homePage.clickCartLink();
    }

    @When("User clicks on the Place Order button")
    public void userClicksOnTheButton() {
        cartPage.clickButtonPlace();
    }


    @And("I fill in the order form with my details")
    public void iFillInTheOrderFormWithMyDetails(Map<String, String> details) {
        cartPage.fill_order(details);
    }

    @And("User clicks on the {string} button")
    public void userClicksOnTheButton(String buttonName) {
        cartPage.clickButton(buttonName);
    }

    @Then("a confirmation message should be displayed with the order ID")
    public void aConfirmationMessageShouldBeDisplayedWithTheOrderID() {
        cartPage.confirmationMessage();
    }

    @And("the cart should be empty")
    public void theCartShouldBeEmpty() {
        homePage.demoBlazeHomePage();
        homePage.clickCartLink();
    }
}
