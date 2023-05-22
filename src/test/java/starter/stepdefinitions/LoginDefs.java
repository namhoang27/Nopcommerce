package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

    @When("I click on {string} link")
    public void iClickOnLink(String link) {
        navigateTo.i_click_on_link(link);
    }

    @And("I should see error message with {string} fields as {string} at Login page")
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
