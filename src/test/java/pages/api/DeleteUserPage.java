package pages.api;


import static helper.Models.deleteUserById;
import static helper.Models.response;
import static org.assertj.core.api.Assertions.assertThat;
import static pages.api.GetUserPage.finalEndpoint;


public class DeleteUserPage {


    public void hitDeleteUser() {
        response = deleteUserById(finalEndpoint);
        System.out.println(finalEndpoint);
        System.out.println(response.getBody().asString());
    }

    public void responseDelete() {
        String responseBody = response.jsonPath().getString("id");

        assertThat(responseBody).isNotNull();
        System.out.println(responseBody);
    }


}
