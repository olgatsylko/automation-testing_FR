package nyx_solution.forms;

import framework.BaseForm;
import framework.elements.Button;
import framework.elements.PopUp;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SfsPending_complete extends BaseForm {
    public Button create = new Button(By.xpath("//a[contains(@class,\"btn btn-primary btn-xs\")]"), "Create");
    public Button delete = new Button(By.xpath("//button[contains(text(), 'Delete')]"), "Delete button");
    public PopUp confirmPopUp = new PopUp (By.xpath("//div[contains(text(), 'Are you sure you want to delete Standard Financial Statement?')]"), "Confirmation popup");
    public Button ok = new Button(By.xpath("//button[contains(text(), 'OK')]"), "OK button on confirmation");

    public void assertCreateButton() {
        create.waitForIsElementPresent();
        Assert.assertTrue(create.isPresent());
    }

    public SfsPending_complete() {
        super(By.xpath("//input[contains(@id, \"legacyID\")]"), "SFS page");
    }

    public void create (){
        assertCreateButton();
        create.click();
    }

}
