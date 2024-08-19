package stepDef.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.web.HomePage;

public class HomeDef {

    HomePage homePage = new HomePage();

    @Given("I am on the DemoBlaze homepage")
    public void iAmOnTheDemoBlazeHomepage() {
        homePage.demoBlazeHomePage();
    }

    @When("I click on a product titled {string}")
    public void iClickOnAProductTitled(String productTitle) {
        homePage.getProduct(productTitle);
    }

    @Then("I should be redirected to the product details page for {string}")
    public void iShouldBeRedirectedToTheProductDetailsPageFor(String productTitle) {
        homePage.validateProduct(productTitle);
    }

    @And("I should see the product's price")
    public void iShouldSeeTheProductSPrice() {
        homePage.validatePrice();
    }

    @And("I should see the product's description")
    public void iShouldSeeTheProductSDescription() {
        homePage.validateDesc();
    }

    @When("I click on the {string} category")
    public void iClickOnTheCategory(String category) {
        homePage.productByCategory(category);
    }

    @Then("I should see a list of category")
    public void iShouldSeeAListOfCategory() {
        homePage.listProduct();
    }

    @And("each laptop should have a name, price, and description")
    public void eachLaptopShouldHaveANamePriceAndDescription() {
        homePage.validateListProduct();
    }

    @When("I click on the {string} product")
    public void iClickOnTheProduct(String productName) {
        homePage.getProduct(productName);
    }

    @And("I click the {string} button")
    public void iClickTheButton(String buttonText) {
        homePage.clickButton(buttonText);
    }

    @Then("the product should be added to my cart")
    public void theProductShouldBeAddedToMyCart() {
        homePage.clickCartLink();
    }

    @And("I should see a confirmation message saying {string}")
    public void iShouldSeeAConfirmationMessageSaying(String message) {
        homePage.getMessage(message);
    }
}
