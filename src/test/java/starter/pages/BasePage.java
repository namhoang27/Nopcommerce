package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

public class BasePage extends PageObject {
    private JavascriptExecutor jsExecutor;
    private WebElement element;
    private Actions action;

    public List<String> getList(String xPath) {
        List<String> element = new ArrayList<>();
        List<WebElementFacade> treeNodes = findAll(xPath);
        System.out.println(treeNodes.size());
        for (WebElementFacade treeNode : treeNodes) {
            element.add(treeNode.getText());
            System.out.println(treeNode.getText());
        }
        return element;
    }
    public String getCurrentPageSource() {
        return getDriver().getPageSource();
    }

    public String getTextAlert() {
        return getDriver().switchTo().alert().getText();
    }


    public WebElement getElement(String locator) {
       try {
           return getDriver().findElement(getByXpath(locator));
       } catch (NoSuchElementException e){
           return null;
       }
    }

    public List<WebElement> getElements(String locator) {
        return getDriver().findElements(getByXpath(locator));
    }

    public By getByXpath(String locator) {
        return By.xpath(locator);
    }


//    public String parseSpecialText(String text) {
//        String[] items = text.trim().split(" ");
//        StringBuilder builder = new StringBuilder();
//        for (String item : items) {
//            builder.append(item).append(" ");
//        }
//        return builder.toString();
//    }

    public void switchToFrame(String locator) {
        getDriver().switchTo().frame(getElement(locator));
    }

    public void switchToDefaultContent() {
        getDriver().switchTo().defaultContent();
    }


    public void hoverMouseToElement(String locator) {
        action = new Actions(getDriver());
        action.moveToElement(getElement(locator)).perform();
    }

    public void clickAndHoldToElement(String locator) {
        action = new Actions(getDriver());
        action.clickAndHold(getElement(locator)).perform();
    }

    public void dragAndDropElement(String sourceLocator, String targetLocator) {
        action = new Actions(getDriver());
        action.dragAndDrop(getElement(sourceLocator), getElement(targetLocator)).perform();
    }

    public void sendKeyBoardToElement(String locator, Keys key) {
        action = new Actions(getDriver());
        action.sendKeys(getElement(locator), key).perform();
    }

    public Object executeForBrowser(String javaScript) {
        jsExecutor = (JavascriptExecutor) getDriver();
        return jsExecutor.executeScript(javaScript);
    }

    public String getInnerText() {
        jsExecutor = (JavascriptExecutor) getDriver();
        return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
    }

    public boolean areExpectedTextInInnerText(String textExpected) {
        jsExecutor = (JavascriptExecutor) getDriver();
        String textActual = (String) jsExecutor
                .executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
        return textActual.equals(textExpected);
    }

    public void scrollToBottomPage() {
        jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void navigateToUrlByJS(String url) {
        jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("window.location = '" + url + "'");
    }

    public void highlightElement(String locator) {
        jsExecutor = (JavascriptExecutor) getDriver();
        element = getElement(locator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
                "border: 2px solid red; border-style: dashed;");
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
                originalStyle);
    }

    public void clickToElementByJS(String locator) {
        jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].click();", getElement(locator));
    }

    public void scrollToElement(String locator) {
        jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
    }

    public void sendkeyToElementByJS(String locator, String value) {
        jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(locator));
    }

    public void removeAttributeInDOM(String locator, String attributeRemove) {
        jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
                getElement(locator));
    }

    public String getElementValidationMessage(String locator) {
        jsExecutor = (JavascriptExecutor) getDriver();
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(locator));
    }

    public boolean isImageLoaded(String locator) {
        jsExecutor = (JavascriptExecutor) getDriver();
        boolean status = (boolean) jsExecutor.executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
                getElement(locator));
        if (status) {
            return true;
        } else {
            return false;
        }
    }

}
