package stepDef.api;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.api.DeleteUserPage;

public class DeleteStepDef {

    DeleteUserPage deleteUserPage = new DeleteUserPage();

    @When("user hit delete user data")
    public void userHitDeleteUserData() {
        deleteUserPage.hitDeleteUser();
    }

    @Then("validation response delete user")
    public void validationResponseDeleteUser() {
        deleteUserPage.responseDelete();
    }
}
