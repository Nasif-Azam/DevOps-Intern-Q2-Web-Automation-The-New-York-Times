import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Set;


public class ActionMethods {
    WebDriver driver;

    // Constructor
    ActionMethods(WebDriver driver){
        this.driver = driver;
    }

    // Locators
    String expected_title = "The New York Times - Breaking News, US News, World News and Videos";
    By all_img_tags = By.tagName("img");
    By allHeadings = By.xpath("//div[@class='css-xdandi']/p");
    By img_logo_loc = By.xpath("//*[name()='image' and contains(@width,'100%')]");

    By searchIconBtn = By.xpath("//button[@class='css-tkwi90 e1iflr850']");
    By searchInputBox = By.xpath("//input[@placeholder='SEARCH']");
    By searchGoBtn = By.xpath("//button[@type='submit']");

    By searchedNewsHead = By.xpath("//div[@class='css-e1lvw9']/a/h4");
    By searchedLetestNewsClicked = By.xpath("(//div[@class='css-e1lvw9']/a)[1]");
    By searchedOldestNewsClicked = By.xpath("(//div[@class='css-e1lvw9'])[10]");
    By homePage = By.xpath("//a[@aria-label='New York Times homepage']//*[name()='svg']");
    By homePage1 = By.xpath("(//*[name()='path'])[2]");

    By englishLanguage = By.xpath("//li[@class='css-1shpxcj']/a[@lang='en-US']");
    By internationalLanguage = By.xpath("//li[@class='css-1nrdlje']/a[@lang='en']");
    By canadaLanguage = By.xpath("//li[@class='css-1nrdlje']/a[@lang='en-CA']");
    By spanishLanguage = By.xpath("//li[@class='css-1nrdlje']/a[@lang='es-ES']");
    By chineseLanguage = By.xpath("//li[@class='css-1nrdlje']/a[@lang='zh-hans']");
    By reset = By.xpath("//a[contains(text(),'ENGLISH (英文)')]");

    By clickLoginBtn = By.xpath("//span[@class='css-ni9it0 e1j3jvdr0']");
    By username_loc = By.xpath("//input[@id='email']");
    By cont_username_loc = By.xpath("//button[normalize-space()='Continue']");
    By password_loc = By.xpath("//input[@id='password']");
    By loginBtn_loc = By.xpath("//button[normalize-space()='Log In']");

//    By txt_username_loc = By.xpath("//input[@placeholder='Username']");
//    By txt_password_loc = By.xpath("//input[@placeholder='Password']");
//    By btn_login_loc = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']");

    // Action Methods
    public String titleChecker(){
        return expected_title;
    }

    public int allImageChecker(){
        List<WebElement> images = driver.findElements(all_img_tags);
        System.out.println("Total images: "+images.size());
        return images.size();
    }

    public int allHeadings(){
        List<WebElement> headingList = driver.findElements(allHeadings);
        int count = 0;
        for (WebElement element : headingList) {
            String heading = element.getText();
            if (heading.split("\\s+").length > 2) {
                System.out.println("Heading-"+(count+1)+": "+heading);
                count += 1;
            }
        }
        System.out.println("Total Head Lines: "+(count));
        return count;
    }

    public String search(String searchItem){
        driver.findElement(searchIconBtn).click();
        driver.findElement(searchInputBox).sendKeys(searchItem);
        driver.findElement(searchGoBtn).click();
        System.out.println("Search Item: "+searchItem);
        System.out.println("Page Title: "+driver.getTitle());
        return driver.getTitle();
    }

    public int searchedHeadings(){
        List<WebElement> searchHeadingList = driver.findElements(searchedNewsHead);
        int count = 0;
        for (WebElement element : searchHeadingList) {
            String heading = element.getText();
            if (heading.split("\\s+").length > 2) {
                System.out.println("Search-"+(count+1)+": "+heading);
                count += 1;
            }
        }
        System.out.println("Total Search Result: "+(count));
        return count;
    }

    public String searchedLatestHeading(){
        List<WebElement> searchHeadingList = driver.findElements(searchedNewsHead);
        System.out.println("Latest Search Result: "+ searchHeadingList.getFirst().getText());
        return searchHeadingList.getFirst().getText();
    }

    public String searchedOlderHeading(){
        List<WebElement> searchHeadingList = driver.findElements(searchedNewsHead);
        System.out.println("Oldest Search Result: "+ searchHeadingList.getLast().getText());
        return searchHeadingList.getLast().getText();
    }

    public void clickLatestNews(){
        driver.findElement(searchedLetestNewsClicked).click();
        System.out.println("Switched to Latest News: "+driver.getCurrentUrl());
    }

    public void directedHomepage(){
        driver.findElement(homePage).click();
    }

    public void clickOldestNews(){
        driver.findElement(searchedOldestNewsClicked).click();
        System.out.println("Switched to Oldest News: "+driver.getCurrentUrl());
        driver.findElement(homePage1).click();
    }

    public String engLanChecker(){
        driver.findElement(englishLanguage).click();
        return driver.getTitle();
    }
    public String intaLanChecker(){
        driver.findElement(internationalLanguage).click();
        return driver.getTitle();
    }
    public String canLanChecker(){
        driver.findElement(canadaLanguage).click();
        return driver.getTitle();
    }
    public String spnLanChecker(){
        driver.findElement(spanishLanguage).click();
        return driver.getTitle();
    }
    public String chnLanChecker(){
        driver.findElement(chineseLanguage).click();
        return driver.getTitle();
    }
    public String navigateToNewTab(){
        String originalWindow = driver.getWindowHandle();
        driver.findElement(reset).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
        String newTabTitle = driver.getTitle();
        System.out.println("New Tab Title: " + newTabTitle);
        return newTabTitle;
    }

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

