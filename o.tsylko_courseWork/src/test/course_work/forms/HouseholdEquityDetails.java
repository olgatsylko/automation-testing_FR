package course_work.forms;

import miniSmart.webdriver.BaseForm;
import miniSmart.webdriver.elements.DropDown;
import miniSmart.webdriver.elements.Label;
import miniSmart.webdriver.elements.TextBox;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HouseholdEquityDetails extends BaseForm {
    private String pattern = "//input[contains(@name,\"%s\")]";
    private Label header = new Label(By.xpath("//div[contains(@class, \"ccm-panel\")]"), "Household and Equity Details page");
    public Label householdMess = new Label(By.xpath("//span[contains(text(), 'The number must be equal or greater than 1.')]"), "The number must be equal or greater than 1 mess");
    public Label householdMessVsTotalChild = new Label (By.xpath("//span[contains(text(), 'The sum of \"Children Under 16\" and \"Children 16 to 18\" must be less than \"Number In Household\".')]"), "The summ mess");
    public DropDown householdType = new DropDown(By.xpath("//select[contains(@name, \"householdType\")]"), "Household Type dropdown");

public HouseholdEquityDetails() {
        super(By.xpath("//div[contains(@class, \"ccm-panel\")]"), "Household and Equity Details page");
    }
    public enum Fields {NumberInHouseHold ("numberInHousehold"), ChildrenUnder16 ("numberOfChildrenUnder16"), Children16_18("numberOfChildren16to18");
        private String uniqueLocator;
        Fields(String uniqueLocator) {
            this.uniqueLocator = uniqueLocator;
        }
    }
    public void populateItem(Fields itemName, String value) {
        TextBox fieldName = new TextBox(By.xpath(String.format(pattern, itemName.uniqueLocator)), "fieldName");
        fieldName.setText(value);
    }

    public void householdValidationMess(){
        header.click();
        Assert.assertTrue(householdMess.isPresent());
    }

    public void householdSumMess(){
        header.click();
        Assert.assertTrue(householdMessVsTotalChild.isPresent());
    }

    public void validationMessIsNotPresent(){
        header.click();
        Assert.assertFalse(householdMessVsTotalChild.isPresent());
    }
}
