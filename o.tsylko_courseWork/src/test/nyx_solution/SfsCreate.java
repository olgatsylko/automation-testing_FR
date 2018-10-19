package nyx_solution;

import nyx_solution.forms.SfsPending_complete;
import framework.BaseTest;

public class SfsCreate extends BaseTest {
    public void runTest() {
        logger.step(1);
        logger.info("Click Create");
        SfsPending_complete sfs = new SfsPending_complete();
        sfs.create();
    }
}

