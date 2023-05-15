package starter.pages;

import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    public static final By LOGIN_BUTTON = By.xpath("//button[normalize-space()='Log in']");
    public static final By EMAIL_ERROR_TEXTBOX = By.xpath("//span[@id='Email-error']");

    public static final By EXIST_EMAIL_ERROR = By.xpath("//div[@class='message-error validation-summary-errors']");

    public static final By PASSWORD_ERROR_TEXTBOX = By.xpath("");
    public static final By EMAIL_TEXTBOX = By.xpath("//input[@id='Email']");
    public static final By PASSWORD_TEXTBOX = By.xpath("//input[@id='Password']");

    public void i_click_on_login_button() {
        $(LOGIN_BUTTON).waitUntilClickable();
        $(LOGIN_BUTTON).click();
    }

    public void verify_message_of_field_at_Login_page(String email, String message) {
        switch (email) {
            case "empty email":
            case "invalid email":
                $(EMAIL_ERROR_TEXTBOX).waitUntilVisible();
                Assert.assertEquals($(EMAIL_ERROR_TEXTBOX).getText().trim().replaceAll("\n", " "), message);
                break;
            default:
                $(EXIST_EMAIL_ERROR).waitUntilVisible();
                Assert.assertEquals($(EXIST_EMAIL_ERROR).getText().trim().replaceAll("\n", " "), message);
        }
    }

    public void inputToEmailTextbox(String email) {
        $(EMAIL_TEXTBOX).waitUntilVisible();
        $(EMAIL_TEXTBOX).clear();
        $(EMAIL_TEXTBOX).sendKeys(email);
    }

    public void inputToPasswordTextbox(String password) {
        $(PASSWORD_TEXTBOX).waitUntilVisible();
        $(PASSWORD_TEXTBOX).clear();
        $(PASSWORD_TEXTBOX).sendKeys(password);
    }

    public void verify_login_successfully() {
        waitABit(1000);
        Assert.assertEquals(getTitle(), "nopCommerce demo store");
        Assert.assertTrue($("//a[@class='ico-account']").isDisplayed());
    }
}
