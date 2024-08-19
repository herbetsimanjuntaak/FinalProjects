package pages.api;

import helper.Endpoint;
import helper.Models;
import helper.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.Assert;

import java.io.File;

import static helper.Models.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class GetUserPage {

    public static String setUpUrl, finalEndpoint;


    public void prepareUrlFor(String url) {
        switch (url) {
            case "GET_LIST_USERS":
                setUpUrl = Endpoint.GET_LIST_USERS;
                break;
            case "GET_LIST_USER_BY_ID":
                setUpUrl = Endpoint.GET_LIST_USERS_ID;
                break;
            case "CREATE_NEW_USERS":
                setUpUrl = Endpoint.CREATE_NEW_USERS;
                break;
            case "DELETE_USERS":
                setUpUrl = Endpoint.DELETE_USERS;
                break;
            case "POST_USERS":
                setUpUrl = Endpoint.POST_USERS;
                break;
            case "PATCH_USERS":
                setUpUrl = Endpoint.PATCH_USERS;
                break;
            case "GET_USER_BY_CREATED":
                setUpUrl = Endpoint.GET_USER_BY_CREATED;
                break;
            case "GET_DATA_WRONG_ID":
                setUpUrl = Endpoint.GET_DATA_WRONG_ID;
                break;
            case "GET_ENDPOINT_WRONG":
                setUpUrl = Endpoint.GET_ENDPOINT_WRONG;
                break;
            case "CREATE_POST":
                setUpUrl = Endpoint.CREATE_POST;
                break;
            case "GET_LIST_POST":
                setUpUrl = Endpoint.GET_LIST_POST;
                break;
            case "GET_LIST_POST_BY_USER_ID":
                setUpUrl = Endpoint.GET_LIST_POST_BY_USER_ID;
                break;
            case "UPDATE_POST":
                setUpUrl = Endpoint.UPDATE_POST;
                break;
            case "GET_LIST_COMMENT":
                setUpUrl = Endpoint.GET_LIST_COMMENT;
                break;
            case "CREATE_COMMENT":
                setUpUrl = Endpoint.CREATE_COMMENT;
                break;
            default:
                System.out.println("input valid url :)");
        }
    }


    public void hitAPIGetListUsers() {
        response = Models.getListUsers(setUpUrl);
    }

    public void hitAPIBlankHeader() {
        response = Models.blankHeader(setUpUrl);
    }

    public void validationStatusCodeIsEquals(Integer status_code) {
        assertThat(response.statusCode()).isEqualTo(status_code);
    }

    public void validationResponseBodyGetListUsers() {
        System.out.println(response.getBody().asString());
        String id = response.jsonPath().getString("data[0].id");
        assertThat(id).isNotNull();

        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("data"));
    }

    public void validationResponseJsonWithJSONSchema(String fileName) {
        File JSONFile = Utility.getJSONSchemaFile(fileName);
        actualResponse.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }

    public void prepareValidId(String id) {
        finalEndpoint = setUpId(setUpUrl, id);
    }

    public void hitAPIGetUserById() {
        response = hitUserById(finalEndpoint);
    }

    public void validationResponseBodyGetUserById() {
        String firstName = response.jsonPath().getString("firstName");
        assertThat(firstName).isIn("Delbert updated");

        String responseBody = response.getBody().asString();
        assertTrue(responseBody.contains("Delbert updated"));
        System.out.println(responseBody);
    }

    public void responseBodyInvalidEndpoint() {
        String responseBody = actualResponse.getBody().asString();
        System.out.println(actualResponse.getBody().asString());
        assertTrue(responseBody.contains("error"));
    }

    public void hitAPIGetListUsersWithParamsPage(String params, String limit) {
        response = hitUserParams(setUpUrl, params, limit);
        System.out.println(response.getBody().asString());
    }

    public void hitAPIGetListUsersWithParamFirstName(String firstName, String lastName) {
        response = hitUserParamsFirstName(setUpUrl, firstName, lastName);
        System.out.println(response.getBody().asString());
    }

    public void validateParams(String firstName, String lastName) {
        String responseBody = response.getBody().asString();
        assertTrue(responseBody.contains(firstName));
        assertTrue(responseBody.contains(lastName));
        System.out.println(response.getBody().asString());
        System.out.println(firstName + " dan ini adalah " + lastName);
    }

    public void validatePage(String page, String limit) {
        String pages = response.jsonPath().getString("page");
        String limits = response.jsonPath().getString("limit");
        assertThat(pages).isIn(page);
        assertThat(limits).isIn(limit);
        System.out.println("page respon = " + pages);
        System.out.println("limits respon = " + limits);
    }

}
