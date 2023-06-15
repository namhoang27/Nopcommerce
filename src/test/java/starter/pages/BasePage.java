package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    private WebDriverWait explicitWait;
    private WebElement element;
    private List<WebElement> elements;
    private Actions action;
    private Select select;

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

    public void backToPage() {
        getDriver().navigate().back();
    }

    public void forwardToPage() {
        getDriver().navigate().forward();
    }

    public void refreshCurrentPage() {
        getDriver().navigate().refresh();
    }

    public void acceptAlert() {
        getDriver().switchTo().alert().accept();
    }

    public void cancelAlert() {
        getDriver().switchTo().alert().dismiss();
    }

    public String getTextAlert() {
        return getDriver().switchTo().alert().getText();
    }

    public void setTextAlert(String value) {
        getDriver().switchTo().alert().sendKeys(value);
    }

    public void switchToWindowByID(String parentID) {
        Set<String> allWindows = getDriver().getWindowHandles();
        for (String runWindow : allWindows) {
            if (!runWindow.equals(parentID)) {
                getDriver().switchTo().window(runWindow);
                break;
            }
        }
    }

    public void switchToWindowByTitle(String title) {
        Set<String> allWindows = getDriver().getWindowHandles();
        for (String runWindows : allWindows) {
            getDriver().switchTo().window(runWindows);
            String currentWin = getDriver().getTitle();
            if (currentWin.equals(title)) {
                break;
            }
        }
    }

    public void closeAllWindowsWithoutParent(String parentID) {
        Set<String> allWindows = getDriver().getWindowHandles();
        for (String runWindows : allWindows) {
            if (!runWindows.equals(parentID)) {
                getDriver().switchTo().window(runWindows);
                getDriver().close();
            }
        }
        getDriver().switchTo().window(parentID);
    }

    public WebElement getElement(String locator) {
        return getDriver().findElement(getByXpath(locator));
    }

    public List<WebElement> getElements(String locator) {
        return getDriver().findElements(getByXpath(locator));
    }

    public By getByXpath(String locator) {
        return By.xpath(locator);
    }

    public void clickToElement(String locator) {
        element = getElement(locator);
        element.click();
    }

    public void clickToElement(String locator, String... values) {
        element = getElement(getDynamicLocator(locator, values));
        element.click();
    }

    public void sendkeyToElement(String locator, String value) {
        element = getElement(locator);
        element.clear();
        element.sendKeys(value);
    }

    public void sendkeyToElement(String locator, String value, String... values) {
        element = getElement(locator);
        element.clear();
        element.sendKeys(getDynamicLocator(locator, values));
    }

    public void selectItemInDropdown(String locator, String itemValue) {
        element = getElement(locator);
        select = new Select(element);
        select.selectByVisibleText(itemValue);
    }

    public String getFirstSelectedTextInDropdown(String locator) {
        element = getElement(locator);
        select = new Select(element);
        return select.getFirstSelectedOption().getText();
    }

    public boolean isDropdownMultiple(String locator) {
        element = getElement(locator);
        select = new Select(element);
        return select.isMultiple();
    }

    public void selectItemInCustomDropdown(String parentLocator, String childItemLocator,
                                           String expectedItem) {
        getElement(parentLocator).click();
        sleepInSecond(1);
        WebDriverWait explicitWait = new WebDriverWait(getDriver(), GlobalConstants.LONG_TIMEOUT);
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));

        List<WebElement> allItems = getElements(childItemLocator);
        for (WebElement item : allItems) {
            if (item.getText().equals(expectedItem)) {
                jsExecutor = (JavascriptExecutor) getDriver();
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                sleepInSecond(1);

                item.click();
                sleepInSecond(1);
                break;
            }
        }
    }

    public void sleepInSecond(long timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String getElementAttribute(String locator, String attributeName) {
        element = getElement(locator);
        return element.getAttribute(attributeName);
    }
//    public String parseSpecialText(String text) {
//        String[] items = text.trim().split(" ");
//        StringBuilder builder = new StringBuilder();
//        for (String item : items) {
//            builder.append(item).append(" ");
//        }
//        return builder.toString();
//    }

    public String getElementText(String locator) {
        element = getElement(locator);
        return element.getText().trim();
    }

    public String getElementText(String locator, String... values) {
        element = getElement(getDynamicLocator(locator, values));
        return element.getText();
    }

    public int countElementSize(String locator) {
        return getElements(locator).size();
    }

    public int countElementSize(String locator, String... values) {
        return getElements(getDynamicLocator(locator, values)).size();
    }

    public void checkToCheckBox(String locator) {
        element = getElement(locator);
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void checkToCheckBox(String locator, String... values) {
        element = getElement(getDynamicLocator(locator, values));
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void uncheckToCheckBox(String locator) {
        element = getElement(locator);
        if (element.isSelected()) {
            element.click();
        }
    }

    public void uncheckToCheckBox(String locator, String... values) {
        element = getElement(getDynamicLocator(locator, values));
        if (!element.isSelected()) {
            element.click();
        }
    }

    public boolean isElementDisplayed(String locator) {
        return getElement(locator).isDisplayed();
    }

    public boolean isElementDisplayed(String locator, String... values) {
        return getElement(getDynamicLocator(locator, values)).isDisplayed();
    }

    public boolean isElementEnabled(String locator) {
        return getElement(locator).isEnabled();
    }

    public boolean isElementEnabled(String locator, String... values) {
        return getElement(getDynamicLocator(locator, values)).isEnabled();
    }

    public boolean isElementSelected(String locator) {
        return getElement(locator).isSelected();
    }

    public boolean isElementSelected(String locator, String... values) {
        return getElement(getDynamicLocator(locator, values)).isSelected();
    }


    public boolean isElementUndisplayed(String locator) {
        if (elements.size() == 0) {
            System.out.println("Element not in DOM");
            System.out.println("End time = " + new Date().toString());
            return true;
        } else if (elements.size() >= 0 && !elements.get(0).isDisplayed()) {
            System.out.println("Element in DOM but not visible/displayed");
            System.out.println("End time = " + new Date().toString());
            return true;
        } else {
            System.out.println("Element in DOM and visible");
            return true;
        }
    }

    public boolean isElementUndisplayed(String locator, String... values) {
        if (elements.size() == 0) {
            System.out.println("Element not in DOM");
            System.out.println("End time = " + new Date().toString());
            return true;
        } else if (elements.size() >= 0 && !elements.get(0).isDisplayed()) {
            System.out.println("Element in DOM but not visible/displayed");
            System.out.println("End time = " + new Date().toString());
            return true;
        } else {
            System.out.println("Element in DOM and visible");
            return true;
        }
    }

    public void switchToFrame(String locator) {
        getDriver().switchTo().frame(getElement(locator));
    }

    public void switchToDefaultContent() {
        getDriver().switchTo().defaultContent();
    }

    public void doubleClickToElement(String locator) {
        action = new Actions(getDriver());
        action.doubleClick(getElement(locator)).perform();
    }

    public void rightClickToElement(String locator) {
        action = new Actions(getDriver());
        action.contextClick(getElement(locator)).perform();
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
        sleepInSecond(1);
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

    public void waitToElementVisible(String locator) {
        explicitWait = new WebDriverWait(getDriver(), GlobalConstants.LONG_TIMEOUT);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
    }

    public void waitToElementInvisible(String locator) {
        explicitWait = new WebDriverWait(getDriver(), GlobalConstants.SHORT_TIMEOUT);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
    }

    public void waitToElementVisible(String locator, String... values) {
        explicitWait = new WebDriverWait(getDriver(), GlobalConstants.LONG_TIMEOUT);
        explicitWait
                .until(ExpectedConditions.visibilityOfElementLocated(getByXpath(getDynamicLocator(locator, values))));
    }

    public void waitToElementInvisible(String locator, String... values) {
        explicitWait = new WebDriverWait(getDriver(), GlobalConstants.LONG_TIMEOUT);
        explicitWait
                .until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(getDynamicLocator(locator, values))));
    }


    public String getDynamicLocator(String locator, String... values) {
        locator = String.format(locator, (Object[]) values);
        return locator;
    }

    public void waitToElementClickable(String locator, String... values) {
        explicitWait = new WebDriverWait(getDriver(), GlobalConstants.LONG_TIMEOUT);
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(getDynamicLocator(locator, values))));
    }

    public void waitAlertPresence() {
        explicitWait = new WebDriverWait(getDriver(), GlobalConstants.LONG_TIMEOUT);
        explicitWait.until(ExpectedConditions.alertIsPresent());
    }
}
