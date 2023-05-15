package starter.navigation;


import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import starter.interfaces.NavigationPageUI;
import starter.pages.BasePage;

public class NavigateTo extends BasePage {
    public static final By LOGIN_LINK = By.xpath("//a[@class='ico-login']");
    public static final By LOGOUT_LINK = By.xpath("//a[@class='ico-logout']");
    public static final By REGISTER_LINK = By.xpath("//a[@class='ico-register']");
    public static final By MYACCOUNT_LINK = By.xpath("//a[@class='ico-account']");

    public void openHomePage() {
        openUrl("https://demo.nopcommerce.com/");
    }

    public void closeApplication() {
        getDriver().quit();
    }

    public void i_click_on_login_link() {
        $(LOGIN_LINK).waitUntilClickable();
        $(LOGIN_LINK).click();
    }

    public void i_click_on_register_link() {
        $(REGISTER_LINK).waitUntilClickable();
        $(REGISTER_LINK).click();
    }

    public void i_click_on_myAccount_link() {
        $(MYACCOUNT_LINK).waitUntilClickable();
        $(MYACCOUNT_LINK).click();
    }

    public void i_click_on_logout_link() {
        $(LOGOUT_LINK).waitUntilClickable();
        $(LOGOUT_LINK).click();
    }
}
