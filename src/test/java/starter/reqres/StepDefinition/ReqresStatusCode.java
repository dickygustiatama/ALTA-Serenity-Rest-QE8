package starter.reqres.StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class ReqresStatusCode {

    @Steps
    ReqresAPI reqresAPI;
    private File jsonSchema;

    @Then("should return status code {int}")
    public void shouldReturnStatusCode(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("response body name should be {string}")
    public void responseBodyNameShouldBe(String text) {
        SerenityRest.then()
                .body("error", equalTo(text));
    }

}