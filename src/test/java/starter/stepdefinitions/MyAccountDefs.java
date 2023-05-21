package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;
import starter.navigation.NavigateTo;
import starter.pages.MyAccountPage;
import starter.pages.RegisterPage;

import java.util.List;
import java.util.Map;

public class MyAccountDefs {
    @Steps
    MyAccountPage myAccountPage;

    @Steps
    RegisterPage registerPage;
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

    @Then("I click Save button after update customer info")
    public void iClickSaveButtonAfterUpdateCustomerInfo() {
        myAccountPage.click_save_btn();
    }

    @Then("I should see success message is displayed {string}")
    public void iShouldSeeSuccessMessageIsDisplayed(String message) {
        myAccountPage.verify_message_save_info_successfully(message);
    }

    @When("I update information of an account as below")
    public void iUpdateInformationOfAnAccountAsBelow(DataTable dt) {
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
            registerPage.clickToGenderRadioButton(gender);

            registerPage.inputToFirstNameTextbox(firstName);
            registerPage.inputToLastNameTextbox(lastName);

            registerPage.selectDayDropdown(day);
            registerPage.selectMonthDropdown(month);
            registerPage.selectYearDropdown(year);

            registerPage.inputToEmailTextbox(email);
            registerPage.inputToCompanyTextbox(companyName);
        }
    }

    @Then("I click on Add new Address button")
    public void iClickOnAddNewAddressButton() {
        myAccountPage.click_add_new_btn();
    }

    @And("I input information of addresses as below")
    public void iInputInformationOfAddressesAsBelow(DataTable dt) {
        List<Map<String, String>> values = dt.asMaps(String.class, String.class);
        for (Map<String, String> column : values) {
            String firstName = column.get("First name");
            String lastName = column.get("Last name");
            String email = column.get("Email");
            String company = column.get("Company");
            String country = column.get("Country");
            String state = column.get("State / province");
            String city = column.get("City");
            String address_1 = column.get("Address 1");
            String address_2 = column.get("Address 2");
            String zip_code = column.get("Zip / Postal code");
            String phone_number = column.get("Phone number");
            String fax_number = column.get("Fax number");

            myAccountPage.inputToFirstNameTextbox(firstName);
            myAccountPage.inputToLastNameTextbox(lastName);
            myAccountPage.inputToEmailTextbox(email);
            myAccountPage.inputToCompanyTextbox(company);
            myAccountPage.inputToCountryDropdown(country);
            myAccountPage.inputToStateDropdown(state);
            myAccountPage.inputToCityTextbox(city);
            myAccountPage.inputToAddress1Textbox(address_1);
            myAccountPage.inputToAddress2Textbox(address_2);
            myAccountPage.inputToZipCodeTextbox(zip_code);
            myAccountPage.inputToPhoneTextbox(phone_number);
            myAccountPage.inputToFaxTextbox(fax_number);
        }
    }

    @And("I verify the information of addresses have just inputted display as below")
    public void iVerifyTheInformationOfAddressesHaveJustInputtedDisplayAsBelow(DataTable dt) {
        List<Map<String, String>> values = dt.asMaps(String.class, String.class);
        for (Map<String, String> column : values) {
            String name = column.get("Name");
            String email = column.get("Email");
            String phone = column.get("Phone");
            String fax = column.get("Fax");
            String company = column.get("Company");
            String address1 = column.get("Address1");
            String address2 = column.get("Address2");
            String city_zip = column.get("City-Zip");
            String country = column.get("Country");

            myAccountPage.verify_value_name_address(name);
            myAccountPage.verify_value_email_address(email);
            myAccountPage.verify_value_phone_address(phone);
            myAccountPage.verify_value_fax_address(fax);
            myAccountPage.verify_value_company_address(company);
            myAccountPage.verify_value_address1_address(address1);
            myAccountPage.verify_value_address2_address(address2);
            myAccountPage.verify_value_cityZip_address(city_zip);
            myAccountPage.verify_value_country_address(country);
        }
    }

    @And("I click Save button after inputting address")
    public void iClickSaveButtonAfterInputtingAddress() {
        myAccountPage.click_save_address();
    }

    @Then("I click on Change Password button")
    public void iClickOnChangePasswordButton() {
        myAccountPage.click_change_password();
    }

    @And("I input information of change password as below")
    public void iInputInformationOfChangePasswordAsBelow(DataTable dt) {
        List<Map<String, String>> values = dt.asMaps(String.class, String.class);
        for (Map<String, String> column : values) {
            String Old_pass = column.get("Old password");
            String New_pass = column.get("New password");
            String Confirm_pass = column.get("Confirm password");

            myAccountPage.inputToOldPassword(Old_pass);
            myAccountPage.inputToNewPassword(New_pass);
            myAccountPage.inputToConfirmPassword(Confirm_pass);
        }
    }

    @And("I dismiss the popup message")
    public void iDismissThePopupMessage() {
        myAccountPage.dismiss_popup();
    }

    @And("I select {string} of {string} option tab")
    public void iSelectOfOptionTab(String subList, String headerMenu) {
        myAccountPage.i_hover_on_headerMenu(headerMenu);
        myAccountPage.i_select_subList(subList);
    }

    @And("I select product name {string}")
    public void iSelectProductName(String product) {
        myAccountPage.i_select_product(product);
    }

    @And("I click {string} option")
    public void iClickOption(String option) {
        myAccountPage.i_click_option_in_a_product(option);
    }


    @And("I input information for write review as below")
    public void iInputInformationForWriteReviewAsBelow(DataTable dt) {
        List<Map<String, String>> values = dt.asMaps(String.class, String.class);
        for (Map<String, String> column : values) {
            String review_title = column.get("Review title");
            String review_text = column.get("Review text");
            String rating = column.get("Rating");

            myAccountPage.inputToReviewTitleTB(review_title);
            myAccountPage.inputToReviewTextTA(review_text);
            myAccountPage.inputValueForRating(rating);
        }
    }

    @Then("I click on Submit review button")
    public void iClickOnSubmitReviewButton() {
        myAccountPage.click_submit_review_btn();
    }

    @And("I should see success message after reviewing {string}")
    public void productReviewIsSuccessfully(String message) {
        myAccountPage.verify_message_add_review_succesfully(message);
    }

    @And("I verify information for review product at My product reviews as below")
    public void iVerifyInformationForReviewProductAtMyProductReviewsAsBelow(DataTable dt) {
        List<Map<String, String>> values = dt.asMaps(String.class, String.class);
        for (Map<String, String> column : values) {
            String product_is_reviewed = column.get("Product is reviewed");
            String review_title = column.get("Review title");
            String review_text = column.get("Review text");
            String rating = column.get("Rating");

            myAccountPage.verify_value_product_review(review_title, product_is_reviewed);
            myAccountPage.verify_value_title_review(review_title);
            myAccountPage.verify_value_text_review(review_title, review_text);
            myAccountPage.verify_value_rating_review(review_title, rating);
        }
    }
}
