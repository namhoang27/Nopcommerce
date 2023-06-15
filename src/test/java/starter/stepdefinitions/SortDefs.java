package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.SortPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SortDefs {
    @Steps
    SortPage sortPage;

    @And("I select option {string} of {string} dropdown list")
    public void iSelectOptionOfDropdownList(String order, String label) {
        sortPage.selectOrderType(order, label);
    }

    @Then("I should see list product displays as below")
    public void iShouldSeeListProductDisplaysAsBelow(DataTable dt) {
        List<Map<String, String>> values = dt.asMaps(String.class, String.class);
        for (int i = 0; i < values.size(); i++) {
            String product_name = values.get(i).get("Product Name");
            String price = values.get(i).get("Price");

            sortPage.verifyProductName(i+1, product_name);
            sortPage.verifyPrice(i+1, price);

        }
    }

    @Then("I verify the products display per page is not bigger than {int}")
    public void iVerifyTheProductsDisplayPerPageIsNotBiggerThan(int numberDisplay) {
        sortPage.verify_number_product_display_per_a_page(numberDisplay);
    }

    @And("I verify the current page is {string} and display icon {string}")
    public void iVerifyTheCurrentPageIsAndDisplayIcon(String page, String icon) {
        sortPage.verify_current_page(page);
        sortPage.verify_icon_page_is_displayed(icon);
    }

    @When("I select page {string}")
    public void iSelectPage(String value) {
        sortPage.select_icon_page(value);
    }
}
