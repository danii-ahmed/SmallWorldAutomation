package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

// @RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
//        tags = "@WebShopLogin",
        glue = "stepDefinitions")
public class testrunner extends AbstractTestNGCucumberTests {}
