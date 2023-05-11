package starter.pages;


import org.junit.Assert;

public class MyAccountPage extends BasePage {
    public void select_tab_of_my_account_options(String tab) {
        String xPathTab = "//div[@class='block block-account-navigation']//strong[contains(text(),'My account')]/parent::div/following-sibling::div[@class='listbox']//a[text()='"+tab+"']";
        waitToElementClickable(xPathTab);
        clickToElement(xPathTab);
    }

    public void verify_value_of_gender_radiobutton(String tab) {

    }

    public void verify_value_of_fistname_textbox(String firstName) {
        String xpathFirstNameTB = "//input[@id='FirstName']";
        waitToElementVisible(xpathFirstNameTB);
        String value = getElementAttribute(xpathFirstNameTB,"value");
        Assert.assertEquals(value,firstName);
    }

    public void verify_value_of_lastname_textbox(String lastName) {
        String xpathLastNameTB = "//input[@id='LastName']";
        waitToElementVisible(xpathLastNameTB);
        String value = getElementAttribute(xpathLastNameTB,"value");
        Assert.assertEquals(value,lastName);
    }

    public void verify_value_of_day_dropdown(String day) {
        String xpathDay = "//select[@name='DateOfBirthDay']";
        waitToElementVisible(xpathDay);
        String value = getFirstSelectedTextInDropdown(xpathDay);
        Assert.assertEquals(value,day);
    }

    public void verify_value_of_month_dropdown(String month) {
        String xpathMonth = "//select[@name='DateOfBirthMonth']";
        waitToElementVisible(xpathMonth);
        String value = getFirstSelectedTextInDropdown(xpathMonth);
        Assert.assertEquals(value,month);
    }

    public void verify_value_of_year_dropdown(String year) {
        String xpathYear = "//select[@name='DateOfBirthYear']";
        waitToElementVisible(xpathYear);
        String value = getFirstSelectedTextInDropdown(xpathYear);
        Assert.assertEquals(value,year);
    }

    public void verify_value_of_email_textbox(String email) {
        String xpathEmailTB = "//input[@id='Email']";
        waitToElementVisible(xpathEmailTB);
        String value = getElementAttribute(xpathEmailTB,"value");
        Assert.assertEquals(value,email);
    }

    public void verify_value_of_companyName_textbox(String companyName) {
        String xpathCompanyTB = "//input[@id='Company']";
        waitToElementVisible(xpathCompanyTB);
        String value = getElementAttribute(xpathCompanyTB,"value");
        Assert.assertEquals(value,companyName);
    }
}
