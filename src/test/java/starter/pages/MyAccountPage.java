package starter.pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyAccountPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(MyAccountPage.class);
    public void select_tab_of_my_account_options(String tab) {
        String xPathTab = "//div[@class='block block-account-navigation']//strong[contains(text(),'My account')]/parent::div/following-sibling::div[@class='listbox']//a[text()='" + tab + "']";
        $(xPathTab).waitUntilClickable();
        $(xPathTab).click();
        logger.info("Selected tab "+tab+" on My Account options");
        logger.info("Locator of selected tab {}",xPathTab);
    }

    public void verify_value_of_gender_radiobutton(String tab) {

    }

    public void verify_value_of_fistname_textbox(String firstName) {
        String xpathFirstNameTB = "//input[@id='FirstName']";
        $(xpathFirstNameTB).waitUntilVisible();
        String value = $(xpathFirstNameTB).getAttribute("value");
        Assert.assertEquals(value, firstName);
        logger.info("Locator of FirstName textbox {}",xpathFirstNameTB);
    }

    public void verify_value_of_lastname_textbox(String lastName) {
        String xpathLastNameTB = "//input[@id='LastName']";
        $(xpathLastNameTB).waitUntilVisible();
        String value = $(xpathLastNameTB).getAttribute("value");
        Assert.assertEquals(value, lastName);
        logger.info("Locator of LastName textbox {}",xpathLastNameTB);
    }

    public void verify_value_of_day_dropdown(String day) {
        String xpathDay = "//select[@name='DateOfBirthDay']";
        $(xpathDay).waitUntilVisible();
        String value = $(xpathDay).getFirstSelectedOptionVisibleText();

        Assert.assertEquals(value, day);
    }

    public void verify_value_of_month_dropdown(String month) {
        String xpathMonth = "//select[@name='DateOfBirthMonth']";
        $(xpathMonth).waitUntilVisible();
        String value = $(xpathMonth).getFirstSelectedOptionVisibleText();
        Assert.assertEquals(value, month);
    }

    public void verify_value_of_year_dropdown(String year) {
        String xpathYear = "//select[@name='DateOfBirthYear']";
        $(xpathYear).waitUntilVisible();
        String value = $(xpathYear).getFirstSelectedOptionVisibleText();
        Assert.assertEquals(value, year);
    }

    public void verify_value_of_email_textbox(String email) {
        String xpathEmailTB = "//input[@id='Email']";
        $(xpathEmailTB).waitUntilVisible();
        String value = $(xpathEmailTB).getAttribute("value");
        Assert.assertEquals(value, email);
    }

    public void verify_value_of_companyName_textbox(String companyName) {
        String xpathCompanyTB = "//input[@id='Company']";
        $(xpathCompanyTB).waitUntilVisible();
        String value = $(xpathCompanyTB).getAttribute("value");
        Assert.assertEquals(value, companyName);
        logger.info("Locator of Company textbox {}",xpathCompanyTB);
    }

    public void click_save_btn() {
        $("//button[@id='save-info-button']").waitUntilClickable();
        $("//button[@id='save-info-button']").click();
        logger.info("Clicked Save button {}","//button[@id='save-info-button']");
    }

    public void verify_message_save_info_successfully(String message) {
        $("//p[@class='content']").waitUntilVisible();
        Assert.assertEquals($("//p[@class='content']").getText().trim(), message);
    }

    public void click_add_new_btn() {
        $("//button[normalize-space()='Add new']").waitUntilClickable();
        $("//button[normalize-space()='Add new']").click();
        logger.info("Clicked Add New button {}","//button[normalize-space()='Add new']");
    }

    public void inputToFirstNameTextbox(String firstName) {
        $("//input[@id='Address_FirstName']").waitUntilVisible();
        $("//input[@id='Address_FirstName']").clear();
        $("//input[@id='Address_FirstName']").sendKeys(firstName);
        logger.info("Input to FirstName textbox value: "+firstName);
        logger.info("Locator of FirstName textbox {}","//input[@id='Address_FirstName']");
    }

    public void inputToLastNameTextbox(String lastName) {
        $("//input[@id='Address_LastName']").waitUntilVisible();
        $("//input[@id='Address_LastName']").clear();
        $("//input[@id='Address_LastName']").sendKeys(lastName);
        logger.info("Input to LastName textbox value: "+lastName);
        logger.info("Locator of Lastname textbox {}","//input[@id='Address_LastName']");
    }

    public void inputToEmailTextbox(String email) {
        $("//input[@id='Address_Email']").waitUntilVisible();
        $("//input[@id='Address_Email']").clear();
        $("//input[@id='Address_Email']").sendKeys(email);
        logger.info("Input to email textbox value: "+email);
        logger.info("Locator of Email textbox {}","//input[@id='Address_Email']");
    }

    public void inputToCompanyTextbox(String company) {
        $("//input[@id='Address_Company']").waitUntilVisible();
        $("//input[@id='Address_Company']").clear();
        $("//input[@id='Address_Company']").sendKeys(company);
        logger.info("Input to Company textbox value: "+company);
        logger.info("Locator of Company textbox {}","//input[@id='Address_Company']");
    }

    public void inputToCountryDropdown(String country) {
        $("//select[@id='Address_CountryId']").waitUntilClickable();
        $("//select[@id='Address_CountryId']").selectByVisibleText(country);
        logger.info("Selected Country dropdown value: "+country);
        logger.info("Locator of Country dropdown {}","//select[@id='Address_CountryId']");
    }

    public void inputToStateDropdown(String state) {
        $("//select[@id='Address_StateProvinceId']").waitUntilClickable();
        $("//select[@id='Address_StateProvinceId']").selectByVisibleText(state);
        logger.info("Selected State dropdown value: "+state);
    }

    public void inputToCityTextbox(String city) {
        $("//input[@id='Address_City']").waitUntilVisible();
        $("//input[@id='Address_City']").clear();
        $("//input[@id='Address_City']").sendKeys(city);
        logger.info("Input to City textbox value: "+city);
        logger.info("Locator of City textbox {}","//input[@id='Address_City']");
    }

    public void inputToAddress1Textbox(String address_1) {
        $("//input[@id='Address_Address1']").waitUntilVisible();
        $("//input[@id='Address_Address1']").clear();
        $("//input[@id='Address_Address1']").sendKeys(address_1);
        logger.info("Input to Address 1 textbox value: "+address_1);
        logger.info("Locator of Address 1 textbox {}","//input[@id='Address_Address1']");
    }

    public void inputToAddress2Textbox(String address_2) {
        $("//input[@id='Address_Address2']").waitUntilVisible();
        $("//input[@id='Address_Address2']").clear();
        $("//input[@id='Address_Address2']").sendKeys(address_2);
        logger.info("Input to Address 2 textbox value: "+address_2);
        logger.info("Locator of Address 2 textbox {}","//input[@id='Address_Address2']");
    }

    public void inputToZipCodeTextbox(String zip_code) {
        $("//input[@id='Address_ZipPostalCode']").waitUntilVisible();
        $("//input[@id='Address_ZipPostalCode']").clear();
        $("//input[@id='Address_ZipPostalCode']").sendKeys(zip_code);
        logger.info("Input to Zip_Postal code textbox value: "+zip_code);
        logger.info("Locator of Zip code textbox {}","//input[@id='Address_ZipPostalCode']");
    }

    public void inputToPhoneTextbox(String phone_number) {
        $("//input[@id='Address_PhoneNumber']").waitUntilVisible();
        $("//input[@id='Address_PhoneNumber']").clear();
        $("//input[@id='Address_PhoneNumber']").sendKeys(phone_number);
        logger.info("Input to Phone number textbox value: "+phone_number);
        logger.info("Locator of Phone textbox {}","//input[@id='Address_PhoneNumber']");
    }

    public void inputToFaxTextbox(String fax_number) {
        $("//input[@id='Address_FaxNumber']").waitUntilVisible();
        $("//input[@id='Address_FaxNumber']").clear();
        $("//input[@id='Address_FaxNumber']").sendKeys(fax_number);
        logger.info("Input to fax number textbox value: "+fax_number);
        logger.info("Locator of Fax textbox {}","//input[@id='Address_FaxNumber']");
    }

    public void click_save_address() {
        $("//button[normalize-space()='Save']").waitUntilClickable();
        $("//button[normalize-space()='Save']").click();
        logger.info("Clicked save address {}","//button[normalize-space()='Save']");
    }

    public void verify_value_name_address(String name) {
        $("//li[@class='name']").waitUntilVisible();
        Assert.assertEquals($("//li[@class='name']").getText(),name);
        logger.info("Locator of Name Textbox {}","//li[@class='name']");
    }

    public void verify_value_email_address(String email) {
        $("//li[@class='email']").waitUntilVisible();
        Assert.assertEquals($("//li[@class='email']").getText(),"Email: "+email);
        logger.info("Locator of Email Textbox {}","//li[@class='email']");
    }

    public void verify_value_phone_address(String phone) {
        $("//li[@class='phone']").waitUntilVisible();
        Assert.assertEquals($("//li[@class='phone']").getText(),"Phone number: "+phone);
        logger.info("Locator of Phone Textbox {}","//li[@class='phone']");
    }

    public void verify_value_fax_address(String fax) {
        $("//li[@class='fax']").waitUntilVisible();
        Assert.assertEquals($("//li[@class='fax']").getText(),"Fax number: "+fax);
        logger.info("Locator of Fax Textbox {}","//li[@class='fax']");
    }

    public void verify_value_company_address(String company) {
        $("//li[@class='company']").waitUntilVisible();
        Assert.assertEquals($("//li[@class='company']").getText(),company);
        logger.info("Locator of Company Textbox {}","//li[@class='company']");
    }

    public void verify_value_address1_address(String address1) {
        $("//li[@class='address1']").waitUntilVisible();
        Assert.assertEquals($("//li[@class='address1']").getText(),address1);
        logger.info("Locator of address1 Textbox {}","//li[@class='address1']");
    }

    public void verify_value_address2_address(String address2) {
        $("//li[@class='address2']").waitUntilVisible();
        Assert.assertEquals($("//li[@class='address2']").getText(),address2);
        logger.info("Locator of address2 Textbox {}","//li[@class='address2']");
    }

    public void verify_value_cityZip_address(String city_zip) {
        $("//li[@class='city-state-zip']").waitUntilVisible();
        Assert.assertEquals($("//li[@class='city-state-zip']").getText(),city_zip);
        logger.info("Locator of cityZip Textbox {}","//li[@class='city-state-zip']");
    }

    public void verify_value_country_address(String country) {
        $("//li[@class='country']").waitUntilVisible();
        Assert.assertEquals($("//li[@class='country']").getText(),country);
        logger.info("Locator of Country Textbox {}","//li[@class='country']");
    }

    public void click_change_password() {
        $("//button[normalize-space()='Change password']").waitUntilClickable();
        $("//button[normalize-space()='Change password']").click();
    }

    public void inputToOldPassword(String oldPass) {
        $("//input[@id='OldPassword']").waitUntilVisible();
        $("//input[@id='OldPassword']").clear();
        $("//input[@id='OldPassword']").sendKeys(oldPass);
    }

    public void inputToNewPassword(String newPass) {
        $("//input[@id='NewPassword']").waitUntilVisible();
        $("//input[@id='NewPassword']").clear();
        $("//input[@id='NewPassword']").sendKeys(newPass);
    }

    public void inputToConfirmPassword(String confirmPass) {
        $("//input[@id='ConfirmNewPassword']").waitUntilVisible();
        $("//input[@id='ConfirmNewPassword']").clear();
        $("//input[@id='ConfirmNewPassword']").sendKeys(confirmPass);
    }

    public void dismiss_popup() {
        $("//span[@title='Close']").waitUntilClickable();
        $("//span[@title='Close']").click();

    }

    public void i_hover_on_headerMenu(String headerMenu) {
        $("//ul[@class='top-menu notmobile']//a[normalize-space()='" + headerMenu + "']").waitUntilVisible();
        hoverMouseToElement("//ul[@class='top-menu notmobile']//a[normalize-space()='" + headerMenu + "']");
//        moveTo($("//ul[@class='top-menu notmobile']//a[normalize-space()='" + headerMenu + "']"));
    }

    public void i_select_subList(String subList) {
        $("//ul[@class='top-menu notmobile']//a[normalize-space()='" + subList + "']").waitUntilClickable();
        $("//ul[@class='top-menu notmobile']//a[normalize-space()='" + subList + "']").click();
    }

    public void i_select_product(String product) {
        String xpathProduct = "//h2[@class='product-title']//a[contains(text(),'" + product + "')]";
        scrollToElement(xpathProduct);
        $(xpathProduct).click();
    }

    public void i_click_option_in_a_product(String option) {
        $("//a[normalize-space()='" + option + "']").waitUntilVisible();
        $("//a[normalize-space()='" + option + "']").click();
    }

    public void inputToReviewTitleTB(String reviewTitle) {
        $("//input[@id='AddProductReview_Title']").waitUntilClickable();
        $("//input[@id='AddProductReview_Title']").clear();
        $("//input[@id='AddProductReview_Title']").sendKeys(reviewTitle);
    }

    public void inputToReviewTextTA(String reviewText) {
        $("//textarea[@id='AddProductReview_ReviewText']").waitUntilClickable();
        $("//textarea[@id='AddProductReview_ReviewText']").clear();
        $("//textarea[@id='AddProductReview_ReviewText']").sendKeys(reviewText);
    }

    public void inputValueForRating(String rating) {
        $("//div[@class='rating-options']/input[@value='" + rating + "']").click();
    }

    public void click_submit_review_btn() {
        $("//button[normalize-space()='Submit review']").waitUntilClickable();
        $("//button[normalize-space()='Submit review']").click();
    }

    public void verify_message_add_review_succesfully(String message) {
        $("//div[@class='result']").waitUntilVisible();
        Assert.assertEquals($("//div[@class='result']").getText().trim(), message);
    }

    public void verify_value_product_review(String review_title,String productIsReviewed) {
        String xpathProduct = "//div[@class='review-item-head']//div[@class='review-title']/strong[.='"+review_title+"']/ancestor::div[@class='product-review-item']//div[@class='review-info']//a";
        Assert.assertEquals($(xpathProduct).getText(),productIsReviewed);
    }

    public void verify_value_title_review(String reviewTitle) {
        $("div[class='review-title'] strong").waitUntilVisible();
        Assert.assertEquals($("div[class='review-title'] strong").getText().trim(),reviewTitle);
    }

    public void verify_value_text_review(String review_title,String reviewText) {
        String xpathText = "//div[@class='review-item-head']//div[@class='review-title']/strong[.='"+review_title+"']/ancestor::div[@class='product-review-item']//div[@class='review-text']";
        Assert.assertEquals($(xpathText).getText().trim(),reviewText);
    }

    public void verify_value_rating_review(String review_title,String rating) {
        WebElement xpathRating = $("//div[@class='review-title']/strong[.='"+review_title+"']/ancestor::div[@class='review-item-head']//div[@class='rating']/div");
        switch (rating) {
            case "1":
                Assert.assertEquals(xpathRating.getAttribute("style"),"width: 20%;");
                break;
            case "2":
                Assert.assertEquals(xpathRating.getAttribute("style"),"width: 40%;");
                break;
            case "3":
                Assert.assertEquals(xpathRating.getAttribute("style"),"width: 60%;");
                break;
            case "4":
                Assert.assertEquals(xpathRating.getAttribute("style"),"width: 80%;");
                break;
            default:
                Assert.assertEquals(xpathRating.getAttribute("style"),"width: 100%;");
        }
    }
}
