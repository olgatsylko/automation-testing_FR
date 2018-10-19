package nyx_solution;

import framework.BaseTest;
import nyx_solution.forms.HouseholdEquityDetails;
import nyx_solution.forms.PriorityBillPage;
import nyx_solution.forms.SfsPending_complete;

import static nyx_solution.forms.PriorityBillPage.Fields.RentAmount;

public class ExpendGroupPriorityBills extends BaseTest {
    public void runTest() {
        logger.step(1);
        logger.info("Click Create");
        SfsPending_complete sfs = new SfsPending_complete();
        sfs.create();

        logger.step(2);
        logger.info("Navigate to Priority Bills");
        HouseholdEquityDetails hsDet2 = new HouseholdEquityDetails();
        hsDet2.householdType.selectItem("Couple with no children");
        hsDet2.residenceStatus.selectItem("Tenant");
        hsDet2.next.click();

        logger.step(3);
        logger.info("Validate Priority Bills page");
        PriorityBillPage pbp = new PriorityBillPage();

        logger.step(4);
        logger.info("Validate Frequency dropdown values");
        pbp.frequency0.selectItem("Weekly");
        pbp.frequency0.selectItem("Fortnightly");
        pbp.frequency0.selectItem("Four Weekly");
        pbp.frequency0.selectItem("Monthly");

        pbp.frequency1.selectItem("Weekly");
        pbp.frequency1.selectItem("Fortnightly");
        pbp.frequency1.selectItem("Four Weekly");
        pbp.frequency1.selectItem("Monthly");

        pbp.frequency2.selectItem("Weekly");
        pbp.frequency2.selectItem("Fortnightly");
        pbp.frequency2.selectItem("Four Weekly");
        pbp.frequency2.selectItem("Monthly");

        pbp.frequency3.selectItem("Weekly");
        pbp.frequency3.selectItem("Fortnightly");
        pbp.frequency3.selectItem("Four Weekly");
        pbp.frequency3.selectItem("Monthly");

        pbp.frequency4.selectItem("Weekly");
        pbp.frequency4.selectItem("Fortnightly");
        pbp.frequency4.selectItem("Four Weekly");
        pbp.frequency4.selectItem("Monthly");

        pbp.frequency5.selectItem("Weekly");
        pbp.frequency5.selectItem("Fortnightly");
        pbp.frequency5.selectItem("Four Weekly");
        pbp.frequency5.selectItem("Monthly");

        logger.step(5);
        logger.info("Validate Total Priority Bills for Weekly/Fortnightly/Four Weekly/Monthly frequency");
        pbp.populateItem(RentAmount, "100.00");
        pbp.frequency0.selectItem("Weekly");
      //  System.out.println((pbp.totalPriorityBills.getFieldValue()));
       // Assert.assertTrue(pbp.totalPriorityBills.getFieldValue() == 433.00);

    }
}
