package nyx_solution.forms;

import framework.BaseForm;
import framework.elements.Button;
import framework.elements.DropDown;
import framework.elements.PopUp;
import framework.elements.TextBox;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class CommLeisurePage extends BaseForm {
    public DropDown frequency_22 = new DropDown(By.xpath("//select[contains(@name, \"expFrequency22\")]"), "Frequency for Home Phone");
    public DropDown frequency_23 = new DropDown(By.xpath("//select[contains(@name, \"expFrequency23\")]"), "Frequency for Mobile Phone");
    public DropDown frequency_24 = new DropDown(By.xpath("//select[contains(@name, \"expFrequency24\")]"), "Frequency for Hobbies");
    public DropDown frequency_34 = new DropDown(By.xpath("//select[contains(@name, \"expFrequency34\")]"), "Frequency for Other1");
    public DropDown frequency_35= new DropDown(By.xpath("//select[contains(@name, \"expFrequency35\")]"), "Frequency for Other2");

    public ArrayList<DropDown> frequency3;
    public PopUp confirmLeavePage = new PopUp(By.xpath("//div[contains(text(), 'Are you sure you want to leave current page and do not save data?')]"), "Confirmation to leave the page");
    public Button ok = new Button(By.xpath("//button[contains(text(), 'OK')]"), "OK button");
    public Button cancel = new Button(By.xpath("//button[contains(text(), 'Cancel')]"), "Cancel button");
    public Button previous = new Button(By.xpath("//button[contains(text(), 'Previous')]"), "Previous button");
    public Button addCustomType = new Button(By.xpath("//i[contains(@class, \"fa fa-plus fa-fw\")]"), "Add Custom type button");
    public Button deleteCustomType = new Button (By.xpath("//i[contains(@class, \"fa fa-remove fa-fw\")]"), "Delete Custom type button");
    public TextBox inputCustomType = new TextBox(By.xpath("//input[contains(@name, \"expName34\")]"), "input Custom Type");
    public TextBox totalCommAndLeisure = new TextBox(By.xpath("//td[contains(@colspan, \"3\")]"), "Total Comms and Leisure");
    private String pattern = "//input[contains(@name,\"%s\")]";
    public CommLeisurePage() {
        super(By.xpath("//h4[contains(text(),'Communications & Leisure')]"), "Communications & Leisure page");
    }
    public enum amountFields {
        HOME_PHONE("expAmount22"), MOBILE_PHONE("expAmount23"), HOBBIES("expAmount24"), OTHER1("expAmount34"), OTHER2("expAmount35");
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
        frequency3 = new ArrayList<>();
        frequency3.add(frequency_22);
        frequency3.add(frequency_23);
        frequency3.add(frequency_24);
        return frequency3;
    }
}
