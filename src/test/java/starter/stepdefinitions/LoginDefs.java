package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import starter.navigation.NavigateTo;
import starter.pages.LoginPage;

import java.util.List;
import java.util.Map;

public class LoginDefs {
    @Steps
    LoginPage loginPage;

    @Steps
    NavigateTo navigateTo;

    @Given("^I click on Login link$")
    public void iClickOnLoginLink() {
        navigateTo.i_click_on_login_link();
    }

    @Then("I click on Login button")
    public void iClickOnLoginButton() {
        loginPage.i_click_on_login_button();
    }

    @And("^I should see error message with \"([^\"]*)\" fields as \"([^\"]*)\" at Login page$")
    public void iShouldSeeErrorMessageWithFieldsAsAtLoginPage(String email, String message) {
        loginPage.verify_message_of_field_at_Login_page(email, message);
    }

    @And("I input information to login as below")
    public void iInputInformationToLoginAsBelow(DataTable dt) {
        List<Map<String, String>> values = dt.asMaps(String.class, String.class);
        for (Map<String, String> column : values) {
            String email = column.get("Email");
            String password = column.get("Password");

            loginPage.inputToEmailTextbox(email);
            loginPage.inputToPasswordTextbox(password);
        }
    }

    @And("I should see Login successfully and navigate to home page")
    public void iShouldSeeLoginSuccessfullyAndNavigateToHomePage() {

        loginPage.verify_login_successfully();
    }
}
