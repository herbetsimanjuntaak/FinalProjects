package stepDef.api;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.api.UpdateUserPage;

public class UpdateStepDef {

    UpdateUserPage updateUserPage = new UpdateUserPage();

    @When("user hit updated data")
    public void userHitUpdatedData() {
        updateUserPage.hitUpdateUser();
    }

    @Then("validation response body update user")
    public void validationResponseBodyUpdateUser() {
        updateUserPage.responseUpdate();

    }
}
