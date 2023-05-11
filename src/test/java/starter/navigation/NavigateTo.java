package starter.navigation;


import net.thucydides.core.annotations.Step;
import starter.interfaces.NavigationPageUI;
import starter.pages.BasePage;

public class NavigateTo extends BasePage {
    public void openHomePage() {
        openUrl("https://demo.nopcommerce.com/");
    }

    public void closeApplication() {
        getDriver().quit();
    }

    public void i_click_on_login_link() {
        waitToElementClickable(NavigationPageUI.LOGIN_LINK);
        clickToElement(NavigationPageUI.LOGIN_LINK);
    }

    public void i_click_on_register_link() {
        waitToElementClickable(NavigationPageUI.REGISTER_LINK);
        clickToElement(NavigationPageUI.REGISTER_LINK);
    }

    public void i_click_on_myAccount_link() {
        waitToElementClickable(NavigationPageUI.MYACCOUNT_LINK);
        clickToElement(NavigationPageUI.MYACCOUNT_LINK);
    }
}
