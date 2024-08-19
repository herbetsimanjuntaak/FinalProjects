package stepDef.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.web.ContactPage;
import pages.web.HomePage;


public class ContactDef {

    HomePage homePage = new HomePage();
    ContactPage contactPage = new ContactPage();


    @Given("I am on the {string} page of DemoBlaze")
    public void iAmOnThePageOfDemoBlaze(String contact) {
        homePage.demoBlazeHomePage();
        homePage.getProduct(contact);

    }

    @When("I fill in the Email field with {string}")
    public void iFillInTheEmailFieldWithEmail(String email) {
        contactPage.fillEmail(email);
    }

    @And("I fill in the Name field with {string}")
    public void iFillInTheNameFieldWithName(String name) {
        contactPage.fillName(name);
    }

    @And("I fill in the Message field with {string}")
    public void iFillInTheMessageFieldWithMessage(String message) {
        contactPage.fillMessage(message);
    }

    @And("I click the Send message button")
    public void iClickTheSendMessageButton() {
        contactPage.clickButtonSend();

    }

    @And("The contact form should be closed")
    public void theContactFormShouldBeClosed() {
    }

    @When("The user clicks on the Close button on the contact form")
    public void theUserClicksOnTheButtonOnTheContactForm() {
        contactPage.clickButtonClose();
    }
}
