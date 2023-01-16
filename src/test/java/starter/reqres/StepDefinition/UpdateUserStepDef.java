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

public class UpdateUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("put update user with valid json with id {int}")
    public void putUpdateUserWithValidJsonWithId(int id) {
        File json = new File(ReqresAPI.JSON_REQUEST + "/RequestUpdateUser.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @Given("put update user with invalid json with id {int}")
    public void putUpdateUserWithInvalidJsonWithId(int id) {
        File json = new File(ReqresAPI.JSON_REQUEST + "/RequestUpdateInvalidUser.json");
        reqresAPI.putUpdateUser(id, json);
    }


    @When("send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }

    @Then("validate json schema update user")
    public void validateJsonSchemaUpdateUser() {
        File jsonSchema = new File(ReqresAPI.JSON_SCHEMA + "/PutUpdateUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

}
