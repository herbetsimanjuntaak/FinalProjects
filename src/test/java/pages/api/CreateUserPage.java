package pages.api;



import static helper.Models.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static pages.api.GetUserPage.setUpUrl;


public class CreateUserPage {



    public void postUser() {
        response = postCreatedNewUser(setUpUrl);
        System.out.println(response.getBody().asString());
    }

    public void responseBodyCreateUser(){
        String responseBody = response.getBody().asString();
        assertThat(responseBody).isNotNull();

        String firstName = response.jsonPath().getString("firstName");
        assertThat(firstName).isNotEmpty();

        System.out.println(response.getBody().asString());

    }

    public void hitInvalidCreate(){
        response = invalidCreatedNewUser(setUpUrl);
    }

    public void hitOverChar(){
        response = overCharacters(setUpUrl);
    }

    public void hitBlankEmail(){
        response = blankEmail(setUpUrl);
    }

    public void hitInvalidEmail(){
        response = invalidEmail(setUpUrl);
    }

    public void responseBodyInvalidCreateUser(){
        String responseBody = response.getBody().asString();
        assertTrue(responseBody.contains("error"));

        String firstName = response.jsonPath().getString("data.firstName");
        String email = response.jsonPath().getString("data.email");
        String lastName = response.jsonPath().getString("data.lastName");

        assertThat(email).isEqualTo("Path `email` is required.");
        assertThat(firstName).isEqualTo("Path `firstName` is required.");
        assertThat(lastName).isEqualTo("Path `lastName` is required.");

        System.out.println(response.getBody().asString());

    }
}
