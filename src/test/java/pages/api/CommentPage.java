package pages.api;


import static helper.Models.*;
import static pages.api.GetUserPage.finalEndpoint;
import static pages.api.GetUserPage.setUpUrl;
import static pages.api.PostPage.idPost;


public class CommentPage {


    public void hitApiListBy() {
        String Endpoint = finalEndpoint + "/comment";
        response = hitById(Endpoint);
    }

    public void hitCreateComments(){
        response = createComment(setUpUrl);
    }

    public void CreateCommentsInvalidUser(){
        response = createCommentInvalidIdUser(setUpUrl);
    }
    public void CreateCommentsInvalidPost(){
        response = createCommentInvalidIdPost(setUpUrl);
    }
    public void CreateCommentsInvalidMessage(){
        response = createCommentMaxMessage(setUpUrl);
    }

    public void deleteComment(){
        response = hitDeleteComment(setUpUrl, idPost);
    }

}
