package starter.pages;import org.junit.Assert;import org.slf4j.Logger;import org.slf4j.LoggerFactory;public class OrderPage extends BasePage {    private static final Logger logger = LoggerFactory.getLogger(OrderPage.class);    public void iAddProductToCart() {        $("//div[@class='add-to-cart']//button[text()='Add to cart']").waitUntilClickable();        $("//div[@class='add-to-cart']//button[text()='Add to cart']").click();        logger.info("Clicked on Add to Cart button");    }    public void edit_product_quantity(String product, String quantity) {        String xpath = "//td[@class='product'][contains(.,'" + product + "')]/parent::tr//td[@class='quantity']//input";        $(xpath).clear();        $(xpath).sendKeys(quantity);        logger.info("Update quantity ={}", quantity);    }    public void click_button_at_ShoppingCart(String button) {        $("//button[normalize-space()='" + button + "']").waitUntilClickable();        $("//button[normalize-space()='" + button + "']").click();        logger.info("Clicked on button {} at Shopping cart page", button);    }    public void verifyValueOfSubTotal(String subTotal) {        $("tr[class='order-subtotal'] span[class='value-summary']").waitUntilVisible();        String actualValue = $("tr[class='order-subtotal'] span[class='value-summary']").getText();        Assert.assertEquals(subTotal, actualValue);    }    public void verifyValueOfTotal(String total) {        $("span[class='value-summary'] strong").waitUntilVisible();        String actualValue = $("span[class='value-summary'] strong").getText();        Assert.assertEquals(total, actualValue);    }    public void verifyUserAtShoppingCartPage() {        waitABit(1000);        Assert.assertEquals(getTitle(), "nopCommerce demo store. Shopping Cart");        Assert.assertTrue($("//h1[normalize-space()='Shopping cart']").isDisplayed());        logger.info("At Shopping Cart page");    }    public void verifyProductIsNotDisplayedAtShoppingCart(String product) {        String xPathList = "//td[@class='product']//a[normalize-space()='" + product + "']";        Assert.assertTrue(getList(xPathList).isEmpty());        logger.info("Product is removed: {}", product);    }    public void tickCheckBoxAgree() {        $("//input[@id='termsofservice']").waitUntilClickable();        $("//input[@id='termsofservice']").click();        logger.info("Ticked agree with the terms of service checkbox");    }    public void selectCountryOnCheckout(String country) {        $("//select[@id='BillingNewAddress_CountryId']").waitUntilClickable();        $("//select[@id='BillingNewAddress_CountryId']").selectByVisibleText(country);        logger.info("Selected country at Check out page {}", country);    }    public void selectStateOnCheckout(String state) {        $("//select[@id='BillingNewAddress_StateProvinceId']").waitUntilClickable();        $("//select[@id='BillingNewAddress_StateProvinceId']").selectByVisibleText(state);        logger.info("Selected State / provice at Check out page {}", state);    }    public void inputCityOnCheckout(String city) {        $("//input[@id='BillingNewAddress_City']").waitUntilVisible();        $("//input[@id='BillingNewAddress_City']").clear();        $("//input[@id='BillingNewAddress_City']").sendKeys(city);        logger.info("Inputted City: {}", city);    }    public void inputAddress1OnCheckout(String address1) {        $("//input[@id='BillingNewAddress_Address1']").waitUntilVisible();        $("//input[@id='BillingNewAddress_Address1']").clear();        $("//input[@id='BillingNewAddress_Address1']").sendKeys(address1);        logger.info("Inputted Address 1: {}", address1);    }    public void inputZipCodeOnCheckout(String zipCode) {        $("//input[@id='BillingNewAddress_ZipPostalCode']").waitUntilVisible();        $("//input[@id='BillingNewAddress_ZipPostalCode']").clear();        $("//input[@id='BillingNewAddress_ZipPostalCode']").sendKeys(zipCode);        logger.info("Inputted Zip code: {}", zipCode);    }    public void inputPhoneNumberOnCheckout(String phoneNumber) {        $("//input[@id='BillingNewAddress_PhoneNumber']").waitUntilVisible();        $("//input[@id='BillingNewAddress_PhoneNumber']").clear();        $("//input[@id='BillingNewAddress_PhoneNumber']").sendKeys(phoneNumber);        logger.info("Inputted Phone number: {}", phoneNumber);    }    public void inputFaxNumberOnCheckout(String faxNumber) {        $("//input[@id='BillingNewAddress_FaxNumber']").waitUntilVisible();        $("//input[@id='BillingNewAddress_FaxNumber']").clear();        $("//input[@id='BillingNewAddress_FaxNumber']").sendKeys(faxNumber);        logger.info("Inputted Fax number: {}", faxNumber);    }    public void click_continue_button(String step) {        switch (step) {            case "1-Billing address":                $("//button[@onclick='Billing.save()']").waitUntilClickable();                $("//button[@onclick='Billing.save()']").click();                logger.info("Clicked Continue button at step {}", step);                break;            case "3-Shipping method":                $("//button[@class='button-1 shipping-method-next-step-button']").waitUntilClickable();                $("//button[@class='button-1 shipping-method-next-step-button']").click();                logger.info("Clicked Continue button at step {}", step);                break;            case "4-Payment method":                $("//button[@class='button-1 payment-method-next-step-button']").waitUntilClickable();                $("//button[@class='button-1 payment-method-next-step-button']").click();                logger.info("Clicked Continue button at step {}", step);                break;            case "5-Payment information":                $("//button[@class='button-1 payment-info-next-step-button']").waitUntilClickable();                $("//button[@class='button-1 payment-info-next-step-button']").click();                logger.info("Clicked Continue button at step {}", step);                break;            default:                $("//button[normalize-space()='Confirm']").waitUntilClickable();                $("//button[normalize-space()='Confirm']").click();                logger.info("Clicked Continue button at step {}", step);                break;        }    }    public void verify_stand_at_step(String method) {        String xpath = "//li[contains(@class,'tab-section allow active')]//h2[text()='" + method + "']";        Assert.assertTrue($(xpath).isDisplayed());        logger.info("Stand at {}", method);    }    public void select_option_method(String option) {        String xpath = "//div[@class='method-name']//label[contains(.,'" + option + "')]/parent::div/input";        $(xpath).waitUntilClickable();        $(xpath).click();        logger.info("Clicked on option {}", option);    }    public void verify_payment_information() {        $("//div[@class='section payment-info']//tbody//tr//p[2]").waitUntilVisible();        String info = $("//div[@class='section payment-info']//tbody//tr//p[2]").getText().replace("\n"," ");        Assert.assertEquals("NOP SOLUTIONS your address here, New York, NY 10001 USA",info);    }    public void verify_name_of_billing_address(String name) {        String actual = $("//div[@class='billing-info']//li[@class='name']").getText().trim();        Assert.assertEquals(name,actual);        logger.info("Verified name of billing address: {}", name);    }    public void verify_email_of_billing_address(String email) {        String actual = $("//div[@class='billing-info']//li[@class='email']").getText().trim();        Assert.assertEquals("Email: "+email,actual);        logger.info("Verified email of billing address: {}", email);    }    public void verify_phone_of_billing_address(String phone) {        String actual = $("//div[@class='billing-info']//li[@class='phone']").getText().trim();        Assert.assertEquals("Phone: "+phone,actual);        logger.info("Verified phone of billing address: {}", phone);    }    public void verify_fax_of_billing_address(String fax) {        String actual = $("//div[@class='billing-info']//li[@class='fax']").getText().trim();        Assert.assertEquals("Fax: "+fax,actual);        logger.info("Verified fax of billing address: {}", fax);    }    public void verify_company_of_billing_address(String company) {        String actual = $("//div[@class='billing-info']//li[@class='company']").getText().trim();        Assert.assertEquals(company,actual);        logger.info("Verified company of billing address: {}", company);    }    public void verify_address1_of_billing_address(String address1) {        String actual = $("//div[@class='billing-info']//li[@class='address1']").getText().trim();        Assert.assertEquals(address1,actual);        logger.info("Verified address1 of billing address: {}", address1);    }    public void verify_city_of_billing_address(String city) {        String actual = $("//div[@class='billing-info']//li[@class='city-state-zip']").getText().trim();        Assert.assertEquals(city,actual);        logger.info("Verified city-state-zip of billing address: {}", city);    }    public void verify_country_of_billing_address(String country) {        String actual = $("//div[@class='billing-info']//li[@class='country']").getText().trim();        Assert.assertEquals(country,actual);        logger.info("Verified country of billing address: {}", country);    }    public void verify_payment_of_billing_address(String payment) {        String actual = $("//div[@class='payment-method-info']//ul[@class='info-list']").getText().trim();        Assert.assertEquals("Payment Method: "+payment,actual);        logger.info("Verified payment of billing address: {}", payment);    }    public void verify_name_of_shipping_address(String name) {        String actual = $("//div[@class='shipping-info']//li[@class='name']").getText().trim();        Assert.assertEquals(name,actual);        logger.info("Verified name of billing address: {}", name);    }    public void verify_email_of_shipping_address(String email) {        String actual = $("//div[@class='shipping-info']//li[@class='email']").getText().trim();        Assert.assertEquals("Email: "+email,actual);        logger.info("Verified email of billing address: {}", email);    }    public void verify_phone_of_shipping_address(String phone) {        String actual = $("//div[@class='shipping-info']//li[@class='phone']").getText().trim();        Assert.assertEquals("Phone: "+phone,actual);        logger.info("Verified phone of billing address: {}", phone);    }    public void verify_fax_of_shipping_address(String fax) {        String actual = $("//div[@class='shipping-info']//li[@class='fax']").getText().trim();        Assert.assertEquals("Fax: "+fax,actual);        logger.info("Verified fax of billing address: {}", fax);    }    public void verify_company_of_shipping_address(String company) {        String actual = $("//div[@class='shipping-info']//li[@class='company']").getText().trim();        Assert.assertEquals(company,actual);        logger.info("Verified company of billing address: {}", company);    }    public void verify_address1_of_shipping_address(String address1) {        String actual = $("//div[@class='shipping-info']//li[@class='address1']").getText().trim();        Assert.assertEquals(address1,actual);        logger.info("Verified address1 of billing address: {}", address1);    }    public void verify_city_of_shipping_address(String city) {        String actual = $("//div[@class='shipping-info']//li[@class='city-state-zip']").getText().trim();        Assert.assertEquals(city,actual);        logger.info("Verified city-state-zip of billing address: {}", city);    }    public void verify_country_of_shipping_address(String country) {        String actual = $("//div[@class='shipping-info']//li[@class='country']").getText().trim();        Assert.assertEquals(country,actual);        logger.info("Verified country of billing address: {}", country);    }    public void verify_shipping_of_shipping_address(String shipping) {        String actual = $("//div[@class='shipping-method-info']//ul[@class='info-list']").getText().trim();        Assert.assertEquals("Shipping Method: " + shipping, actual);        logger.info("Verified payment of billing address: {}", shipping);    }    public void verify_message_order_complete(String message) {        String xpath = "//div[@class='section order-completed']//div[@class='title']//strong";        Assert.assertTrue($(xpath).isDisplayed());        String actual = $(xpath).getText().trim();        Assert.assertEquals(message,actual);        logger.info("Order completed!!!");    }    public void verifySKU(int i, String sku) {        $("(//span[@class='sku-number'])[" + i + "]").waitUntilVisible();        String actual = $("(//span[@class='sku-number'])[" + i + "]").getText();        logger.info("i= {}", i);        Assert.assertEquals(sku, actual);    }    public void verifyProduct(int i, String product) {        $("(//a[@class='product-name'])[" + i + "]").waitUntilVisible();        String actual = $("(//a[@class='product-name'])[" + i + "]").getText();        logger.info("i= {}", i);        Assert.assertEquals(product, actual);    }    public void verifyPrice(int i, String price) {        $("(//span[@class='product-unit-price'])[" + i + "]").waitUntilVisible();        String actual = $("(//span[@class='product-unit-price'])[" + i + "]").getText();        logger.info("i= {}", i);        Assert.assertEquals(price, actual);    }    public void verifyQuantity(int i, String quantity) {        $("(//span[@class='product-quantity'])[" + i + "]").waitUntilVisible();        String actual = $("(//span[@class='product-quantity'])[" + i + "]").getText();        logger.info("i= {}", i);        Assert.assertEquals(quantity, actual);    }    public void verifyTotal(int i, String total) {        $("(//span[@class='product-subtotal'])[" + i + "]").waitUntilVisible();        String actual = $("(//span[@class='product-subtotal'])[" + i + "]").getText();        logger.info("i= {}", i);        Assert.assertEquals(total, actual);    }}