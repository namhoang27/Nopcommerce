package starter.pages;

import org.junit.Assert;
import starter.interfaces.RegisterPageUI;

public class RegisterPage extends BasePage {



    public void i_click_on_register_button() {
        waitToElementClickable(RegisterPageUI.REGISTER_BUTTON);
        clickToElement(RegisterPageUI.REGISTER_BUTTON);
    }

    public void verify_error_message_field_firstName() {
        waitToElementVisible(RegisterPageUI.FIRSTNAME_ERROR_TEXTBOX);
        Assert.assertEquals(getElementText(RegisterPageUI.FIRSTNAME_ERROR_TEXTBOX), "First name is required.");
    }

    public void verify_error_message_field_lastName() {
        waitToElementVisible(RegisterPageUI.LASTNAME_ERROR_TEXTBOX);
        Assert.assertEquals(getElementText(RegisterPageUI.LASTNAME_ERROR_TEXTBOX), "Last name is required.");
    }

    public void verify_error_message_field_email() {
        waitToElementVisible(RegisterPageUI.EMAIL_ERROR_TEXTBOX);
        Assert.assertEquals(getElementText(RegisterPageUI.EMAIL_ERROR_TEXTBOX), "Email is required.");
    }

    public void verify_error_message_field_password() {
        waitToElementVisible(RegisterPageUI.PASSWORD_ERROR_TEXTBOX);
        Assert.assertEquals(getElementText(RegisterPageUI.PASSWORD_ERROR_TEXTBOX), "Password is required.");
    }

    public void verify_error_message_field_confirm_password() {
        waitToElementVisible(RegisterPageUI.CONFIRM_PASSWORD_ERROR_TEXTBOX);
        Assert.assertEquals(getElementText(RegisterPageUI.CONFIRM_PASSWORD_ERROR_TEXTBOX), "Password is required.");
    }

    public void clickToGenderRadioButton(String gender) {
        if (gender.equals("Male")) {
            waitToElementVisible(RegisterPageUI.GENDER_MALE_RADIO);
            clickToElement(RegisterPageUI.GENDER_MALE_RADIO);
        }
        if (gender.equals("Female")) {
            waitToElementVisible(RegisterPageUI.GENDER_FEMALE_RADIO);
            clickToElement(RegisterPageUI.GENDER_FEMALE_RADIO);
        }
    }

    public void inputToFirstNameTextbox(String firstName) {
        waitToElementVisible(RegisterPageUI.FIRSTNAME_TEXTBOX);
        sendkeyToElement(RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
    }

    public void inputToLastNameTextbox(String lastName) {
        waitToElementVisible(RegisterPageUI.LASTNAME_TEXTBOX);
        sendkeyToElement(RegisterPageUI.LASTNAME_TEXTBOX, lastName);
    }

    public void selectDayDropdown(String day) {
        waitToElementClickable(RegisterPageUI.DAY_DROPDOWN);
        selectItemInDropdown(RegisterPageUI.DAY_DROPDOWN, day);

    }

    public void selectMonthDropdown(String month) {
        waitToElementClickable(RegisterPageUI.MONTH_DROPDOWN);
        selectItemInDropdown(RegisterPageUI.MONTH_DROPDOWN, month);

    }

    public void selectYearDropdown(String year) {
        waitToElementClickable(RegisterPageUI.YEAR_DROPDOWN);
        selectItemInDropdown(RegisterPageUI.YEAR_DROPDOWN, year);

    }

    public void inputToEmailTextbox(String email) {
        waitToElementVisible(RegisterPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(RegisterPageUI.EMAIL_TEXTBOX, email);

    }

    public void inputToCompanyTextbox(String companyName) {
        waitToElementVisible(RegisterPageUI.COMPANY_TEXTBOX);
        sendkeyToElement(RegisterPageUI.COMPANY_TEXTBOX, companyName);

    }

    public void inputToPassTextbox(String password) {
        waitToElementVisible(RegisterPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(RegisterPageUI.PASSWORD_TEXTBOX, password);

    }

    public void inputToConfirmPassTextbox(String confirmPassword) {
        waitToElementVisible(RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendkeyToElement(RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);

    }

    public void verify_message_of_field_at_Register_page(String field, String message) {
        switch (field) {
            case "invalid email":
                waitToElementVisible(RegisterPageUI.EMAIL_ERROR_TEXTBOX);
                Assert.assertEquals(getElementText(RegisterPageUI.EMAIL_ERROR_TEXTBOX), message);
                break;
            case "email is exist":
                waitToElementVisible(RegisterPageUI.EXIST_EMAIL_ERROR);
                Assert.assertEquals(getElementText(RegisterPageUI.EXIST_EMAIL_ERROR), message);
                break;
            case "invalid password":
                waitToElementVisible(RegisterPageUI.PASSWORD_ERROR_TEXTBOX);
                Assert.assertEquals(getElementText(RegisterPageUI.PASSWORD_ERROR_TEXTBOX).replaceAll("\n"," "), message);
                break;
            default:
                waitToElementVisible(RegisterPageUI.CONFIRM_PASSWORD_ERROR_TEXTBOX);
                Assert.assertEquals(getElementText(RegisterPageUI.CONFIRM_PASSWORD_ERROR_TEXTBOX), message);
        }
    }

    public String verify_register_success_message() {
        waitToElementVisible(RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
        return getElementText(RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }
}
