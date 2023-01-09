package starter.reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class ReqresStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("get list user with page {int}")
    public void getListUserWithPage(int page) {
        reqresAPI.getListUsers(page);
    }

    @When("send request get list user")
    public void sendRequestGetListUser() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS);
    }

    @Then("should return status code {int}")
    public void shouldReturnStatusCode(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("response body should page should be {int}")
    public void responseBodyShouldPageShouldBe(int page) {
        SerenityRest.then().body("page", equalTo(page));
    }

    @Given("post create user with valid json")
    public void postCreateUserWithValidJson() {
        File json = new File(ReqresAPI.JSON_REQUEST + "/RequestUser.json");
        reqresAPI.postCreate(json);
    }

    @When("send request post create user")
    public void sendRequestPostCreateUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USER);
    }

    @And("response body name should be {string} and job {string}")
    public void responseBodyNameShouldBeAndJob(String name, String job) {
        SerenityRest.then()
                    .body("name", equalTo(name))
                    .body("job", equalTo(job));
    }

    @Given("put update user with valid json with id {int}")
    public void putUpdateUserWithValidJsonWithId(int id) {
        File json = new File(ReqresAPI.JSON_REQUEST + "RequestUser.json");
                reqresAPI.putUpdateUser(id, json);
    }

    @When("send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }

    @Given("delete user with valid id {int}")
    public void deleteUserWithValidId(int id) {
        reqresAPI.deleteUser(id);
    }

    @When("send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }

}