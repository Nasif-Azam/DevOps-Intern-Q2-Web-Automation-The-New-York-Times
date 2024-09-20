package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountRegistrationPage {
    WebDriver driver;

    // Constructor
    public AccountRegistrationPage(WebDriver driver){
        this.driver = driver;
    }

    // Locators
    By txtFirstname = By.xpath("//input[@id='input-firstname']");
    By txtLastname = By.xpath("//input[@id='input-lastname']");
    By txtEmail = By.xpath("//input[@id='input-email']");
    By txtTelephone = By.xpath("//input[@id='input-telephone']");
    By txtPassword = By.xpath("//input[@id='input-password']");
    By txtConfirmPassword = By.xpath("//input[@id='input-confirm']");
    By checkPolicy = By.xpath("//input[@name='agree']");
    By btnContinue = By.xpath("//input[@value='Continue']");
    By msgConfirmation = By.xpath("//h1[normalize-space()='Your Account Has Been Created!']");
    By msgAlreadyReg = By.xpath("//*[@id='account-register']/div[1]");

    // Action Methods

    public void setFirstName(String fname) {
        driver.findElement(txtFirstname).sendKeys(fname);
    }
    public void setLastName(String lname) {
        driver.findElement(txtLastname).sendKeys(lname);
    }
    public void setEmail(String email) {
        driver.findElement(txtEmail).sendKeys(email);
    }
    public void setTelephone(String tel) {
        driver.findElement(txtTelephone).sendKeys(tel);
    }
    public void setPassword(String pwd) {
        driver.findElement(txtPassword).sendKeys(pwd);
    }
    public void setConfirmPassword(String cpwd) {
        driver.findElement(txtConfirmPassword).sendKeys(cpwd);
    }
    public void setPrivacyPolicy() {
        driver.findElement(checkPolicy).click();
    }
    public void clickContinue() {
        driver.findElement(btnContinue).click();
    }
    public String getConfirmationMsg() {
        try {
            String getMsgText = driver.findElement(msgConfirmation).getText();
            return getMsgText;
        } catch (Exception e) {
            return (e.getMessage());
        }
    }
    public String getAlreadyRegMsg() {
        try {
            String getAlreadyRegMsg = driver.findElement(msgAlreadyReg).getText();
            System.out.println(getAlreadyRegMsg);
            return getAlreadyRegMsg;
        } catch (Exception e) {
            return (e.getMessage());
        }
    }
}
