package testCases;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T001_AccountRegistrationTest extends BaseClass {

    @Test(priority = 1)
    void verify_account_registration() {
        logger.info("===== String T001_AccountRegistrationTest =====");
        try {
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            logger.info("Clicked on My Account Link");
            hp.clickRegister();
            logger.info("Clicked on Register Link");
            AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
            logger.info("Providing Customer Details...");
            regpage.setFirstName(randomString().toUpperCase());
            regpage.setLastName(randomString().toUpperCase());
            regpage.setEmail(randomString()+"@gmail.com");
            regpage.setTelephone(randomNumber());

            String actualPassword = randomAlphaNumeric();
            regpage.setPassword(actualPassword);
            regpage.setConfirmPassword(actualPassword);

            regpage.setPrivacyPolicy();
            regpage.clickContinue();
            // Validation
            logger.info("Validating Expected Message...");
            String confirmMsg = regpage.getConfirmationMsg();
            String alreadyRegMsg = regpage.getAlreadyRegMsg();
            Assert.assertEquals(confirmMsg, "Your Account Has Been Created!");
        } catch (Exception e){
            logger.error("Test Failed!!");
            logger.debug("Debug Logs...");
            Assert.fail();
        }
        logger.info("===== Finished T001_AccountRegistrationTest =====");



        // Validation
//        if (confirmMsg.equals("Your Account Has Been Created!")) {
//            Assert.assertEquals(confirmMsg, "Your Account Has Been Created!");
//        } else {
//            Assert.assertEquals(alreadyRegMsg, "Warning: E-Mail Address is already registered!");
//        }
    }


}

