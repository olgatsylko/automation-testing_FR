package nyx_solution;

import nyx_solution.forms.SfsPending_completePage;
import framework.BaseTest;

public class SfsCreate extends BaseTest {
    public void runTest() {
        logger.step(1);
        logger.info("Click Create");
        SfsPending_completePage sfs = new SfsPending_completePage();
        sfs.create();
    }
}

