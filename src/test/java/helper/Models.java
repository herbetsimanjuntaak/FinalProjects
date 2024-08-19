package helper;


import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static helper.Utility.*;
import static io.restassured.RestAssured.given;


public class Models {

    public static RequestSpecification request;
    public static Integer resStatusCode;
    public static String idUser;
    public static Response actualResponse;

    public static Response response;


    public static void setUpHeaders() {
        request = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("app-id", "669939f1a325844cb69ce7cb");
    }

    public static Response getListUsers(String endpoint) {
        setUpHeaders();
        Response reqApi = request.when().get(endpoint);
        resStatusCode = reqApi.statusCode();
        actualResponse = reqApi;
        return reqApi;
    }

    public static Response blankHeader(String endpoint) {
        Response reqApi = given().
                header("Content-Type", "application/json").
                header("Accept", "application/json").get(endpoint);
        resStatusCode = reqApi.statusCode();
        actualResponse = reqApi;
        return reqApi;
    }

    public static String setUpId(String endpoint, String user_id) {
        return endpoint + "/" + user_id;
    }

    public static Response hitUserById(String endpoint) {
        setUpHeaders();
        Response reqApi = request.when().get(endpoint);
        resStatusCode = reqApi.statusCode();
        actualResponse = reqApi;
        return reqApi;
    }

    public static Response hitUserParams(String endpoint, String params, String limit) {
        request = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("app-id", "669939f1a325844cb69ce7cb")
                .param("page", params)
                .param("limit", limit);

        Response reqApi = request.when().get(endpoint);
        resStatusCode = reqApi.statusCode();
        actualResponse = reqApi;

        return reqApi;
    }

    public static Response hitUserParamsFirstName(String endpoint, String firstName, String lastName) {
        request = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("app-id", "669939f1a325844cb69ce7cb")
                .param("firstName", firstName)
                .param("lastName", lastName);

        Response reqApi = request.when().get(endpoint);
        resStatusCode = reqApi.statusCode();
        actualResponse = reqApi;

        return reqApi;
    }


    public static Response postCreatedNewUser(String endpoint) {
        String title = generateRandomTitle();
        String firstName = generateFirstName();
        String lastName = generateLastName();
        String email = generateEmails();
        String gender = generateGender();
        String phone = generatePhoneNumber();

        JSONObject payload = new JSONObject();
        payload.put("title", title);
        payload.put("firstName", firstName);
        payload.put("lastName", lastName);
        payload.put("email", email);
        payload.put("gender", gender);
        payload.put("phone", phone);
        setUpHeaders();
        Response reqApi = request.body(payload.toString()).when().post(endpoint);
        resStatusCode = reqApi.statusCode();
        actualResponse = reqApi;
        idUser = reqApi.jsonPath().getString("id");
        return reqApi;
    }

    public static Response invalidCreatedNewUser(String endpoint) {
        String title = generateRandomTitle();
        String firstName = "";
        String lastName = "";
        String email = "";
        String gender = generateGender();
        String phone = generatePhoneNumber();

        JSONObject payload = new JSONObject();
        payload.put("title", title);
        payload.put("firstName", firstName);
        payload.put("lastName", lastName);
        payload.put("email", email);
        payload.put("gender", gender);
        payload.put("phone", phone);
        setUpHeaders();
        Response reqApi = request.body(payload.toString()).when().post(endpoint);
        resStatusCode = reqApi.statusCode();
        actualResponse = reqApi;
        return reqApi;
    }

    public static Response overCharacters(String endpoint) {
        String title = generateRandomTitle();
        String firstName = "herbetherbetherbetherbetherbetherbetherbetherbet";
        String lastName = generateLastName();
        String email = generateEmails();
        String gender = generateGender();
        String phone = generatePhoneNumber();

        JSONObject payload = new JSONObject();
        payload.put("title", title);
        payload.put("firstName", firstName);
        payload.put("lastName", lastName);
        payload.put("email", email);
        payload.put("gender", gender);
        payload.put("phone", phone);
        setUpHeaders();
        Response reqApi = request.body(payload.toString()).when().post(endpoint);
        resStatusCode = reqApi.statusCode();
        actualResponse = reqApi;
        return reqApi;
    }

    public static Response blankEmail(String endpoint) {
        String title = generateRandomTitle();
        String firstName = generateFirstName();
        String lastName = generateLastName();
        String email = "";
        String gender = generateGender();
        String phone = generatePhoneNumber();

        JSONObject payload = new JSONObject();
        payload.put("title", title);
        payload.put("firstName", firstName);
        payload.put("lastName", lastName);
        payload.put("email", email);
        payload.put("gender", gender);
        payload.put("phone", phone);
        setUpHeaders();
        Response reqApi = request.body(payload.toString()).when().post(endpoint);
        resStatusCode = reqApi.statusCode();
        actualResponse = reqApi;
        return reqApi;
    }

    public static Response invalidEmail(String endpoint) {
        String title = generateRandomTitle();
        String firstName = generateFirstName();
        String lastName = generateLastName();
        String email = "123324";
        String gender = generateGender();
        String phone = generatePhoneNumber();

        JSONObject payload = new JSONObject();
        payload.put("title", title);
        payload.put("firstName", firstName);
        payload.put("lastName", lastName);
        payload.put("email", email);
        payload.put("gender", gender);
        payload.put("phone", phone);
        setUpHeaders();
        Response reqApi = request.body(payload.toString()).when().post(endpoint);
        resStatusCode = reqApi.statusCode();
        actualResponse = reqApi;
        return reqApi;
    }

    public static Response UpdatedUser(String endpoint) {
        String title = generateRandomTitle();
        String firstName = generateFirstName() + " updated";
        String lastName = generateLastName() + " updated";
        String gender = generateGender();
        String phone = generatePhoneNumber();

        JSONObject payload = new JSONObject();
        payload.put("title", title);
        payload.put("firstName", firstName);
        payload.put("lastName", lastName);
        payload.put("gender", gender);
        payload.put("phone", phone);
        setUpHeaders();
        Response reqApi = request.body(payload.toString()).when().put(endpoint);
        resStatusCode = reqApi.statusCode();
        actualResponse = reqApi;
        return reqApi;
    }

    public static Response deleteUserById(String endpoint) {
        setUpHeaders();
        Response reqApi = request.when().delete(endpoint);
        resStatusCode = reqApi.statusCode();
        actualResponse = reqApi;
        return reqApi;
    }

    public static Response createPost(String endpoint) {
        String image = "https://images.solopos.com/2023/06/rsz_ombak_laut.jpg";
        Number likes = 0;
        String text = "big ocean waves";
        String[] tags = {"nature", "ocean", "sea"};
        String owner = "66a9f196dfd770b1d69c89fe";


        JSONObject payload = new JSONObject();
        payload.put("image", image);
        payload.put("likes", likes);
        payload.put("text", text);
        payload.put("email", tags);
        payload.put("owner", owner);

        setUpHeaders();
        Response reqApi = request.body(payload.toString()).when().post(endpoint);
        resStatusCode = reqApi.statusCode();
        actualResponse = reqApi;

        return reqApi;
    }

    public static Response createPostEmptyOwner(String endpoint) {
        String image = "https://images.solopos.com/2023/06/rsz_ombak_laut.jpg";
        Number likes = 0;
        String text = "big ocean waves";
        String[] tags = {"nature", "ocean", "sea"};
        String owner = "";


        JSONObject payload = new JSONObject();
        payload.put("image", image);
        payload.put("likes", likes);
        payload.put("text", text);
        payload.put("email", tags);
        payload.put("owner", owner);

        setUpHeaders();
        Response reqApi = request.body(payload.toString()).when().post(endpoint);
        resStatusCode = reqApi.statusCode();
        actualResponse = reqApi;

        return reqApi;
    }

    public static Response createPostMaxChar(String endpoint) {
        String image = "https://images.solopos.com/2023/06/rsz_ombak_laut.jpg";
        Number likes = 0;
        String text = "herbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbetherbet";
        String[] tags = {"nature", "ocean", "sea"};
        String owner = "66a9f196dfd770b1d69c89fe";


        JSONObject payload = new JSONObject();
        payload.put("image", image);
        payload.put("likes", likes);
        payload.put("text", text);
        payload.put("email", tags);
        payload.put("owner", owner);

        setUpHeaders();
        Response reqApi = request.body(payload.toString()).when().post(endpoint);
        resStatusCode = reqApi.statusCode();
        actualResponse = reqApi;

        return reqApi;
    }

    public static Response updatePost(String endpoint) {

        String image = "https://cdn0-production-images-kly.akamaized.net/670q5wRuheHgDvHo8sCzFD47VUQ=/1200x900/smart/filters:quality(75):strip_icc():format(webp)/kly-media-production/medias/845563/original/056067800_1428410183-Gunung-SIndoro.jpg";
        Number likes = 0;
        String text = "Mount Sindoro, also known as Mount Sundoro, is a stratovolcano located in Central Java, Indonesia. The mountain has an altitude of about 3,150 meters above sea level and is one of the highest mountains on the island of Java.";
        String[] tags = {"mountain", "hiking", "camp"};

        JSONObject payload = new JSONObject();
        payload.put("image", image);
        payload.put("likes", likes);
        payload.put("text", text);
        payload.put("email", tags);


        setUpHeaders();
        Response reqApi = request.body(payload.toString()).when().put(endpoint);
        resStatusCode = reqApi.statusCode();
        actualResponse = reqApi;

        return reqApi;
    }

    public static Response updateCreatePost(String endpoint, String postId) {

        String image = "https://indonesia-az.com/dieng-si-negeri-di-atas-awan/";
        Number likes = 100;
        String text = "INI SEMUA BUKAN TENTANG GUNUNG";
        String[] tags = {"mountain", "hiking", "camp"};

        JSONObject payload = new JSONObject();
        payload.put("image", image);
        payload.put("likes", likes);
        payload.put("text", text);
        payload.put("email", tags);


        setUpHeaders();

        String baseEndpoint = endpoint.substring(0, endpoint.lastIndexOf("/"));
        String finalEndpoint = baseEndpoint + "/" + postId;
        Response reqApi = request.body(payload.toString()).when().put(finalEndpoint);
        resStatusCode = reqApi.statusCode();
        actualResponse = reqApi;

        return reqApi;
    }

    public static Response deletePost(String endpoint, String postId) {
        setUpHeaders();
        String baseEndpoint = endpoint.substring(0, endpoint.lastIndexOf("/"));
        String finalEndpoint = baseEndpoint + "/" + postId;
        Response reqApi = request.when().delete(finalEndpoint);
        resStatusCode = reqApi.statusCode();
        actualResponse = reqApi;

        return reqApi;
    }

    public static Response hitById(String endpoint) {
        setUpHeaders();
        Response reqApi = request.when().get(endpoint);
        resStatusCode = reqApi.statusCode();
        actualResponse = reqApi;
        return reqApi;
    }

    public static Response createComment(String endpoint) {

        String message = "messi decul";
        String userId = "66a9f196dfd770b1d69c89fe";
        String postId = "66b1dcd35cbce506254b7842";


        JSONObject payload = new JSONObject();
        payload.put("message", message);
        payload.put("owner", userId);
        payload.put("post", postId);

        setUpHeaders();
        Response reqApi = request.body(payload.toString()).when().post(endpoint);
        resStatusCode = reqApi.statusCode();
        actualResponse = reqApi;

        return reqApi;
    }
    public static Response createCommentInvalidIdUser(String endpoint) {

        String message = "big ocean waves";
        String userId = "";
        String postId = "66b1dcd35cbce506254b7842";


        JSONObject payload = new JSONObject();
        payload.put("message", message);
        payload.put("owner", userId);
        payload.put("post", postId);

        setUpHeaders();
        Response reqApi = request.body(payload.toString()).when().post(endpoint);
        resStatusCode = reqApi.statusCode();
        actualResponse = reqApi;

        return reqApi;
    }
    public static Response createCommentInvalidIdPost(String endpoint) {

        String message = "big ocean waves";
        String userId = "66a9f196dfd770b1d69c89fe";
        String postId = "";


        JSONObject payload = new JSONObject();
        payload.put("message", message);
        payload.put("owner", userId);
        payload.put("post", postId);

        setUpHeaders();
        Response reqApi = request.body(payload.toString()).when().post(endpoint);
        resStatusCode = reqApi.statusCode();
        actualResponse = reqApi;

        return reqApi;
    }

    public static Response createCommentMaxMessage(String endpoint) {

        String message = "kinfolk wade awe Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus imperdiet, nulla eu luctus convallis, urna eros fermentum nisi, vel vehicula nulla libero sed augue. Nullam nec ornare turpis. Integer vel metus non felis euismod ultrices a ut magna. Vivamus ac velit et nisl iaculis elementum. Proin ac lacus id elit auctor ultricies a id libero. Morbi ac nibh facilisis, suscipit justo eget, sollicitudin turpis. Fusce pretium nulla id diam sodales, nec tempor elit pretium. Donec quis vestibulum nisl, eget dignissim nisl. Suspendisse potenti. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Donec et tortor sed arcu malesuada luctus ut nec nisl. Sed ac ipsum interdum, vehicula elit at, scelerisque augue. Nam interdum augue sit amet massa viverra, in tincidunt ligula laoreet. Donec nec ligula sit amet purus cursus volutpat. Curabitur accumsan turpis id facilisis consectetur. Sed non justo eu eros eleifend volutpat. Fusce varius elit a dolor elementum, et aliquet metus condimentum.";
        String userId = "66a9f196dfd770b1d69c89fe";
        String postId = "66b1dcd35cbce506254b7842";


        JSONObject payload = new JSONObject();
        payload.put("message", message);
        payload.put("owner", userId);
        payload.put("post", postId);

        setUpHeaders();
        Response reqApi = request.body(payload.toString()).when().post(endpoint);
        resStatusCode = reqApi.statusCode();
        actualResponse = reqApi;

        return reqApi;
    }

    public static Response hitDeleteComment(String endpoint, String commentId) {
        setUpHeaders();
        String baseEndpoint = endpoint.substring(0, endpoint.lastIndexOf("/"));
        String finalEndpoint = baseEndpoint + "/" + commentId;
        Response reqApi = request.when().delete(finalEndpoint);
        resStatusCode = reqApi.statusCode();
        actualResponse = reqApi;

        return reqApi;
    }


}
