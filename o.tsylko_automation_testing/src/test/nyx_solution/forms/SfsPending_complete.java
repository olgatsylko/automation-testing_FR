package nyx_solution.forms;

import framework.BaseForm;
import framework.elements.Button;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SfsPending_complete extends BaseForm {
    public Button create = new Button(By.xpath("//a[contains(@class,\"btn btn-primary btn-xs\")]"), "Create");

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
