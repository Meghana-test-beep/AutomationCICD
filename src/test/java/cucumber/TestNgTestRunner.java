package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/cucumber",glue="StepDefinition",
monochrome=true,plugin= {"html:taget/cucumbr.html"}) // monochrome will generate the report in readable format and plugin help us
// to create the report format
public class TestNgTestRunner extends AbstractTestNGCucumberTests{

	
}
