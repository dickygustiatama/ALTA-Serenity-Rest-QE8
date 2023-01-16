package starter.reqres.StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import jdk.nashorn.internal.parser.JSONParser;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class RegisterUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("post register user with valid json email and password")
    public void putRegisterUserWithValidJson() {
        File json = new File(ReqresAPI.JSON_REQUEST + "/RequestRegister.json");
        reqresAPI.postRegisterUser(json);
    }

    @Given("post register user with invalid json email and password")
    public void putRegisterUserWithInvalidJson() {
        File json = new File(ReqresAPI.JSON_REQUEST + "/RequestRegisterInvalid.json");
        reqresAPI.postRegisterUser(json);
    }


    @When("send request valid register user")
    public void sendRequestValidRegisterUser() {
        SerenityRest.when().post(ReqresAPI.REGISTER_USER);
    }

    @When("send request register user")
    public void sendRequestRegisterUser() {
        SerenityRest.when().post(ReqresAPI.REGISTER_USER);
    }

    @When("send request invalid register user")
    public void sendRequestInvalidRegisterUser() {
        SerenityRest.when().post(ReqresAPI.REGISTER_USER);
    }

    @And("response body name should be id {int} and token {string}")
    public void responseBodyNameShouldBeIdAndToken(Integer id, String token) {
        SerenityRest.then()
                .body("id", equalTo(id))
                .body("token", equalTo(token));
    }

    @Then("validate json schema register user")
    public void validateJsonSchemaRegisterUser() {
        File jsonSchema = new File(ReqresAPI.JSON_SCHEMA + "/PutRegisterUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Then("validate json schema invalid register user")
    public void validateJsonSchemaInvalidRegisterUser() {
        File jsonSchema = new File(ReqresAPI.JSON_SCHEMA + "/PutRegisterUserInvalidSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
