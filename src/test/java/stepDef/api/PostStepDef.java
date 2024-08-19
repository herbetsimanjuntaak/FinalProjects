package stepDef.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.api.GetUserPage;
import pages.api.PostPage;

public class PostStepDef {

    PostPage createPostPage = new PostPage();


    @And("hit API create post")
    public void hitAPICreatePost() {
        createPostPage.hitCreatePost();
    }

    @Then("validation response body")
    public void validationResponseCreatePost() {
        createPostPage.responseCreatePost();
    }

    @And("hit API create post empty owner")
    public void hitAPICreatePostEmptyOwner() {
        createPostPage.hitEmptyOwner();

    }

    @Then("validation response body empty owner")
    public void validationResponseBodyEmptyOwner() {
        GetUserPage getUserPage = new GetUserPage();
        getUserPage.responseBodyInvalidEndpoint();
    }

    @When("hit API create post max char")
    public void hitAPICreatePostMaxChar() {
        createPostPage.hitMaxChar();
    }

    @And("hit API update post")
    public void hitAPIUpdatePost() {
        createPostPage.hitUpdatePost();
    }

    @When("hit API update post after create")
    public void hitAPIUpdatePostAfterCreate() {
        createPostPage.hitUpdateCreatePost();
    }

    @When("hit API delete post")
    public void hitAPIDeletePost() {
        createPostPage.hitDeletePost();
    }

    @When("hit Api get list post by user id")
    public void hitApiGetListPostByUserId() {
        createPostPage.hitApiListBy();
    }

    @When("hit Api get post by id")
    public void hitApiGetPostById() {
        createPostPage.hitGetPostById();
    }
}
