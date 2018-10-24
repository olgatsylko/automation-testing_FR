package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;


/**
 * The class that describes an input field
 */
public class TextBox extends BaseElement {

	/**
	 * Constructor
	 * @param locator locator
	 * @param name name
	 */
	public TextBox(final By locator, final String name) {
		super(locator, name);
	}

	/**
	 * Constructor
	 * @param string locator
	 * @param name name
	 */
	public TextBox(final String string, final String name) {
		super(string, name);
	}

	/**
	 * Returns Element type
	 * @return Element type
	 */
	protected String getElementType() {
		return getLoc("loc.text.field");
	}

	/**
	 * Constructor
	 * @param locator locator
	 */
	public TextBox(final By locator) {
		super(locator);
	}

	/**
	 * Enter the text in the box
	 * @param value text
	 */
	public void type(final String value) {
		waitForIsElementPresent();
		info(String.format(getLoc("loc.text.typing") + " '%1$s'", value));
		if (browser.getDriver() instanceof JavascriptExecutor) {
	        ((JavascriptExecutor)browser.getDriver()).executeScript("arguments[0].style.border='3px solid red'", element);
	    }
		element.sendKeys(value);
	}

	/**
	 * Clear field and type text
	 * @param value text
	 */
	public void setText(final String value) {
		waitForIsElementPresent();
		element.clear();
		type(value);
	}

	/**
	 * Gets value of field
	 * @return value
	 */
	public String getValue() {
		waitForIsElementPresent();
		System.out.println("Value in the field: " + element.getAttribute("value"));
		return element.getAttribute("value");

	}

	public String getText(){
		waitForIsElementPresent();
		System.out.println("Text in the field: " +  element.getText());
		return element.getText();
	}

	public Double getFieldValueDouble(){
		String s = getText().replaceAll("£", "");
		Double result = Double.parseDouble(s);
		return result;
	}
	/*public String getAutopopulatedValue(){
		JavascriptExecutor js = (JavascriptExecutor) browser.getDriver();
		//String s = (String) ((JavascriptExecutor) browser.getDriver()).executeScript("angular.element($('#vm.EquityOfHomeValue')).text()");
		String s = js.executeScript("return document.element.innerHTML").toString();
		String s2 = (String) js.executeScript("return arguments[0].text;", element);
		System.out.println(s);
		return s;
	}*/

}
