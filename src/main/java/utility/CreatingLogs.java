package utility;


 
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import rootClass.Rootclass;

public class CreatingLogs extends Rootclass {   
    @Test
    public void logsGeneration()
    {
    	test = extent.createTest("logsGeneration");
        test.log(Status.INFO,"createTest() method will return the ExtentTest object");
        test.log(Status.INFO, "I am in actual Test");
        test.log(Status.INFO, "We can write the actual test logic in this Test");
         
        // Using Labels
        test.log(Status.INFO, MarkupHelper.createLabel("*************** Using Labels ***************", ExtentColor.RED));
        test.log(Status.INFO, MarkupHelper.createLabel("This is Test Logger 1", ExtentColor.BLUE));
        test.log(Status.INFO, MarkupHelper.createLabel("This is Test Logger 2", ExtentColor.BLUE));
        test.log(Status.INFO, MarkupHelper.createLabel("This is Test Logger 3", ExtentColor.BLUE));
        test.log(Status.INFO, MarkupHelper.createLabel("This is Test Logger 4", ExtentColor.BLUE));
        
    }
    
    public void info(String s) {
    	test.log(Status.INFO, s);
    }
     
    @After
    public void tearDown()
    {
        extent.flush();
    }

}
