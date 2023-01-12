package starter.reqres.StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;

import java.io.File;

public class UpdateUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("put update user with valid json with id {int}")
    public void putUpdateUserWithValidJsonWithId(int id) {
        File json = new File(ReqresAPI.JSON_REQUEST + "/RequestUser.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @When("send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }

}
