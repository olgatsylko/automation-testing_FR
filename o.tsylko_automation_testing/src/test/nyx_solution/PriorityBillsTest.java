package nyx_solution;

import framework.BaseTest;
import framework.elements.DropDown;
import nyx_solution.forms.HouseholdEquityDetailsPage;
import nyx_solution.forms.PriorityBillPage;
import nyx_solution.forms.SfsPending_completePage;
import nyx_solution.forms.SummaryBlock;
import org.testng.Assert;

import static nyx_solution.forms.PriorityBillPage.Fields.*;

public class PriorityBillsTest extends BaseTest {
    public void runTest() {
        logger.step(1);
        logger.info("Click Create");
        SfsPending_completePage sfs = new SfsPending_completePage();
        sfs.create();

        logger.step(2);
        logger.info("Navigate to Priority Bills");
        HouseholdEquityDetailsPage hsDet2 = new HouseholdEquityDetailsPage();
        hsDet2.householdType.selectItem("Couple with no children");
        hsDet2.residenceStatus.selectItem("Tenant");
        hsDet2.next.click();

        logger.step(3);
        logger.info("Validate Priority Bills page");
        PriorityBillPage pbp = new PriorityBillPage();

        logger.step(4);
        logger.info("Validate Frequency dropdown values");
        for (DropDown freq:  pbp.getAllFrequencyDropDowns()){
            freq.selectItem("Weekly");
            freq.selectItem("Fortnightly");
            freq.selectItem("Four Weekly");
            freq.selectItem("Monthly");
        }

        logger.step(5);
        logger.info("Validate Total Priority Bills for Weekly frequency");
        pbp.populateItem(RentAmount, "100.00");
        pbp.frequency0.selectItem("Weekly");
        Assert.assertTrue(pbp.totalPriorityBills.getFieldValueDouble() == 433.33);

        logger.step(6);
        logger.info("Validate Total Priority Bills for Fortnightly frequency");
        pbp.populateItem(RentAmount, "100.00");
        pbp.frequency0.selectItem("Fortnightly");
        Assert.assertTrue(pbp.totalPriorityBills.getFieldValueDouble() == 216.67);

        logger.step(7);
        logger.info("Validate Total Priority Bills for Four Weekly frequency");
        pbp.populateItem(RentAmount, "100.00");
        pbp.frequency0.selectItem("Four Weekly");
        Assert.assertTrue(pbp.totalPriorityBills.getFieldValueDouble() == 108.33);

        logger.step(8);
        logger.info("Validate Total Priority Bills for Monthly frequency");
        pbp.populateItem(RentAmount, "100.00");
        pbp.frequency0.selectItem("Monthly");
        Assert.assertTrue(pbp.totalPriorityBills.getFieldValueDouble() == 100.00);

        logger.step(9);
        logger.info("Validate Total Priority Bills for Rent 100 Weekly + Council Tax 120 Weekly");
        pbp.populateItem(RentAmount, "100.00");
        pbp.frequency0.selectItem("Weekly");
        pbp.populateItem(CouncilTaxAmount, "120.00");
        pbp.frequency1.selectItem("Weekly");
        Assert.assertTrue(pbp.totalPriorityBills.getFieldValueDouble() == 953.33);

        logger.step(10);
        logger.info("Validate Total Priority Bills for Rent 100 Weekly + Council Tax 50 Fortnightly + Gas 80 Four Weekly + Electricity 120 Monthly");
        pbp.populateItem(RentAmount, "100.00");
        pbp.frequency0.selectItem("Weekly");
        pbp.populateItem(CouncilTaxAmount, "50.00");
        pbp.frequency1.selectItem("Fortnightly");
        pbp.populateItem(GasAmount, "80.00");
        pbp.frequency2.selectItem("Four Weekly");
        pbp.populateItem(ElectricityAmount, "120.00");
        pbp.frequency3.selectItem("Monthly");
        Assert.assertTrue(pbp.totalPriorityBills.getFieldValueDouble() == 748.33);

        logger.step(11);
        logger.info("Add and rename custom priority bills type");
        pbp.addCustomType.click();
        pbp.inputCustomType.setText("Other Priority Bill");
        pbp.previous.click();
        hsDet2.next.click();
        Assert.assertTrue(pbp.inputCustomType.getValue().equals("Other Priority Bill"));

        logger.step(12);
        logger.info("Delete custom priority bills type");
        pbp.deleteCustomType.click();
        Assert.assertFalse(pbp.inputCustomType.isPresent());

        logger.step(13);
        logger.info("Add Other Priority bill monthly 100  and check Total Priority Bill, Total Expenditure and Disposable income ");
        pbp.addCustomType.click();
        SummaryBlock sm = new SummaryBlock();
        Double totalExp = sm.totalExpenditure.getFieldValueDouble();
        Double totalPriorBills = pbp.totalPriorityBills.getFieldValueDouble();
        Double dispInc = sm.disposableIncome.getFieldValueDouble();
        pbp.populateItem(OtherAmount, "100.00");
        pbp.frequency6.selectItem("Monthly");
        Assert.assertTrue(pbp.totalPriorityBills.getFieldValueDouble() == (totalPriorBills +100.00));
        Assert.assertTrue(sm.totalExpenditure.getFieldValueDouble() == (totalExp +100.00));
        Assert.assertTrue(sm.disposableIncome.getFieldValueDouble() ==(dispInc - 100));
        pbp.deleteCustomType.click();

        logger.step(13);
        logger.info("Add 10 custom priority bills types");
        for (int i = 0; i < 10; i++) {
            pbp.addCustomType.click();
        }
        Assert.assertFalse(pbp.addCustomType.isPresent());

        logger.step(17);
        logger.info("Click Cancel button and delete SFS");
        pbp.cancel.click();
        if (pbp.confirmLeavePage.isPresent()){
            pbp.ok.click();
        }
        sfs.delete.click();
        if (sfs.confirmPopUp.isPresent()){
            sfs.ok.click();
        }
    }
}

