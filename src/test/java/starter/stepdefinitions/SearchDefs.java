package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import starter.navigation.NavigateTo;
import starter.pages.SearchPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SearchDefs {
    @Steps
    SearchPage searchPage;

    @Steps
    NavigateTo navigateTo;

    @And("I click {string} tab of {string} footer option")
    public void iClickTabOfFooterOption(String tab, String footerOption) {
        searchPage.click_tab_of_footer_option(tab, footerOption);
    }

    @Then("I search with information as below")
    public void iSearchWithInformationAsBelow(DataTable dt) {
        List<Map<String, String>> values = dt.asMaps(String.class, String.class);
        for (Map<String, String> column : values) {
            String search_keyword = column.get("Search keyword");
            String advanced_search = column.get("Advanced search");
            String category = column.get("Category");
            String search_sub_categories = column.get("Search sub categories");
            String manufacturer = column.get("Manufacturer");
            String product_descriptions = column.get("Product descriptions");

            searchPage.inputIntoSearchTb(search_keyword);
            if (advanced_search.equals("Checked")) {
                searchPage.selectAdvancedSearch();
                searchPage.selectCatelogryToSearch(category);
                searchPage.selectSearchSubCatagories(search_sub_categories);
                searchPage.selectManufacturer(manufacturer);
                searchPage.selectProductDescriptions(product_descriptions);
            }
        }
    }

    @And("I click on {string} button")
    public void iClickOnButton(String button) {
        navigateTo.clickOnButton(button);
    }

    @Then("I verify the result return as below")
    public void iVerifyTheResultReturnAsBelow(DataTable dt) {
        searchPage.verifyListResult(new ArrayList<>(dt.asList(String.class)));
    }

    @Then("I verify the message will be displayed {string} with case {string}")
    public void iVerifyTheMessageWillBeDisplayedWithCase(String message, String withcase) throws Exception {
        searchPage.verify_message_will_be_displayed(message,withcase);
    }
}
