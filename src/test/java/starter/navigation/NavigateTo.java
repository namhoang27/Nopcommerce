package starter.navigation;


import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import starter.pages.BasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NavigateTo extends BasePage {
    public static final By LOGIN_LINK = By.xpath("//a[@class='ico-login']");
    public static final By LOGOUT_LINK = By.xpath("//a[@class='ico-logout']");
    public static final By REGISTER_LINK = By.xpath("//a[@class='ico-register']");
    public static final By MYACCOUNT_LINK = By.xpath("//a[@class='ico-account']");
    public static final By SEARCH_BUTTON = By.xpath("//button[@class='button-1 search-button']");
    public static final By LOGIN_BUTTON = By.xpath("//button[normalize-space()='Log in']");
    public static final By REGISTER_BUTTON = By.xpath("//button[@id='register-button']");

    private static final Logger logger = LoggerFactory.getLogger(NavigateTo.class);

    public void openHomePage() {
        openUrl("https://demo.nopcommerce.com/");
        logger.info("Open Website https://demo.nopcommerce.com");
    }


    public void i_click_on_link(String link) {
        switch (link){
            case "Login":
                $(LOGIN_LINK).waitUntilClickable();
                $(LOGIN_LINK).click();
                logger.info("Clicked on Login Link. {}",LOGIN_LINK);
                break;
            case"Register":
                $(REGISTER_LINK).waitUntilClickable();
                $(REGISTER_LINK).click();
                logger.info("Clicked on Register Link. {}",REGISTER_LINK);
                break;
            case"My Account":
                $(MYACCOUNT_LINK).waitUntilClickable();
                $(MYACCOUNT_LINK).click();
                logger.info("Clicked on My Account Link. {}",MYACCOUNT_LINK);
                break;
            case"Logout":
                $(LOGOUT_LINK).waitUntilClickable();
                $(LOGOUT_LINK).click();
                logger.info("Clicked on My Account Link. {}",LOGOUT_LINK);
                break;
            default:
                logger.error("Inputted invalid Link label!!!");
                logger.info("List button: Login, Register, My Acoount");
                break;
        }
    }


    public void clickOnButton(String button) {
        switch (button){
            case "Search":
                $(SEARCH_BUTTON).waitUntilClickable();
                $(SEARCH_BUTTON).click();
                logger.info("Clicked on Search Button {}",SEARCH_BUTTON);
                break;
            case "Register":
                $(REGISTER_BUTTON).waitUntilClickable();
                $(REGISTER_BUTTON).click();
                logger.info("Clicked on Register Button {}",REGISTER_BUTTON);
                break;
            case "Login":
                $(LOGIN_BUTTON).waitUntilClickable();
                $(LOGIN_BUTTON).click();
                logger.info("Clicked on Login Button {}",LOGIN_BUTTON);
                break;
            default:
                logger.error("Inputted invalid button label!!!");
                logger.info("List button: Login, Register, Search");
                break;
        }
    }
}
