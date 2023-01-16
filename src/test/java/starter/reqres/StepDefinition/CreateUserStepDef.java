package starter.reqres.StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class CreateUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("post create user with valid json")
    public void postCreateUserWithValidJson() {
        File json = new File(ReqresAPI.JSON_REQUEST + "/RequestCreateUser.json");
        reqresAPI.postCreate(json);
    }

    @Given("post create user without fill user job field json")
    public void postCreateUserWithoutFillUserJobFieldJson() {
        File json = new File(ReqresAPI.JSON_REQUEST + "/RequestCreateUserWithoutFillJobField.json");
        reqresAPI.postCreate(json);
    }

    @Given("post create user without fill user name field json")
    public void postCreateUserWithoutFillUserNameFieldJson() {
        File json = new File(ReqresAPI.JSON_REQUEST + "/RequestCreateUserWithoutFillNameField.json");
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

    @And("response body should be {string}")
    public void responseBodyNameShouldBeAndJob(String name) {
        SerenityRest.then()
                .body("name", equalTo(name));
    }

    @When("send request post create user without fill user job field")
    public void sendRequestPostCreateUserWithoutFillUserJobField() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USER);
    }

    @When("send request post create user without fill user name field")
    public void sendRequestPostCreateUserWithoutFillUserNameField() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USER);
    }

    @Then("validate json schema create user without fill user job field")
    public void validateJsonSchemaCreateUserWithoutFillUserJobField() {
        File jsonSchema = new File(ReqresAPI.JSON_SCHEMA + "/PutCreateUserWithoutFillJobFieldSchema.json");;
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Then("validate json schema create user without fill user name field")
    public void validateJsonSchemaCreateUserWithoutFillUserNameField() {
        File jsonSchema = new File(ReqresAPI.JSON_SCHEMA + "/PutCreateUserWithoutFillNameFieldSchema.json");;
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Then("validate json schema create user")
    public void validateJsonSchemaCreateUser() {
        File jsonSchema = new File(ReqresAPI.JSON_SCHEMA + "/PutCreateUserSchema.json");;
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @And("response body name should be {string} without job status")
    public void responseBodyNameShouldBeWitoutJobStatus(String name) {
        SerenityRest.then()
                .body("name", equalTo(name));
    }

    @And("response body job should be {string} without name")
    public void responseBodyJobShouldBeWithoutName(String job) {
        SerenityRest.then()
                .body("job", equalTo(job));
    }
}
