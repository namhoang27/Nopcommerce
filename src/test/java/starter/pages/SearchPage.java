package starter.pages;

import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;



public class SearchPage extends BasePage{
    private static final Logger logger = LoggerFactory.getLogger(SearchPage.class);
    public void click_tab_of_footer_option(String tab, String footerOption) {
        String element = "//strong[normalize-space()='"+footerOption+"']/parent::div/following-sibling::ul/li/a[text()='"+tab+"']";
        $(element).waitUntilClickable();
        $(element).click();
        logger.info("Clicked on {} tab of {} footer option {}",tab,footerOption,element);
    }

    public void inputIntoSearchTb(String searchKeyword) {
        $("//input[@class='search-text']").waitUntilVisible();
        $("//input[@class='search-text']").clear();
        $("//input[@class='search-text']").sendKeys(searchKeyword);
        logger.info("Inputted into Search keyword textbox {}. {}",searchKeyword,"//input[@class='search-text']");

    }

    public void selectAdvancedSearch() {
        $("#advs").waitUntilEnabled();
        $("#advs").click();
        logger.info("Selected Advanced search {}","#advs");
    }
    public void selectCatelogryToSearch(String category) {
        $("#cid").waitUntilEnabled();
        $("#cid").selectByVisibleText(category);
        logger.info("Selected category {} of dropdown. {}",category,"#cid");
    }

    public void selectSearchSubCatagories(String searchSubCategories) {
        if(searchSubCategories.equals("Checked")){
            $("#isc").waitUntilEnabled();
            $("#isc").click();
            logger.info("Clicked Automatically search sub categories checkbox {}","#isc");
        }
    }

    public void selectManufacturer(String manufacturer) {
        $("#mid").waitUntilEnabled();
        $("#mid").selectByVisibleText(manufacturer);
        logger.info("Selected manufacturer {} of dropdown. {}",manufacturer,"#mid");
    }

    public void selectProductDescriptions(String productDescriptions) {
        if(productDescriptions.equals("Checked")){
            $("#sid").waitUntilEnabled();
            $("#sid").click();
            logger.info("Clicked Search In product descriptions checkbox {}","#sid");
        }
    }

    public void verify_message_will_be_displayed(String message,String withcase) throws Exception {
        switch (withcase){
            case "empty data":
                $(".warning").waitUntilVisible();
                Assert.assertEquals($(".warning").getText(),message);
                logger.info("Locator of message {}",".warning");
                break;
            case "data does not exist":
                $(".no-result").waitUntilVisible();
                Assert.assertEquals($(".no-result").getText(),message);
                logger.info("Locator of message {}",".no-result");
                break;
            default:
                logger.info("Input the supported case currently: empty data, data does not exist");
                throw new Exception("Invalid case!!!");
        }
    }

    public void verifyListResult(ArrayList<String> expectedList) {
        String xPathActualList = "//h2[@class='product-title']";
        List<String> actualList = getList(xPathActualList);
        Assert.assertEquals(expectedList,actualList);
    }
}
