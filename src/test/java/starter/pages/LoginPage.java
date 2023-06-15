package starter.pages;

import org.junit.*;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoginPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    public static final By EMAIL_ERROR_TEXTBOX = By.xpath("//span[@id='Email-error']");

    public static final By EXIST_EMAIL_ERROR = By.xpath("//div[@class='message-error validation-summary-errors']");

    public static final By PASSWORD_ERROR_TEXTBOX = By.xpath("");
    public static final By EMAIL_TEXTBOX = By.xpath("//input[@id='Email']");
    public static final By PASSWORD_TEXTBOX = By.xpath("//input[@id='Password']");


    public void verify_message_of_field_at_Login_page(String email, String message) {
        switch (email) {
            case "empty email":
            case "invalid email":
                $(EMAIL_ERROR_TEXTBOX).waitUntilVisible();
                Assert.assertEquals($(EMAIL_ERROR_TEXTBOX).getText().trim().replaceAll("\n", " "), message);
                logger.info("Xpath email error textbox {}",EMAIL_ERROR_TEXTBOX);
                break;
            default:
                $(EXIST_EMAIL_ERROR).waitUntilVisible();
                Assert.assertEquals($(EXIST_EMAIL_ERROR).getText().trim().replaceAll("\n", " "), message);
                logger.info("Xpath email error textbox {}",EXIST_EMAIL_ERROR);
        }
    }

    public void inputToEmailTextbox(String email) {
        $(EMAIL_TEXTBOX).waitUntilVisible();
        $(EMAIL_TEXTBOX).sendKeys(email);
        logger.info("Input to email textbox value: "+email);
        logger.info("{}",EMAIL_TEXTBOX);
    }

    public void inputToPasswordTextbox(String password) {
        $(PASSWORD_TEXTBOX).waitUntilVisible();
        $(PASSWORD_TEXTBOX).sendKeys(password);
        logger.info("Input to password textbox value: "+password);
        logger.info("{}",PASSWORD_TEXTBOX);
    }

    public void verify_login_successfully() {
        waitABit(1000);
        Assert.assertEquals(getTitle(), "nopCommerce demo store");
        Assert.assertTrue($("//a[@class='ico-account']").isDisplayed());
        logger.info("Login succesfully");
    }
}
