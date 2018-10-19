package course_work.forms;

import miniSmart.webdriver.BaseForm;
import miniSmart.webdriver.elements.Button;
import miniSmart.webdriver.elements.TextBox;
import org.openqa.selenium.By;

public class AgentPortal extends BaseForm {
    public TextBox searchField = new TextBox(By.xpath("//input[contains(@id, \"legacyID\")]"));
    public Button searchButton = new Button (By.xpath("//button[contains(@class, \"btn btn-default search-input-sm\")]"));

    public AgentPortal() {
        super(By.xpath("//input[contains(@id, \"legacyID\")]"), "Agent Portal");
    }

    public void searchConsumer (final String consumer){
        searchField.type(consumer);
        searchButton.click();
    }

}
