package course_work;

import course_work.forms.HouseholdEquityDetails;
import course_work.forms.SfsPending_complete;
import framework.BaseTest;
import static course_work.forms.HouseholdEquityDetails.Fields.Children16_18;
import static course_work.forms.HouseholdEquityDetails.Fields.ChildrenUnder16;
import static course_work.forms.HouseholdEquityDetails.Fields.NumberInHouseHold;

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
        logger.info("Household and Eq section: household vs Total sum validation message");
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


    }


}

