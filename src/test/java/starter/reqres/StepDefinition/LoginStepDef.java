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

public class LoginStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("post login user with valid json email and password")
    public void putLoginUserWithValidJson() {
        File json = new File(ReqresAPI.JSON_REQUEST + "/RequestLogin.json");
        reqresAPI.postRegisterUser(json);
    }

    @Given("post login user with invalid password json")
    public void putLoginUserWithInvalidPasswordJson() {
        File json = new File(ReqresAPI.JSON_REQUEST + "/RequestLoginInvalidPassword.json");
        reqresAPI.postRegisterUser(json);
    }

    @When("send request login user")
    public void sendRequestLoginUser() {
        SerenityRest.when().post(ReqresAPI.LOGIN_USER);
    }

    @When("send request invalid login user")
    public void sendRequestInvalidLoginUser() {
        SerenityRest.when().post(ReqresAPI.LOGIN_USER);
    }

    @Then("validate json schema login user")
    public void validateJsonSchemaLoginUser() {
        File jsonSchema = new File(ReqresAPI.JSON_SCHEMA + "/PutLoginUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Then("validate json schema invalid login user")
    public void validateJsonSchemaInvalidLoginUser() {
        File jsonSchema = new File(ReqresAPI.JSON_SCHEMA + "/PutLoginUserInvalidSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @And("response body name should be token {string}")
    public void responseBodyNameShouldBeToken(String token) {
        SerenityRest.then()
                .body("token", equalTo(token));
    }

}
