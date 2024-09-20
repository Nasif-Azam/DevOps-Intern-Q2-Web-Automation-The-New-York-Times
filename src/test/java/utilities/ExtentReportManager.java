package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import testCases.BaseClass;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExtentReportManager implements ITestListener {
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    String repName;

    public void onStart(ITestContext testContext){
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        repName = "Test Report-" + timeStamp + ".html";

        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/"+repName);
        sparkReporter.config().setDocumentTitle("The New York Times - Automation Report");
        sparkReporter.config().setReportName("The New York Times - Functional Testing");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Application", "The New York Times");
        extent.setSystemInfo("Computer Name", "localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester Name", "Nasif Azam");
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("OS", "Window-10");
        extent.setSystemInfo("Browser Name", "Chrome");
        extent.setSystemInfo("Environment", "QA");

//        String os = testContext.getCurrentXmlTest().getParameter("os");
//        extent.setSystemInfo("OS", os);
//        String browser = testContext.getCurrentXmlTest().getParameter("browser");
//        extent.setSystemInfo("Browser Name", browser);
//        List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
//        if(!includedGroups.isEmpty()){
//            extent.setSystemInfo("Groups", includedGroups.toString());
//        }
    }

    public void onTestSuccess(ITestResult result){
        test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.PASS, "Test case PASSED is: "+result.getName());
    }

    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());

        test.log(Status.FAIL, result.getName()+"Got Failed");
        test.log(Status.INFO, result.getThrowable().getMessage());

        try {
            String imgPath = new BaseClass().captureScreen(result.getName());
            test.addScreenCaptureFromPath(imgPath);
        } catch (IOException e1){
            e1.printStackTrace();
        }

        test.log(Status.FAIL, "Test case FAILED is: "+result.getName());
        test.log(Status.FAIL, "Test case FAILED cause is: "+result.getThrowable());
    }

    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP, "Test case SKIPPED is: "+result.getName());
        test.log(Status.INFO, result.getThrowable().getMessage());
    }

    public void onFinish(ITestContext context) {
        extent.flush();

//        String pathOfExtentReport = System.getProperty("user.dir"+"\\reports\\"+repName);
//        File extentReport = new File(pathOfExtentReport);
//
//        try {
//            Desktop.getDesktop().browse(extentReport.toURI());
//        } catch (IOException e2){
//            e2.printStackTrace();
//        }
    }

}
