package nyx_solution;

import framework.BaseTest;
import framework.elements.DropDown;
import nyx_solution.forms.*;
import org.testng.Assert;

import static nyx_solution.forms.CommLeisurePage.amountFields.*;

public class CommsLeisureTest extends BaseTest {
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
        logger.info("Navigate to Communications and Leisure");
        fcp.next.click();
        CommLeisurePage comL = new CommLeisurePage();

        logger.step(5);
        logger.info("Validate Frequency dropdown values");
        for (DropDown freq:  comL.getAllFrequencyDropDowns()){
            freq.selectItem("Weekly");
            freq.selectItem("Fortnightly");
            freq.selectItem("Four Weekly");
            freq.selectItem("Monthly");
        }

        logger.step(6);
        logger.info("Validate Total Comms and Leisure for Weekly frequency");
        comL.populateItem(HOME_PHONE, "100.00");
        comL.frequency_22.selectItem("Weekly");
        Assert.assertTrue(comL.totalCommAndLeisure.getFieldValueDouble() == 433.33);

        logger.step(7);
        logger.info("Validate Total Comms and Leisure for Fortnightly frequency");
        comL.populateItem(HOME_PHONE, "100.00");
        comL.frequency_22.selectItem("Fortnightly");
        Assert.assertTrue(comL.totalCommAndLeisure.getFieldValueDouble() == 216.67);

        logger.step(8);
        logger.info("Validate Total Comms and Leisure for Four Weekly frequency");
        comL.populateItem(HOME_PHONE, "100.00");
        comL.frequency_22.selectItem("Four Weekly");
        Assert.assertTrue(comL.totalCommAndLeisure.getFieldValueDouble() == 108.33);

        logger.step(9);
        logger.info("Validate Total Comms and Leisure for Monthly frequency");
        comL.populateItem(HOME_PHONE, "100.00");
        comL.frequency_22.selectItem("Monthly");
        Assert.assertTrue(comL.totalCommAndLeisure.getFieldValueDouble() == 100.00);

        logger.step(10);
        logger.info("Validate Total Comms and Leisure for Home Phone 100 Weekly + Mobile Phone 120 Weekly");
        comL.populateItem(HOME_PHONE, "100.00");
        comL.frequency_22.selectItem("Weekly");
        comL.populateItem(MOBILE_PHONE, "120.00");
        comL.frequency_23.selectItem("Weekly");
        Assert.assertTrue(comL.totalCommAndLeisure.getFieldValueDouble()== 953.33);

        logger.step(11);
        logger.info("Reset values");
        comL.populateItem(HOME_PHONE, "0.00");
        comL.populateItem(MOBILE_PHONE, "0.00");

        logger.step(12);
        logger.info("Validate Total Comms and Leisure for Mobile Phone 100 Weekly + Hobbies 50 Fortnightly + Other 80 Four Weekly + Other 120 Monthly");
        comL.populateItem(MOBILE_PHONE, "100.00");
        comL.frequency_23.selectItem("Weekly");
        comL.populateItem(HOBBIES, "50.00");
        comL.frequency_24.selectItem("Fortnightly");
        comL.addCustomType.click();
        comL.populateItem(OTHER1, "80.00");
        comL.frequency_34.selectItem("Four Weekly");
        comL.addCustomType.click();
        comL.populateItem(OTHER2, "120.00");
        comL.frequency_35.selectItem("Monthly");
        Assert.assertTrue(comL.totalCommAndLeisure.getFieldValueDouble() == 748.33);

        logger.step(13);
        logger.info("Rename custom Comms and Leisure type");
        comL.inputCustomType.setText("Other communications");
        comL.previous.click();
        fcp.next.click();
        Assert.assertTrue(comL.inputCustomType.getValue().equals("Other communications"));

        logger.step(14);
        logger.info("Delete custom Comms and Leisure type");
        comL.deleteCustomType.click();
        comL.deleteCustomType.click();
        Assert.assertFalse(comL.inputCustomType.isPresent());

        logger.step(15);
        logger.info("Add Other Comms and Leisure monthly 100 and check Total Communications and Leisure, Total Expenditure and Disposable income ");
        comL.addCustomType.click();
        SummaryBlock sm = new SummaryBlock();
        Double totalExpInitCl = sm.totalExpenditure.getFieldValueDouble();
        Double totalInitCl = comL.totalCommAndLeisure.getFieldValueDouble();
        Double dispIncInitCl = sm.disposableIncome.getFieldValueDouble();
        comL.populateItem(OTHER1, "100.00");
        comL.frequency_34.selectItem("Monthly");
        Assert.assertTrue(comL.totalCommAndLeisure.getFieldValueDouble() == (totalInitCl +100.00));
        Assert.assertTrue(sm.totalExpenditure.getFieldValueDouble() == (totalExpInitCl +100.00));
        Assert.assertTrue(sm.disposableIncome.getFieldValueDouble() ==(dispIncInitCl - 100));
        comL.deleteCustomType.click();

        logger.step(16);
        logger.info("Add 10 custom Comms and Leisure types");
        for (int i = 0; i < 10; i++) {
            comL.addCustomType.click();
        }
        Assert.assertFalse(comL.addCustomType.isPresent());

        logger.step(17);
        logger.info("Click Cancel button and delete SFS");
        comL.cancel.click();
        if (comL.confirmLeavePage.isPresent()){
            comL.ok.click();
        }
        sfs.delete.click();
        if (sfs.confirmPopUp.isPresent()){
            sfs.ok.click();
        }
    }
}
