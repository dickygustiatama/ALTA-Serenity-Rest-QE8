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

public class ListUserStepDef {

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

    @And("response body should be page {int}")
    public void responseBodyShouldPageShouldBe(int page) {
        SerenityRest.then().body("page", equalTo(page));
    }

    @Then("validate Json Schema list user")
    public void validateJsonSchemaListUser() {
        File jsonSchema = new File(ReqresAPI.JSON_SCHEMA + "/PutListUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

}
