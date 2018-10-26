package nyx_solution;

import framework.BaseTest;
import framework.elements.DropDown;
import nyx_solution.forms.*;
import org.testng.Assert;

import static nyx_solution.forms.FixedCostsPage.amountFields.*;

public class FixedCostTest extends BaseTest {
    public void runTest() {
        logger.step(1);
        logger.info("Click Create");
        SfsPending_completePage sfs = new SfsPending_completePage();
        sfs.create();

        logger.step(2);
        logger.info("Navigate to Priority Bills");
        HouseholdEquityDetailsPage hsDet3 = new HouseholdEquityDetailsPage();
        hsDet3.householdType.selectItem("Couple with no children");
        hsDet3.residenceStatus.selectItem("Tenant");
        hsDet3.next.click();
        PriorityBillPage pbp = new PriorityBillPage();

        logger.step(3);
        logger.info("Navigate to Fixed Costs");
        pbp.next.click();
        Assert.assertTrue(pbp.billsUpToDate.isPresent());
        pbp.yes.click();
        FixedCostsPage fcp = new FixedCostsPage();

        logger.step(4);
        logger.info("Validate Frequency dropdown values");
        for (DropDown freq:  fcp.getAllFrequencyDropDowns()){
            freq.selectItem("Weekly");
            freq.selectItem("Fortnightly");
            freq.selectItem("Four Weekly");
            freq.selectItem("Monthly");
        }

        logger.step(5);
        logger.info("Validate Total Fixed Costs for Weekly frequency");
        fcp.populateItem(SECURED_LOANS, "100.00");
        fcp.frequency_6.selectItem("Weekly");
        Assert.assertTrue(fcp.totalFixedCosts.getFieldValueDouble() == 433.33);

        logger.step(6);
        logger.info("Validate Total Fixed Costs for Fortnightly frequency");
        fcp.populateItem(SECURED_LOANS, "100.00");
        fcp.frequency_6.selectItem("Fortnightly");
        Assert.assertTrue(fcp.totalFixedCosts.getFieldValueDouble() == 216.67);

        logger.step(7);
        logger.info("Validate Total Fixed Costs for Four Weekly frequency");
        fcp.populateItem(SECURED_LOANS, "100.00");
        fcp.frequency_6.selectItem("Four Weekly");
        Assert.assertTrue(fcp.totalFixedCosts.getFieldValueDouble() == 108.33);

        logger.step(8);
        logger.info("Validate Total Fixed Costs for Monthly frequency");
        fcp.populateItem(SECURED_LOANS, "100.00");
        fcp.frequency_6.selectItem("Monthly");
        Assert.assertTrue(fcp.totalFixedCosts.getFieldValueDouble() == 100.00);

        logger.step(9);
        logger.info("Validate Total Fixed Costs for Secured Loans 100 Weekly + TV License 120 Weekly");
        fcp.populateItem(SECURED_LOANS, "100.00");
        fcp.frequency_6.selectItem("Weekly");
        fcp.populateItem(TV_LICENCE, "120.00");
        fcp.frequency_7.selectItem("Weekly");
        Assert.assertTrue(fcp.totalFixedCosts.getFieldValueDouble() == 953.33);

        logger.step(10);
        logger.info("Reset values");
        fcp.populateItem(SECURED_LOANS, "0.00");
        fcp.populateItem(TV_LICENCE, "0.00");

        logger.step(10);
        logger.info("Validate Total Fixed Costs for Vehicle Insurance 100 Weekly + Road Tax 50 Fortnightly + MOT & Maintenance 80 Four Weekly + Fuel 120 Monthly");
        fcp.populateItem(VEHICLE_INSURANCE, "100.00");
        fcp.frequency_17.selectItem("Weekly");
        fcp.populateItem(ROAD_TAX, "50.00");
        fcp.frequency_18.selectItem("Fortnightly");
        fcp.populateItem(MOT_MAINTENANCE, "80.00");
        fcp.frequency_19.selectItem("Four Weekly");
        fcp.populateItem(FUEL, "120.00");
        fcp.frequency_20.selectItem("Monthly");
        Assert.assertTrue(fcp.totalFixedCosts.getFieldValueDouble() == 748.33);

        logger.step(11);
        logger.info("Add and rename custom Fixed Costs type");
        fcp.addCustomType.click();
        fcp.inputCustomType.setText("Other Fixed Cost");
        fcp.previous.click();
        pbp.next.click();
        Assert.assertTrue(fcp.inputCustomType.getValue().equals("Other Fixed Cost"));

        logger.step(12);
        logger.info("Delete custom Fixed cost type");
        fcp.deleteCustomType.click();
        Assert.assertFalse(fcp.inputCustomType.isPresent());

        logger.step(13);
        logger.info("Add Other Fixed Cost monthly 100 and check Total Fixed Cost, Total Expenditure and Disposable income ");
        fcp.addCustomType.click();
        SummaryBlock sm = new SummaryBlock();
        Double totalExpInit = sm.totalExpenditure.getFieldValueDouble();
        Double totalFixedCostsInit = fcp.totalFixedCosts.getFieldValueDouble();
        Double dispIncInit = sm.disposableIncome.getFieldValueDouble();
        fcp.populateItem(LIFE_INSURANCE, "100.00");
        fcp.frequency_6.selectItem("Monthly");
        Assert.assertTrue(pbp.totalPriorityBills.getFieldValueDouble() == (totalFixedCostsInit +100.00));
        Assert.assertTrue(sm.totalExpenditure.getFieldValueDouble() == (totalExpInit +100.00));
        Assert.assertTrue(sm.disposableIncome.getFieldValueDouble() ==(dispIncInit - 100));
        fcp.deleteCustomType.click();

        logger.step(14);
        logger.info("Add 10 custom Fixed costs types");
        for (int i = 0; i < 10; i++) {
            fcp.addCustomType.click();
        }
        Assert.assertFalse(fcp.addCustomType.isPresent());

        logger.step(15);
        logger.info("Click Cancel button and delete SFS");
        fcp.cancel.click();
        if (fcp.confirmLeavePage.isPresent()){
            fcp.ok.click();
        }
        sfs.delete.click();
        if (sfs.confirmPopUp.isPresent()){
            sfs.ok.click();
        }

    }

}
