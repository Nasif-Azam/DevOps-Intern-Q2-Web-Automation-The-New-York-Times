import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Scanner;

public class pageObjects {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String URL = "https://www.nytimes.com/";
        WebDriver driver = new ChromeDriver();
        driver.get(URL);

        // Test Case-0 (Logo)
        System.out.print("Enter to Begin Test Case-1..");
        sc.nextLine();
        String logo = "//*[@id='app']/div[2]/div[2]/header/div[1]/div/a/svg";
        boolean l = driver.findElement(By.xpath(logo)).isDisplayed();
        System.out.println(l);
//        // Test Case-1 (Title)
//        System.out.print("Enter to Begin Test Case-1..");
//        sc.nextLine();
//        String actual_title = driver.getTitle();
//        String expected_title = "The New York Times - Breaking News, US News, World News and Videos";
//        if(actual_title.equals(expected_title)){
//            assert true;
//            System.out.println("Test Passed...");
//        } else{
//            assert false;
//            System.out.println("Test Failed!!");
//        }

//        // Test Case-2 (All Images)
//        System.out.print("Enter to Begin Test Case-2..");
//        sc.nextLine();
//        String img_tags = "img";
//        List<WebElement> images = driver.findElements(By.tagName(img_tags));
//        int total_imgs = images.size();
//        System.out.println("Total images: "+total_imgs);
//        if(total_imgs == 99){
//            assert true;
//            System.out.println("Test Passed..");
//        } else{
//            assert false;
//            System.out.println("Test Failed!!");
//        }
//
//        // Test Case-3 (All HeadLines)
//        System.out.print("Enter to Begin Test Case-3..");
//        sc.nextLine();
//        String headings = "//div[@class='css-xdandi']/p";
//        List<WebElement> headList = driver.findElements(By.xpath(headings));
//        int count = 1;
//        for (WebElement element : headList) {
//            String heading = element.getText();
//            if (heading.split("\\s+").length > 2) {
//                System.out.println("Heading-"+count+": "+heading);
//                count += 1;
//            }
//        }
//        System.out.println("Total Head Lines: "+(count-1));

//        // Test Case-3 (Search)
//        System.out.print("Enter to Begin Test Case-4..");
//        sc.nextLine();
//        String searchIconBtn = "//button[@class='css-tkwi90 e1iflr850']";
//        String searchInputBox = "//input[@placeholder='SEARCH']";
//        String searchGoBtn = "//button[@type='submit']";
//        driver.findElement(By.xpath(searchIconBtn)).click();
//        driver.findElement(By.xpath(searchInputBox)).sendKeys("Putin");
//        driver.findElement(By.xpath(searchGoBtn)).click();

        // Close the Browser
        System.out.print("Enter to Close Browser..");
        sc.nextLine();
        driver.close();

    }
}
