package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class ReqresAPI {
    public static String BASE_URL = "https://reqres.in"; //ini Base URL

    public static final String DIR = System.getProperty("user.dir"); //ini untuk dapatkan location project

    public static String JSON_REQUEST = DIR + "/src/test/resources/JSON/Request"; //untuk path JSON Request

    public static String JSON_SCHEMA = DIR + "/src/test/resources/JSON/JsonSchema"; //untuk path JSON Schema Request
//---------------------------------------------------------------------------------------------------------
    public static String GET_LIST_USERS = BASE_URL + "/api/users?page={page}"; //untuk URL get list users

    public static String POST_CREATE_USER = BASE_URL + "/api/users"; //untuk URL create users

    public static String PUT_UPDATE_USER = BASE_URL + "/api/users/{id}"; //untuk URL update users

    public static String DELETE_USER = BASE_URL + "/api/users/{id}"; //untuk URL delete users

    public static String REGISTER_USER = BASE_URL + "/api/register"; //untuk URL register users

//---------------------------------------------------------------------------------------------------------

    @Step("Get list users")
    public void getListUsers(int page) {
        SerenityRest.given().pathParam("page", page);
    }

    @Step("Post create user")
    public void postCreate(File json) {
        SerenityRest.given()
                    .contentType(ContentType.JSON)
                    .body(json);
    }

    @Step("put update user")
    public void putUpdateUser(int id, File json) {
        SerenityRest.given()
                    .pathParam("id", id)
                    .contentType(ContentType.JSON)
                    .body(json);
    }

    @Step("delete user")
    public void deleteUser(int id) {
        SerenityRest.given()
                    .pathParam("id", id);
    }

    @Step("post register user")
    public void putRegisterUser(int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }
    @Step("post register user")
    public void postRegisterUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

}
