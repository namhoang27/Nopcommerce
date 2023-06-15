package starter.stepdefinitions;import io.cucumber.datatable.DataTable;import io.cucumber.java.en.And;import io.cucumber.java.en.Then;import net.thucydides.core.annotations.Steps;import starter.pages.WishlistPage;import java.util.ArrayList;import java.util.List;import java.util.Map;public class WishlistDefs {    @Steps    WishlistPage wishlistPage;    @And("I click {string} option button")    public void iClickOptionButton(String option) {        wishlistPage.clickOptionButton(option);    }    @Then("I should see the wishlist display as below")    public void iShouldSeeTheWishlistDisplayAsBelow(DataTable dt) {        List<Map<String, String>> values = dt.asMaps(String.class, String.class);        for (int i = 0; i < values.size(); i++) {            String sku = values.get(i).get("SKU");            String product = values.get(i).get("Product(s)");            String price = values.get(i).get("Price");            String quantity = values.get(i).get("Qty.");            String total = values.get(i).get("Total");            wishlistPage.verifySKU(i + 1, sku);            wishlistPage.verifyProduct(i + 1, product);            wishlistPage.verifyPrice(i + 1, price);            wishlistPage.verifyQuantity(i + 1, quantity);            wishlistPage.verifyTotal(i + 1, total);        }    }    @And("I click on wishlist URL for sharing")    public void iClickOnWishlistURLForSharing() {        wishlistPage.clickOnURLforSharing();    }    @And("I should see the wishlist of {string}")    public void iShouldSeeTheWishlistOf(String user) {        wishlistPage.verifyWishListOfUser(user);    }    @And("I select product below to {string}")    public void iSelectProductBelow(String checkbox, DataTable dt) {        ArrayList<String> products = new ArrayList<>(dt.asList(String.class));        for (String product : products) {            wishlistPage.listProductToAction(product, checkbox);        }    }    @And("I click on {string} at Wishlist page")    public void iClickOnAtWishlistPage(String option) {        wishlistPage.clickOnOptionAtWistListPage(option);    }    @Then("I should see products is added to shopping cart as list below")    public void iShouldSeeProductsIsAddedToShoppingCartAsListBelow(DataTable dt) {        wishlistPage.verifyUserAtShoppingCartPage();        List<Map<String, String>> values = dt.asMaps(String.class, String.class);        for (int i = 0; i < values.size(); i++) {            String sku = values.get(i).get("SKU");            String product = values.get(i).get("Product(s)");            String price = values.get(i).get("Price");            String quantity = values.get(i).get("Qty.");            String total = values.get(i).get("Total");            wishlistPage.verifySKU(i + 1, sku);            wishlistPage.verifyProduct(i + 1, product);            wishlistPage.verifyPrice(i + 1, price);            wishlistPage.verifyQuantity(i + 1, quantity);            wishlistPage.verifyTotal(i + 1, total);        }    }    @And("I should see the products is removed from {string}")    public void iShouldSeeTheProductsIsRemoveFromPage(String page, DataTable dt) {        ArrayList<String> products = new ArrayList<>(dt.asList(String.class));        switch (page) {            case "Wishlist page":                wishlistPage.verifyUserAtWishListPage();                for (String product : products) {                    wishlistPage.verifyProductIsNotDisplayed(product);                }                break;            case "Compare products page":                wishlistPage.verifyUserAtCompareProductPage();                for (String product : products) {                    wishlistPage.verifyProductIsNotDisplayedAtCompareProduct(product);                }                break;            default:                System.out.println("Inputted invalid page!!!");                break;        }    }    @Then("I should see the message {string} is displayed")    public void iShouldSeeTheMessage(String message) {        wishlistPage.verify_message_is_displayed(message);    }    @And("I should see list product to compare as below")    public void iShouldSeeListProductToCompareAsBelow(DataTable dt) {        List<Map<String, String>> values = dt.asMaps(String.class, String.class);        for (int i = 0; i < values.size(); i++) {            String name = values.get(i).get("Name");            String price = values.get(i).get("Price");            wishlistPage.verifyNameProductCompare(i + 1, name);            wishlistPage.verifyPriceProductCompare(i + 1, price);        }    }}