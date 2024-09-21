package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class TC007_CheckLanguages extends BaseClass {
    @Test(priority = 10)
    void english_lang_check(){
        try {
            logger.info("===== String TC007_CheckLanguages =====");
            HomePage hp = new HomePage(driver);
            logger.info("Validating English Language...");
            Assert.assertEquals("The New York Times - Breaking News, US News, World News and Videos", hp.engLanChecker());
        } catch (Exception e) {
            logger.error("English Language Test Failed!!");
            logger.debug("English Language Debug Logs...");
            Assert.fail();
        }

    }
    @Test(priority = 11)
    void international_lang_check(){
        try {
            HomePage hp = new HomePage(driver);
            logger.info("Validating International Language...");
            Assert.assertEquals("The New York Times International - Breaking News, US News, World News, Videos", hp.intaLanChecker());
        } catch (Exception e) {
            logger.error("International Language Test Failed!!");
            logger.debug("International Language Debug Logs...");
            Assert.fail();
        }

    }
    @Test(priority = 12)
    void canada_lang_check(){
        try {
            HomePage hp = new HomePage(driver);
            logger.info("Validating Canadian Language...");
            Assert.assertEquals("The New York Times Canada - Breaking News, US News, World News, Videos", hp.canLanChecker());
        } catch (Exception e) {
            logger.error("Canadian Language Test Failed!!");
            logger.debug("Canadian Language Debug Logs...");
            Assert.fail();
        }

    }
    @Test(priority = 13)
    void spain_lang_check(){
        try {
            HomePage hp = new HomePage(driver);
            logger.info("Validating Spanish Language...");
            Assert.assertEquals("The New York Times en Español - The New York Times", hp.spnLanChecker());
        } catch (Exception e) {
            logger.error("Spanish Language Test Failed!!");
            logger.debug("Spanish Language Debug Logs...");
            Assert.fail();
        }
    }
    @Test(priority = 14)
    void chinese_lang_check(){
        try {
            HomePage hp = new HomePage(driver);
            logger.info("Validating Chinese Language...");
            Assert.assertEquals("纽约时报中文网 国际纵览", hp.chnLanChecker());
        } catch (Exception e) {
            logger.error("Chinese Language Test Failed!!");
            logger.debug("Chinese Language Debug Logs...");
            Assert.fail();
        }
    }

    @Test(priority = 15)
    void switch_home_tabTC(){
        try {
            logger.info("Switching Home Tab");
            HomePage hp = new HomePage(driver);
            logger.info("Validating Homepage Title...");
            Assert.assertEquals("The New York Times - Breaking News, US News, World News and Videos", hp.navigateToNewTab());
        } catch (Exception e) {
            logger.error("Homepage Title Test Failed!!");
            logger.debug("Homepage Title Debug Logs...");
            Assert.fail();
        }
        logger.info("===== Finished TC007_CheckLanguages =====");
    }
}
