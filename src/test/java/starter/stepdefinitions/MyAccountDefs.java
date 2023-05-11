package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;
import starter.navigation.NavigateTo;
import starter.pages.MyAccountPage;

import java.util.List;
import java.util.Map;

public class MyAccountDefs {
    @Steps
    MyAccountPage myAccountPage;

    @Steps
    NavigateTo navigateTo;

    @And("^I click on \"([^\"]*)\" tab of My account option$")
    public void iClickOnTabOfMyAccountOptions(String tab) {
        myAccountPage.select_tab_of_my_account_options(tab);
    }

    @When("^I should see the information of customer info as below$")
    public void iSeeInformationCustomerInfoAsBelow(DataTable dt) {
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

            //myAccountPage.verify_value_of_gender_radiobutton(gender);
            myAccountPage.verify_value_of_fistname_textbox(firstName);
            myAccountPage.verify_value_of_lastname_textbox(lastName);

            myAccountPage.verify_value_of_day_dropdown(day);
            myAccountPage.verify_value_of_month_dropdown(month);
            myAccountPage.verify_value_of_year_dropdown(year);

            myAccountPage.verify_value_of_email_textbox(email);
            myAccountPage.verify_value_of_companyName_textbox(companyName);
        }
    }

    @Then("I click on My Account link")
    public void iClickOnMyAccountLink() {
        navigateTo.i_click_on_myAccount_link();
    }
}
