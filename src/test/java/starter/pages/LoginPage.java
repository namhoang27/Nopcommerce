package starter.pages;

import org.junit.Assert;
import starter.interfaces.LoginPageUI;

public class LoginPage extends BasePage {


    public void i_click_on_login_button() {
        waitToElementClickable(LoginPageUI.LOGIN_BUTTON);
        clickToElement(LoginPageUI.LOGIN_BUTTON);
    }

    public void verify_message_of_field_at_Login_page(String email, String message) {
        switch (email) {
            case "empty email":
            case "invalid email":
                waitToElementVisible(LoginPageUI.EMAIL_ERROR_TEXTBOX);
                Assert.assertEquals(getElementText(LoginPageUI.EMAIL_ERROR_TEXTBOX), message);
                break;
            default:
                waitToElementVisible(LoginPageUI.EXIST_EMAIL_ERROR);
                Assert.assertEquals(getElementText(LoginPageUI.EXIST_EMAIL_ERROR), message);
        }
    }

    public void inputToEmailTextbox( String email) {
        waitToElementVisible( LoginPageUI.EMAIL_TEXTBOX);
        sendkeyToElement( LoginPageUI.EMAIL_TEXTBOX, email);
    }

    public void inputToPasswordTextbox( String password) {
        waitToElementVisible( LoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement( LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public void verify_login_successfully() {
        waitABit(1000);
        Assert.assertEquals(getCurrentPageTitle(),"nopCommerce demo store");
        Assert.assertTrue(isElementDisplayed("//a[@class='ico-account']"));
    }
}
