package nyx_solution.forms;

import framework.BaseForm;
import framework.elements.Button;
import framework.elements.DropDown;
import framework.elements.PopUp;
import framework.elements.TextBox;
import org.openqa.selenium.By;

public class PriorityBillPage extends BaseForm {
    private String pattern = "//input[contains(@name,\"%s\")]";
    public DropDown frequency0 = new DropDown(By.xpath("//select[contains(@name, \"expFrequency0\")]"), "Frequency for Rent/Mortgage");
    public DropDown frequency1 = new DropDown(By.xpath("//select[contains(@name, \"expFrequency1\")]"), "Frequency for Council Tax");
    public DropDown frequency2 = new DropDown(By.xpath("//select[contains(@name, \"expFrequency2\")]"), "Frequency for Gas");
    public DropDown frequency3 = new DropDown(By.xpath("//select[contains(@name, \"expFrequency3\")]"), "Frequency for Electricity");
    public DropDown frequency4 = new DropDown(By.xpath("//select[contains(@name, \"expFrequency4\")]"), "Frequency for Water");
    public DropDown frequency5 = new DropDown(By.xpath("//select[contains(@name, \"expFrequency5\")]"), "Frequency for County Court Judgement");
    //public TextBox totalPriorityBills = new TextBox(By.xpath("//td[contains(@colspan, \"3\")}"), "Total Priority Bills");
    public TextBox totalPriorityBills = new TextBox(By.xpath("//*[@id=\"vm.sfsForm\"]/fieldset/div/table/tbody/tr[8]/td[2]"), "Total Priority Bills");
    public Button addCustomType = new Button(By.xpath("//i[contains(@class, \"fa fa-plus fa-fw\")]"), "Add Custom type button");
    public Button deleteCustomType = new Button (By.xpath("//i[contains(@class, \"fa fa-remove fa-fw\")]"), "Delete Custom type button");
    public PopUp confirmLeavePage = new PopUp(By.xpath("//div[contains(text(), 'Are you sure you want to leave current page and do not save data?')]"), "Confirmation to leave the page");
    public Button ok = new Button(By.xpath("//button[contains(text(), 'OK')]"), "OK button");
    public Button cancel = new Button(By.xpath("//button[contains(text(), 'Cancel')]"), "Cancel button");
    public Button previous = new Button(By.xpath("//button[contains(text(), 'Previous')]"), "Previous button");
    public TextBox inputCustomType = new TextBox(By.xpath("//input[contains(@name, \"expName34\")]"), "input Custom Type");

    public PriorityBillPage (){
        super(By.xpath("//select[contains(@name, \"expFrequency0\")]"), "Priority Bills page");
    }

    public enum Fields {
        RentAmount("expAmount0"), CouncilTaxAmount("expAmount1"), GasAmount("expAmount2"),  ElectricityAmount("expAmount3"), WaterAmount("expAmount4"),CountyCourtJudgementAmount("expAmount5");
        private String uniqueLocator;
        Fields(String uniqueLocator) {
            this.uniqueLocator = uniqueLocator;
        }
    }
    public void populateItem(Fields itemName, String value) {
        TextBox fieldName = new TextBox(By.xpath(String.format(pattern, itemName.uniqueLocator)), "fieldName");
        fieldName.setText(value);
    }

}
