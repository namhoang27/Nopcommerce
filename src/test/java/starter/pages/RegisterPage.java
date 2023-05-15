package starter.pages;

import org.junit.Assert;
import org.openqa.selenium.By;

public class RegisterPage extends BasePage {
    public static final By GENDER_MALE_RADIO = By.xpath("//input[@id='gender-male']");
    public static final By GENDER_FEMALE_RADIO = By.xpath("//input[@id='gender-female']");
    public static final By FIRSTNAME_TEXTBOX = By.xpath("//input[@id='FirstName']");
    public static final By LASTNAME_TEXTBOX = By.xpath("//input[@id='LastName']");
    public static final By COMPANY_TEXTBOX = By.xpath("//input[@id='Company']");
    public static final By EMAIL_TEXTBOX = By.xpath("//input[@id='Email']");
    public static final By PASSWORD_TEXTBOX = By.xpath("//input[@id='Password']");
    public static final By CONFIRM_PASSWORD_TEXTBOX = By.xpath("//input[@id='ConfirmPassword']");
    public static final By REGISTER_BUTTON = By.xpath("//button[@id='register-button']");
    public static final By DAY_DROPDOWN = By.xpath("//select[@name='DateOfBirthDay']");
    public static final By MONTH_DROPDOWN = By.xpath("//select[@name='DateOfBirthMonth']");
    public static final By YEAR_DROPDOWN = By.xpath("//select[@name='DateOfBirthYear']");
    public static final By REGISTER_SUCCESS_MESSAGE = By.xpath("//div[@class='result']");


    public static final By FIRSTNAME_ERROR_TEXTBOX = By.xpath("//span[@id='FirstName-error']");
    public static final By LASTNAME_ERROR_TEXTBOX = By.xpath("//span[@id='LastName-error']");
    public static final By EMAIL_ERROR_TEXTBOX = By.xpath("//span[@id='Email-error']");
    public static final By EXIST_EMAIL_ERROR = By.xpath("//div[@class='message-error validation-summary-errors']");
    public static final By PASSWORD_ERROR_TEXTBOX = By.xpath("//span[@id='Password-error']");
    public static final By CONFIRM_PASSWORD_ERROR_TEXTBOX = By.xpath("//span[@id='ConfirmPassword-error']");


    public void i_click_on_register_button() {
        $(REGISTER_BUTTON).waitUntilClickable();
        $(REGISTER_BUTTON).click();
//        waitToElementClickable(RegisterPageUI.REGISTER_BUTTON);
//        clickToElement(RegisterPageUI.REGISTER_BUTTON);
    }

    public void verify_error_message_field_firstName() {
        $(FIRSTNAME_ERROR_TEXTBOX).waitUntilVisible();
        Assert.assertEquals($(FIRSTNAME_ERROR_TEXTBOX).getText().trim(), "First name is required.");
    }

    public void verify_error_message_field_lastName() {
        $(LASTNAME_ERROR_TEXTBOX).waitUntilVisible();
        Assert.assertEquals($(LASTNAME_ERROR_TEXTBOX).getText().trim(), "Last name is required.");
    }

    public void verify_error_message_field_email() {
        $(EMAIL_ERROR_TEXTBOX).waitUntilVisible();
        Assert.assertEquals($(EMAIL_ERROR_TEXTBOX).getText().trim(), "Email is required.");
    }

    public void verify_error_message_field_password() {
        $(PASSWORD_ERROR_TEXTBOX).waitUntilVisible();
        Assert.assertEquals($(PASSWORD_ERROR_TEXTBOX).getText().trim(), "Password is required.");
    }

    public void verify_error_message_field_confirm_password() {
        $(CONFIRM_PASSWORD_ERROR_TEXTBOX).waitUntilVisible();
        Assert.assertEquals($(CONFIRM_PASSWORD_ERROR_TEXTBOX).getText().trim(), "Password is required.");
    }

    public void clickToGenderRadioButton(String gender) {
        if (gender.equals("Male")) {
            $(GENDER_MALE_RADIO).waitUntilVisible();
            $(GENDER_MALE_RADIO).click();
        }
        if (gender.equals("Female")) {
            $(GENDER_FEMALE_RADIO).waitUntilVisible();
            $(GENDER_FEMALE_RADIO).click();
        }
    }

    public void inputToFirstNameTextbox(String firstName) {
        $(FIRSTNAME_TEXTBOX).waitUntilVisible();
        $(FIRSTNAME_TEXTBOX).clear();
        $(FIRSTNAME_TEXTBOX).sendKeys(firstName);
    }

    public void inputToLastNameTextbox(String lastName) {
        $(LASTNAME_TEXTBOX).waitUntilVisible();
        $(LASTNAME_TEXTBOX).clear();
        $(LASTNAME_TEXTBOX).sendKeys(lastName);
    }

    public void selectDayDropdown(String day) {
        $(DAY_DROPDOWN).waitUntilClickable();
        $(DAY_DROPDOWN).selectByVisibleText(day);
    }

    public void selectMonthDropdown(String month) {
        $(MONTH_DROPDOWN).waitUntilClickable();
        $(MONTH_DROPDOWN).selectByVisibleText(month);
    }

    public void selectYearDropdown(String year) {
        $(YEAR_DROPDOWN).waitUntilClickable();
        $(YEAR_DROPDOWN).selectByVisibleText(year);
    }

    public void inputToEmailTextbox(String email) {
        $(EMAIL_TEXTBOX).waitUntilVisible();
        $(EMAIL_TEXTBOX).clear();
        $(EMAIL_TEXTBOX).sendKeys(email);
    }

    public void inputToCompanyTextbox(String companyName) {
        $(COMPANY_TEXTBOX).waitUntilVisible();
        $(COMPANY_TEXTBOX).clear();
        $(COMPANY_TEXTBOX).sendKeys(companyName);
    }

    public void inputToPassTextbox(String password) {
        $(PASSWORD_TEXTBOX).waitUntilVisible();
        $(PASSWORD_TEXTBOX).clear();
        $(PASSWORD_TEXTBOX).sendKeys(password);
    }

    public void inputToConfirmPassTextbox(String confirmPassword) {
        $(CONFIRM_PASSWORD_TEXTBOX).waitUntilVisible();
        $(CONFIRM_PASSWORD_TEXTBOX).clear();
        $(CONFIRM_PASSWORD_TEXTBOX).sendKeys(confirmPassword);
    }

    public void verify_message_of_field_at_Register_page(String field, String message) {
        switch (field) {
            case "invalid email":
                $(EMAIL_ERROR_TEXTBOX).waitUntilVisible();
                Assert.assertEquals($(EMAIL_ERROR_TEXTBOX).getText().trim(), message);
                break;
            case "email is exist":
                $(EXIST_EMAIL_ERROR).waitUntilVisible();
                Assert.assertEquals($(EXIST_EMAIL_ERROR).getText().trim(), message);
                break;
            case "invalid password":
                $(PASSWORD_ERROR_TEXTBOX).waitUntilVisible();
                Assert.assertEquals($(PASSWORD_ERROR_TEXTBOX).getText().trim().replaceAll("\n", " "), message);
                break;
            default:
                $(CONFIRM_PASSWORD_ERROR_TEXTBOX).waitUntilVisible();
                Assert.assertEquals($(CONFIRM_PASSWORD_ERROR_TEXTBOX).getText().trim(), message);
        }
    }

    public String verify_register_success_message() {
        $(REGISTER_SUCCESS_MESSAGE).waitUntilVisible();
        return $(REGISTER_SUCCESS_MESSAGE).getText().trim();
    }
}
