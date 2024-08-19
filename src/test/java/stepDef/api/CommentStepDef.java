package stepDef.api;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.api.CommentPage;
import pages.api.GetUserPage;

public class CommentStepDef {

    CommentPage commentPage = new CommentPage();



    @When("Hit Api list of comments By Post")
    public void hitAPIListOfComments() {
        commentPage.hitApiListBy();
    }

    @When("Hit Api list of comments By User")
    public void hitApiListOfCommentsByUser() {
        commentPage.hitApiListBy();
    }

    @When("hit Api create comment")
    public void hitApiCreateComment() {
        commentPage.hitCreateComments();

    }

    @When("hit Api create comment invalid user ID")
    public void hitApiCreateCommentInvalidUserID() {
        commentPage.CreateCommentsInvalidUser();


    }

    @When("hit Api create comment invalid post ID")
    public void hitApiCreateCommentInvalidPostID() {
        commentPage.CreateCommentsInvalidPost();
    }

    @When("hit Api create comment max message")
    public void hitApiCreateCommentMaxMessage() {
        commentPage.CreateCommentsInvalidMessage();
    }

    @Then("validation error response body")
    public void validationErrorResponseBody() {
        GetUserPage getUserPage = new GetUserPage();
        getUserPage.responseBodyInvalidEndpoint();
    }

    @When("hit API delete comment")
    public void hitAPIDeleteComment() {
        commentPage.deleteComment();

    }
}
