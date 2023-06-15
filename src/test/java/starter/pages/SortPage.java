package starter.pages;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;

public class SortPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(SortPage.class);

    public void selectOrderType(String order, String label) {
        String xpath = "//span[.='" + label + "']/following-sibling::select";
        $(xpath).waitUntilVisible();
        $(xpath).selectByVisibleText(order);
        logger.info("Selected order {} of {}. {}", order, label, xpath);
        $("//div[@class='ajax-products-busy']").waitUntilNotVisible();
    }

    public void verifyProductName(int i, String product_name) {
        $("//div[@class='item-grid']//div[@class='item-box'][" + i + "]//h2").waitUntilVisible();
        String actual = $("//div[@class='item-grid']//div[@class='item-box'][" + i + "]//h2").getText();
        logger.info("i= {}", i);
        Assert.assertEquals(product_name, actual);
    }

    public void verifyPrice(int i, String price) {
        $("//div[@class='item-grid']//div[@class='item-box'][" + i + "]//span").waitUntilVisible();
        String actual = $("//div[@class='item-grid']//div[@class='item-box'][" + i + "]//span").getText();
        Assert.assertEquals(price, actual);
    }

    public void verify_number_product_display_per_a_page(int numberDisplay) {
        String xpath = "//div[@class='item-grid']//div[@class='item-box']//h2";
        if (getElements(xpath).size() > numberDisplay) {
            logger.info("error");
        }
        logger.info("number of product < {}", numberDisplay);
    }

    public void verify_current_page(String page) {
        $("//div[@class='ajax-products-busy']").waitUntilNotVisible();
        String actual = $(".current-page").getText();
        Assert.assertEquals(page, actual);
        logger.info("The current page is {} {}", actual, ".current-page");
    }

    public void verify_icon_page_is_displayed(String icon) {
        if (icon.equals("next")) {
            $("//div[@class='ajax-products-busy']").waitUntilNotVisible();
            $("li[class='next-page'] a").waitUntilClickable();
            $("li[class='next-page'] a").isEnabled();
            logger.info("Next page icon is displayed");
        }
        if (icon.equals("previous")) {
            $("//div[@class='ajax-products-busy']").waitUntilNotVisible();
            $("li[class='previous-page'] a").waitUntilClickable();
            $("li[class='previous-page'] a").isEnabled();
            logger.info("Previous page icon is displayed");
        }
    }

    public void select_icon_page(String value) {
        switch (value) {
            case "next":
                $("li[class='next-page'] a").waitUntilClickable();
                $("li[class='next-page'] a").click();
                $("//div[@class='ajax-products-busy']").waitUntilNotVisible();
                logger.info("Click on page {}. {}", value,"li[class='next-page'] a");
                break;
            case "previous":
                $("li[class='previous-page'] a").waitUntilClickable();
                $("li[class='previous-page'] a").click();
                $("//div[@class='ajax-products-busy']").waitUntilNotVisible();
                logger.info("Click on page {}. {}", value,"li[class='previous-page'] a");
                break;
            default:
                if (!Objects.equals($(".current-page").getText(), value)) {
                    $("//a[normalize-space()='" + value + "']").waitUntilClickable();
                    $("//a[normalize-space()='" + value + "']").click();
                    $("//div[@class='ajax-products-busy']").waitUntilNotVisible();
                    logger.info("Click on page {}. {}", value,"//a[normalize-space()='" + value + "']");
                } else {
                    logger.info("Click on page {}", value);
                }
                break;
        }
    }
}
