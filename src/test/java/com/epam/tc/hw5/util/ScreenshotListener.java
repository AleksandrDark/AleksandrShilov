package com.epam.tc.hw5.util;

import com.epam.tc.hw4.util.AttacmentUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenshotListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        Object driver = result.getTestContext().getAttribute("webDriver");
        if (driver != null) {
            AttacmentUtils.makeScreenshotAttachment("Test",
                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        }
    }
}
