package starter.reqres.StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class RegisterUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("put register user with valid json with id {int}")
    public void putRegisterUserWithValidJsonWithId(int id) {
        File json = new File(ReqresAPI.JSON_REQUEST + "/api/register{id}");
        reqresAPI.postRegisterUser(id);
    }

    @When("send request register user with email {string} and password {string}")
    public void sendRequestRegisterUser(string email, string password) {
        SerenityRest.when()
                .body("eemail", equalTo(email))
                .body("password", equalTo(password));
    }
}
