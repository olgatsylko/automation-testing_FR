package nyx_solution.forms;

import framework.BaseForm;
import framework.elements.Button;
import framework.elements.DropDown;
import framework.elements.PopUp;
import framework.elements.TextBox;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class FixedCostsPage extends BaseForm {
    public DropDown frequency_6 = new DropDown(By.xpath("//select[contains(@name, \"expFrequency6\")]"), "Frequency for Secured Loans");
    public DropDown frequency_7 = new DropDown(By.xpath("//select[contains(@name, \"expFrequency7\")]"), "Frequency for TV Licence");
    public DropDown frequency_8 = new DropDown(By.xpath("//select[contains(@name, \"expFrequency8\")]"), "Frequency for Appliance");
    public DropDown frequency_9 = new DropDown(By.xpath("//select[contains(@name, \"expFrequency9\")]"), "Frequency for Life Insurance");
    public DropDown frequency_10 = new DropDown(By.xpath("//select[contains(@name, \"expFrequency10\")]"), "Frequency for Building");
    public DropDown frequency_11 = new DropDown(By.xpath("//select[contains(@name, \"expFrequency11\")]"), "Frequency for Health Insurance");
    public DropDown frequency_12 = new DropDown(By.xpath("//select[contains(@name, \"expFrequency12\")]"), "Frequency for Childcare");
    public DropDown frequency_13 = new DropDown(By.xpath("//select[contains(@name, \"expFrequency13\")]"), "Frequency for Child Maintenance");
    public DropDown frequency_14 = new DropDown(By.xpath("//select[contains(@name, \"expFrequency14\")]"), "Frequency for Prescriptions");
    public DropDown frequency_15 = new DropDown(By.xpath("//select[contains(@name, \"expFrequency15\")]"), "Frequency for Dentistry");
    public DropDown frequency_16 = new DropDown(By.xpath("//select[contains(@name, \"expFrequency16\")]"), "Frequency for Public Transport");
    public DropDown frequency_17 = new DropDown(By.xpath("//select[contains(@name, \"expFrequency17\")]"), "Frequency for Vehicle Insurance");
    public DropDown frequency_18 = new DropDown(By.xpath("//select[contains(@name, \"expFrequency18\")]"), "Frequency for Road Tax");
    public DropDown frequency_19 = new DropDown(By.xpath("//select[contains(@name, \"expFrequency19\")]"), "Frequency for MOT and Maintenance");
    public DropDown frequency_20 = new DropDown(By.xpath("//select[contains(@name, \"expFrequency20\")]"), "Frequency for Fuel");
    public DropDown frequency_21 = new DropDown(By.xpath("//select[contains(@name, \"expFrequency21\")]"), "Frequency for Hire Purchase");
    public ArrayList<DropDown> frequency2;
    public PopUp confirmLeavePage = new PopUp(By.xpath("//div[contains(text(), 'Are you sure you want to leave current page and do not save data?')]"), "Confirmation to leave the page");
    public Button ok = new Button(By.xpath("//button[contains(text(), 'OK')]"), "OK button");
    public Button cancel = new Button(By.xpath("//button[contains(text(), 'Cancel')]"), "Cancel button");
    public Button previous = new Button(By.xpath("//button[contains(text(), 'Previous')]"), "Previous button");
    public TextBox totalPriorityBills = new TextBox(By.xpath("//td[contains(@colspan, \"3\")]"), "Total Priority Bills");

    private String pattern = "//input[contains(@name,\"%s\")]";
    public FixedCostsPage() {
        super(By.xpath("//h4[contains(text(),'Fixed Costs')]"), "Fixed Income page");
    }
    public enum amountFields {
        SECURED_LOANS("expAmount6"), TV_LICENCE("expAmount7"), APPLIANCE("expAmount8"), LIFE_INSURANCE("expAmount9"),VEHICLE_INSURANCE("expAmount17"), ROAD_TAX("expAmount18"), MOT_MAINTENANCE("expAmount19"),
        FUEL("expAmount20") ;
        private String uniqueLocator;
        amountFields(String uniqueLocator) {
            this.uniqueLocator = uniqueLocator;
        }
    }
    public void populateItem(amountFields itemName, String value) {
        TextBox fieldName = new TextBox(By.xpath(String.format(pattern, itemName.uniqueLocator)), "fieldName");
        fieldName.setText(value);
    }
    public ArrayList <DropDown> getAllFrequencyDropDowns(){
        frequency2 = new ArrayList<>();
        frequency2.add(frequency_6);
        frequency2.add(frequency_7);
        frequency2.add(frequency_8);
        frequency2.add(frequency_9);
        frequency2.add(frequency_10);
        frequency2.add(frequency_11);
        frequency2.add(frequency_12);
        frequency2.add(frequency_13);
        frequency2.add(frequency_14);
        frequency2.add(frequency_15);
        frequency2.add(frequency_16);
        frequency2.add(frequency_17);
        frequency2.add(frequency_18);
        frequency2.add(frequency_19);
        frequency2.add(frequency_20);
        frequency2.add(frequency_21);
        return frequency2;
    }
}
