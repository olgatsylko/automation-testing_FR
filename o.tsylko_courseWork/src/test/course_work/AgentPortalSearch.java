package course_work;

import course_work.forms.AgentPortal;
import miniSmart.webdriver.BaseTest;

public class AgentPortalSearch extends BaseTest {
    public void runTest() {
        logger.step(1);
        logger.info("Navigation");
        AgentPortal ap = new AgentPortal();
        logger.step(2);
        logger.info("Search for Consumer");
      //  ap.searchConsumer(Browser.consumer);
    }
}
