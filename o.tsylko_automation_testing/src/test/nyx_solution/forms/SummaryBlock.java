package nyx_solution.forms;

import framework.BaseForm;
import framework.elements.TextBox;
import org.openqa.selenium.By;

public class SummaryBlock extends BaseForm {

    public TextBox currentBalance = new TextBox(By.xpath("//h2[contains(@class, 'text-center ng-binding ng-scope')]"), "Current Balance");
    public TextBox totalExpenditure = new TextBox(By.xpath("//*[@id=\"agentPortalLayout\"]/div[2]/div/div/div/div[1]/div/div/div[2]/div/table/tbody/tr[1]/td[2]"), "Total Expenditure");
    public TextBox totalIncome = new TextBox(By.xpath("//*[@id=\"agentPortalLayout\"]/div[2]/div/div/div/div[1]/div/div/div[2]/div/table/tbody/tr[2]/td[2]"), "Total Income");
    public TextBox disposableIncome = new TextBox(By.xpath("//*[@id=\"agentPortalLayout\"]/div[2]/div/div/div/div[1]/div/div/div[2]/div/table/tbody/tr[3]/td[2]"), "Disposable Income");

    public SummaryBlock(){
        super(By.xpath("//div[contains(@class, 'ccm-panel')]"), "Summary tile");

    }
}
