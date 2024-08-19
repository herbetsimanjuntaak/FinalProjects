package stepDef.web;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.web.AboutUsPage;
import pages.web.HomePage;

public class AboutUsDef {

    HomePage homePage = new HomePage();
    AboutUsPage aboutUsPage = new AboutUsPage();

    @Given("the user is on the homepage")
    public void theUserIsOnTheHomepage() {
        homePage.demoBlazeHomePage();
    }

    @When("the user clicks the About Us button")
    public void theUserClicksTheAboutUsButton() {
        aboutUsPage.clickLinkAboutUs();

    }

    @Then("the About Us modal should be displayed")
    public void theAboutUsModalShouldBeDisplayed() throws InterruptedException {
        aboutUsPage.clickPlayVideo();
    }

}
