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

public class ReqresStepDef {

    @Steps
    ReqresAPI reqresAPI;
    private File jsonSchema;

    @Then("should return status code {int}")
    public void shouldReturnStatusCode(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("response body name should be {string} and job {string}")
    public void responseBodyNameShouldBeAndJob(String name, String job) {
        SerenityRest.then()
                    .body("name", equalTo(name))
                    .body("job", equalTo(job));
    }

    @And("validate json schema update user")
    public void validateJsonSchemaUpdateUser() {
        File jsonschema = new File(ReqresAPI.JSON_SCHEMA + "/PutUpdateUserSchema.sjon");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

}