package runnerClass;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/feature"},
glue = {"stepDefinition","baseClass"},
tags=("@Employees or @Departments"),
plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","rerun:rerun/failed_scenarios.txt"}
)

public class Runner {
	
	}


