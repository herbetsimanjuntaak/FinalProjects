package stepDef.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.web.HomePage;
import pages.web.LoginPage;
import pages.web.SignPage;

public class SignDef {

    HomePage homePage = new HomePage();
    SignPage signPage = new SignPage();
    LoginPage loginPage = new LoginPage();


    @Given("the user is on the Sign Up page")
    public void theUserIsOnTheSignUpPage() {
        homePage.demoBlazeHomePage();
        signPage.clickSignUp();
    }

    @When("the user enters a unique {string} and a valid {string}")
    public void theUserEntersAUniqueAndAValid(String username, String password) {
        signPage.inputUsernameAndPassword(username,password);
    }


    @And("the user clicks the Sign Up button")
    public void theUserClicksTheSignUpButton() {
        signPage.clickButtonSignUp();
    }

    @Then("the user should see a confirmation message saying {string}")
    public void theUserShouldSeeAConfirmationMessageSaying(String message) {
        homePage.getMessage(message);
    }

    @And("the user should be redirected to the login page")
    public void theUserShouldBeRedirectedToTheLoginPage() {
        loginPage.clickLinkLogin();
    }

    @When("the user enters an existing {string} and a valid {string}")
    public void theUserEntersAnExistingUsernameAndAValidPassword(String username, String password) {
        signPage.inputUsernameAndPassword(username,password);
    }



}
