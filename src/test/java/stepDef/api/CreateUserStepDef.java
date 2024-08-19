package stepDef.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.api.CreateUserPage;
import pages.api.GetUserPage;


public class CreateUserStepDef {


    CreateUserPage createUserPage = new CreateUserPage();



    @And("hit API create new users")
    public void hitAPICreateNewUsers() {
        createUserPage.postUser();
    }

    @Then("validation response body create user")
    public void validationResponseBodyCreateUser() {
        createUserPage.responseBodyCreateUser();
    }

    @When("user hit API invalid create new users")
    public void userHitAPIInvalidCreateNewUsers() {
        createUserPage.hitInvalidCreate();
    }

    @Then("validation response body create invalid user")
    public void validationResponseBodyCreateInvalidUser() {
        createUserPage.responseBodyInvalidCreateUser();
    }

    @When("user hit API over characters")
    public void userHitAPIOverCharacters() {
        createUserPage.hitOverChar();
    }



    @When("user hit API blank email")
    public void userHitAPIBlankEmail() {
        createUserPage.hitBlankEmail();
    }

    @When("user hit API invalid email")
    public void userHitAPIInvalidEmail() {
        createUserPage.hitInvalidEmail();
    }

    @Then("validation response body over characters")
    public void validationResponseBodyOverCharacters() {
        GetUserPage getUserPage = new GetUserPage();
        getUserPage.responseBodyInvalidEndpoint();
    }
}
