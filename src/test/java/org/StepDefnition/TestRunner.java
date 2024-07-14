package org.StepDefnition;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources", 
glue = "org.StepDefnition",dryRun = false,plugin={"html:Report\\scenthtmlreport.html","junit:Report\\scentjunitreport.xml","json:Report\\scentjsonreport.json"})
public class TestRunner {
	
	
}