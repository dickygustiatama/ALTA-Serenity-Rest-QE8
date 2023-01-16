package starter.reqres.StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;

public class DeleteUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("delete user with valid id {int}")
    public void deleteUserWithValidId(int id) {
        reqresAPI.deleteUser(id);
    }

    @Given("delete user with invalid id {int}")
    public void deleteUserWithInvalidId(int id) {
        reqresAPI.deleteUser(id);
    }


    @When("send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }
}
