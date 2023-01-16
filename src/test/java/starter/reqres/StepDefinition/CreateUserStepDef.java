package starter.reqres.StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;

import java.io.File;

public class CreateUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("post create user with valid json")
    public void postCreateUserWithValidJson() {
        File json = new File(ReqresAPI.JSON_REQUEST + "/RequestUser.json");
        reqresAPI.postCreate(json);
    }

    @When("send request post create user")
    public void sendRequestPostCreateUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USER);
    }

    @Then("validate json schema create user")
    public void validateJsonSchemaCreateUser() {
        File jsonSchema = new File(ReqresAPI.JSON_SCHEMA + "/CreateUserSchema.json");;
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
