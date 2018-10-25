package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDown extends BaseElement {
    private Select select;

    public DropDown(final By locator, final String name) {
        super(locator, name);
    }
    public DropDown(String string, String name) {
        super(string, name);
    }
    public DropDown(By locator) {
        super(locator);
    }
    protected String getElementType() {
        return getLoc("loc.dropdown");
    }

    public void selectItem(String value) {
        WebElement el = browser.getDriver().findElement(this.getLocator());
        if (browser.getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor)browser.getDriver()).executeScript("arguments[0].style.border='3px solid red'", el);
        }
        Select categories = new Select(el);
        //categories.selectByValue(value);
        categories.selectByVisibleText(value);
    }
}
