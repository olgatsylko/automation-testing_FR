package nyx_solution.forms;

import framework.BaseForm;
import framework.elements.*;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Calendar;
import java.util.TimeZone;

public class HouseholdEquityDetailsPage extends BaseForm {
    private String pattern = "//input[contains(@name,\"%s\")]";
    private String patternDate = "//span[contains(text(),\"%s\")]/parent::button";
    private Label header = new Label(By.xpath("//div[contains(@class, \"ccm-panel\")]"), "Household and Equity Details page");
    public Label householdMess = new Label(By.xpath("//span[contains(text(), 'The number must be equal or greater than 1.')]"), "The number must be equal or greater than 1 mess");
    public Label householdMessVsTotalChild = new Label (By.xpath("//span[contains(text(), 'The sum of \"Children Under 16\" and \"Children 16 to 18\" must be less than \"Number In Household\".')]"), "The summ mess");
    public Label mandatoryFieldMess = new Label(By.xpath("//span[contains(text(), \"This is a required field.\")]"), "Mandatory field valid mess");
    public Label outstandMortgageMess = new Label(By.xpath("//span[contains(text(), \"The number must be less than 999,999,999.\")]"), "Outstanding Mortgage format valid mess");
    public Button next = new Button(By.xpath("//button[contains(text(), 'Next')]"), "Next button");
    public DropDown householdType = new DropDown(By.xpath("//select[contains(@name, \"householdType\")]"), "Household Type dropdown");
    public DropDown residenceStatus = new DropDown(By.xpath("//select[contains(@name, \"residenceStatus\")]"), "Residence Status dropdown");
    public DropDown employmentStatus = new DropDown(By.xpath("//select[contains(@name, \"employmentStatus\")]"), "Employment Status dropdown");
    public DropDown partnersEmploymentStatus = new DropDown(By.xpath("//select[contains(@name, \"partnersEmploymentStatus\")]"), " Partner Employment Status dropdown");
    public TextBox equityOfHome = new TextBox(By.xpath("//input[contains(@name,\"outstandingDebt\")]"));
    public Button cancel = new Button(By.xpath("//button[contains(text(), 'Cancel')]"), "Cancel button");
    public PopUp confirmLeavePage = new PopUp(By.xpath("//div[contains(text(), 'Are you sure you want to leave current page and do not save data?')]"), "Confirmation to leave the page");
    public Button ok = new Button(By.xpath("//button[contains(text(), 'OK')]"), "OK button");
    public Button receivedFromDMC = new Button(By.xpath("//i[contains(@class, \"glyphicon glyphicon-calendar\")]"), "Date picker");

public HouseholdEquityDetailsPage() {
        super(By.xpath("//div[contains(@class, \"ccm-panel\")]"), "Household and Equity Details page");
    }
    public enum Fields {
        Children16_18("numberOfChildren16to18"), ChildrenUnder16("numberOfChildrenUnder16"), VALUEofHome("propertyValue"), NumberInHouseHold("numberInHousehold"), OutstandingMORTGAGE("mortgageAmount"),;
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
    public void validationMessMandatoryField(){
        header.click();
        Assert.assertTrue(mandatoryFieldMess.isPresent());
    }

    public void selectCurrentDate(){
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
       // Date date = calendar.getTime();
        int day = calendar.get(Calendar.DATE);
        Label currentDate = new Label(By.xpath(String.format(patternDate, day)), "Date");
        receivedFromDMC.click();
        currentDate.click();
    }

    public void selectPastDate(){
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        int dayPast = calendar.get(Calendar.DATE)-1;
        Label pastDate = new Label(By.xpath(String.format(patternDate, dayPast)), "Date");
        receivedFromDMC.click();
        pastDate.click();
    }

    public void validateFutureDateIsDisabled(){
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        int dayFuture = calendar.get(Calendar.DATE)+1;
        Label futureDate = new Label(By.xpath(String.format(patternDate, dayFuture)), "Date");
        receivedFromDMC.click();
        Assert.assertTrue(futureDate.getElement().getAttribute("disabled").contains("true"));
    }



}
