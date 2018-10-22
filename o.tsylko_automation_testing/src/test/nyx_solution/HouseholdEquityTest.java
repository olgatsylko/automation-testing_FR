package nyx_solution;

import framework.BaseTest;
import nyx_solution.forms.HouseholdEquityDetails;
import nyx_solution.forms.SfsPending_complete;
import org.testng.Assert;

import static nyx_solution.forms.HouseholdEquityDetails.Fields.*;

public class HouseholdEquityTest extends BaseTest {
    public void runTest() {
        logger.step(1);
        logger.info("Click Create");
        SfsPending_complete sfs = new SfsPending_complete();
        sfs.create();

        logger.step(2);
        logger.info("Household and Eq section: household validation message");
        HouseholdEquityDetails hsDet = new HouseholdEquityDetails();
        hsDet.populateItem(NumberInHouseHold, "0");
        hsDet.householdValidationMess();

        logger.step(3);
        logger.info("Household and Eq section: household vs Total sum validation message");
        hsDet.populateItem(NumberInHouseHold, "3");
        hsDet.populateItem(ChildrenUnder16, "1");
        hsDet.populateItem(Children16_18, "2");
        hsDet.householdSumMess();

        logger.step(4);
        logger.info("Household and Equity section: household vs Total sum validation message");
        hsDet.populateItem(NumberInHouseHold, "3");
        hsDet.populateItem(ChildrenUnder16, "2");
        hsDet.populateItem(Children16_18, "1");
        hsDet.householdSumMess();

        logger.step(5);
        logger.info("Data accepted");
        hsDet.populateItem(NumberInHouseHold, "3");
        hsDet.populateItem(ChildrenUnder16, "1");
        hsDet.populateItem(Children16_18, "1");
        hsDet.validationMessIsNotPresent();

        logger.step(6);
        logger.info("Household Types validation message");
        hsDet.householdType.click();
        hsDet.validationMessMandatoryField();

        logger.step(7);
        logger.info("Household Types selection");
        hsDet.householdType.selectItem("Couple with no children");
        hsDet.householdType.selectItem("Couple with children");
        hsDet.householdType.selectItem("Single Person");
        hsDet.householdType.selectItem("Single Parent");
        hsDet.householdType.selectItem("Unknown");

        logger.step(8);
        logger.info("Residence Status validation message");
        hsDet.residenceStatus.click();
        hsDet.validationMessMandatoryField();

        logger.step(9);
        logger.info("Residence Status selection");
        hsDet.residenceStatus.selectItem("Tenant");
        hsDet.residenceStatus.selectItem("Home Owner");
        hsDet.residenceStatus.selectItem("Living with Parents");
        hsDet.residenceStatus.selectItem("No Fixed Abode");
        hsDet.residenceStatus.selectItem("Sheltered Accommodation");
        hsDet.residenceStatus.selectItem("Unknown");

        logger.step(10);
        logger.info("Employment Status selection");
        hsDet.employmentStatus.selectItem("Full Time");
        hsDet.employmentStatus.selectItem("Part Time");
        hsDet.employmentStatus.selectItem("Self Employed");
        hsDet.employmentStatus.selectItem("Unemployed");
        hsDet.employmentStatus.selectItem("Unknown");

        logger.step(11);
        logger.info("Partners Employment Status selection");
        hsDet.partnersEmploymentStatus.selectItem("Full Time");
        hsDet.partnersEmploymentStatus.selectItem("Part Time");
        hsDet.partnersEmploymentStatus.selectItem("Self Employed");
        hsDet.partnersEmploymentStatus.selectItem("Unemployed");
        hsDet.partnersEmploymentStatus.selectItem("Unknown");

        logger.step(12);
        logger.info("Outstanding Mortgage validation message");
        hsDet.populateItem(OutstandingMORTGAGE, "999999999.01");
        Assert.assertTrue(hsDet.outstandMortgageMess.isPresent());

        logger.step(13);
        logger.info("Outstanding Mortgage validation");
        hsDet.populateItem(VALUEofHome, "200000.00");
        hsDet.populateItem(OutstandingMORTGAGE, "100000.00 ");
        //System.out.println(hsDet.equityOfHome.getValue());
       // Assert.assertTrue(hsDet.equityOfHome.==0.00);


        logger.step(14);
        logger.info("Click Cancel button");
        hsDet.cancel.click();
        Assert.assertTrue(hsDet.confirmLeavePage.isPresent());
        hsDet.ok.click();


    }


}

