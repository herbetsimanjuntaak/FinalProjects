package stepDef.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.web.HomePage;
import pages.web.LoginPage;

public class LoginDef {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();


    @Given("the user is on the Login page")
    public void theUserIsOnTheLoginPage() {
        homePage.demoBlazeHomePage();
        loginPage.clickLinkLogin();
    }

    @When("the user enters a valid {string} and a valid {string}")
    public void theUserEntersAValidUsernameAndAValidPassword(String username, String password) {
        loginPage.inputUsernameAndPassword(username, password);
    }

    @And("the user clicks the Login button")
    public void theUserClicksTheLoginButton() {
        loginPage.clickButtonLogin();
    }

    @Then("the user should be logged in successfully")
    public void theUserShouldBeLoggedInSuccessfully() {
        loginPage.validateLogin();
    }


    @And("the user should see their {string} displayed on the page")
    public void theUserShouldSeeTheirDisplayedOnThePage(String username) {
        loginPage.validateUsername(username);
    }


}
