package course_work;

import course_work.forms.HouseholdEquityDetails;
import course_work.forms.SfsPending_complete;
import miniSmart.webdriver.BaseTest;
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
        logger.info("Household Types selection");
        hsDet.householdType.selectItem("1");

    }


}

