package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPage {
    WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    // Locators
    By img_logo_loc = By.xpath("//*[name()='image' and contains(@width,'100%')]");
    By clickLoginBtn = By.xpath("//span[@class='css-ni9it0 e1j3jvdr0']");
    By username_loc = By.xpath("//input[@id='email']");
    By cont_username_loc = By.xpath("//button[normalize-space()='Continue']");
    By password_loc = By.xpath("//input[@id='password']");
    By loginBtn_loc = By.xpath("//button[normalize-space()='Log In']");

    // Action Methods
    public boolean logoDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(img_logo_loc));

            if (logo.isDisplayed()) {
                System.out.println("Logo is displayed.");
                return true;
            } else {
                System.out.println("Logo is not displayed.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Logo not found or some error occurred: " + e.getMessage());
            return false;
        }
    }
    public void clickLoginButton(){
        driver.findElement(clickLoginBtn).click();
    }

    public void setUserName(String user){
        driver.findElement(username_loc).sendKeys(user);
    }
    public void contUserName(){
        driver.findElement(cont_username_loc).click();
    }

    public void setPassword(String password){
        driver.findElement(password_loc).sendKeys(password);
    }
    public void clickLogin(){
        driver.findElement(loginBtn_loc).click();
    }


}
