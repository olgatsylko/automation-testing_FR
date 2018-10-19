package course_work;

import course_work.forms.SfsPending_complete;
import miniSmart.webdriver.BaseTest;

public class SfsCreate extends BaseTest {
    public void runTest() {
        logger.step(1);
        logger.info("Click Create");
        SfsPending_complete sfs = new SfsPending_complete();
        sfs.create();
    }
}

