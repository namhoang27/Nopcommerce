package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import starter.navigation.NavigateTo;
import starter.pages.RegisterPage;

import java.util.List;
import java.util.Map;

public class RegisterDefs {
    @Steps
    NavigateTo navigateTo;

    @Steps
    RegisterPage registerPage;

    @Given("I open the home page")
    public void openTheHomePage() {
        navigateTo.openHomePage();
    }

    @Given("I open the admin page")
    public void openTheAdminPage() {
        navigateTo.openTheAdminPage();
    }


    @And("^I should see error message at mandatory fields$")
    public void iShouldSeeErrorMessageAtMandatoryFields() {
        registerPage.verify_error_message_field_firstName();
        registerPage.verify_error_message_field_lastName();
        registerPage.verify_error_message_field_email();
        registerPage.verify_error_message_field_password();
        registerPage.verify_error_message_field_confirm_password();
    }

    @When("^I input information to register an account as below$")
    public void iInputInformationToRegisterAnAccountAsBelow(DataTable dt) {
        List<Map<String, String>> values = dt.asMaps(String.class, String.class);
        for (Map<String, String> column : values) {
            String gender = column.get("Gender");
            String firstName = column.get("First name");
            String lastName = column.get("Last name");
            String day = column.get("Day");
            String month = column.get("Month");
            String year = column.get("Year");
            String email = column.get("Email");
            String companyName = column.get("Company Name");
            String password = column.get("Password");
            String confirmPassword = column.get("Confirm password");

            registerPage.clickToGenderRadioButton(gender);

            registerPage.inputToFirstNameTextbox(firstName);
            registerPage.inputToLastNameTextbox(lastName);

            registerPage.selectDayDropdown(day);
            registerPage.selectMonthDropdown(month);
            registerPage.selectYearDropdown(year);

            registerPage.inputToEmailTextbox(email);
            registerPage.inputToCompanyTextbox(companyName);
            registerPage.inputToPassTextbox(password);
            registerPage.inputToConfirmPassTextbox(confirmPassword);
        }
    }

    @And("^I should see error message with \"([^\"]*)\" fields as \"([^\"]*)\" at Register page$")
    public void iShouldSeeErrorMessageAtFieldsAs(String field, String message) {
        registerPage.verify_message_of_field_at_Register_page(field,message);
    }

    @And("I should see success message is displayed after registering successfully")
    public void iShouldSeeSuccessMessageIsDisplayed() {
        registerPage.verify_register_success_message();
    }
}
