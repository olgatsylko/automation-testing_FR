package nyx_solution.forms;

import framework.BaseForm;
import framework.elements.DropDown;
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
    public TextBox totalPriorityBills = new TextBox(By.xpath("//td[contains(@colspan, \"3\")}"), "Total Priority Bills");


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
