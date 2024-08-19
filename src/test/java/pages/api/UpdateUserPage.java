package pages.api;


import static helper.Models.UpdatedUser;
import static helper.Models.response;
import static org.assertj.core.api.Assertions.assertThat;
import static pages.api.GetUserPage.finalEndpoint;


public class UpdateUserPage {


    public void hitUpdateUser() {
        response = UpdatedUser(finalEndpoint);
        System.out.println(finalEndpoint);
        System.out.println(response.getBody().asString());
    }

    public void responseUpdate() {
        String responseBody = response.getBody().asString();
        assertThat(responseBody).isNotNull();
        System.out.println(responseBody);
    }


}
