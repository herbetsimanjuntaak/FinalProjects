package pages.api;


import static helper.Models.*;
import static org.assertj.core.api.Assertions.assertThat;
import static pages.api.GetUserPage.finalEndpoint;
import static pages.api.GetUserPage.setUpUrl;

public class PostPage {


    public static String idPost;

    public void hitApiListBy() {
        String Endpoint = finalEndpoint + "/post";
        System.out.println(Endpoint);
        response = hitById(Endpoint);

    }

    public void hitGetPostById() {
        response = hitById(finalEndpoint);
    }

    public void hitCreatePost() {
        response = createPost(setUpUrl);
        System.out.println(response.getBody().asString());
    }

    public void responseCreatePost() {

        String responseBody = actualResponse.getBody().asString();
        System.out.println(actualResponse.getBody().asString());
        idPost = actualResponse.jsonPath().get("id");
        assertThat(responseBody).isNotNull();
    }

    public void hitEmptyOwner() {
        response = createPostEmptyOwner(setUpUrl);
        System.out.println(response.getBody().asString());
    }

    public void hitMaxChar() {
        response = createPostMaxChar(setUpUrl);
        System.out.println(response.getBody().asString());
    }

    public void hitUpdatePost() {
        response = updatePost(finalEndpoint);
        System.out.println(response.getBody().asString());

    }

    public void hitUpdateCreatePost() {
        response = updateCreatePost(setUpUrl, idPost);
        System.out.println(response.getBody().asString());

    }

    public void hitDeletePost() {
        response = deletePost(setUpUrl, idPost);

    }
}
