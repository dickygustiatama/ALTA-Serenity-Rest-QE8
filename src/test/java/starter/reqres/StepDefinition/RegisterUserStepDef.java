package starter.reqres.StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
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
        File json = new File(ReqresAPI.JSON_REQUEST + "/RegisterRequest.json");
        reqresAPI.postRegisterUser(json);
    }

    @When("send request register user")
    public void sendRequestRegisterUser() {
        SerenityRest.when().post(ReqresAPI.REGISTER_USER);
    }
}
